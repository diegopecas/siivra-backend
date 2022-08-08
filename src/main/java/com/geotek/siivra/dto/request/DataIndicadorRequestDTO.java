package com.geotek.siivra.dto.request;

import javax.persistence.*;
import java.io.Serializable;

public class DataIndicadorRequestDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long idIndicador;
	private Long idProcesoIndicador;
	private Object idComponenteDesagregaItem;
	private Object valor;
	private String periodoInicialValidez;
	private String periodoFinalValidez;
	private Object valorMeta;
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
		// return valor;
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

	public Double getValorMeta() {

		try {
			if(this.valorMeta == null) {
				return -2d;
			} else if(this.valorMeta.toString().compareTo("") == 0) {
				return -2d;
			} else {
				double d = Double.parseDouble(this.valorMeta.toString());
				return d;
			}
		} catch (NumberFormatException nfe) {
			return -1d;
		}
	}

	public void setValorMeta(Double valorMeta) {
		this.valorMeta = valorMeta.toString();
	}

	public void setValorMeta(String valorMeta) {
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
	public String getAuditoria() {
		return auditoria;
	}

	public void setAuditoria(String auditoria) {
		this.auditoria = auditoria;
	}

 */
}