package com.geotek.siivra.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geotek.siivra.entity.common.Periodicity;

@Entity
@Table(name = "siivrat_modelo")
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "id_unidad_medida")
    private Long idUnidadMedida;
    
    @NotNull
    @Column(name = "id_tablero_control")
    private Long idTableroControl;
    
    @NotNull
    @Column(name = "id_estado")
    public Long idEstado;
    
    @NotNull
    @Column(name = "id_rutina")
    private Long idRutina;
    
    //@ManyToOne()
    //@JoinColumn(name = "id_periodicidad", insertable = false, updatable = false)
    //private Periodicity periodicity;

    @Column(name = "id_periodicidad")
    private Long idPeriodicidad;

    @Column(name = "id_comp_desagregacion")
    private Long idCompDesagregacion;

    @Column(length = 500, nullable = false)
    private String nombre;
    
    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaPublicacion;

    @Column(name = "descripcion", length = 4000)
    private String descripcion;
    
    @Column(name = "archivo_ficha")
    private String archivoFicha;

    
    @Column(name = "url_ficha", length = 1000)
    private String urlFicha;

    @Column(length = 4000)
    private String observaciones;
    
    @Column(name = "calcular_valores_jerarquia", length = 1)
    private String calcularValoresJerarquia;

    @Column(name = "necesita_validar", length = 1)
    private String necesitaValidar;

    @Column(name = "necesita_aprobar", length = 1)
    private String necesitaAprobar;

    @Column(name = "id_formato_origen_datos")
    private Long idFormatoOrigenDatos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Long idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Long getIdTableroControl() {
        return idTableroControl;
    }

    public void setIdTableroControl(Long idTableroControl) {
        this.idTableroControl = idTableroControl;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Long idRutina) {
        this.idRutina = idRutina;
    }

    public Long getIdPeriodicidad() {
        return idPeriodicidad;
    }

    public void setIdPeriodicidad(Long idPeriodicidad) {
        this.idPeriodicidad = idPeriodicidad;
    }

    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getArchivoFicha() {
        return archivoFicha;
    }

    public void setArchivoFicha(String archivoFicha) {
        this.archivoFicha = archivoFicha;
    }

    public String getUrlFicha() {
        return urlFicha;
    }

    public void setUrlFicha(String urlFicha) {
        this.urlFicha = urlFicha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCalcularValoresJerarquia() {
        return calcularValoresJerarquia;
    }

    public void setCalcularValoresJerarquia(String calcularValoresJerarquia) {
        this.calcularValoresJerarquia = calcularValoresJerarquia;
    }

    public String getNecesitaValidar() {
        return necesitaValidar;
    }

    public void setNecesitaValidar(String necesitaValidar) {
        this.necesitaValidar = necesitaValidar;
    }

    public String getNecesitaAprobar() {
        return necesitaAprobar;
    }

    public void setNecesitaAprobar(String necesitaAprobar) {
        this.necesitaAprobar = necesitaAprobar;
    }

    public Long getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
    }

/*

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCalcularValoresJerarquia() {
        return calcularValoresJerarquia;
    }

    public void setCalcularValoresJerarquia(String calcularValoresJerarquia) {
        this.calcularValoresJerarquia = calcularValoresJerarquia;
    }

    public Integer getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Integer idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }
    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
    public Integer getIdTableroControl() {
		return idTableroControl;
	}

	public void setIdTableroControl(Integer idTableroControl) {
		this.idTableroControl = idTableroControl;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getArchivoFicha() {
		return archivoFicha;
	}

	public void setArchivoFicha(String archivoFicha) {
		this.archivoFicha = archivoFicha;
	}

    /*public Periodicity getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(Periodicity periodicidad) {
		this.periodicidad = periodicidad;
	}
    * /
	public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }
    
    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Integer idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getUrlFicha() {
        return urlFicha;
    }

    public void setUrlFicha(String urlFicha) {
        this.urlFicha = urlFicha;
    }

    /*
    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }* /

    public Integer getIdPeriodicidad() {
        return idPeriodicidad;
    }

    public void setIdPeriodicidad(Integer idPeriodicidad) {
        this.idPeriodicidad = idPeriodicidad;
    }

    public String getNecesitaValidar() {
        return necesitaValidar;
    }

    public void setNecesitaValidar(String necesitaVallidar) {
        this.necesitaValidar = necesitaVallidar;
    }

    public String getNecesitaAprobar() {
        return necesitaAprobar;
    }

    public void setNecesitaAprobar(String necesitaAprobar) {
        this.necesitaAprobar = necesitaAprobar;
    }

    public Integer getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Integer idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
    }
    / *********
     * {
     *   "id": 1,
     *   "nombre": "nombre208",
     *   "idUnidadMedida": 1,
     *   "idTableroControl": 1,
     *   "idEstado": 1,
     *   "idRutina": 1,
     *   "idPeriodicidad": 1,
     *   "idCompDesagregacion": 1,
     *   "fechaPublicacion": "2022-02-01",
     *   "descripcion": "descripcion1",
     *   "archivoFicha": "archivo",
     *   "urlFicha": "url ficha",
     *   "observaciones": "observaciones",
     *   "calcularValoresJerarquia": "1",
     *   "necesitaValidar": "1",
     *   "necesitaAprobar": "0",
     *   "idFormatoOrigenDatos": null,
     *   "modeloXIndicador": {
     *      "idIndicador":1,
     *      "idVariable":3,
     *      "idModeloCalculo":1
     *   }
     * }
     * * */

}