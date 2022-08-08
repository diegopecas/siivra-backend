package com.geotek.siivra.entity.common;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "siivrat_proyecto")
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    // private Estado estado;
    @Column(name = "id_estado")
    private Long idEstado;

    // @ManyToOne()
    // @JoinColumn(name = "id_entidad", insertable = false, updatable = false)
    // private Entidad entidad;
    @Column(name = "id_entidad")
    private Long IdEntidad;

    @Column(name = "nombre")
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

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Integer getIdestado() {
        return idestado;
    }

    public void setIdestado(Integer idestado) {
        this.idestado = idestado;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Integer getIDentidad() {
        return IDentidad;
    }

    public void setIDentidad(Integer IDentidad) {
        this.IDentidad = IDentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 */
}
