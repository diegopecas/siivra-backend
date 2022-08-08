package com.geotek.siivra.entity.common;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="siivrat_modelo_tipo_valor")
public class ModeloTipoValor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(name="nombre", length=100)
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
