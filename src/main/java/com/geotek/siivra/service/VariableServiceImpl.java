package com.geotek.siivra.service;

import com.geotek.siivra.constantes.Mensajes;
import com.geotek.siivra.dto.request.VariableRequestDTO;
import com.geotek.siivra.dto.response.CreateResponseDTO;
import com.geotek.siivra.dto.response.VariableResponseDTO;
import com.geotek.siivra.entity.Variable;
import com.geotek.siivra.repository.AuditoriaRepository;
import com.geotek.siivra.repository.IDataVariableRepository;
import com.geotek.siivra.repository.IIndicadorXVarIndRepository;
import com.geotek.siivra.repository.IVariableRepository;
import org.postgresql.util.PSQLException;
import org.slf4j.event.Level;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;
import java.lang.*;
import java.util.logging.Logger;


@Service
public class VariableServiceImpl implements IVariableService {

    static Logger logger = Logger.getLogger(VariableServiceImpl.class.getName());

    @Autowired
    private IVariableRepository iVariableRepository;

    @Autowired
    private IDataVariableRepository iDataVariableRepository;

    @Autowired
    private IIndicadorXVarIndRepository iIndicadorXVarIndRepository;

    @Autowired
    private AuditoriaRepository procedureInvoker;

    private boolean validarNombre(String nombre){
        return iVariableRepository.comprobarNombre(nombre) > 0 ? true : false;
    }

    private boolean validarNombre(String nombre, Long id){
        return iVariableRepository.comprobarNombre(nombre, id) > 0 ? true : false;
    }

    @Override
    public ResponseEntity<Object> addVariable(VariableRequestDTO variableRequestDTO, String auditoria) {
        logger.severe("[CREAR UNA NUEVA VARIABLE]");
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setEntidad("Variables");

        if(validarNombre(variableRequestDTO.getNombre())){
            createResponseDTO.setMensaje(Mensajes.EXISTE_VARIABLE_NOMBRE);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }

        Variable variable = new Variable();
        try {
            BeanUtils.copyProperties(variableRequestDTO, variable);
            iVariableRepository.save(variable);
            procedureInvoker.procedureName(auditoria,"","variable", variable.getId());
            createResponseDTO.setId(variable.getId());
            createResponseDTO.setMensaje(Mensajes.VARIABLE_CREADA);
            createResponseDTO.setObjeto(variable);

            return ResponseEntity.status(HttpStatus.CREATED).body((Object)createResponseDTO);
        } catch (DataAccessException ex) {

            logger.severe("[ERROR GENERAL CREAR VARIABLE] " + ex.getMostSpecificCause().getMessage());
            final String mensaje = dataExceptionInterpreter(ex.getMostSpecificCause().getMessage());
            createResponseDTO.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        } catch(Exception e) {
            logger.severe("[ERROR GENERAL CREAR VARIABLE]" + e.getMessage());
            createResponseDTO.setMensaje(Mensajes.NO_ADD_VARIABLE);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((Object)createResponseDTO);
        }
    }

    @Override
    public ResponseEntity<Object> updateVariable(VariableRequestDTO variableRequestDTO, String auditoria) {
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setEntidad("Variable");
        createResponseDTO.setId(variableRequestDTO.getId());

        if(validarNombre(variableRequestDTO.getNombre(), variableRequestDTO.getId())){
            createResponseDTO.setMensaje(Mensajes.EXISTE_VARIABLE_NOMBRE);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        }

        Variable variable = new Variable();
        try {
            BeanUtils.copyProperties(variableRequestDTO, variable);

            iVariableRepository.save(variable);
            procedureInvoker.procedureName(auditoria,"","variable", variable.getId());
            createResponseDTO.setMensaje(Mensajes.VARIABLE_ACTUALIZADA);
            createResponseDTO.setObjeto(variable);

            return ResponseEntity.status(HttpStatus.OK).body((Object)createResponseDTO);

        } catch (DataAccessException ex) {
            logger.severe("[ERROR GENERAL UPD VARIABLE] " + ex.getMostSpecificCause().getMessage());
            final String mensaje = dataExceptionInterpreter(ex.getMostSpecificCause().getMessage());
            createResponseDTO.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        } catch(Exception e) {
            logger.severe("[ERROR GENERAL UPD VARIABLE]" + e.getMessage());
            createResponseDTO.setMensaje(Mensajes.NO_UPDATE_VARIABLE);
            createResponseDTO.setObjeto(variableRequestDTO);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((Object)createResponseDTO);
        }

    }

    @Override
    public ResponseEntity<Object> deleteVariable(Long id, String auditoria, String motivo) {
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setEntidad("Variable");
        createResponseDTO.setId(id);

        try {
            if(iIndicadorXVarIndRepository.findindicadorXVarIndByVar(id).size() > 0){
                createResponseDTO.setMensaje(Mensajes.VARIABLE_ASOCIADO_INDICADOR);
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
            }
            long registros = iDataVariableRepository.getCountOfDataByVariable(id);
            iVariableRepository.delete(id);
            procedureInvoker.procedureName(auditoria,motivo,"variable", id);
            if(registros > 0) {
                createResponseDTO.setMensaje(Mensajes.VARIABLE_ELIMINADA_CON_DATOS);
            } else {
                createResponseDTO.setMensaje(Mensajes.VARIABLE_ELIMINADA);
            }
            return ResponseEntity.status(HttpStatus.OK).body((Object)createResponseDTO);
        } catch (DataAccessException ex) {
            final String mensaje = dataExceptionInterpreter(ex.getMostSpecificCause().getMessage());
            createResponseDTO.setMensaje(mensaje);
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body((Object)createResponseDTO);
        } catch(Exception e) {
            createResponseDTO.setMensaje(Mensajes.NO_DELETE_VARIABLE);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body((Object)createResponseDTO);
        }
    }

    public List<VariableResponseDTO> obtenerTodos() {
        return iVariableRepository.obtenerTodos();
    }

    public List<VariableResponseDTO> obtenerTodos(Integer rows, Integer page) {
        return iVariableRepository.obtenerTodos(rows, page);
    }

    public List<VariableResponseDTO> obtenerById(Long id) {
        return iVariableRepository.obtenerById(id);
    }

    public Integer obtenerPaginas(Integer rows) {
        return iVariableRepository.obtenerPaginas(rows);
    }

    public List<VariableResponseDTO> obtenerByAny(String value) {
        String condicion = "%";
        if(value != null) {
            condicion = '%' + value + '%';
        }

        return iVariableRepository.obtenerByAny(condicion);
    }


    private String dataExceptionInterpreter(String ex){
        logger.severe("[EX VARIABLE] " + ex);
        if((ex.contains("duplicate key") || ex.contains("llave duplicada")) && ex.contains("codigo")){
            return Mensajes.EXISTE_VARIABLE_CODIGO;
        }
        if((ex.contains("duplicate key") || ex.contains("llave duplicada")) && ex.contains("nombre")){
            return Mensajes.EXISTE_VARIABLE_NOMBRE;
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

        return Mensajes.VARIABLE_ERROR_GENERAL;
    }
}
