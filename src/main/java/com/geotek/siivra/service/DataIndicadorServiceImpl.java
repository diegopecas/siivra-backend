package com.geotek.siivra.service;

import com.geotek.siivra.api.email.rest.EmailBody;
import com.geotek.siivra.api.email.rest.EmailService;
import com.geotek.siivra.constantes.EstadosIndicador;
import com.geotek.siivra.constantes.Mensajes;
import com.geotek.siivra.constantes.Notificaciones;
import com.geotek.siivra.dto.request.ValidarAprobarDataIndicadorRequestDTO;
import com.geotek.siivra.dto.response.DataIndicadorResponseDTO;
import com.geotek.siivra.dto.request.DataIndicadorRequestDTO;
import com.geotek.siivra.dto.response.CreateResponseDTO;
import com.geotek.siivra.entity.DataIndicador;
import com.geotek.siivra.entity.DataVariable;
import com.geotek.siivra.entity.Indicador;
import com.geotek.siivra.exception.NotFoundException;
import com.geotek.siivra.repository.AuditoriaRepository;
import com.geotek.siivra.repository.ICompDesagreacionItemRepository;
import com.geotek.siivra.repository.IDataIndicadorRepository;
import com.geotek.siivra.repository.IIndicadorRepository;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;
// import java.util.stream.Collectors;

@Service
public class DataIndicadorServiceImpl implements IDataIndicadorService {
    static Logger logger = Logger.getLogger(com.geotek.siivra.service.DataIndicadorServiceImpl.class.getName());

    @Autowired
    private IDataIndicadorRepository iDataIndicadorRepository;

    @Autowired
    private ICompDesagreacionItemRepository iCompDesagreacionItemRepository;

    @Autowired
    private AuditoriaRepository procedureInvoker;

    @Autowired
    EmailService emailService;

    @Autowired
    private IIndicadorRepository iIndicadorRepository;

    private CreateResponseDTO datosIndicadorMR(DataIndicadorRequestDTO dataIndicadorRequestDTO, String auditoria, Boolean mantener) {
        CreateResponseDTO c = new CreateResponseDTO();
        c.setEntidad("Data Indicador");
        List adds = new ArrayList();

        if(dataIndicadorRequestDTO.getValor() == null) {
            c.setMensaje(Mensajes.VALOR_NO_NUMERICO);
            adds.add(dataIndicadorRequestDTO);
            c.setObjeto(adds);
            return c;
        }
        if(dataIndicadorRequestDTO.getIdComponenteDesagregaItem() == null) {
            c.setMensaje(Mensajes.NO_EXISTE_COMP_DESAGREGACION);
            adds.add(dataIndicadorRequestDTO);
            c.setObjeto(adds);
            return c;
        }
        if(dataIndicadorRequestDTO.getValorMeta() == -1d) {
            c.setMensaje(Mensajes.VALOR_META_NO_NUMERICO);
            adds.add(dataIndicadorRequestDTO);
            c.setObjeto(adds);
            return c;
        }
        if (iCompDesagreacionItemRepository.findOne(dataIndicadorRequestDTO.getIdComponenteDesagregaItem()) == null){
            c.setMensaje(Mensajes.NO_EXISTE_COMP_DESAGREGACION);
            adds.add(dataIndicadorRequestDTO);
            c.setObjeto(adds);
            return c;
        }

        try {
            String resumen = "";
            if (mantener) { // mantener
                if (dataIndicadorRequestDTO.getId() != null) {
                    c.setId(null);
                    resumen = resumen.concat(dataIndicadorRequestDTO.getPeriodoInicialValidez()+", existe.");
                    c.setMensaje(Mensajes.EXISTE_DATO_INDICADOR_X_PERIODO+resumen);
                } else {

                    int inicioPeriodo = Integer.parseInt(dataIndicadorRequestDTO.getPeriodoInicialValidez());
                    int finalPeriodo = Integer.parseInt(dataIndicadorRequestDTO.getPeriodoFinalValidez());
                    for(int periodo = inicioPeriodo; periodo <= finalPeriodo; periodo++) {

                        DataIndicador dataIndicador = new DataIndicador();

                        BeanUtils.copyProperties(dataIndicadorRequestDTO, dataIndicador);
                        if(dataIndicadorRequestDTO.getValorMeta() == -2d) {
                            dataIndicador.setValorMeta(null);
                        }

                        dataIndicador.setPeriodoInicialValidez(String.valueOf(periodo));
                        dataIndicador.setPeriodoFinalValidez(String.valueOf(periodo));

                        List<DataIndicador> data = iDataIndicadorRepository.findByPeriodo(dataIndicador.getIdIndicador(), dataIndicador.getIdComponenteDesagregaItem(), String.valueOf(periodo), String.valueOf(periodo));
                        if (data.size() == 0 ) {
                            try {
                                logger.info("Crear dato nuevo en mantener: " + periodo);
                                iDataIndicadorRepository.save(dataIndicador);
                                resumen = resumen.concat(periodo+", creado.");
                                String aud = configurarAuditoria(dataIndicador.getId(), auditoria);
                                procedureInvoker.procedureName(aud, "","indicador_info_alfa",dataIndicador.getId());
                                adds.add(dataIndicador);
                            } catch (Exception dex) {
                                // adds.add(dataIndicador);
                                resumen = resumen.concat(periodo+", error al crear.");
                            }
                        } else {
                            resumen = resumen.concat(periodo+", existe.");
                        }

                        if(String.valueOf(periodo).substring(String.valueOf(periodo).length() - 2).compareTo("12") == 0) {
                            periodo = Integer.parseInt(String.valueOf(periodo).substring( 0 , 4 ) + "99") + 1;
                        }
                    }
                    c.setId(null);
                    if (adds.size() > 0) {
                        String men = "Periodos: "+resumen;
                        c.setMensaje(Mensajes.DATO_INDICADOR_ADD_MANTENER + men);
                    } else {
                        adds.add(dataIndicadorRequestDTO);
                        c.setMensaje(Mensajes.DATO_INDICADOR_ADD_NO_DATA+dataIndicadorRequestDTO.getPeriodoInicialValidez()+", existe.");
                    }
                }
            } else { // reemplazar
                if (dataIndicadorRequestDTO.getId() != null) { // dato existente que viene con ID conocido - update
                    DataIndicador dataIndicador = new DataIndicador();

                    BeanUtils.copyProperties(dataIndicadorRequestDTO, dataIndicador);
                    if(dataIndicadorRequestDTO.getValorMeta() == -2d) {
                        dataIndicador.setValorMeta(null);
                    }
                    try {
                        iDataIndicadorRepository.save(dataIndicador);
                        resumen = resumen.concat(dataIndicador.getPeriodoInicialValidez()+", reemplazado.");
                        String aud = configurarAuditoria(dataIndicador.getId(), auditoria);
                        procedureInvoker.procedureName(aud, "","indicador_info_alfa",dataIndicador.getId());
                        adds.add(dataIndicador);
                    } catch (Exception dex) {
                        adds.add(dataIndicador);
                        resumen = resumen.concat(dataIndicador.getPeriodoInicialValidez()+", error al reemplazar.");
                    }
                    c.setId(dataIndicador.getId());
                    if (adds.size() > 0) {
                        String men = "Periodos: "+resumen;
                        c.setMensaje(Mensajes.DATO_INDICADOR_REEMPLAZAR + men);
                    } else {
                        c.setMensaje(Mensajes.DATO_INDICADOR_ADD_NO_DATA);
                    }
                } else { // dato sin ID conocido - create
                    if (dataIndicadorRequestDTO.getPeriodoInicialValidez().compareTo(dataIndicadorRequestDTO.getPeriodoFinalValidez())==0) { // mismo periodo
                        DataIndicador dataIndicador = new DataIndicador();
                        BeanUtils.copyProperties(dataIndicadorRequestDTO, dataIndicador);
                        List<DataIndicador> data = iDataIndicadorRepository.findByPeriodo(dataIndicador.getIdIndicador(), dataIndicador.getIdComponenteDesagregaItem(), dataIndicadorRequestDTO.getPeriodoInicialValidez(), dataIndicadorRequestDTO.getPeriodoFinalValidez());
                        if (data.size() > 0 ) {
                            dataIndicador.setId(data.get(0).getId());
                        }
                        if(dataIndicadorRequestDTO.getValorMeta() == -2d) {
                            dataIndicador.setValorMeta(null);
                        }
                        try {
                            iDataIndicadorRepository.save(dataIndicador);
                            if(data.size() > 0 ) {
                                resumen = resumen.concat(dataIndicador.getPeriodoInicialValidez()+", reemplazado.");
                            } else {
                                resumen = resumen.concat(dataIndicador.getPeriodoInicialValidez()+", creado.");
                            }
                            String aud = configurarAuditoria(dataIndicador.getId(), auditoria);
                            procedureInvoker.procedureName(aud, "","indicador_info_alfa",dataIndicador.getId());
                            adds.add(dataIndicador);
                        } catch (Exception dex) {
                            adds.add(dataIndicador);
                            resumen = resumen.concat(dataIndicador.getPeriodoInicialValidez()+", error al crear.");
                        }
                        c.setId(dataIndicador.getId());
                        if (adds.size() > 0) {
                            String men = "Periodos: "+resumen;
                            c.setMensaje(Mensajes.DATO_INDICADOR_NUEVO + men);
                        } else {
                            c.setMensaje(Mensajes.DATO_INDICADOR_ADD_NO_DATA);
                        }
                    } else { // diferente periodo
                        for(int periodo = Integer.parseInt(dataIndicadorRequestDTO.getPeriodoInicialValidez()); periodo <= Integer.parseInt(dataIndicadorRequestDTO.getPeriodoFinalValidez()); periodo++) {
                            DataIndicador dataIndicador = new DataIndicador();

                            BeanUtils.copyProperties(dataIndicadorRequestDTO, dataIndicador);
                            if(dataIndicadorRequestDTO.getValorMeta() == -2d) {
                                dataIndicador.setValorMeta(null);
                            }
                            dataIndicador.setPeriodoInicialValidez(String.valueOf(periodo));
                            dataIndicador.setPeriodoFinalValidez(String.valueOf(periodo));

                            List<DataIndicador> data = iDataIndicadorRepository.findByPeriodo(dataIndicador.getIdIndicador(), dataIndicador.getIdComponenteDesagregaItem(), String.valueOf(periodo), String.valueOf(periodo));
                            if (data.size() > 0 ) {
                                dataIndicador.setId(data.get(0).getId());
                                logger.info("SE OBTIENE ID EN PERIODOS DIFERENTES "+data.get(0).getId());
                            }
                            try {
                                iDataIndicadorRepository.save(dataIndicador);
                                if(data.size() > 0 ) {
                                    resumen = resumen.concat(periodo+", reemplazado.");
                                } else {
                                    resumen = resumen.concat(periodo+", creado.");
                                }
                                String aud = configurarAuditoria(dataIndicador.getId(), auditoria);
                                procedureInvoker.procedureName(aud, "","indicador_info_alfa",dataIndicador.getId());
                                adds.add(dataIndicador);
                            } catch (Exception dex) {
                                adds.add(dataIndicador);
                                resumen = resumen.concat(periodo+", error al crear/reemplazar.");
                            }
                            if(String.valueOf(periodo).substring(String.valueOf(periodo).length() - 2).compareTo("12") == 0) {
                                periodo = Integer.parseInt(String.valueOf(periodo).substring( 0 , 4 ) + "99") + 1;
                            }
                        }
                        c.setId(null);
                        if (adds.size() > 0) {
                            String men = "Periodos: "+resumen;
                            c.setMensaje(Mensajes.DATO_INDICADOR_ADD_MANTENER + men);
                        } else {
                            c.setMensaje(Mensajes.DATO_INDICADOR_ADD_NO_DATA);
                        }
                    }
                }
            }
            c.setObjeto(adds);
            return c; // ResponseEntity.status(HttpStatus.CREATED).body(c);
        } catch(Exception e) {
            logger.info("[DATA INDICADOR]" + e.getLocalizedMessage());
            c.setMensaje("Ocurrió un error en el servicio al procesar la petición.");
            return c;
        }
    }

    @Override
    public ResponseEntity<Object> addDataIndicador(DataIndicadorRequestDTO dataIndicadorRequestDTO, String auditoria, Boolean mantener) {
        return ResponseEntity.status(HttpStatus.CREATED).body((Object)datosIndicadorMR(dataIndicadorRequestDTO, auditoria, mantener));
    }

    public  ResponseEntity<Object> addDataIndicadorMasivo(List<DataIndicadorRequestDTO> dataIndicadorRequestDTO, String auditoria, Boolean mantener) {
        try {
            List<CreateResponseDTO> resultado = new ArrayList<CreateResponseDTO>();
            logger.info("AUD DI: "+auditoria);
            Iterator it = dataIndicadorRequestDTO.iterator();
            while (it.hasNext()){
                resultado.add(datosIndicadorMR((DataIndicadorRequestDTO) it.next(), auditoria, mantener));
            }

            return new ResponseEntity<Object>(resultado, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.info("[DATA INDICADOR MASIVO] " + e.getMessage());
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Indicador");
            c.setMensaje("Se generó un error en el servicio al intentar procesar la petición.");
            return new ResponseEntity<Object>(c, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<String> updateDataIndicador(DataIndicadorRequestDTO dataIndicadorRequestDTO, String auditoria) {

        try {

            DataIndicador dataIndicador = new DataIndicador();
            BeanUtils.copyProperties(dataIndicadorRequestDTO, dataIndicador);
            iDataIndicadorRepository.save(dataIndicador);
            String aud = configurarAuditoria(dataIndicador.getId(), auditoria);
            procedureInvoker.procedureName(aud, "","indicador_info_alfa",dataIndicador.getId());
            return ResponseEntity.status(HttpStatus.OK).body("Data Indicador actualizado correctamente, id data indicador: " + dataIndicador.getId());

        } catch(Exception e) {
            throw new NotFoundException("Error: "+ e.getMessage());
        }

    }

    @Override
    public ResponseEntity<Object> deleteDataIndicador(Long id, String auditoria, String motivo) {
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        try {
            iDataIndicadorRepository.delete(id);
            String aud = configurarAuditoria(id, auditoria);
            procedureInvoker.procedureName(aud, motivo,"indicador_info_alfa",id);
            createResponseDTO.setEntidad("Data indicador");
            createResponseDTO.setId(id);
            createResponseDTO.setMensaje(Mensajes.DATO_ELIMINADO);
            return ResponseEntity.status(HttpStatus.OK).body((Object)createResponseDTO);
        } catch(Exception e) {
            createResponseDTO.setEntidad("Data indicador");
            createResponseDTO.setId(null);
            createResponseDTO.setMensaje(Mensajes.NO_DELETE_DATO);
            createResponseDTO.setObjeto(null);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((Object)createResponseDTO);
        }
    }

    public List<DataIndicadorResponseDTO> obtenerTodos() {
        return iDataIndicadorRepository.obtenerTodos();
    }

    public List<DataIndicadorResponseDTO> obtenerTodos(Integer rows, Integer page) {
        return iDataIndicadorRepository.obtenerTodos(rows, page);
    }

    public List<DataIndicadorResponseDTO> obtenerById(Long id) {
        return iDataIndicadorRepository.obtenerById(id);
    }

    public Integer obtenerPaginas(Integer rows) {
        return iDataIndicadorRepository.obtenerPaginas(rows);
    }

    public List<DataIndicadorResponseDTO> obtenerByAny(DataIndicadorRequestDTO dataIndicadorRequestDTO) {
        String condicion = "1=1";
        String query = "ind.id,\n" +
                "ind.id_indicador,\n" +
                "ind.id_proceso_indicador,\n" +
                "ind.id_componente_desagrega_item,\n" +
                "ind.valor,\n" +
                "ind.periodo_inicial_validez,\n" +
                "ind.periodo_final_validez,\n" +
                "ind.valor_meta,\n" +
                "ind.id_tipo_estado,\n" +
                "ind.motivo,\n" +
                "ind.motivo_complementario";
        return iDataIndicadorRepository.obtenerByAny(condicion);
    }

    @Override
    public List<DataIndicadorResponseDTO> getDataIndicadorIdIndicador(Long id) {
        List<DataIndicadorResponseDTO> listaDataIndicador = iDataIndicadorRepository.buscarPorIndicador(id);
        return listaDataIndicador;
    }

    @Override
    public ResponseEntity<Object> updateDataIndicadorMasivo(List<DataIndicadorRequestDTO> dataIndicadorRequestDTO, String auditoria) {

        try {

            List<CreateResponseDTO> resultado = new ArrayList<CreateResponseDTO>();

            Iterator it = dataIndicadorRequestDTO.iterator();
            while (it.hasNext()){
                DataIndicadorRequestDTO d = (DataIndicadorRequestDTO)it.next();
                try {
                    DataIndicador dato = new DataIndicador();
                    BeanUtils.copyProperties(d, dato);
                    iDataIndicadorRepository.save(dato);
                    String aud = configurarAuditoria(dato.getId(), auditoria);
                    procedureInvoker.procedureName(aud, "","indicador_info_alfa",dato.getId());
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Indicador");
                    c.setId(dato.getId());
                    c.setMensaje("Creado correctamente.");
                    c.setObjeto(d);
                    resultado.add(c);
                } catch (Exception e) {
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Indicador");
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
    public ResponseEntity<Object> deleteDataIndicadorWithIds(List<Long> ids, String auditoria, String motivo) {
        try {
            iDataIndicadorRepository.deleteDataIndicadorWithIds(ids);
            Iterator it = ids.iterator();
            while (it.hasNext()) {
                Long _id = (Long)it.next();
                String aud = configurarAuditoria(_id, auditoria);
                procedureInvoker.procedureName(aud,motivo,"indicador_info_alfa", _id);
            }
            return new ResponseEntity<Object>(ids, HttpStatus.OK);
        } catch(Exception e) {
            throw new NotFoundException("Error: "+ e.getMessage());
        }
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

    @Override
    public ResponseEntity<Object> validarAprobarDataIndicador(List<ValidarAprobarDataIndicadorRequestDTO> validarAprobarDataIndicadorRequestDTO, String auditoria, String motivo, Long estado, Integer notificar) {
        List<Long> estados = new ArrayList<>();
        Iterator it = validarAprobarDataIndicadorRequestDTO.iterator();
        while (it.hasNext()) {
            estados.add(((ValidarAprobarDataIndicadorRequestDTO)it.next()).getIdTipoEstado());
        }

        List<CreateResponseDTO> resultado = new ArrayList<CreateResponseDTO>();

        if (!evaluarUnicoEstado(estados)) {
            logger.info("[VAL] "+Mensajes.ERROR_UNICO_TIPO_CAMBIO_ESTADO);
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Indicador");
            c.setMensaje(Mensajes.ERROR_UNICO_TIPO_CAMBIO_ESTADO);
            resultado.add(c);
            return new ResponseEntity<Object>(resultado, HttpStatus.NOT_ACCEPTABLE);
        } else if (!evaluarEstado(validarAprobarDataIndicadorRequestDTO.get(0).getIdTipoEstado(), estado)) {
            logger.info("[VAL] "+Mensajes.ERROR_NUEVO_CAMBIO_ESTADO);
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Indicador");
            c.setMensaje(Mensajes.ERROR_NUEVO_CAMBIO_ESTADO);
            resultado.add(c);
            return new ResponseEntity<Object>(resultado, HttpStatus.NOT_ACCEPTABLE);
        }
        try {

            Iterator it2 = validarAprobarDataIndicadorRequestDTO.iterator();
            while (it2.hasNext()){
                ValidarAprobarDataIndicadorRequestDTO d = (ValidarAprobarDataIndicadorRequestDTO)it2.next();
                try {
                    iDataIndicadorRepository.updateEstadoDataIndicador(d.getId(), estado );//dato.getIdTipoEstado());
                    String aud = configurarAuditoria(d.getId(), auditoria);
                    procedureInvoker.procedureName(aud, "","indicador_info_alfa",d.getId());
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Indicador");
                    c.setId(d.getId());
                    c.setMensaje(Mensajes.CAMBIO_ESTADO_OK);
                    c.setObjeto(d);

                    resultado.add(c);
                } catch (javax.persistence.TransactionRequiredException e) {
                    logger.info("[EXL] "+e.getLocalizedMessage());
                    CreateResponseDTO c = new CreateResponseDTO();
                    c.setEntidad("Data Indicador");
                    c.setId(null);
                    c.setMensaje(Mensajes.ERROR_CAMBIO_ESTADO);
                    c.setObjeto(d);
                    resultado.add(c);
                }
            }

            return new ResponseEntity<Object>(resultado, HttpStatus.OK);
        } catch(Exception e) {
            logger.info("[EX] " + e.getLocalizedMessage());
            CreateResponseDTO c = new CreateResponseDTO();
            c.setEntidad("Data Indicador");
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
                    Object lastAuditoria = iDataIndicadorRepository.getLastAuditoria(id);
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
