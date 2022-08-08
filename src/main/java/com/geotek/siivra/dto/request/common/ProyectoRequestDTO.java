package com.geotek.siivra.dto.request.common;

import javax.persistence.*;
import java.io.Serializable;

public class ProyectoRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idEstado;
    private Long IdEntidad;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdEntidad() {
        return IdEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        IdEntidad = idEntidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
