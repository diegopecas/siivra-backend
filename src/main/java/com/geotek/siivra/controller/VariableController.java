package com.geotek.siivra.controller;

import com.geotek.siivra.config.ExceptionConfig;
import com.geotek.siivra.dto.response.VariableResponseDTO;
import com.geotek.siivra.dto.request.VariableRequestDTO;
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

import com.geotek.siivra.service.IVariableService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/variable")
public class VariableController {

    @Autowired
    private IVariableService iVariableService;

    @GetMapping("/")
    public ResponseEntity<List<VariableResponseDTO>> getAll() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iVariableService.obtenerTodos());
    }

    @GetMapping("/{page}/{rows}")
    public ResponseEntity<List<VariableResponseDTO>> getAll(@PathVariable Integer page, @PathVariable Integer rows) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iVariableService.obtenerTodos(rows, page));
    }


    @GetMapping(value = "/pages/{rows}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getPages(@PathVariable Integer rows) throws Exception {

        Integer pages = iVariableService.obtenerPaginas(rows);

        Map<String, Object> payload = new HashMap<>();
        payload.put("pages", pages);

        return ResponseEntity.status(HttpStatus.OK).body(payload);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<VariableResponseDTO>> obtenerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iVariableService.obtenerById(id));
    }

    @GetMapping("/obtenerByAny/{value}")
    public ResponseEntity<List<VariableResponseDTO>> obtenerByAny(@PathVariable String value) {
        return ResponseEntity.status(HttpStatus.OK).body(iVariableService.obtenerByAny(value));
    }

    @PostMapping(value = "/crear/{auditoria}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  createVariable(@RequestBody VariableRequestDTO variableRequestDTO, @PathVariable String auditoria){
        ResponseEntity responseEntity = iVariableService.addVariable(variableRequestDTO, auditoria);
        return responseEntity;
    }

    @PostMapping("/actualizar/{auditoria}")
    public ResponseEntity<Object> updateVariable(@RequestBody VariableRequestDTO variableRequestDTO, @PathVariable String auditoria) {
        ResponseEntity responseEntity = iVariableService.updateVariable(variableRequestDTO, auditoria);
        return responseEntity;

    }

    @PostMapping("/eliminar/{id}/{auditoria}/{motivo}")
    public ResponseEntity<Object> deleteVariable(@PathVariable Long id, @PathVariable String auditoria, @PathVariable String motivo) {
        ResponseEntity responseEntity = iVariableService.deleteVariable(id, auditoria, motivo);
        return responseEntity;
    }

}
