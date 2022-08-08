package com.geotek.siivra.dto.request;

import javax.persistence.*;
import java.io.Serializable;

public class DataModeloRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idComponenteDesagregaItem;
    private Long idModeloTipoVal;
    private Long idTipoEstado;
    private Long idProcesoModelo;
    private double valor;
    private String periodoInicialValidez;
    private String periodoFinalValidez;
    private Long idModelo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdComponenteDesagregaItem() {
        return idComponenteDesagregaItem;
    }

    public void setIdComponenteDesagregaItem(Long idComponenteDesagregaItem) {
        this.idComponenteDesagregaItem = idComponenteDesagregaItem;
    }

    public Long getIdModeloTipoVal() {
        return idModeloTipoVal;
    }

    public void setIdModeloTipoVal(Long idModeloTipoVal) {
        this.idModeloTipoVal = idModeloTipoVal;
    }

    public Long getIdTipoEstado() {
        return idTipoEstado;
    }

    public void setIdTipoEstado(Long idTipoEstado) {
        this.idTipoEstado = idTipoEstado;
    }

    public Long getIdProcesoModelo() {
        return idProcesoModelo;
    }

    public void setIdProcesoModelo(Long idProcesoModelo) {
        this.idProcesoModelo = idProcesoModelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

}
