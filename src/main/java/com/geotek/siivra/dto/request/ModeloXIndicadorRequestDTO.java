package com.geotek.siivra.dto.request;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ModeloXIndicadorRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idIndicador;
    private Long idModelo;
    private Long idVariable;
    private Long idModeloCalculo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public Long getIdModeloCalculo() {
        return idModeloCalculo;
    }

    public void setIdModeloCalculo(Long idModeloCalculo) {
        this.idModeloCalculo = idModeloCalculo;
    }

}