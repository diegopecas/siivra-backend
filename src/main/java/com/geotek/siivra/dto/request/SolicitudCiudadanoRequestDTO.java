package com.geotek.siivra.dto.request;

import javax.persistence.*;
import java.io.Serializable;

public class SolicitudCiudadanoRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idSolSop;
    private Long idEstSolicitud;
    private Long idEntidad;
    private Long idTipoDocumento;
    private Integer numeroDocumento;
    private Integer nombre;
    private String correoElectronico;
    private String numeroContacto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdSolSop() {
        return idSolSop;
    }

    public void setIdSolSop(Long idSolSop) {
        this.idSolSop = idSolSop;
    }

    public Long getIdEstSolicitud() {
        return idEstSolicitud;
    }

    public void setIdEstSolicitud(Long idEstSolicitud) {
        this.idEstSolicitud = idEstSolicitud;
    }

    public Long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

}