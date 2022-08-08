package com.geotek.siivra.dto.response.common;

import java.io.Serializable;
import java.util.Date;

public class ProcesoModeloResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idRutine;
    private Long idUsuario;
    private Long idFormaCargaInformacion;
    private Long idEstEjecucion;
    private Long idModelo;
    private Date fechaCarga;
    private String descripcionEjecucion;
    private String periodoInicialValidez;
    private String periodoFinalValidez;
    private String ubicacionArchivoLog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRutine() {
        return idRutine;
    }

    public void setIdRutine(Long idRutine) {
        this.idRutine = idRutine;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdFormaCargaInformacion() {
        return idFormaCargaInformacion;
    }

    public void setIdFormaCargaInformacion(Long idFormaCargaInformacion) {
        this.idFormaCargaInformacion = idFormaCargaInformacion;
    }

    public Long getIdEstEjecucion() {
        return idEstEjecucion;
    }

    public void setIdEstEjecucion(Long idEstEjecucion) {
        this.idEstEjecucion = idEstEjecucion;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getDescripcionEjecucion() {
        return descripcionEjecucion;
    }

    public void setDescripcionEjecucion(String descripcionEjecucion) {
        this.descripcionEjecucion = descripcionEjecucion;
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

    public String getUbicacionArchivoLog() {
        return ubicacionArchivoLog;
    }

    public void setUbicacionArchivoLog(String ubicacionArchivoLog) {
        this.ubicacionArchivoLog = ubicacionArchivoLog;
    }

}
