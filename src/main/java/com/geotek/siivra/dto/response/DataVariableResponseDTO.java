package com.geotek.siivra.dto.response;

public interface DataVariableResponseDTO {

	Long getId();
	Long getIdVariable();
	String getNombreVariable();
	Long getIdProcesoVariable();
	Long getIdComponenteDesagregaItem();
	String getNombreComponenteDesagregaItem();
	Long getIdTipoCompDesagregacion();
	String getNombreTipoCompDesagregacion();
	Double getValor();
	String getPeriodoInicialValidez();
	String getPeriodoFinalValidez();
	Long getIdTipoEstado();
	String getNombreTipoEstado();
	String getMotivo();
	String getMotivoComplementario();
	String getAuditoria();

}