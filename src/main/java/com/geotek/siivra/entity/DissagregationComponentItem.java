package com.geotek.siivra.entity;

import com.geotek.siivra.entity.common.DissagregationComponent;

import javax.persistence.*;


@Entity
@Table(name = "siivrat_comp_desagregacion_item")
public class DissagregationComponentItem {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Long id;

	@Column(name="codigo_capa_geografica", length=30)
	private String codigoCapaGeografica;

	@Column(name="id_dato_maestro_valor", nullable=false)
	private Integer idDatoMaestroValor;

	@Column(nullable=false, length=100)
	private String nombre;

	@ManyToOne
	@JoinColumn(name="id_comp_desagregacion", nullable=false)
	private DissagregationComponent dissagregationComponent;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoCapaGeografica() {
		return codigoCapaGeografica;
	}

	public void setCodigoCapaGeografica(String codigoCapaGeografica) {
		this.codigoCapaGeografica = codigoCapaGeografica;
	}

	public Integer getIdDatoMaestroValor() {
		return idDatoMaestroValor;
	}

	public void setIdDatoMaestroValor(Integer idDatoMaestroValor) {
		this.idDatoMaestroValor = idDatoMaestroValor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DissagregationComponent getDissagregationComponent() {
		return dissagregationComponent;
	}

	public void setDissagregationComponent(DissagregationComponent dissagregationComponent) {
		this.dissagregationComponent = dissagregationComponent;
	}
}
