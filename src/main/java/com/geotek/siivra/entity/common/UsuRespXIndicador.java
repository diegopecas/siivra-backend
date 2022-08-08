package com.geotek.siivra.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_usu_resp_x_indicador")
public class UsuRespXIndicador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_indicador")
    private Long idIndicador;

    @Column(name = "fecha_inico_responsabilidad")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaInicioResponbilidad;

    @Column(name = "fecha_fin_responsabilidad")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaFinResponbilidad;

    @Column(name = "id_responsable")
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