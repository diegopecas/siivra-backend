package com.geotek.siivra.dto;


import com.geotek.siivra.entity.DissagregationComponentItem;
import com.geotek.siivra.entity.Indicador;
import com.geotek.siivra.entity.common.EstDato;
import com.geotek.siivra.entity.common.ProcesoIndicador;

import javax.persistence.*;

public class IndicadorInfoArchivoDTO {

    private Long id;
    private ProcesoIndicador idprocesoIndicador;
    private Long idProcesoIndicador;
    private Indicador idindicador;
    private Long idIndicador;
    private DissagregationComponentItem idcomponenteDesagregaItem;
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

    public ProcesoIndicador getIdprocesoIndicador() {
        return idprocesoIndicador;
    }

    public void setIdprocesoIndicador(ProcesoIndicador idprocesoIndicador) {
        this.idprocesoIndicador = idprocesoIndicador;
    }

    public Long getIdProcesoIndicador() {
        return idProcesoIndicador;
    }

    public void setIdProcesoIndicador(Long idProcesoIndicador) {
        this.idProcesoIndicador = idProcesoIndicador;
    }

    public Indicador getIdindicador() {
        return idindicador;
    }

    public void setIdindicador(Indicador idindicador) {
        this.idindicador = idindicador;
    }

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public DissagregationComponentItem getIdcomponenteDesagregaItem() {
        return idcomponenteDesagregaItem;
    }

    public void setIdcomponenteDesagregaItem(DissagregationComponentItem idcomponenteDesagregaItem) {
        this.idcomponenteDesagregaItem = idcomponenteDesagregaItem;
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
