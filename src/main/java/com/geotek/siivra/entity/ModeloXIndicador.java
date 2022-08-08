package com.geotek.siivra.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_modelo_x_indicador")
public class ModeloXIndicador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //////////////////////////////////
    @NotNull
    @Column(name = "id_indicador")
    private Long idIndicador;

    @NotNull
    @Column(name = "id_modelo")
    private Long idModelo;

    @Column(name = "id_variable")
    private Long idVariable;

    @Column(name = "id_modelo_calculo")
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

//id_modelo int4 NOT NULL,
    //id_variable int4 NULL,
    //id_modelo_calculo int4 NULL,

////////////////////////////////////
/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public Integer getIdModeloCalculo() {
        return idModeloCalculo;
    }

    public void setIdModeloCalculo(Integer idModeloCalculo) {
        this.idModeloCalculo = idModeloCalculo;
    }

    /****
     * json para prueba de guardar modelo con modeloxindicador
     * {
     *   "id": 1,
     *   "nombre": "nombre203",
     *   "idUnidadMedida": 1,
     *   "idTableroControl": 1,
     *   "idEstado": 1,
     *   "idRutina": 1,
     *   "idPeriodicidad": 1,
     *   "idCompDesagregacion": 1,
     *   "fechaPublicacion": "2022-02-01",
     *   "descripcion": "descripcion1",
     *   "archivoFicha": "archivo",
     *   "urlFicha": "url ficha",
     *   "observaciones": "observaciones",
     *   "calcularValoresJerarquia": "1",
     *   "necesitaValidar": "1",
     *   "necesitaAprobar": "0",
     *   "idFormatoOrigenDatos": null,
     *   "ModeloXIndicador": {
     *      "idIndicador":1
     *   }
     * }
     *
     *
     * ** */
}