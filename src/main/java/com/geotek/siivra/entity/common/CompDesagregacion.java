package com.geotek.siivra.entity.common;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "siivrat_comp_desagregacion")
public class CompDesagregacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_componente_desagrega_padre", insertable = false, updatable = false)
    // private CompDesagregacion compDesagregacion;
    @Column(name = "id_componente_desagrega_padre")
    private Long idComponenteDesagregaPadre;

    // @ManyToOne()
    // @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    // private Estado estado;
    @Column(name = "id_estado")
    private Long idEstado;

    // @ManyToOne()
    // @JoinColumn(name = "id_dato_maestro", insertable = false, updatable = false)
    // private DatoMaestro datoMaestro;
    @Column(name = "id_dato_maestro")
    private Long idDatoMaestro;

    @Column(name = "nombre")
    private String nombre;

    // @ManyToOne()
    // @JoinColumn(name = "id_capa_geografica", insertable = false, updatable = false)
    // private CapaGeografica capaGeografica;
    @Column(name = "id_capa_geografica")
    private Long idCapaGeografica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdComponenteDesagregaPadre() {
        return idComponenteDesagregaPadre;
    }

    public void setIdComponenteDesagregaPadre(Long idComponenteDesagregaPadre) {
        this.idComponenteDesagregaPadre = idComponenteDesagregaPadre;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdDatoMaestro() {
        return idDatoMaestro;
    }

    public void setIdDatoMaestro(Long idDatoMaestro) {
        this.idDatoMaestro = idDatoMaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCapaGeografica() {
        return idCapaGeografica;
    }

    public void setIdCapaGeografica(Long idCapaGeografica) {
        this.idCapaGeografica = idCapaGeografica;
    }

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompDesagregacion getCompDesagregacion() {
        return compDesagregacion;
    }

    public void setCompDesagregacion(CompDesagregacion compDesagregacion) {
        this.compDesagregacion = compDesagregacion;
    }

    public Integer getComponenteDesagregaPadre() {
        return componenteDesagregaPadre;
    }

    public void setComponenteDesagregaPadre(Integer componenteDesagregaPadre) {
        this.componenteDesagregaPadre = componenteDesagregaPadre;
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

    public DatoMaestro getDatoMaestro() {
        return datoMaestro;
    }

    public void setDatoMaestro(DatoMaestro datoMaestro) {
        this.datoMaestro = datoMaestro;
    }

    public Integer getIddatoMaestro() {
        return iddatoMaestro;
    }

    public void setIddatoMaestro(Integer iddatoMaestro) {
        this.iddatoMaestro = iddatoMaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public CapaGeografica getCapaGeografica() {
        return capaGeografica;
    }

    public void setCapaGeografica(CapaGeografica capaGeografica) {
        this.capaGeografica = capaGeografica;
    }

    public Integer getCapageografica() {
        return capageografica;
    }

    public void setCapageografica(Integer capageografica) {
        this.capageografica = capageografica;
    }

     */
}
