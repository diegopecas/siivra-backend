package com.geotek.siivra.entity.common;

import com.geotek.siivra.entity.DissagregationComponentItem;
import com.geotek.siivra.entity.Indicador;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "siivrat_indicador_info_archivo")
public class IndicadorInfoArchivo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "id_proceso_indicador",insertable = false, updatable = false)
    // private ProcesoIndicador idprocesoindicador;
    @Column(name = "id_proceso_indicador")
    private Long idProcesoIndicador;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador", insertable = false, updatable = false)
    // private Indicador idindicador;
    @Column(name = "id_indicador")
    private Long idIndicador;

    // @ManyToOne(fetch = FetchType.LAZY, targetEntity = CompDesagregacionItem.class)
    // @JoinColumn(name = "id_componente_desagrega_item", insertable = false, updatable = false)
    // private CompDesagregacionItem idcomponentedesagregaitem;
    @Column(name = "id_componente_desagrega_item")
    private Long idComponenteDesagregaItem;

    @Column(name = "periodo_inicial_validez", nullable = false, length = 8)
    private String periodoInicialValidez;

    @Column(name = "periodo_final_validez", length = 8)
    private String periodoFinalValidez;

    @Column(name = "ubicacion_imagen", nullable = false, length = 4000)
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

    /*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProcesoIndicador getIdprocesoindicador() {
        return idprocesoindicador;
    }

    public void setIdprocesoindicador(ProcesoIndicador idprocesoindicador) {
        this.idprocesoindicador = idprocesoindicador;
    }

    public Integer getIdProcesoIndicador() {
        return idProcesoIndicador;
    }

    public void setIdProcesoIndicador(Integer idProcesoIndicador) {
        this.idProcesoIndicador = idProcesoIndicador;
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

    public CompDesagregacionItem getIdcomponentedesagregaitem() {
        return idcomponentedesagregaitem;
    }

    public void setIdcomponentedesagregaitem(CompDesagregacionItem idcomponentedesagregaitem) {
        this.idcomponentedesagregaitem = idcomponentedesagregaitem;
    }

    public Integer getIdComponenteDesagregaItem() {
        return idComponenteDesagregaItem;
    }

    public void setIdComponenteDesagregaItem(Integer idComponenteDesagregaItem) {
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

 */
}
