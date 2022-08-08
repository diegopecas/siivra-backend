package com.geotek.siivra.dto.response.common;

import java.io.Serializable;

public class AccesoVariableXUsuResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idUsuario;
    private Long idVariable;
    private String accesoNegado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public String getAccesoNegado() {
        return accesoNegado;
    }

    public void setAccesoNegado(String accesoNegado) {
        this.accesoNegado = accesoNegado;
    }

}
