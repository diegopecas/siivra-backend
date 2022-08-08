package com.geotek.siivra.service;

import com.geotek.siivra.dto.request.ValidarAprobarDataVariableRequestDTO;
import com.geotek.siivra.dto.response.DataVariableResponseDTO;
import com.geotek.siivra.dto.request.DataVariableRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDataVariableService {

    ResponseEntity<Object>  addDataVariableMasivo(List<DataVariableRequestDTO> dataVariableRequestDTO, String auditoria, Boolean mantener);
    ResponseEntity<Object>  updateDataVariableMasivo(List<DataVariableRequestDTO> dataVariableRequestDTO, String auditoria);
    ResponseEntity<Object> deleteDataVariableWithIds(List<Long> ids, String auditoria, String motivo);
    ResponseEntity<Object>  validarAprobarDataVariable(List<ValidarAprobarDataVariableRequestDTO> validarAprobarDataVariableRequestDTO, String auditoria, String motivo, Long estado, Integer Notificar);

    ResponseEntity<Object> addDataVariable(DataVariableRequestDTO dataVariableListDTO, String auditoria, Boolean mantener);
    ResponseEntity<String> updateDataVariable(DataVariableRequestDTO dataVariableRequestDTO, String auditoria);
    ResponseEntity<String> deleteDataVariable(Long id, String auditoria,String motivo);
    List<DataVariableResponseDTO> getDataVariableIdVariable(Long id);

    List<DataVariableResponseDTO> obtenerTodos();
    List<DataVariableResponseDTO> obtenerTodos(Integer rows, Integer page);
    List<DataVariableResponseDTO> obtenerById(Long id);
    Integer obtenerPaginas(Integer rows);
    List<DataVariableResponseDTO> obtenerByAny(DataVariableRequestDTO dataVariableRequestDTO);
}
