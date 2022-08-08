package com.geotek.siivra.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geotek.siivra.entity.Variable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_usu_resp_x_modelo")
public class UsuRespXModelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_modelo", insertable = false, updatable = false)
    // private Variable idvariable;
    @Column(name = "id_modelo")
    private Long idVariable;

    // @ManyToOne()
    // @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    // private Estado idestado;
    @Column(name = "id_estado")
    private Long idEstado;

    // @ManyToOne()
    // @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    // private Usuario idusuario;
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "fecha_inico_responsabilidad")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaInicoResponsabilidad;

    @Column(name = "fecha_fin_responsabilidad")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaFinResponsabilidad;

    @Column(name = "id_responsable")
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

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Variable getIdvariable() {
        return idvariable;
    }

    public void setIdvariable(Variable idvariable) {
        this.idvariable = idvariable;
    }

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
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

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

     */
}
