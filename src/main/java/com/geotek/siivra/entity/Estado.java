package com.geotek.siivra.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="siivrat_estado")
public class Estado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(nullable=false, length=100)
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
