package com.geotek.siivra.dto;

import com.geotek.siivra.entity.common.CompDesagregacion;
import com.geotek.siivra.entity.common.DatoMaestro;

import javax.persistence.*;

public class CompDesagregacionItemDTO {

    private Long id;

    private Long idcompdesagregacion;

    private Long idCompDesagregacion;
    private Long iddatomaestrovalor;
    private Long idDatoMaestroValor;
    private String nombre;
    private String codigocapageografica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public Long getIdDatoMaestroValor() {
        return idDatoMaestroValor;
    }

    public void setIdDatoMaestroValor(Long idDatoMaestroValor) {
        this.idDatoMaestroValor = idDatoMaestroValor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigocapageografica() {
        return codigocapageografica;
    }

    public void setCodigocapageografica(String codigocapageografica) {
        this.codigocapageografica = codigocapageografica;
    }

    public Long getIdcompdesagregacion() {
        return idcompdesagregacion;
    }

    public void setIdcompdesagregacion(Long idcompdesagregacion) {
        this.idcompdesagregacion = idcompdesagregacion;
    }

    public Long getIddatomaestrovalor() {
        return iddatomaestrovalor;
    }

    public void setIddatomaestrovalor(Long iddatomaestrovalor) {
        this.iddatomaestrovalor = iddatomaestrovalor;
    }
}
