package com.geotek.siivra.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import com.geotek.siivra.entity.common.EstDato;
import com.geotek.siivra.entity.common.ModeloTipoValor;
import com.geotek.siivra.entity.common.ProcesoModelo;
import com.geotek.siivra.entity.Modelo;
import com.geotek.siivra.entity.common.TipoEstado;

@Entity
@Table(name="siivrat_modelo_info_alfanu")
public class DataModelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name="id_componente_desagrega_item", nullable=false, insertable = false, updatable = false)
    // private DissagregationComponentItem dissagregationComponentItem;
    @Column(name = "id_componente_desagrega_item")
    private Long idComponenteDesagregaItem;

    // @ManyToOne
    // @JoinColumn(name="id_modelo_tipo_val", nullable=false, insertable = false, updatable = false)
    // private ModeloTipoValor tipoValor;
    @Column(name = "id_modelo_tipo_val")
    private Long idModeloTipoVal;

    // @ManyToOne
    // @JoinColumn(name="id_tipo_estado", nullable=false, insertable = false, updatable = false)
    // private TipoEstado tipoEstado;
    @Column(name = "id_tipo_estado")
    private Long idTipoEstado;

    // @ManyToOne
    // @JoinColumn(name="id_proceso_modelo", nullable=false, insertable = false, updatable = false)
    // private ProcesoModelo procesoModelo;
    @Column(name = "id_proceso_modelo")
    private Long idProcesoModelo;

    @Column(nullable=false)
    private double valor;

    @Column(name="periodo_inicial_validez", length=8)
    private String periodoInicialValidez;

    @Column(name="periodo_final_validez", length=8)
    private String periodoFinalValidez;

    // @ManyToOne
    // @JoinColumn(name="id_modelo", nullable=false, insertable = false, updatable = false)
    // private Modelo modelo;
    @Column(name = "id_modelo")
    private Long idModelo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdComponenteDesagregaItem() {
        return idComponenteDesagregaItem;
    }

    public void setIdComponenteDesagregaItem(Long idComponenteDesagregaItem) {
        this.idComponenteDesagregaItem = idComponenteDesagregaItem;
    }

    public Long getIdModeloTipoVal() {
        return idModeloTipoVal;
    }

    public void setIdModeloTipoVal(Long idModeloTipoVal) {
        this.idModeloTipoVal = idModeloTipoVal;
    }

    public Long getIdTipoEstado() {
        return idTipoEstado;
    }

    public void setIdTipoEstado(Long idTipoEstado) {
        this.idTipoEstado = idTipoEstado;
    }

    public Long getIdProcesoModelo() {
        return idProcesoModelo;
    }

    public void setIdProcesoModelo(Long idProcesoModelo) {
        this.idProcesoModelo = idProcesoModelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    /*
    public DataModelo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DissagregationComponentItem getDissagregationComponentItem() {
        return dissagregationComponentItem;
    }

    public void setDissagregationComponentItem(DissagregationComponentItem dissagregationComponentItem) {
        this.dissagregationComponentItem = dissagregationComponentItem;
    }

    public Integer getIdCompDesagregacionItem() {
        return idCompDesagregacionItem;
    }

    public void setIdCompDesagregacionItem(Integer idCompDesagregacionItem) {
        this.idCompDesagregacionItem = idCompDesagregacionItem;
    }

    public ModeloTipoValor getTipoValor() {
        return tipoValor;
    }

    public void setTipoValor(ModeloTipoValor tipoValor) {
        this.tipoValor = tipoValor;
    }

    public Integer getIdModeloTipoVal() {
        return idModeloTipoVal;
    }

    public void setIdModeloTipoVal(Integer idModeloTipoVal) {
        this.idModeloTipoVal = idModeloTipoVal;
    }

    public TipoEstado getTipoEstado() {
        return tipoEstado;
    }

    public void setTipoEstado(TipoEstado tipoEstado) {
        this.tipoEstado = tipoEstado;
    }

    public Integer getIdtipoEstado() {
        return idtipoEstado;
    }

    public void setIdtipoEstado(Integer idtipoEstado) {
        this.idtipoEstado = idtipoEstado;
    }

    public ProcesoModelo getProcesoModelo() {
        return procesoModelo;
    }

    public void setProcesoModelo(ProcesoModelo procesoModelo) {
        this.procesoModelo = procesoModelo;
    }

    public Integer getIdProcesoModelo() {
        return idProcesoModelo;
    }

    public void setIdProcesoModelo(Integer idProcesoModelo) {
        this.idProcesoModelo = idProcesoModelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

     */
}
