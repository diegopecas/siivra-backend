package com.geotek.siivra.dto.request.common;

import javax.persistence.*;
import java.io.Serializable;

public class IndicadorXCapaRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idCompDesagregacion;
    private Long idIndicador;
    private Long idCapaGeografica;

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

    public Long getIdCapaGeografica() {
        return idCapaGeografica;
    }

    public void setIdCapaGeografica(Long idCapaGeografica) {
        this.idCapaGeografica = idCapaGeografica;
    }

}
