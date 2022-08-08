package com.geotek.siivra.entity.common;

import com.geotek.siivra.entity.Indicador;
import com.geotek.siivra.entity.Modelo;
import com.geotek.siivra.entity.Variable;
import com.geotek.siivra.entity.common.CompDesagregacionItem;
import com.geotek.siivra.entity.common.TipoEstado;
import com.geotek.siivra.entity.common.TypeLocationInfo;

import java.io.Serializable;
import javax.persistence.*;
import javax.print.attribute.IntegerSyntax;

@Entity
@Table(name="siivrat_modelo_x_indicador")
public class ModeloXIndicador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador", insertable = false, updatable = false)
    // private Indicador indicador;
    @Column(name="id_indicador")
    private Long idIndicador;

    // @ManyToOne()
    // @JoinColumn(name = "id_modelo", insertable = false, updatable = false)
    // private Modelo modelo;
    @Column(name="id_modelo")
    private Long idModelo;

    // @ManyToOne()
    // @JoinColumn(name = "id_variable", insertable = false, updatable = false)
    // private Variable variable;
    @Column(name="id_variable")
    private Long idVariable;

    // @ManyToOne()
    // @JoinColumn(name = "id_modelo_calculo", insertable = false, updatable = false)
    // private Modelo modeloCalculo;
    @Column(name="id_modelo_calculo")
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

    /*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public Modelo getModeloCalculo() {
        return modeloCalculo;
    }

    public void setModeloCalculo(Modelo modeloCalculo) {
        this.modeloCalculo = modeloCalculo;
    }

    public Integer getIdModeloCalculo() {
        return idModeloCalculo;
    }

    public void setIdModeloCalculo(Integer idModeloCalculo) {
        this.idModeloCalculo = idModeloCalculo;
    }

     */
}
