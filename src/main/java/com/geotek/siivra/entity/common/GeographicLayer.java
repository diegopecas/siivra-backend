package com.geotek.siivra.entity.common;

import javax.persistence.*;

@Entity
@Table(name = "siivrat_capa_geografica")

public class GeographicLayer {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "id_capa_geografica_tipo", insertable = false, updatable = false)
	private CapaGeograficaTipo capaGeograficaTipo;
    @Column(name = "id_capa_geografica_tipo")
	private Integer idCapaGeograficaTipo;

	@ManyToOne()
	@JoinColumn(name = "id_estado", insertable = false, updatable = false)
	private Estado estado;
    @Column(name = "id_estado")
	private Integer idEstado;

	@ManyToOne()
	@JoinColumn(name = "id_tipo_salida_geografica", insertable = false, updatable = false)
	private TipoSalidaGeografica tipoSalidaGeografica;
    @Column(name = "id_tipo_salida_geografica")
	private Integer idTipoSalidaGeografica;
	
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

	public CapaGeograficaTipo getCapaGeograficaTipo() {
		return capaGeograficaTipo;
	}

	public void setCapaGeograficaTipo(CapaGeograficaTipo capaGeograficaTipo) {
		this.capaGeograficaTipo = capaGeograficaTipo;
	}

	public Integer getIdCapaGeograficaTipo() {
		return idCapaGeograficaTipo;
	}

	public void setIdCapaGeograficaTipo(Integer idCapaGeograficaTipo) {
		this.idCapaGeograficaTipo = idCapaGeograficaTipo;
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

	public TipoSalidaGeografica getTipoSalidaGeografica() {
		return tipoSalidaGeografica;
	}

	public void setTipoSalidaGeografica(TipoSalidaGeografica tipoSalidaGeografica) {
		this.tipoSalidaGeografica = tipoSalidaGeografica;
	}

	public Integer getIdTipoSalidaGeografica() {
		return idTipoSalidaGeografica;
	}

	public void setIdTipoSalidaGeografica(Integer idTipoSalidaGeografica) {
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
}
