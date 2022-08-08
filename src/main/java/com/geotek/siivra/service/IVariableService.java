package com.geotek.siivra.service;

import com.geotek.siivra.dto.request.VariableRequestDTO;
import com.geotek.siivra.dto.response.VariableResponseDTO;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface IVariableService {

    ResponseEntity<Object> addVariable(VariableRequestDTO variableListDTO, String auditoria);
    ResponseEntity<Object> updateVariable(VariableRequestDTO variableRequestDTO, String auditoria);
    ResponseEntity<Object> deleteVariable(Long id, String auditoria,String motivo);

    List<VariableResponseDTO> obtenerTodos();
    List<VariableResponseDTO> obtenerTodos(Integer rows, Integer page);
    List<VariableResponseDTO> obtenerById(Long id);
    Integer obtenerPaginas(Integer rows);
    List<VariableResponseDTO> obtenerByAny(String value);

}
