package com.geotek.siivra.entity.common;

import com.geotek.siivra.entity.Indicador;
import com.geotek.siivra.entity.Variable;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_indicador_x_var_ind")
public class IndicadorXVarInd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador", insertable = false, updatable = false)
    // private Indicador idindicador;
    @Column(name = "id_indicador", nullable = false)
    private Long idIndicador;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador_calculo", insertable = false, updatable = false)
    // private Indicador idindicadorcalculo;
    @Column(name = "id_indicador_calculo")
    private Long idIndicadorCalculo;

    // @ManyToOne()
    // @JoinColumn(name = "id_variable_calculo", insertable = false, updatable = false)
    // private Variable idindvariablecalculo;
    @Column(name = "id_variable_calculo")
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

    /*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Indicador getIdindicador() {
        return idindicador;
    }

    public void setIdindicador(Indicador idindicador) {
        this.idindicador = idindicador;
    }

    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Indicador getIdindicadorcalculo() {
        return idindicadorcalculo;
    }

    public void setIdindicadorcalculo(Indicador idindicadorcalculo) {
        this.idindicadorcalculo = idindicadorcalculo;
    }

    public Integer getIdIndicadorCalculo() {
        return idIndicadorCalculo;
    }

    public void setIdIndicadorCalculo(Integer idIndicadorCalculo) {
        this.idIndicadorCalculo = idIndicadorCalculo;
    }

    public Variable getIdindvariablecalculo() {
        return idindvariablecalculo;
    }

    public void setIdindvariablecalculo(Variable idindvariablecalculo) {
        this.idindvariablecalculo = idindvariablecalculo;
    }

    public Integer getIdVariableCalculo() {
        return idVariableCalculo;
    }

    public void setIdVariableCalculo(Integer idVariableCalculo) {
        this.idVariableCalculo = idVariableCalculo;
    }
*/

}
