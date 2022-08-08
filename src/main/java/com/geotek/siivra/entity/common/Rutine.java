package com.geotek.siivra.entity.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "siivrat_rutina")
public class Rutine implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "script_ejecucion")
	private String scriptEjecucion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getScriptEjecucion() {
		return scriptEjecucion;
	}

	public void setScriptEjecucion(String scriptEjecucion) {
		this.scriptEjecucion = scriptEjecucion;
	}
}
