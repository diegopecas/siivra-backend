package com.geotek.siivra.dto.request;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

public class ProcesoVariableRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String datosUbicacion;
    private String descripcionEjecucion;
    private Timestamp fechaCarga;
    private String periodoFinalValidez;
    private String periodoInicialValidez;
    private String ubicacionArchivoLog;
    private Long idEstEjecucion;
    private Long idFormaCargaInformacion;
    private Long idFormatoOrigenDato;
    private Long idRutina;
    private Long idUsuario;
    private Long idVariable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatosUbicacion() {
        return datosUbicacion;
    }

    public void setDatosUbicacion(String datosUbicacion) {
        this.datosUbicacion = datosUbicacion;
    }

    public String getDescripcionEjecucion() {
        return descripcionEjecucion;
    }

    public void setDescripcionEjecucion(String descripcionEjecucion) {
        this.descripcionEjecucion = descripcionEjecucion;
    }

    public Timestamp getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Timestamp fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getPeriodoFinalValidez() {
        return periodoFinalValidez;
    }

    public void setPeriodoFinalValidez(String periodoFinalValidez) {
        this.periodoFinalValidez = periodoFinalValidez;
    }

    public String getPeriodoInicialValidez() {
        return periodoInicialValidez;
    }

    public void setPeriodoInicialValidez(String periodoInicialValidez) {
        this.periodoInicialValidez = periodoInicialValidez;
    }

    public String getUbicacionArchivoLog() {
        return ubicacionArchivoLog;
    }

    public void setUbicacionArchivoLog(String ubicacionArchivoLog) {
        this.ubicacionArchivoLog = ubicacionArchivoLog;
    }

    public Long getIdEstEjecucion() {
        return idEstEjecucion;
    }

    public void setIdEstEjecucion(Long idEstEjecucion) {
        this.idEstEjecucion = idEstEjecucion;
    }

    public Long getIdFormaCargaInformacion() {
        return idFormaCargaInformacion;
    }

    public void setIdFormaCargaInformacion(Long idFormaCargaInformacion) {
        this.idFormaCargaInformacion = idFormaCargaInformacion;
    }

    public Long getIdFormatoOrigenDato() {
        return idFormatoOrigenDato;
    }

    public void setIdFormatoOrigenDato(Long idFormatoOrigenDato) {
        this.idFormatoOrigenDato = idFormatoOrigenDato;
    }

    public Long getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Long idRutina) {
        this.idRutina = idRutina;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

}