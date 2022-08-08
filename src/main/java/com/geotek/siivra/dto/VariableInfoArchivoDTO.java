package com.geotek.siivra.dto;


import com.geotek.siivra.entity.DissagregationComponentItem;
import com.geotek.siivra.entity.Indicador;
import com.geotek.siivra.entity.Variable;
import com.geotek.siivra.entity.common.EstDato;
import com.geotek.siivra.entity.common.ProcesoIndicador;
import com.geotek.siivra.entity.common.ProcesoVariable;

import javax.persistence.*;

public class VariableInfoArchivoDTO {

    private Long id;

    private Variable idvariable;

    private Long idVariable;

    private ProcesoVariable idprocesovariable;

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

    public Variable getIdvariable() {
        return idvariable;
    }

    public void setIdvariable(Variable idvariable) {
        this.idvariable = idvariable;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public ProcesoVariable getIdprocesovariable() {
        return idprocesovariable;
    }

    public void setIdprocesovariable(ProcesoVariable idprocesovariable) {
        this.idprocesovariable = idprocesovariable;
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
