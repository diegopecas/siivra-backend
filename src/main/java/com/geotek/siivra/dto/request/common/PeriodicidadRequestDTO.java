package com.geotek.siivra.dto.request.common;

import javax.persistence.*;
import java.io.Serializable;

public class PeriodicidadRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
