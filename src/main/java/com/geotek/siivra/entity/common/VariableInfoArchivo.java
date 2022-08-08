package com.geotek.siivra.entity.common;

import com.geotek.siivra.entity.Variable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_variable_info_archivo")
public class VariableInfoArchivo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_variable", insertable = false, updatable = false)
    // private Variable idvariable;
    @Column(name = "id_variable")
    private Long idVariable;

    // @ManyToOne()
    // @JoinColumn(name = "id_proceso_variable", insertable = false, updatable = false)
    // private ProcesoVariable idprocesovariable;
    @Column(name = "id_proceso_variable")
    private Long idProcesoVariable;

    @Column(name = "periodo_inicial_validez")
    private String periodoInicialValidez;

    @Column(name = "periodo_final_validez")
    private String periodoFinalValidez;

    @Column(name = "ubicacion_archivo")
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

    /*
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

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public ProcesoVariable getIdprocesovariable() {
        return idprocesovariable;
    }

    public void setIdprocesovariable(ProcesoVariable idprocesovariable) {
        this.idprocesovariable = idprocesovariable;
    }

    public Integer getIdProcesoVariable() {
        return idProcesoVariable;
    }

    public void setIdProcesoVariable(Integer idProcesoVariable) {
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

     */
}
