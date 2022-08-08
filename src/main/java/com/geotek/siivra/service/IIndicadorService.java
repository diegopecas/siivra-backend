package com.geotek.siivra.service;

import com.geotek.siivra.dto.request.IndicadorRequestDTO;
import com.geotek.siivra.dto.request.VariableRequestDTO;
import com.geotek.siivra.dto.response.IndicadorResponseCompleteDTO;
import com.geotek.siivra.dto.response.IndicadorResponseDTO;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface IIndicadorService {
    ResponseEntity<Object> addIndicador(IndicadorRequestDTO indicadorListDTO, String auditoria);
    ResponseEntity<Object> updateIndicador(IndicadorRequestDTO indicadorRequestDTO, String auditoria);
    ResponseEntity<Object> deleteIndicador(Long id, String auditoria,String motivo);

    List<IndicadorResponseDTO> obtenerTodos();
    List<IndicadorResponseDTO> obtenerTodos(Integer rows, Integer page);
    List<IndicadorResponseDTO> obtenerTodos(Integer rows, Integer page, String value);
    IndicadorResponseCompleteDTO obtenerById(Long id);
    Integer obtenerPaginas(Integer rows);
    Integer obtenerPaginas(Integer rows, String value);
    List<IndicadorResponseDTO> obtenerByAny(String value);
}