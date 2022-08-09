package com.geotek.siivra.service;

import com.geotek.siivra.api.email.rest.EmailBody;
import com.geotek.siivra.constantes.EstadosIndicador;
import com.geotek.siivra.constantes.Mensajes;
import com.geotek.siivra.constantes.Notificaciones;
import com.geotek.siivra.dto.request.DataVariableRequestDTO;
import com.geotek.siivra.dto.request.ValidarAprobarDataIndicadorRequestDTO;
import com.geotek.siivra.dto.request.ValidarAprobarDataVariableRequestDTO;
import com.geotek.siivra.dto.response.CreateResponseDTO;
import com.geotek.siivra.dto.response.DataVariableResponseDTO;
import com.geotek.siivra.entity.DataVariable;
import com.geotek.siivra.entity.Variable;
import com.geotek.siivra.exception.NotFoundException;
import com.geotek.siivra.repository.AuditoriaRepository;
import com.geotek.siivra.repository.ICompDesagreacionItemRepository;
import com.geotek.siivra.repository.IDataVariableRepository;
import com.geotek.siivra.repository.IVariableRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import com.geotek.siivra.api.email.rest.EmailService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
// import java.util.stream.Collectors;

@Service
public class IDataVariableServiceImpl implements IDataVariableService {
    static Logger logger = Logger.getLogger(IDataVariableServiceImpl.class.getName());

    @Autowired
    private IDataVariableRepository iDataVariableRepository;

    @Autowired
    private ICompDesagreacionItemRepository iCompDesagreacionItemRepository;

    @Autowired
    private AuditoriaRepository procedureInvoker;

    @Autowired
    EmailService emailService;

    @Autowired
    private IVariableRepository iVariableRepository;

    private CreateResponseDTO datosVariableMR(DataVariableRequestDTO dataVariableRequestDTO, String auditoria, Boolean mantener) {
        CreateResponseDTO c = new CreateResponseDTO();
        c.setEntidad("Data Variable");

        List adds = new ArrayList();

        if(dataVariableRequestDTO.getPeriodoInicialValidez() == null) {
            c.setMensaje(Mensajes.PERIODO_INICIAL_NO_VALIDO);
            adds.add(dataVariableRequestDTO);
            c.setObjeto(adds);
            return c;
        }

        if(dataVariableRequestDTO.getPeriodoFinalValidez() == null) {
            c.setMensaje(Mensajes.PERIODO_FINAL_NO_VALIDO);
            adds.add(dataVariableRequestDTO);
            c.setObjeto(adds);
            return c;
        }

        if(Double.parseDouble(dataVariableRequestDTO.getPeriodoFinalValidez()) < Double.parseDouble(dataVariableRequestDTO.getPeriodoInicialValidez())){
            c.setMensaje(Mensajes.PERIODOS_NO_VALIDO);
            adds.add(dataVariableRequestDTO);
            c.setObjeto(adds);
            return c;
        }

        if(dataVariableRequestDTO.getValor() == null) {
            c.setMensaje(Mensajes.VALOR_NO_NUMERICO);
            adds.add(dataVariableRequestDTO);
            c.setObjeto(adds);
            return c;
        }
        if(dataVariableRequestDTO.getIdComponenteDesagregaItem() == null) {
            c.setMensaje(Mensajes.NO_EXISTE_COMP_DESAGREGACION);
            adds.add(dataVariableRequestDTO);
            c.setObjeto(adds);
            return c;
        }
        if (iCompDesagreacionItemRepository.findOne(dataVariableRequestDTO.getIdComponenteDesagregaItem()) == null){
            c.setMensaje(Mensajes.NO_EXISTE_COMP_DESAGREGACION);
            adds.add(dataVariableRequestDTO);
            c.setObjeto(adds);
            return c;
        }

        try {
            String resumen = "";
            if (mantener) { // mantener
                if (dataVariableRequestDTO.getId() != null) {
                    // c.setId(null);
                    resumen = resumen.concat(dataVariableRequestDTO.getPeriodoInicialValidez()+", existe.");
                    c.setMensaje(Mensajes.EXISTE_DATO_VARIABLE_X_PERIODO+resumen);
                } else {

                    int inicioPeriodo = Integer.parseInt(dataVariableRequestDTO.getPeriodoInicialValidez());
                    int finalPeriodo = Integer.parseInt(dataVariableRequestDTO.getPeriodoFinalValidez());

                    for(int periodo = inicioPeriodo; periodo <= finalPeriodo; periodo++) {

                        DataVariable dataVariable = new DataVariable();
                        BeanUtils.copyProperties(dataVariableRequestDTO, dataVariable);
                        dataVariable.setPeriodoInicialValidez(String.valueOf(periodo));
                        dataVariable.setPeriodoFinalValidez(String.valueOf(periodo));

                            List<DataVariable> data = iDataVariableRepository.findByPeriodo(dataVariable.getIdVariable(), dataVariable.getIdComponenteDesagregaItem(), String.valueOf(periodo), String.valueOf(periodo));
                            if (data.size() == 0) {
                                try {
                                    iDataVariableRepository.save(dataVariable);
                                    resumen = resumen.concat(periodo+", creado.");
                                    String aud = configurarAuditoria(dataVariable.getId(), auditoria);
                                    procedureInvoker.procedureName(aud,"","variable_info_alfa", dataVariable.getId());
                                    adds.add(dataVariable);
                                } catch (Exception dex) {
                                    logger.info("[DEX MASIVO] " + dex.getMessage());
                                    resumen = resumen.concat(periodo+", error.");
                                    // adds.add(dataVariable);
                                }
                            } else {
                                resumen = resumen.concat(periodo+", existe.");
                            }


                        if(String.valueOf(periodo).substring(String.valueOf(periodo).length() - 2).compareTo("12") == 0) {
                            periodo = Integer.parseInt(String.valueOf(periodo).substring( 0 , 4 ) + "99") + 1;
                        }
                    }
                    // c.setId(null);
                    if (adds.size() > 0) {
                        String men = "Periodos: " + resumen;
                        c.setMensaje(Mensajes.DATO_VARIABLE_ADD_MANTENER + men);
                    } else {
                        adds.add(dataVariableRequestDTO);
                        c.setMensaje(Mensajes.DATO_VARIABLE_ADD_NO_DATA+dataVariableRequestDTO.getPeriodoInicialValidez()+", existe.");
                    }

                }
            } else { // reemplazar
                if (dataVariableRequestDTO.getId() != null) { // dato existente que viene con ID conocido - update
                    DataVariable dataVariable = new DataVariable();
                    BeanUtils.copyProperties(dataVariableRequestDTO, dataVariable);
                    try {
                        iDataVariableRepository.save(dataVariable);
                        resumen = resumen.concat(dataVariable.getPeriodoInicialValidez()+", reemplazado.");
                        String aud = configurarAuditoria(dataVariable.getId(), auditoria);
                        procedureInvoker.procedureName(aud,"","variable_info_alfa", dataVariable.getId());
                        adds.add(dataVariable);
                    } catch (Exception dex) {
                        adds.add(dataVariable);
                        resumen = resumen.concat(dataVariable.getPeriodoInicialValidez()+", error al reemplazar.");
                    }
                    c.setId(dataVariable.getId());
                    if (adds.size() > 0) {
                        String men = "Periodos: "+resumen;
                        c.setMensaje(Mensajes.DATO_VARIABLE_REEMPLAZAR + men);
                    } else {
                        c.setMensaje(Mensajes.DATO_VARIABLE_ADD_NO_DATA);
                    }
                } else { // dato sin ID conocido - create
                    if (dataVariableRequestDTO.getPeriodoInicialValidez() == dataVariableRequestDTO.getPeriodoFinalValidez()) { // mismo periodo
                        DataVariable dataVariable = new DataVariable();
                        BeanUtils.copyProperties(dataVariableRequestDTO, dataVariable);
                        List<DataVariable> data = iDataVariableRepository.findByPeriodo(dataVariable.getIdVariable(), dataVariable.getIdComponenteDesagregaItem(), dataVariableRequestDTO.getPeriodoInicialValidez(), dataVariableRequestDTO.getPeriodoFinalValidez());
                        if (data.size() > 0 ) {
                            dataVariable.setId(data.get(0).getId());
                        }
                        try {
                            iDataVariableRepository.save(dataVariable);
                            if(data.size() > 0 ) {
                                resumen = resumen.concat(dataVariable.getPeriodoInicialValidez()+", reemplazado.");
                            } else {
                                resumen = resumen.concat(dataVariable.getPeriodoInicialValidez()+", creado.");
                            }
                            String aud = configurarAuditoria(dataVariable.getId(), auditoria);
                            procedureInvoker.procedureName(aud,"","variable_info_alfa", dataVariable.getId());
                            adds.add(dataVariable);
                        } catch (Exception dex) {
                            adds.add(dataVariable);
                            resumen = resumen.concat(dataVariable.getPeriodoInicialValidez()+", error al crear.");
                        }
                        c.setId(dataVariable.getId());
                        if (adds.size() > 0) {
                            String men = "Periodos: "+resumen;
                            c.setMensaje(Mensajes.DATO_VARIABLE_NUEVO + men);
                        } else {
                            c.setMensaje(Mensajes.DATO_VARIABLE_ADD_NO_DATA);
                        }
                    } else { // diferente periodo
                        for(int periodo = Integer.parseInt(dataVariableRequestDTO.getPeriodoInicialValidez()); periodo <= Integer.parseInt(dataVariableRequestDTO.getPeriodoFinalValidez()); periodo++) {
                            DataVariable dataVariable = new DataVariable();
                            BeanUtils.copyProperties(dataVariableRequestDTO, dataVariable);
                            dataVariable.setPeriodoInicialValidez(String.valueOf(periodo));
                            dataVariable.setPeriodoFinalValidez(String.valueOf(periodo));

                            List<DataVariable> data = iDataVariableRepository.findByPeriodo(dataVariable.getIdVariable(), dataVariable.getIdComponenteDesagregaItem(), String.valueOf(periodo), String.valueOf(periodo));
                            if (data.size() > 0 ) {
                                dataVariable.setId(data.get(0).getId());
                            }
                            try {
                                iDataVariableRepository.save(dataVariable);
                                if(data.size() > 0 ) {
                                    resumen = resumen.concat(periodo+", reemplazado.");
                                } else {
                                    resumen = resumen.concat(periodo+", creado.");
                                }
                                String aud = configurarAuditoria(dataVariable.getId(), auditoria);
                                procedureInvoker.procedureName(aud,"","variable_info_alfa", dataVariable.getId());
                                adds.add(dataVariable);
                            } catch (Exception dex) {
                                adds.add(dataVariable);
                                resumen = resumen.concat(periodo+", error al crear/reemplazar.");
                            }

                            if(String.valueOf(periodo).substring(String.valueOf(periodo).length() - 2).compareTo("12") == 0) {
                                periodo = Integer.parseInt(String.valueOf(periodo).substring( 0 , 4 ) + "99") + 1;
                            }

                        }
                        c.setId(null);
                        if (adds.size() > 0) {
                            String men = "Periodos: "+resumen;
                            c.setMensaje(Mensajes.DATO_VARIABLE_ADD_MANTENER + men);
                        } else {
                            c.setMensaje(Mensajes.DATO_VARIABLE_ADD_NO_DATA);
                        }
                    }
                }
            }
            c.setObjeto(adds);
            return c;
        } catch(Exception e) {
            logger.info("[DATA VARIABLE] " + e.getMessage());
            c.setMensaje(Mensajes.ERROR_GENERAL_SERVICIO);
            return c;
        }
    }

    @Override
    public ResponseEntity<Object> addDataVariable(DataVariableRequestDTO dataVariableRequestDTO, String auditoria, Boolean mantener) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body((Object)datosVariableMR(dataVariableRequestDTO, auditoria, mantener));
        } catch (Exception e) {
            logger.info("[DATA VARIABLE] " + e.getLocalizedMessage());
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Variable");
            c.setMensaje(Mensajes.ERROR_GENERAL_SERVICIO);
            return new ResponseEntity<Object>(c, HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<String> updateDataVariable(DataVariableRequestDTO dataVariableRequestDTO, String auditoria) {

        try {
            String aud = configurarAuditoria(dataVariableRequestDTO.getId(), auditoria);
            DataVariable dataVariable = new DataVariable();
            BeanUtils.copyProperties(dataVariableRequestDTO, dataVariable);
            iDataVariableRepository.save(dataVariable);
            procedureInvoker.procedureName(aud,"","variable_info_alfa", dataVariable.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Data Variable actualizada correctamente, id data variable: " + dataVariable.getId());

        } catch(Exception e) {
            throw new NotFoundException("Error: "+ e.getMessage());
        }

    }

    @Override
    public ResponseEntity<String> deleteDataVariable(Long id, String auditoria, String motivo) {
        try {
            String aud = configurarAuditoria(id, auditoria);
            iDataVariableRepository.delete(id);
            procedureInvoker.procedureName(aud,motivo,"variable_info_alfa", id);
            return ResponseEntity.status(HttpStatus.OK).body("Dato de variable eliminado correctamente");
        } catch (Exception ex) {
            return new ResponseEntity<String>(Mensajes.NO_DELETE_DATO, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    public List<DataVariableResponseDTO> obtenerTodos() {
        return iDataVariableRepository.obtenerTodos();
    }

    public List<DataVariableResponseDTO> obtenerTodos(Integer rows, Integer page) {
        return iDataVariableRepository.obtenerTodos(rows, page);
    }

    public List<DataVariableResponseDTO> obtenerById(Long id) {
        return iDataVariableRepository.obtenerById(id);
    }

    public Integer obtenerPaginas(Integer rows) {
        return iDataVariableRepository.obtenerPaginas(rows);
    }

    public List<DataVariableResponseDTO> obtenerByAny(DataVariableRequestDTO dataVariableRequestDTO) {
        System.out.println("ingresa al servicio");
        String condicion = "1=1";
        System.out.println(dataVariableRequestDTO.toString());
        String query = "ind.id,\n" +
                "ind.id_variable,\n" +
                "ind.id_proceso_variable,\n" +
                "ind.id_componente_desagrega_item,\n" +
                "ind.valor,\n" +
                "ind.periodo_inicial_validez,\n" +
                "ind.periodo_final_validez,\n" +
                "ind.id_tipo_estado,\n" +
                "ind.motivo,\n" +
                "ind.motivo_complementario";
        System.out.println("query :: " + query);
        return iDataVariableRepository.obtenerByAny(condicion);
    }

    @Override
    public List<DataVariableResponseDTO> getDataVariableIdVariable(Long id) {
        List<DataVariableResponseDTO> listaDataVariable = iDataVariableRepository.obtenerByIdVariable(id);
        return listaDataVariable;
    }

    private Boolean evaluarUnicoEstado(List<Long> estados) {

        int longEstados = (new ArrayList<Long>(new HashSet<Long>(estados))).size();

        if (longEstados == 1 ) {
            return true;
        } else {
            return false;
        }

    }

    private Boolean evaluarEstado(Long estadoActual, Long estadoNuevo ) {

        if (estadoActual == EstadosIndicador.PENDIENTE_VALIDAR) {
            return estadoNuevo == EstadosIndicador.VALIDADO || estadoNuevo == EstadosIndicador.RECHAZADO || estadoNuevo == EstadosIndicador.APROBADO ? true : false;
        } else if (estadoActual == EstadosIndicador.VALIDADO) {
            return estadoNuevo == EstadosIndicador.PENDIENTE_APROBACION || estadoNuevo == EstadosIndicador.APROBADO || estadoNuevo == EstadosIndicador.RECHAZADO ? true : false;
        } else if (estadoActual == EstadosIndicador.PENDIENTE_APROBACION) {
            return estadoNuevo == EstadosIndicador.APROBADO || estadoNuevo == EstadosIndicador.RECHAZADO ? true : false;
        } else if (estadoActual == EstadosIndicador.APROBADO) {
            return estadoNuevo == EstadosIndicador.PENDIENTE_VALIDAR || estadoNuevo == EstadosIndicador.PENDIENTE_APROBACION ? true : false;
        } else if (estadoActual == EstadosIndicador.RECHAZADO) {
            return estadoNuevo == EstadosIndicador.VALIDADO || estadoNuevo == EstadosIndicador.PENDIENTE_VALIDAR || estadoNuevo == EstadosIndicador.PENDIENTE_APROBACION ? true : false;
        } else {
            return false;
        }

    }

    public  ResponseEntity<Object> addDataVariableMasivo(List<DataVariableRequestDTO> dataVariableRequestDTO, String auditoria, Boolean mantener) {
        try {
            List<CreateResponseDTO> resultado = new ArrayList<CreateResponseDTO>();

            Iterator it = dataVariableRequestDTO.iterator();
            while (it.hasNext()){
                DataVariableRequestDTO d = (DataVariableRequestDTO)it.next();
                logger.severe("insertar..." + d.getValor());
                resultado.add(datosVariableMR(d, auditoria, mantener));
            }
            return new ResponseEntity<Object>(resultado, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.severe("[ERR MASIVO] " + e.getStackTrace().toString());
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Variable");
            c.setMensaje(Mensajes.ERROR_GENERAL_SERVICIO);
            return new ResponseEntity<Object>(c, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Object> updateDataVariableMasivo(List<DataVariableRequestDTO> dataVariableRequestDTO, String auditoria) {

        try {

            List<CreateResponseDTO> resultado = new ArrayList<CreateResponseDTO>();

            Iterator it = dataVariableRequestDTO.iterator();
            while (it.hasNext()){
                DataVariableRequestDTO d = (DataVariableRequestDTO)it.next();
                try {
                    DataVariable dato = new DataVariable();
                    BeanUtils.copyProperties(d, dato);
                    iDataVariableRepository.save(dato);
                    String aud = configurarAuditoria(dato.getId(), auditoria);
                    procedureInvoker.procedureName(aud,"","variable_info_alfa", dato.getId());
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Variable");
                    c.setId(dato.getId());
                    c.setMensaje("Creado correctamente.");
                    c.setObjeto(d);

                    resultado.add(c);
                } catch (Exception e) {
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Variable");
                    c.setId(null);
                    c.setMensaje(e.getMessage());
                    c.setObjeto(d);
                    resultado.add(c);
                }
            }

            return new ResponseEntity<Object>(resultado, HttpStatus.OK);
        } catch(Exception e) {
            throw new NotFoundException("Error: "+ e.getMessage());
        }

    }

    @Transactional
    public ResponseEntity<Object> deleteDataVariableWithIds(List<Long> ids, String auditoria, String motivo) {
        try {
            iDataVariableRepository.deleteDataVariableWithIds(ids);
            Iterator it = ids.iterator();
            while (it.hasNext()) {
                Long _id = (Long)it.next();
                String aud = configurarAuditoria(_id, auditoria);
                procedureInvoker.procedureName(aud,motivo,"variable_info_alfa", _id);
            }
            return new ResponseEntity<Object>(ids, HttpStatus.OK);
        } catch(Exception e) {
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Variable");
            c.setMensaje(Mensajes.NO_DELETE_DATO);
            return new ResponseEntity<Object>(c, HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Object> validarAprobarDataVariable(List<ValidarAprobarDataVariableRequestDTO> validarAprobarDataVariableRequestDTO, String auditoria, String motivo, Long estado, Integer notificar) {
        List<Long> estados = new ArrayList<>();
        Iterator it = validarAprobarDataVariableRequestDTO.iterator();
        while (it.hasNext()) {
            estados.add(((ValidarAprobarDataVariableRequestDTO)it.next()).getIdTipoEstado());
        }

        List<CreateResponseDTO> resultado = new ArrayList<CreateResponseDTO>();

        if (!evaluarUnicoEstado(estados)) {
            logger.info("[VAL] "+Mensajes.ERROR_UNICO_TIPO_CAMBIO_ESTADO);
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Variable");
            c.setMensaje(Mensajes.ERROR_UNICO_TIPO_CAMBIO_ESTADO);
            resultado.add(c);
            return new ResponseEntity<Object>(resultado, HttpStatus.NOT_ACCEPTABLE);
        } else if (!evaluarEstado(validarAprobarDataVariableRequestDTO.get(0).getIdTipoEstado(), estado)) {
            logger.info("[VAL] "+Mensajes.ERROR_NUEVO_CAMBIO_ESTADO);
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Variable");
            c.setMensaje(Mensajes.ERROR_NUEVO_CAMBIO_ESTADO);
            resultado.add(c);
            return new ResponseEntity<Object>(resultado, HttpStatus.NOT_ACCEPTABLE);
        }
        try {

            Iterator it2 = validarAprobarDataVariableRequestDTO.iterator();
            while (it2.hasNext()) {
                ValidarAprobarDataVariableRequestDTO d = (ValidarAprobarDataVariableRequestDTO)it2.next();
                try {
                    iDataVariableRepository.updateEstadoDataVariable(d.getId(), estado );//dato.getIdTipoEstado());
                    String aud = configurarAuditoria(d.getId(), auditoria);
                    procedureInvoker.procedureName(aud,"","variable_info_alfa", d.getId());
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Variable");
                    c.setId(d.getId());
                    c.setMensaje(Mensajes.CAMBIO_ESTADO_OK);
                    c.setObjeto(d);

                    resultado.add(c);
                } catch (DataAccessException ex) {
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Variable");
                    c.setId(null);
                    c.setMensaje(Mensajes.ERROR_CAMBIO_ESTADO);
                    c.setObjeto(d);
                    resultado.add(c);
                }
            }

            return new ResponseEntity<Object>(resultado, HttpStatus.OK);
        } catch(Exception e) {
            logger.info("[EX] " + e.getMessage());
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Variable");
            c.setMensaje(Mensajes.ERROR_GLOBAL_CAMBIO_ESTADO);
            resultado.add(c);
            return new ResponseEntity<Object>(resultado, HttpStatus.BAD_REQUEST);
        }
    }

    private String configurarAuditoria(Long id, String auditoria) {
        try {
            byte[] auditoriaValue = DatatypeConverter.parseBase64Binary(auditoria);
            String auditoriaDecode = new String(auditoriaValue, StandardCharsets.UTF_8);
            JSONObject auditoriaJsonObject = new JSONObject(auditoriaDecode);
            String tipoAccion = auditoriaJsonObject.optString("tipoAccion","N/A");
            String usuario = auditoriaJsonObject.optString("usuario","N/A");
            String formaCarga = "";
            switch (tipoAccion) {
                case "Carga individual":
                    formaCarga = tipoAccion + "::" + usuario;
                    break;
                case "Carga masiva":
                    formaCarga = tipoAccion + "::" + usuario;
                    break;
                default:
                    Object lastAuditoria = iDataVariableRepository.getLastAuditoria(id);
                    byte[] lastAuditoriaValue = DatatypeConverter.parseBase64Binary(lastAuditoria.toString());
                    String lastAuditoriaDecode = new String(lastAuditoriaValue, StandardCharsets.UTF_8);
                    JSONObject lastAuditoriaJsonObject = new JSONObject(lastAuditoriaDecode);
                    formaCarga = lastAuditoriaJsonObject.optString("formaCarga","Carga individual::admin");
                    break;
            }

            logger.info(formaCarga);
            auditoriaJsonObject.putOpt("formaCarga", formaCarga);

            String auditoriaEncode = DatatypeConverter.printBase64Binary(auditoriaJsonObject.toString().getBytes(StandardCharsets.UTF_8));

            return auditoriaEncode;
        } catch (Exception ex) {
            return auditoria;
        }
    }
}
