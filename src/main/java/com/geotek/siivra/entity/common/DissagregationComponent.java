package com.geotek.siivra.entity.common;


import com.geotek.siivra.entity.Estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "siivrat_comp_desagregacion")

public class DissagregationComponent {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=100)
	private String nombre;

	@ManyToOne
	@JoinColumn(name="id_capa_geografica", insertable = false, updatable = false)
	private GeographicLayer geographicLayer;
	@Column(name = "id_capa_geografica")
	private Integer capageografica;

	@ManyToOne
	@JoinColumn(name="id_componente_desagrega_padre", insertable = false, updatable = false)
	private DissagregationComponent dissagregationComponent;
	@Column(name = "id_componente_desagrega_padre")
	private Integer componentedesagregacion;

	@ManyToOne
	@JoinColumn(name="id_dato_maestro", nullable=false, insertable = false, updatable = false)
	private DatoMaestro DatoMaestro;
	@Column(name = "id_dato_maestro")
	private Integer datomaestro;

	@ManyToOne
	@JoinColumn(name="id_estado", nullable=false, insertable = false, updatable = false)
	private Estado estado;
	@Column(name = "id_estado")
	private Integer idestado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GeographicLayer getGeographicLayer() {
		return geographicLayer;
	}

	public void setGeographicLayer(GeographicLayer geographicLayer) {
		this.geographicLayer = geographicLayer;
	}

	public Integer getCapageografica() {
		return capageografica;
	}

	public void setCapageografica(Integer capageografica) {
		this.capageografica = capageografica;
	}

	public DissagregationComponent getDissagregationComponent() {
		return dissagregationComponent;
	}

	public void setDissagregationComponent(DissagregationComponent dissagregationComponent) {
		this.dissagregationComponent = dissagregationComponent;
	}

	public Integer getComponentedesagregacion() {
		return componentedesagregacion;
	}

	public void setComponentedesagregacion(Integer componentedesagregacion) {
		this.componentedesagregacion = componentedesagregacion;
	}

	public com.geotek.siivra.entity.common.DatoMaestro getDatoMaestro() {
		return DatoMaestro;
	}

	public void setDatoMaestro(com.geotek.siivra.entity.common.DatoMaestro datoMaestro) {
		DatoMaestro = datoMaestro;
	}

	public Integer getDatomaestro() {
		return datomaestro;
	}

	public void setDatomaestro(Integer datomaestro) {
		this.datomaestro = datomaestro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getIdestado() {
		return idestado;
	}

	public void setIdestado(Integer idestado) {
		this.idestado = idestado;
	}
}
