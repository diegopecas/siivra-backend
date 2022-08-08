package com.geotek.siivra.dto.response.common;

import java.io.Serializable;
import java.util.Date;

public class UsuRespXIndicadorResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idUsuario;
    private Long idIndicador;
    private Date fechaInicioResponbilidad;
    private Date fechaFinResponbilidad;
    private Integer idRespondable;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

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

    public Date getFechaInicioResponbilidad() {
        return fechaInicioResponbilidad;
    }

    public void setFechaInicioResponbilidad(Date fechaInicioResponbilidad) {
        this.fechaInicioResponbilidad = fechaInicioResponbilidad;
    }

    public Date getFechaFinResponbilidad() {
        return fechaFinResponbilidad;
    }

    public void setFechaFinResponbilidad(Date fechaFinResponbilidad) {
        this.fechaFinResponbilidad = fechaFinResponbilidad;
    }

    public Integer getIdRespondable() {
        return idRespondable;
    }

    public void setIdRespondable(Integer idRespondable) {
        this.idRespondable = idRespondable;
    }
}