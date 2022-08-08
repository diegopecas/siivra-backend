package com.geotek.siivra.controller;

import com.geotek.siivra.dto.request.IndicadorRequestDTO;
import com.geotek.siivra.dto.request.VariableRequestDTO;
import com.geotek.siivra.dto.response.IndicadorResponseCompleteDTO;
import com.geotek.siivra.dto.response.IndicadorResponseDTO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geotek.siivra.service.IIndicadorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/indicador")
public class IndicadorController {

    @Autowired
    private IIndicadorService iIndicadorService;

    @GetMapping("/")
    public ResponseEntity<List<IndicadorResponseDTO>> getAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iIndicadorService.obtenerTodos());
    }

    @GetMapping("/{page}/{rows}")
    public ResponseEntity<List<IndicadorResponseDTO>> getAll(@PathVariable Integer page, @PathVariable Integer rows) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iIndicadorService.obtenerTodos(rows, page));
    }

    @GetMapping("/{page}/{rows}/{value}")
    public ResponseEntity<List<IndicadorResponseDTO>> getAll(@PathVariable Integer page, @PathVariable Integer rows, @PathVariable String value) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iIndicadorService.obtenerTodos(rows, page, value));
    }

    @GetMapping(value = "/pages/{rows}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getPages(@PathVariable Integer rows) throws Exception {

        Integer pages = iIndicadorService.obtenerPaginas(rows);

        Map<String, Object> payload = new HashMap<>();
        payload.put("pages", pages);

        return ResponseEntity.status(HttpStatus.OK).body(payload);
    }

    @GetMapping(value = "/pages/{rows}/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getPages(@PathVariable Integer rows, @PathVariable String value) throws Exception {

        Integer pages = iIndicadorService.obtenerPaginas(rows, value);

        Map<String, Object> payload = new HashMap<>();
        payload.put("pages", pages);

        return ResponseEntity.status(HttpStatus.OK).body(payload);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IndicadorResponseCompleteDTO> obtenerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iIndicadorService.obtenerById(id));
    }

    @GetMapping("/obtenerByAny/{value}")
    public ResponseEntity<List<IndicadorResponseDTO>> obtenerByAny(@PathVariable String value) {
        return ResponseEntity.status(HttpStatus.OK).body(iIndicadorService.obtenerByAny(value));
    }

    @PostMapping(value = "/crear/{auditoria}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  createIndicador(@RequestBody IndicadorRequestDTO indicadorRequestDTO, @PathVariable String auditoria){
        System.out.println("[create indicador]");
        ResponseEntity responseEntity = iIndicadorService.addIndicador(indicadorRequestDTO, auditoria);
        return responseEntity;
    }

    @PostMapping("/actualizar/{auditoria}")
    public ResponseEntity<Object> updateIndicador(@RequestBody IndicadorRequestDTO indicadorRequestDTO, @PathVariable String auditoria) {
        ResponseEntity responseEntity = iIndicadorService.updateIndicador(indicadorRequestDTO, auditoria);
        return responseEntity;

    }

    @PostMapping("/eliminar/{id}/{auditoria}/{motivo}")
    public ResponseEntity<Object> deleteIndicador(@PathVariable Long id, @PathVariable String auditoria, @PathVariable String motivo) {
        ResponseEntity responseEntity = iIndicadorService.deleteIndicador(id, auditoria, motivo);
        return responseEntity;
    }

}
