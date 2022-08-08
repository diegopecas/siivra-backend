package com.geotek.siivra.dto.response.common;

import java.io.Serializable;

public class IndicadorInfoArchivoResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idProcesoIndicador;
    private Long idIndicador;
    private Long idComponenteDesagregaItem;
    private String periodoInicialValidez;
    private String periodoFinalValidez;
    private String ubicacionImagen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProcesoIndicador() {
        return idProcesoIndicador;
    }

    public void setIdProcesoIndicador(Long idProcesoIndicador) {
        this.idProcesoIndicador = idProcesoIndicador;
    }

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Long getIdComponenteDesagregaItem() {
        return idComponenteDesagregaItem;
    }

    public void setIdComponenteDesagregaItem(Long idComponenteDesagregaItem) {
        this.idComponenteDesagregaItem = idComponenteDesagregaItem;
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

    public String getUbicacionImagen() {
        return ubicacionImagen;
    }

    public void setUbicacionImagen(String ubicacionImagen) {
        this.ubicacionImagen = ubicacionImagen;
    }

}
