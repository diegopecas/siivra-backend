package com.geotek.siivra.dto.response.common;

import java.io.Serializable;
import java.util.Date;

public class UsuRespXVariableResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idVariable;
    private Long idEstado;
    private Long idUsuario;
    private Date fechaInicoResponsabilidad;
    private Date fechaFinResponsabilidad;
    private Long idResponsable;

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

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getFechaInicoResponsabilidad() {
        return fechaInicoResponsabilidad;
    }

    public void setFechaInicoResponsabilidad(Date fechaInicoResponsabilidad) {
        this.fechaInicoResponsabilidad = fechaInicoResponsabilidad;
    }

    public Date getFechaFinResponsabilidad() {
        return fechaFinResponsabilidad;
    }

    public void setFechaFinResponsabilidad(Date fechaFinResponsabilidad) {
        this.fechaFinResponsabilidad = fechaFinResponsabilidad;
    }

    public Long getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Long idResponsable) {
        this.idResponsable = idResponsable;
    }

}
