package com.geotek.siivra.entity.common;

import javax.persistence.*;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import java.io.Serializable;

@Entity
@Immutable
@Table(name = "common_lists_view")
public class CommonLists implements Serializable {

	private static final long serialVersionUID = 1L;

    public String getNombreDato() {
		return nombreDato;
	}

	public void setNombreDato(String nombreDato) {
		this.nombreDato = nombreDato;
	}
	@Id
	@Column(name = "id_r")
	private Integer idR;
	
	public Integer getId_r() {
		return idR;
	}

	public void setId_r(Integer id_r) {
		this.idR = idR;
	}
	@Column(name = "id")
	private Long id;
    
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_dato")
    private String nombreDato;

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
	
	
}
