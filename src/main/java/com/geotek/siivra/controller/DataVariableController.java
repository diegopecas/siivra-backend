package com.geotek.siivra.controller;

import com.geotek.siivra.dto.request.ValidarAprobarDataVariableRequestDTO;
import com.geotek.siivra.dto.response.DataVariableResponseDTO;
import com.geotek.siivra.dto.request.DataVariableRequestDTO;
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
import com.geotek.siivra.service.IDataVariableService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
// import java.util.stream.Collectors;


@RestController
@RequestMapping("/datavariable")
public class DataVariableController {

    @Autowired
    private IDataVariableService iDataVariableService;

    @GetMapping("/{id}")
    public ResponseEntity<List<DataVariableResponseDTO>> obtenerById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(iDataVariableService.obtenerById(id));
    }

    @GetMapping("/ByVar/{idVariable}")
    public ResponseEntity <List<DataVariableResponseDTO>> getDataVariableIdVariable(@PathVariable(value="idVariable") Long idVariable) {
        return ResponseEntity.status(HttpStatus.OK).body(iDataVariableService.getDataVariableIdVariable(idVariable));
    }

    @PostMapping("/obtenerByAny")
    public ResponseEntity<List<DataVariableResponseDTO>> obtenerByAny(DataVariableRequestDTO dataVariableRequestDTO) {
        System.out.println("ingresa al controlador");
        return ResponseEntity.status(HttpStatus.OK).body(iDataVariableService.obtenerByAny(dataVariableRequestDTO));
    }

    @PostMapping(value = "/crear/{auditoria}/{mantener}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  createDataVariable(@RequestBody DataVariableRequestDTO dataVariableListDTO, @PathVariable String auditoria, @PathVariable Integer mantener) {
       // 1 - Reemplazar y 2 - Mantener
        ResponseEntity responseEntity = iDataVariableService.addDataVariable(dataVariableListDTO, auditoria, mantener == 2 ? true : false);
        return responseEntity;

    }

    @PostMapping("/actualizar/{auditoria}")
    public ResponseEntity<String> updateDataVariable(@RequestBody DataVariableRequestDTO dataVariableRequestDTO, @PathVariable String auditoria) {
        ResponseEntity responseEntity = iDataVariableService.updateDataVariable(dataVariableRequestDTO, auditoria);
        return responseEntity;

    }

    @PostMapping("/eliminar/{id}/{auditoria}/{motivo}")
    public ResponseEntity<String> deleteDataVariable(@PathVariable Long id, @PathVariable String auditoria, @PathVariable String motivo) {
        ResponseEntity responseEntity = iDataVariableService.deleteDataVariable(id, auditoria, motivo);
        return responseEntity;
    }

    @PostMapping("/validarAprobar/{auditoria}/{motivo}/{estado}/{notificar}")
    public ResponseEntity<Object> validarAprobarDataVariable(@RequestBody List<ValidarAprobarDataVariableRequestDTO> validarAprobarDataVariableRequestDTO, @PathVariable String auditoria, @PathVariable String motivo, @PathVariable Long estado, @PathVariable Integer notificar) {
        ResponseEntity responseEntity = iDataVariableService.validarAprobarDataVariable(validarAprobarDataVariableRequestDTO, auditoria, motivo, estado, notificar);
        return responseEntity;
    }

    @PostMapping("/crearMasivo/{dataVariableDTO}/{auditoria}/{mantener}")
    public ResponseEntity<Object>  createDataVariableMasivo(@RequestBody List<DataVariableRequestDTO> dataVariableRequestDTO, @PathVariable String auditoria, @PathVariable Integer mantener) {
        System.out.println("Crear masivo :: "+ mantener + " :: " + auditoria);
        ResponseEntity responseEntity = iDataVariableService.addDataVariableMasivo(dataVariableRequestDTO, auditoria, mantener == 2 ? true : false);
        return responseEntity;
    }

    @PostMapping("/actualizarMasivo/{dataVariableDTO}/{auditoria}")
    public ResponseEntity<Object> updateDataVariableMasivo(@RequestBody List<DataVariableRequestDTO> dataVariableRequestDTO, @PathVariable String auditoria) {
        ResponseEntity responseEntity = iDataVariableService.updateDataVariableMasivo(dataVariableRequestDTO, auditoria);
        return responseEntity;
    }

    @PostMapping("/eliminarMasivo/{auditoria}/{motivo}")
    public ResponseEntity<Object>  deleteDataVariableWithIds(@RequestBody List<DataVariableRequestDTO> dataVariableDTO, @PathVariable String auditoria, @PathVariable String motivo) {
        List<Long> ids = new ArrayList<>();
        Iterator it = dataVariableDTO.iterator();
        while (it.hasNext()){
            ids.add(((DataVariableRequestDTO)it.next()).getId());
        }
        ResponseEntity responseEntity = iDataVariableService.deleteDataVariableWithIds(ids, auditoria, motivo);
        return responseEntity;
    }
}
