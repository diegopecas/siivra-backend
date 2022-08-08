package com.geotek.siivra.entity.common;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.geotek.siivra.entity.common.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_adaptacion_nivel")
public class AdaptacionNivel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
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
