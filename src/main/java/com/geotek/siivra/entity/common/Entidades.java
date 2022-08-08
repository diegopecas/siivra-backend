package com.geotek.siivra.entity.common;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "siivrat_entidad")
public class Entidades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
/*
	@ManyToOne()
	@JoinColumn(name = "id_tipo_entidad", insertable = false, updatable = false)
	private TipoEntidad tipoEntidad;
	@Column(name = "id_tipo_entidad")
	private Integer idTipoEntidad;

	@ManyToOne()
	@JoinColumn(name = "id_estado", insertable = false, updatable = false)
	private Estado  estado;
	@Column(name = "id_estado")
	private Integer idEstado;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "pagina_web")
	private String paginaweb;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEntidad getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(TipoEntidad tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public Integer getIdTipoEntidad() {
		return idTipoEntidad;
	}

	public void setIdTipoEntidad(Integer idTipoEntidad) {
		this.idTipoEntidad = idTipoEntidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPaginaweb() {
		return paginaweb;
	}

	public void setPaginaweb(String paginaweb) {
		this.paginaweb = paginaweb;
	}*/
}