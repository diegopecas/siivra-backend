package com.geotek.siivra.config;

import com.geotek.siivra.dto.response.CreateResponseDTO;
import com.geotek.siivra.exception.BadRequestException;
import com.geotek.siivra.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createResponseDTO);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception e){
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setMensaje(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createResponseDTO);
    }

    @ExceptionHandler(javax.persistence.PersistenceException.class)
    public ResponseEntity<?> persistenceException(javax.persistence.PersistenceException  e){
        CreateResponseDTO createResponseDTO = new CreateResponseDTO();
        createResponseDTO.setMensaje(e.getMessage());
        createResponseDTO.setEntidad(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createResponseDTO);
    }

}
