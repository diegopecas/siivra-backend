package com.geotek.siivra.dto.response.common;

import java.io.Serializable;

public class CompDesagregacionItemResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idCompDesagregacion;
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

}
