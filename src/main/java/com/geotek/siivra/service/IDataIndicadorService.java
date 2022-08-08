package com.geotek.siivra.service;

import com.geotek.siivra.dto.request.ValidarAprobarDataIndicadorRequestDTO;
import com.geotek.siivra.dto.response.DataIndicadorResponseDTO;
import com.geotek.siivra.dto.request.DataIndicadorRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDataIndicadorService {

    ResponseEntity<Object>  addDataIndicadorMasivo(List<DataIndicadorRequestDTO> dataIndicadorRequestDTO, String auditoria, Boolean mantener);
    ResponseEntity<Object>  updateDataIndicadorMasivo(List<DataIndicadorRequestDTO> dataIndicadorRequestDTO, String auditoria);
    ResponseEntity<Object> deleteDataIndicadorWithIds(List<Long> ids, String auditoria, String motivo);
    ResponseEntity<Object>  validarAprobarDataIndicador(List<ValidarAprobarDataIndicadorRequestDTO> validarAprobarDataIndicadorRequestDTO, String auditoria, String motivo, Long estado, Integer Notificar);

    ResponseEntity<Object> addDataIndicador(DataIndicadorRequestDTO dataIndicadorListDTO, String auditoria, Boolean mantener);
    ResponseEntity<String> updateDataIndicador(DataIndicadorRequestDTO dataIndicadorRequestDTO, String auditoria);
    ResponseEntity<Object> deleteDataIndicador(Long id, String auditoria,String motivo);
    List<DataIndicadorResponseDTO> getDataIndicadorIdIndicador(Long id);

    List<DataIndicadorResponseDTO> obtenerTodos();
    List<DataIndicadorResponseDTO> obtenerTodos(Integer rows, Integer page);
    List<DataIndicadorResponseDTO> obtenerById(Long id);
    Integer obtenerPaginas(Integer rows);
    List<DataIndicadorResponseDTO> obtenerByAny(DataIndicadorRequestDTO dataIndicadorRequestDTO);
}