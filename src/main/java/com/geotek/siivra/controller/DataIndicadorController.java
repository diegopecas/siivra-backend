package com.geotek.siivra.controller;

import com.geotek.siivra.dto.response.DataIndicadorResponseDTO;
import com.geotek.siivra.dto.request.DataIndicadorRequestDTO;
import com.geotek.siivra.dto.request.ValidarAprobarDataIndicadorRequestDTO;
import com.geotek.siivra.service.IDataIndicadorService;
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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// import java.util.stream.Collectors;

@RestController
@RequestMapping("/dataindicador")
public class DataIndicadorController {

    @Autowired
    private IDataIndicadorService iDataIndicadorService;

    @GetMapping("/{id}")
    public ResponseEntity<List<DataIndicadorResponseDTO>> obtenerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iDataIndicadorService.obtenerById(id));
    }

    @GetMapping("/ByInd/{idIndicador}")
    public ResponseEntity <List<DataIndicadorResponseDTO>> getDataIndicadorIdIndicador(@PathVariable(value="idIndicador") Long idIndicador) {
        return ResponseEntity.status(HttpStatus.OK).body(iDataIndicadorService.getDataIndicadorIdIndicador(idIndicador));
    }

    @PostMapping("/obtenerByAny")
    public ResponseEntity<List<DataIndicadorResponseDTO>> obtenerByAny(DataIndicadorRequestDTO dataIndicadorRequestDTO) {
        System.out.println("ingresa al controlador");
        return ResponseEntity.status(HttpStatus.OK).body(iDataIndicadorService.obtenerByAny(dataIndicadorRequestDTO));
    }

    @PostMapping(value = "/crear/{auditoria}/{mantener}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  createDataIndicador(@RequestBody DataIndicadorRequestDTO dataIndicadorListDTO, @PathVariable String auditoria, @PathVariable Integer mantener) {
        // 1 - Reemplazar y 2 - Mantener
        ResponseEntity responseEntity = iDataIndicadorService.addDataIndicador(dataIndicadorListDTO, auditoria, mantener == 2 ? true : false);
        return responseEntity;

    }

    @PostMapping("/actualizar/{auditoria}")
    public ResponseEntity<String> updateDataIndicador(@RequestBody DataIndicadorRequestDTO dataIndicadorRequestDTO, @PathVariable String auditoria) {
        ResponseEntity responseEntity = iDataIndicadorService.updateDataIndicador(dataIndicadorRequestDTO, auditoria);
        return responseEntity;

    }

    @PostMapping("/eliminar/{id}/{auditoria}/{motivo}")
    public ResponseEntity<Object> deleteDataIndicador(@PathVariable Long id, @PathVariable String auditoria, @PathVariable String motivo) {
        ResponseEntity responseEntity = iDataIndicadorService.deleteDataIndicador(id, auditoria, motivo);
        return responseEntity;
    }

    @PostMapping("/validarAprobar/{auditoria}/{motivo}/{estado}/{notificar}")
    public ResponseEntity<Object> validarAprobarDataIndicador(@RequestBody List<ValidarAprobarDataIndicadorRequestDTO> validarAprobarDataIndicadorRequestDTO, @PathVariable String auditoria, @PathVariable String motivo, @PathVariable Long estado, @PathVariable Integer notificar) {
        ResponseEntity responseEntity = iDataIndicadorService.validarAprobarDataIndicador(validarAprobarDataIndicadorRequestDTO, auditoria, motivo, estado, notificar);
        return responseEntity;
    }

    @PostMapping("/crearMasivo/{dataIndicadorDTO}/{auditoria}/{mantener}")
    public ResponseEntity<Object>  createDataIndicadorMasivo(@RequestBody List<DataIndicadorRequestDTO> dataIndicadorRequestDTO, @PathVariable String auditoria, @PathVariable Integer mantener) {
        ResponseEntity responseEntity = iDataIndicadorService.addDataIndicadorMasivo(dataIndicadorRequestDTO, auditoria, mantener == 2 ? true : false);
        return responseEntity;
    }

    @PostMapping("/actualizarMasivo/{dataIndicadorDTO}/{auditoria}")
    public ResponseEntity<Object> updateDataIndicadorMasivo(@RequestBody List<DataIndicadorRequestDTO> dataIndicadorRequestDTO, @PathVariable String auditoria) {
        ResponseEntity responseEntity = iDataIndicadorService.updateDataIndicadorMasivo(dataIndicadorRequestDTO, auditoria);
        return responseEntity;
    }

    @PostMapping("/eliminarMasivo/{auditoria}/{motivo}")
    public ResponseEntity<Object>  deleteDataIndicadorWithIds(@RequestBody List<DataIndicadorRequestDTO> dataIndicadorDTO, @PathVariable String auditoria, @PathVariable String motivo) {
        // List<Long> ids = dataIndicadorDTO.stream().map(DataIndicadorRequestDTO::getId).collect(Collectors.toList());
        List<Long> ids = new ArrayList<>();
        Iterator it = dataIndicadorDTO.iterator();
        while (it.hasNext()){
            ids.add(((DataIndicadorRequestDTO)it.next()).getId());
        }
        ResponseEntity responseEntity = iDataIndicadorService.deleteDataIndicadorWithIds(ids, auditoria, motivo);
        return responseEntity;
    }
}