package com.geotek.siivra.dto.request.common;

import javax.persistence.*;
import java.io.Serializable;

public class IndicadorXVarIndRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idIndicador;
    private Long idIndicadorCalculo;
    private Long idVariableCalculo;

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

    public Long getIdIndicadorCalculo() {
        return idIndicadorCalculo;
    }

    public void setIdIndicadorCalculo(Long idIndicadorCalculo) {
        this.idIndicadorCalculo = idIndicadorCalculo;
    }

    public Long getIdVariableCalculo() {
        return idVariableCalculo;
    }

    public void setIdVariableCalculo(Long idVariableCalculo) {
        this.idVariableCalculo = idVariableCalculo;
    }

}
