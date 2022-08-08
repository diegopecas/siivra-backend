package com.geotek.siivra.dto.request.common;

import javax.persistence.*;
import java.io.Serializable;

public class CapaGeograficaRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idCapaGeograficaTipo;
    private Long idEstado;
    private Long idTipoSalidaGeografica;
    private String nombre;
    private String descripcion;
    private String periodoInicialValidez;
    private String periodoFinalValidez;
    private String urlPublicacion;
    private String repositorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCapaGeograficaTipo() {
        return idCapaGeograficaTipo;
    }

    public void setIdCapaGeograficaTipo(Long idCapaGeograficaTipo) {
        this.idCapaGeograficaTipo = idCapaGeograficaTipo;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdTipoSalidaGeografica() {
        return idTipoSalidaGeografica;
    }

    public void setIdTipoSalidaGeografica(Long idTipoSalidaGeografica) {
        this.idTipoSalidaGeografica = idTipoSalidaGeografica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeriodoInicialValidez() {
        return periodoInicialValidez;
    }

    public void setPeriodoInicialValidez(String periodoInicialValidez) {
        this.periodoInicialValidez = periodoInicialValidez;
    }

    public String getPeriodoFinalValidez() {
        return periodoFinalValidez;
    }

    public void setPeriodoFinalValidez(String periodoFinalValidez) {
        this.periodoFinalValidez = periodoFinalValidez;
    }

    public String getUrlPublicacion() {
        return urlPublicacion;
    }

    public void setUrlPublicacion(String urlPublicacion) {
        this.urlPublicacion = urlPublicacion;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

}
