package com.geotek.siivra.entity;

import com.geotek.siivra.entity.common.CompDesagregacionItem;
import com.geotek.siivra.entity.common.DissagregationComponent;
import com.geotek.siivra.entity.common.ProcesoVariable;
import com.geotek.siivra.entity.common.TipoEstado;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="siivrat_variable_info_alfa")
public class DataVariable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "id_variable", insertable = false, updatable = false)
	// private Variable idvariable;
	@Column(name = "id_variable")
	private Long idVariable;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "id_proceso_variable", insertable = false, updatable = false)
	// private com.geotek.siivra.entity.common.ProcesoVariable idprocesovariable;
	@Column(name = "id_proceso_variable")
	private Long idProcesoVariable;

	// @ManyToOne(fetch = FetchType.LAZY, targetEntity = CompDesagregacionItem.class)
	// @JoinColumn(name = "id_componente_desagrega_item", insertable = false, updatable = false)
	// private CompDesagregacionItem idcomponentedesagregaitem;
	@Column(name = "id_componente_desagrega_item")
	private Long idComponenteDesagregaItem;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "periodo_inicial_validez")
	private String periodoInicialValidez;

	@Column(name = "periodo_final_validez")
	private String periodoFinalValidez;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "id_tipo_estado", insertable = false, updatable = false)
	// private TipoEstado tipoEstado;
	@Column(name = "id_tipo_estado")
	private Long idTipoEstado;

	@Column(name = "motivo")
	private String motivo;

	@Column(name = "motivo_complementario")
	private String motivoComplementario;

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
	public DataVariable() {
	}

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

	public com.geotek.siivra.entity.common.ProcesoVariable getIdprocesovariable() {
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

	public TipoEstado getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(TipoEstado tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public Integer getIdTipoEstado() {
		return idTipoEstado;
	}

	public void setIdTipoEstado(Integer idTipoEstado) {
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
*/

}