package com.geotek.siivra.dto.request;

import java.io.Serializable;

public class ValidarAprobarDataVariableRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idTipoEstado;
    private String motivo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
