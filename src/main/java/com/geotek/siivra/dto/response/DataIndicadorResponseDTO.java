package com.geotek.siivra.dto.response;

public interface DataIndicadorResponseDTO {

	Long getId();
	Long getIdIndicador();
	String getNombreIndicador();
	Long getIdProcesoIndicador();
	Long getIdComponenteDesagregaItem();
	String getNombreComponenteDesagregaItem();
	Long getIdTipoCompDesagregacion();
	String getNombreTipoCompDesagregacion();
	Double getValor();
	String getPeriodoInicialValidez();
	String getPeriodoFinalValidez();
	Double getValorMeta();
	Long getIdTipoEstado();
	String getNombreTipoEstado();
	String getMotivo();
	String getMotivoComplementario();
	String getAuditoria();
}