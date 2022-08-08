package com.geotek.siivra.dto.response;

import java.io.Serializable;
import java.util.Date;

public class ModeloResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idUnidadMedida;
    private Long idTableroControl;
    public Long idEstado;
    private Long idRutina;
    private Long idPeriodicidad;
    private Long idCompDesagregacion;
    private String nombre;
    private Date fechaPublicacion;
    private String descripcion;
    private String archivoFicha;
    private String urlFicha;
    private String observaciones;
    private String calcularValoresJerarquia;
    private String necesitaValidar;
    private String necesitaAprobar;
    private Long idFormatoOrigenDatos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Long idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Long getIdTableroControl() {
        return idTableroControl;
    }

    public void setIdTableroControl(Long idTableroControl) {
        this.idTableroControl = idTableroControl;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Long idRutina) {
        this.idRutina = idRutina;
    }

    public Long getIdPeriodicidad() {
        return idPeriodicidad;
    }

    public void setIdPeriodicidad(Long idPeriodicidad) {
        this.idPeriodicidad = idPeriodicidad;
    }

    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivoFicha() {
        return archivoFicha;
    }

    public void setArchivoFicha(String archivoFicha) {
        this.archivoFicha = archivoFicha;
    }

    public String getUrlFicha() {
        return urlFicha;
    }

    public void setUrlFicha(String urlFicha) {
        this.urlFicha = urlFicha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCalcularValoresJerarquia() {
        return calcularValoresJerarquia;
    }

    public void setCalcularValoresJerarquia(String calcularValoresJerarquia) {
        this.calcularValoresJerarquia = calcularValoresJerarquia;
    }

    public String getNecesitaValidar() {
        return necesitaValidar;
    }

    public void setNecesitaValidar(String necesitaValidar) {
        this.necesitaValidar = necesitaValidar;
    }

    public String getNecesitaAprobar() {
        return necesitaAprobar;
    }

    public void setNecesitaAprobar(String necesitaAprobar) {
        this.necesitaAprobar = necesitaAprobar;
    }

    public Long getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
    }

}