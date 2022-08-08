package com.geotek.siivra.entity;

import com.geotek.siivra.entity.common.CompDesagregacionItem;
import com.geotek.siivra.entity.common.ProcesoIndicador;
import com.geotek.siivra.entity.common.TipoEstado;
import com.geotek.siivra.entity.common.TypeLocationInfo;

import java.io.Serializable;
import javax.persistence.*;
import javax.print.attribute.IntegerSyntax;

@Entity
@Table(name="siivrat_indicador_info_alfa")
public class DataIndicador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Column(updatable = false)
	private Long id;

	// @ManyToOne()
	// @JoinColumn(name = "id_indicador", insertable = false, updatable = false)
	// private Indicador indicador;
	@Column(name="id_indicador")
	private Long idIndicador;

	// @ManyToOne()
	// @JoinColumn(name = "id_proceso_indicador", insertable = false, updatable = false)
	// private ProcesoIndicador procesoIndicador;
	@Column(name="id_proceso_indicador")
	private Long idProcesoIndicador;

	// @ManyToOne()
	// @JoinColumn(name = "id_componente_desagrega_item", insertable = false, updatable = false)
	// private CompDesagregacionItem compDesagregacionItem;
	@Column(name="id_componente_desagrega_item")
	private Long idComponenteDesagregaItem;

	@Column(name="valor")
	private Double valor;

	@Column(name="periodo_inicial_validez")
	private String periodoInicialValidez;

	@Column(name="periodo_final_validez")
	private String periodoFinalValidez;

	@Column(name="valor_meta")
	private Double valorMeta;

	// @ManyToOne()
	// @JoinColumn(name = "id_tipo_estado", insertable = false, updatable = false)
	// private TipoEstado tipoestado;
	@Column(name="id_tipo_estado")
	private Long idTipoEstado;

	@Column(name="motivo")
	private String motivo;

	@Column(name="motivo_complementario")
	private String motivoComplementario;

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

	public Long getIdProcesoIndicador() {
		return idProcesoIndicador;
	}

	public void setIdProcesoIndicador(Long idProcesoIndicador) {
		this.idProcesoIndicador = idProcesoIndicador;
	}

	public Long getIdComponenteDesagregaItem() {
		return idComponenteDesagregaItem;
	}

	public void setIdComponenteDesagregaItem(Long idComponenteDesagregaItem) {
		this.idComponenteDesagregaItem = idComponenteDesagregaItem;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
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

	public Double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(Double valorMeta) {
		this.valorMeta = valorMeta;
	}

	public Long getIdTipoEstado() {
		return idTipoEstado;
	}

	public void setIdTipoEstado(Long idTipoEstado) {
		this.idTipoEstado = idTipoEstado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMotivoComplementario() {
		return motivoComplementario;
	}

	public void setMotivoComplementario(String motivoComplementario) {
		this.motivoComplementario = motivoComplementario;
	}

	/*
	public DataIndicador() {
	}

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


	public Integer getIdProcesoIndicador() {
		return idProcesoIndicador;
	}

	public void setIdProcesoIndicador(Integer idProcesoIndicador) {
		this.idProcesoIndicador = idProcesoIndicador;
	}

	public CompDesagregacionItem getCompDesagregacionItem() {
		return compDesagregacionItem;
	}

	public void setCompDesagregacionItem(CompDesagregacionItem compDesagregacionItem) {
		this.compDesagregacionItem = compDesagregacionItem;
	}

	public Integer getIdComponenteDesagregaItem() {
		return idComponenteDesagregaItem;
	}

	public void setIdComponenteDesagregaItem(Integer idComponenteDesagregaItem) {
		this.idComponenteDesagregaItem = idComponenteDesagregaItem;
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

	public double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(double valorMeta) {
		this.valorMeta = valorMeta;
	}

	public TipoEstado getTipoestado() {
		return tipoestado;
	}

	public void setTipoestado(TipoEstado tipoestado) {
		this.tipoestado = tipoestado;
	}

	public Integer getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(Integer tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMotivoComplementario() {
		return motivoComplementario;
	}

	public void setMotivoComplementario(String motivoComplementario) {
		this.motivoComplementario = motivoComplementario;
	}

	 */
}