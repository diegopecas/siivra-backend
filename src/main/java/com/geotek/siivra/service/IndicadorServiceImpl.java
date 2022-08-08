package com.geotek.siivra.service;

import com.geotek.siivra.constantes.Mensajes;
import com.geotek.siivra.dto.request.IndicadorRequestDTO;
import com.geotek.siivra.dto.request.common.IndicadorXCapaRequestDTO;
import com.geotek.siivra.dto.request.common.IndicadorXVarIndRequestDTO;
import com.geotek.siivra.dto.response.*;
import com.geotek.siivra.entity.Indicador;
import com.geotek.siivra.entity.common.IndicadorXCapa;
import com.geotek.siivra.entity.common.IndicadorXVarInd;
import com.geotek.siivra.repository.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

@Service
public class IndicadorServiceImpl implements IIndicadorService {

    static Logger logger = Logger.getLogger(IndicadorServiceImpl.class.getName());

    @Autowired
    private IIndicadorRepository iIndicadorRepository;

    @Autowired
    private IIndicadorXVarIndRepository iIndicadorXVarIndRepository;

    @Autowired
    private IIndicadorXCapaRepository iIndicadorXCapaRepository;

    @Autowired
    private IVariableRepository iVariableRepository;

    @Autowired
    private IDataIndicadorRepository iDataIndicadorRepository;

    @Autowired
    private AuditoriaRepository procedureInvoker;

    private boolean validarNombre(String nombre){
        return iIndicadorRepository.comprobarNombre(nombre) > 0 ? true : false;
    }

    private boolean validarNombre(String nombre, Long id){
        return iIndicadorRepository.comprobarNombre(nombre, id) > 0 ? true : false;
    }

    private boolean validarCodigo(String codigo){
        return iIndicadorRepository.comprobarCodigo(codigo) > 0 ? true : false;
    }

    private boolean validarCodigo(String codigo, Long id){
        return iIndicadorRepository.comprobarCodigo(codigo, id) > 0 ? true : false;
    }

    @Override
    public ResponseEntity<Object> addIndicador(IndicadorRequestDTO indicadorRequestDTO, String auditoria) {
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setEntidad("Indicador");

        if(validarNombre(indicadorRequestDTO.getNombre())){
            createResponseDTO.setMensaje(Mensajes.EXISTE_INDICADOR_NOMBRE);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }

        if(validarCodigo(indicadorRequestDTO.getCodigo())){
            createResponseDTO.setMensaje(Mensajes.EXISTE_INDICADOR_CODIGO);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }

        Indicador indicador = new Indicador();

        try {
            // Crear el indicador
            try {
                BeanUtils.copyProperties(indicadorRequestDTO, indicador);
                iIndicadorRepository.save(indicador);
                procedureInvoker.procedureName(auditoria,"","indicador", indicador.getId());
                createResponseDTO.setId(indicador.getId());
                createResponseDTO.setObjeto(indicador);
            } catch (DataAccessException ex) {
                final String mensaje = dataExceptionInterpreter(ex.getMostSpecificCause().getMessage());
                createResponseDTO.setMensaje(mensaje);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            } catch(Exception exInd) {
                createResponseDTO.setMensaje(Mensajes.NO_ADD_INDICADOR);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }

            // Agregar variables e indicadores asociados
            try {
                List<IndicadorXVarInd> listIndicadorXVarInd = new ArrayList<IndicadorXVarInd>();
                Iterator it = indicadorRequestDTO.getListIndicadorXVarInd().iterator();
                while(it.hasNext()){
                    IndicadorXVarIndRequestDTO ind = (IndicadorXVarIndRequestDTO)it.next();
                    IndicadorXVarInd indVar =  new IndicadorXVarInd();
                    BeanUtils.copyProperties(ind, indVar);
                    indVar.setIdIndicador(indicador.getId());
                    listIndicadorXVarInd.add(indVar);
                }

                iIndicadorXVarIndRepository.save(listIndicadorXVarInd);
            } catch(Exception exIndVar) {

                createResponseDTO.setEntidad("Indicador por variable e indicador");
                createResponseDTO.setMensaje(Mensajes.INDICADOR_CREADO_SIN_VARIND);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }

            // Agregar capas asociadas
            try {
                List<IndicadorXCapa> listIndicadorXCapa = new ArrayList<IndicadorXCapa>();
                Iterator it = indicadorRequestDTO.getListIndicadorXCapa().iterator();
                while (it.hasNext()){
                    IndicadorXCapaRequestDTO ind = (IndicadorXCapaRequestDTO)it.next();
                    if(ind.getIdCapaGeografica() > 0) {
                        IndicadorXCapa indCapa =  new IndicadorXCapa();
                        BeanUtils.copyProperties(ind, indCapa);
                        indCapa.setIdIndicador(indicador.getId());
                        indCapa.setIdCompDesagregacion(indicador.getIdCompDesagregacion());
                        listIndicadorXCapa.add(indCapa);
                    }
                }

                iIndicadorXCapaRepository.save(listIndicadorXCapa);
            } catch(Exception exIndCap) {

                createResponseDTO.setEntidad("Indicador por capa");
                createResponseDTO.setMensaje(Mensajes.INDICADOR_CREADO_SIN_CAPA);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }

            createResponseDTO.setMensaje(Mensajes.INDICADOR_CREADO);
            return ResponseEntity.status(HttpStatus.OK).body((Object)createResponseDTO);

        } catch(Exception e) {
            createResponseDTO.setMensaje(Mensajes.NO_ADD_INDICADOR);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }

    }

    @Override
    public ResponseEntity<Object> updateIndicador(IndicadorRequestDTO indicadorRequestDTO, String auditoria) {
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setEntidad("Indicador");
        createResponseDTO.setId(indicadorRequestDTO.getId());

        if(validarNombre(indicadorRequestDTO.getNombre(), indicadorRequestDTO.getId())){
            createResponseDTO.setMensaje(Mensajes.EXISTE_INDICADOR_NOMBRE);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }

        if(validarCodigo(indicadorRequestDTO.getCodigo(), indicadorRequestDTO.getId())){
            createResponseDTO.setMensaje(Mensajes.EXISTE_INDICADOR_CODIGO);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }

        Indicador indicador = new Indicador();

        try {
            //eliminar las variables, indicadores y capas asociadas al indicador
            try {
                iIndicadorXVarIndRepository.deleteByIdIndicador(indicadorRequestDTO.getId());
                iIndicadorXCapaRepository.deleteByIdIndicador(indicadorRequestDTO.getId());
            } catch (DataAccessException ex) {
                final String mensaje = dataExceptionInterpreter(ex.getMostSpecificCause().getMessage());
                createResponseDTO.setMensaje(mensaje);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            } catch(Exception exDel) {
                createResponseDTO.setMensaje(Mensajes.NO_UPDATE_INDICADOR);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }

            // Actualizar un indicador
            try {
                BeanUtils.copyProperties(indicadorRequestDTO, indicador);
                iIndicadorRepository.save(indicador);
                procedureInvoker.procedureName(auditoria,"","indicador", indicador.getId());
            } catch (DataAccessException ex) {
                final String mensaje = dataExceptionInterpreter(ex.getMostSpecificCause().getMessage());
                createResponseDTO.setMensaje(mensaje);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            } catch(Exception exInd) {
                createResponseDTO.setMensaje(Mensajes.NO_UPDATE_INDICADOR);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }

            // Agregar variables e indicadores asociados
            try {
                List<IndicadorXVarInd> listIndicadorXVarInd = new ArrayList<IndicadorXVarInd>();
                Iterator it = indicadorRequestDTO.getListIndicadorXVarInd().iterator();
                while (it.hasNext()){
                    IndicadorXVarIndRequestDTO ind = (IndicadorXVarIndRequestDTO)it.next();
                    IndicadorXVarInd indVar =  new IndicadorXVarInd();
                    BeanUtils.copyProperties(ind, indVar);
                    indVar.setIdIndicador(indicador.getId());
                    listIndicadorXVarInd.add(indVar);
                }

                iIndicadorXVarIndRepository.save(listIndicadorXVarInd);
            } catch(Exception exIndVar) {

                createResponseDTO.setEntidad("Indicador por variable e indicador");
                createResponseDTO.setMensaje(Mensajes.INDICADOR_CREADO_SIN_VARIND);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }

            // Agregar capas asociadas
            try {
                List<IndicadorXCapa> listIndicadorXCapa = new ArrayList<IndicadorXCapa>();
                Iterator it = indicadorRequestDTO.getListIndicadorXCapa().iterator();
                while (it.hasNext()){
                    IndicadorXCapaRequestDTO ind = (IndicadorXCapaRequestDTO)it.next();
                    if(ind.getIdCapaGeografica() > 0) {
                        IndicadorXCapa indCapa =  new IndicadorXCapa();
                        BeanUtils.copyProperties(ind, indCapa);
                        indCapa.setIdIndicador(indicador.getId());
                        indCapa.setIdCompDesagregacion(indicador.getIdCompDesagregacion());
                        listIndicadorXCapa.add(indCapa);
                    }
                }

                iIndicadorXCapaRepository.save(listIndicadorXCapa);
            } catch(Exception exIndCap) {

                createResponseDTO.setEntidad("Indicador por capa");
                createResponseDTO.setMensaje(Mensajes.INDICADOR_CREADO_SIN_CAPA);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }

            createResponseDTO.setMensaje(Mensajes.INDICADOR_ACTUALIZADO);
            return ResponseEntity.status(HttpStatus.OK).body((Object)createResponseDTO);

        } catch(Exception e) {
            createResponseDTO.setMensaje(Mensajes.NO_UPDATE_INDICADOR);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }
    }

    @Override
    public ResponseEntity<Object> deleteIndicador(Long id, String auditoria, String motivo) {
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setEntidad("Indicador");
        createResponseDTO.setId(id);
        try {
            // tiene asociados
            List<IndicadorXVarInd> relacionadosHijos = iIndicadorXVarIndRepository.findindicadorXVarIndByIdIndHijo(id);
            if(relacionadosHijos.size() > 0){
                createResponseDTO.setMensaje(Mensajes.INDICADOR_ASOCIADO_INDICADOR);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }
            // está asociado a otro
            List<IndicadorXVarInd> relacionados = iIndicadorXVarIndRepository.findindicadorXVarIndByIdIndPadre(id);
            if(relacionados.size() > 0){
                createResponseDTO.setMensaje(Mensajes.INDICADOR_TIENE_ASOCIADOS);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }
            long registros = iDataIndicadorRepository.getCountOfDataByIndicador(id);
            iIndicadorRepository.delete(id);
            procedureInvoker.procedureName(auditoria,motivo,"indicador", id);
            if(registros > 0) {
                createResponseDTO.setMensaje(Mensajes.INDICADOR_ELIMINADO_CON_DATOS);
            } else {
                createResponseDTO.setMensaje(Mensajes.INDICADOR_ELIMINADO);
            }

            return ResponseEntity.status(HttpStatus.OK).body((Object)createResponseDTO);
        } catch (DataAccessException ex) {
            final String mensaje = dataExceptionInterpreter(ex.getMostSpecificCause().getMessage());
            createResponseDTO.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        } catch(Exception e) {
            createResponseDTO.setMensaje(Mensajes.NO_DELETE_INDICADOR);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((Object)createResponseDTO);
        }
    }

    public List<IndicadorResponseDTO> obtenerTodos() {
        return iIndicadorRepository.obtenerTodos();
    }

    public List<IndicadorResponseDTO> obtenerTodos(Integer rows, Integer page) {
        return iIndicadorRepository.obtenerTodos(rows, page);
    }

    public List<IndicadorResponseDTO> obtenerTodos(Integer rows, Integer page, String value) {
        String condicion = "%";
        if(value != null) {
            condicion = '%' + value + '%';
        }
        return iIndicadorRepository.obtenerTodos(rows, page, condicion);
    }

    public IndicadorResponseCompleteDTO obtenerById(Long id) {
        try {
            IndicadorResponseCompleteDTO indicadorComplete = new IndicadorResponseCompleteDTO();

            List<IndicadorResponseDTO> indicadores = iIndicadorRepository.obtenerById(id);
            BeanUtils.copyProperties(indicadores.get(0), indicadorComplete);

            List<IndicadorIndVarResponseDTO> indicadoresVariables = iIndicadorRepository.obtenerVarIndDeIndicador(id);
            indicadorComplete.setListIndicadorXVarInd(indicadoresVariables);

            List<IndicadorCgResponseDTO> indicadoresCapaGeo = iIndicadorRepository.obtenerCapasDeIndicador(id);
            indicadorComplete.setListIndicadorXCapa(indicadoresCapaGeo);

            return indicadorComplete;
        } catch(Exception ex) {
            return null;
        }
    }

    public Integer obtenerPaginas(Integer rows) {
        return iIndicadorRepository.obtenerPaginas(rows);
    }

    public Integer obtenerPaginas(Integer rows, String value) {
        String condicion = "%";
        if(value != null) {
            condicion = '%' + value + '%';
        }
        return iIndicadorRepository.obtenerPaginas(rows, condicion);
    }

    public List<IndicadorResponseDTO> obtenerByAny(String value) {
        String condicion = "%";
        if(value != null) {
            condicion = '%' + value + '%';
        }

        return iIndicadorRepository.obtenerByAny(condicion);
    }

    private String dataExceptionInterpreter(String ex){
        if((ex.contains("duplicate key") || ex.contains("llave duplicada")) && ex.contains("codigo")){
            return Mensajes.EXISTE_INDICADOR_CODIGO;
        }
        if((ex.contains("duplicate key") || ex.contains("llave duplicada")) && ex.contains("nombre")){
            return Mensajes.EXISTE_INDICADOR_NOMBRE;
        }
        if(ex.contains("siivrat_indicador_x_var_ind")) {
            return Mensajes.ELEMENTO_ASOCIADO_INDICADOR;
        }
        if(ex.contains("siivrat_modelo_x_indicador")) {
            return Mensajes.ELEMENTO_ASOCIADO_MODELO;
        }
        if(ex.contains("update or delete") && (ex.contains("violates foreign key constraint") || ex.contains("llave foránea"))) {
            return Mensajes.ELEMENTO_ASOCIADO_GENERAL;
        }

        return Mensajes.INDICADOR_ERROR_GENERAL;
    }
}
