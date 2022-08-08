package com.geotek.siivra.dto.response;

import java.io.Serializable;
import java.util.ArrayList;

public class CreateResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String entidad;
    private Long id;
    private String mensaje;
    private Object objeto;
    private int codigoError;

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObjeto() {
        if (objeto == null) {
            return new ArrayList();
        }
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public void setCodigoError(int codigoError) {
        this.codigoError = codigoError;
    }
}
