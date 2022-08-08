package com.geotek.siivra.dto.response.common;

import java.io.Serializable;

public class IndicadorXCapaResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idCompDesagregacion;
    private Long idIndicador;
    private long idCapaGeografica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public long getIdCapaGeografica() {
        return idCapaGeografica;
    }

    public void setIdCapaGeografica(long idCapaGeografica) {
        this.idCapaGeografica = idCapaGeografica;
    }

}
