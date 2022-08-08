package com.geotek.siivra.entity.common;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "siivrat_capa_geografica")
public class CapaGeografica implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_capa_geografica_tipo", insertable = false, updatable = false)
    // private CapaGeografica capaGeografica;
    @Column(name = "id_capa_geografica_tipo")
    private Long idCapaGeograficaTipo;

    // @ManyToOne()
    // @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    // private Estado estado;
    @Column(name = "id_estado")
    private Long idEstado;

    // @ManyToOne()
    // @JoinColumn(name = "id_tipo_salida_geografica", insertable = false, updatable = false)
    // private TipoSalidaGeografica tipoSalidaGeografica;
    @Column(name = "id_tipo_salida_geografica")
    private Long idTipoSalidaGeografica;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "periodo_inicial_validez")
    private String periodoInicialValidez;

    @Column(name = "periodo_final_validez")
    private String periodoFinalValidez;

    @Column(name = "url_publicacion")
    private String urlPublicacion;

    @Column(name = "repositorio")
    private String repositorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCapaGeograficaTipo() {
        return idCapaGeograficaTipo;
    }

    public void setIdCapaGeograficaTipo(Long idCapaGeograficaTipo) {
        this.idCapaGeograficaTipo = idCapaGeograficaTipo;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdTipoSalidaGeografica() {
        return idTipoSalidaGeografica;
    }

    public void setIdTipoSalidaGeografica(Long idTipoSalidaGeografica) {
        this.idTipoSalidaGeografica = idTipoSalidaGeografica;
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

    public String getPeriodoInicialValidez() {
        return periodoInicialValidez;
    }

    public void setPeriodoInicialValidez(String periodoInicialValidez) {
        this.periodoInicialValidez = periodoInicialValidez;
    }

    public String getPeriodoFinalValidez() {
        return periodoFinalValidez;
    }

    public void setPeriodoFinalValidez(String periodoFinalValidez) {
        this.periodoFinalValidez = periodoFinalValidez;
    }

    public String getUrlPublicacion() {
        return urlPublicacion;
    }

    public void setUrlPublicacion(String urlPublicacion) {
        this.urlPublicacion = urlPublicacion;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CapaGeografica getCapaGeografica() {
        return capaGeografica;
    }

    public void setCapaGeografica(CapaGeografica capaGeografica) {
        this.capaGeografica = capaGeografica;
    }

    public Integer getCapageograficatipo() {
        return capageograficatipo;
    }

    public void setCapageograficatipo(Integer capageograficatipo) {
        this.capageograficatipo = capageograficatipo;
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

    public TipoSalidaGeografica getTipoSalidaGeografica() {
        return tipoSalidaGeografica;
    }

    public void setTipoSalidaGeografica(TipoSalidaGeografica tipoSalidaGeografica) {
        this.tipoSalidaGeografica = tipoSalidaGeografica;
    }

    public Integer getTiposalidageografica() {
        return tiposalidageografica;
    }

    public void setTiposalidageografica(Integer tiposalidageografica) {
        this.tiposalidageografica = tiposalidageografica;
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

    public String getPeriodoinicialvalidez() {
        return periodoinicialvalidez;
    }

    public void setPeriodoinicialvalidez(String periodoinicialvalidez) {
        this.periodoinicialvalidez = periodoinicialvalidez;
    }

    public String getPeriodofinalvalidez() {
        return periodofinalvalidez;
    }

    public void setPeriodofinalvalidez(String periodofinalvalidez) {
        this.periodofinalvalidez = periodofinalvalidez;
    }

    public String getUrlpublicacion() {
        return urlpublicacion;
    }

    public void setUrlpublicacion(String urlpublicacion) {
        this.urlpublicacion = urlpublicacion;
    }

    public String getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }

 */
}
