package com.geotek.siivra.entity.common;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_comp_desagregacion_item")
public class CompDesagregacionItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name = "id_comp_desagregacion", insertable = false, updatable = false)
    // private CompDesagregacion idcompdesagregacion;
    @Column(name = "id_comp_desagregacion")
    private Long idCompDesagregacion;

    @Column(name = "id_dato_maestro_valor")
    private Long idDatoMaestroValor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo_capa_geografica")
    private String codigocapageografica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public Long getIdDatoMaestroValor() {
        return idDatoMaestroValor;
    }

    public void setIdDatoMaestroValor(Long idDatoMaestroValor) {
        this.idDatoMaestroValor = idDatoMaestroValor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigocapageografica() {
        return codigocapageografica;
    }

    public void setCodigocapageografica(String codigocapageografica) {
        this.codigocapageografica = codigocapageografica;
    }

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompDesagregacion getIdcompdesagregacion() {
        return idcompdesagregacion;
    }

    public void setIdcompdesagregacion(CompDesagregacion idcompdesagregacion) {
        this.idcompdesagregacion = idcompdesagregacion;
    }

    public Integer getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Integer idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
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

    public String getCodigocapageografica() {
        return codigocapageografica;
    }

    public void setCodigocapageografica(String codigocapageografica) {
        this.codigocapageografica = codigocapageografica;
    }

     */
}
