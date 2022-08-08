package com.geotek.siivra.dto.response.common;

import java.io.Serializable;

public class VariableInfoArchivoResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idVariable;
    private Long idProcesoVariable;
    private String periodoInicialValidez;
    private String periodoFinalValidez;
    private String ubicacionArchivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public Long getIdProcesoVariable() {
        return idProcesoVariable;
    }

    public void setIdProcesoVariable(Long idProcesoVariable) {
        this.idProcesoVariable = idProcesoVariable;
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

    public String getUbicacionArchivo() {
        return ubicacionArchivo;
    }

    public void setUbicacionArchivo(String ubicacionArchivo) {
        this.ubicacionArchivo = ubicacionArchivo;
    }

}
