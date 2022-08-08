package com.geotek.siivra.dto.request;

import java.util.Date;
public class DataVariableRequestDTO{

	private Long id;
	private Long idVariable;
	private Long idProcesoVariable;
	private Object idComponenteDesagregaItem;
	private Object valor;
	private String periodoInicialValidez;
	private String periodoFinalValidez;
	private Long idTipoEstado;
	private String motivo;
	private String motivoComplementario;
	// private String auditoria;

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
		try {
			long d = Long.parseLong(idComponenteDesagregaItem.toString());
			return d;
		} catch (NumberFormatException nfe) {
			return null;
		}
		// return idComponenteDesagregaItem;
	}

	public void setIdComponenteDesagregaItem(Object idComponenteDesagregaItem) {
		this.idComponenteDesagregaItem = idComponenteDesagregaItem;
	}

	public Double getValor() {
		try {
			if(valor == null || valor.toString().isEmpty()) {
				return null;
			}
			double d = Double.parseDouble(valor.toString());
			return d;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public void setValor(Object valor) {
		this.valor = valor;
	}

	public String getPeriodoInicialValidez() {
		try {
			if(periodoInicialValidez == null || periodoInicialValidez.isEmpty()) {
				return null;
			}
			double d = Double.parseDouble(periodoInicialValidez);
			if (d < 196001) {
				return null;
			}
			return periodoInicialValidez;
		} catch (NumberFormatException nfe) {
			return null;
		}
	}

	public void setPeriodoInicialValidez(String periodoInicialValidez) {
		this.periodoInicialValidez = periodoInicialValidez;
	}

	public String getPeriodoFinalValidez() {
		try {
			if(periodoFinalValidez == null || periodoFinalValidez.isEmpty()) {
				return null;
			}
			double d = Double.parseDouble(periodoFinalValidez);
			if (d < 196001) {
				return null;
			}
			return periodoFinalValidez;
		} catch (NumberFormatException nfe) {
			return null;
		}
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
	public String getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}

 */
}