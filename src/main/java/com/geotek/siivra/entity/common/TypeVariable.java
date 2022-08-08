package com.geotek.siivra.entity.common;
import javax.persistence.*;

@Entity
@Table(name = "siivrat_tipo_variable")


public class TypeVariable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    
    @Column(name = "nombre")
    private String nombre;

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
