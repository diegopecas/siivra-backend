package com.geotek.siivra.dto.request.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

public class ProcesoIndicadorRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idEstEjecucion;
    private Long idFormaCargaInformacion;
    private Long idUsuario;
    private Long idRutina;
    private Long idIndicador;
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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Long idRutina) {
        this.idRutina = idRutina;
    }

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
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
