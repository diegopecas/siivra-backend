package com.geotek.siivra.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="siivrat_proceso_variable")
public class ProcesoVariable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(name="datos_ubicacion", length=4000)
    private String datosUbicacion;

    @Column(name="descripcion_ejecucion", nullable=false, length=4000)
    private String descripcionEjecucion;

    @Column(name="fecha_carga", nullable=false)
    private Timestamp fechaCarga;

    @Column(name="periodo_final_validez", nullable=false, length=8)
    private String periodoFinalValidez;

    @Column(name="periodo_inicial_validez", nullable=false, length=8)
    private String periodoInicialValidez;

    @Column(name="ubicacion_archivo_log", length=500)
    private String ubicacionArchivoLog;

    /*
    @ManyToOne
    @JoinColumn(name="id_est_ejecucion", nullable=false)
    private EstEjecucion estEjecucion;
    */
    @Column(name = "id_est_ejecucion")
    private Long idEstEjecucion;

    /*
    @ManyToOne
    @JoinColumn(name="id_forma_carga_informacion", nullable=false)
    private FormaCargaInformacion formaCargaInformacion;
    */
    @Column(name = "id_forma_carga_informacion")
    private Long idFormaCargaInformacion;

    /*
    @ManyToOne
    @JoinColumn(name="id_formato_origen_datos", nullable=false)
    private FormatoOrigenDato formatoOrigenDato;
    */
    @Column(name = "id_formato_origen_datos")
    private Long idFormatoOrigenDato;

    /*
    @ManyToOne
    @JoinColumn(name="id_rutina")
    private Rutina rutina;
    */
    @Column(name = "id_rutina")
    private Long idRutina;

    /*
    @ManyToOne
    @JoinColumn(name="id_usuario", nullable=false)
    private Usuario usuario;
    */
    @Column(name = "id_usuario")
    private Long idUsuario;

    /*
    @ManyToOne
    @JoinColumn(name="id_variable", nullable=false)
    private Variable Variable;
    */
    @Column(name = "id_variable")
    private Long idVariable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatosUbicacion() {
        return datosUbicacion;
    }

    public void setDatosUbicacion(String datosUbicacion) {
        this.datosUbicacion = datosUbicacion;
    }

    public String getDescripcionEjecucion() {
        return descripcionEjecucion;
    }

    public void setDescripcionEjecucion(String descripcionEjecucion) {
        this.descripcionEjecucion = descripcionEjecucion;
    }

    public Timestamp getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Timestamp fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getPeriodoFinalValidez() {
        return periodoFinalValidez;
    }

    public void setPeriodoFinalValidez(String periodoFinalValidez) {
        this.periodoFinalValidez = periodoFinalValidez;
    }

    public String getPeriodoInicialValidez() {
        return periodoInicialValidez;
    }

    public void setPeriodoInicialValidez(String periodoInicialValidez) {
        this.periodoInicialValidez = periodoInicialValidez;
    }

    public String getUbicacionArchivoLog() {
        return ubicacionArchivoLog;
    }

    public void setUbicacionArchivoLog(String ubicacionArchivoLog) {
        this.ubicacionArchivoLog = ubicacionArchivoLog;
    }

    public Long getIdEstEjecucion() {
        return idEstEjecucion;
    }

    public void setIdEstEjecucion(Long idEstEjecucion) {
        this.idEstEjecucion = idEstEjecucion;
    }

    public Long getIdFormaCargaInformacion() {
        return idFormaCargaInformacion;
    }

    public void setIdFormaCargaInformacion(Long idFormaCargaInformacion) {
        this.idFormaCargaInformacion = idFormaCargaInformacion;
    }

    public Long getIdFormatoOrigenDato() {
        return idFormatoOrigenDato;
    }

    public void setIdFormatoOrigenDato(Long idFormatoOrigenDato) {
        this.idFormatoOrigenDato = idFormatoOrigenDato;
    }

    public Long getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Long idRutina) {
        this.idRutina = idRutina;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    /*
    public ProcesoVariable() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatosUbicacion() {
        return datosUbicacion;
    }

    public void setDatosUbicacion(String datosUbicacion) {
        this.datosUbicacion = datosUbicacion;
    }

    public String getDescripcionEjecucion() {
        return descripcionEjecucion;
    }

    public void setDescripcionEjecucion(String descripcionEjecucion) {
        this.descripcionEjecucion = descripcionEjecucion;
    }

    public Timestamp getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Timestamp fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getPeriodoFinalValidez() {
        return periodoFinalValidez;
    }

    public void setPeriodoFinalValidez(String periodoFinalValidez) {
        this.periodoFinalValidez = periodoFinalValidez;
    }

    public String getPeriodoInicialValidez() {
        return periodoInicialValidez;
    }

    public void setPeriodoInicialValidez(String periodoInicialValidez) {
        this.periodoInicialValidez = periodoInicialValidez;
    }

    public String getUbicacionArchivoLog() {
        return ubicacionArchivoLog;
    }

    public void setUbicacionArchivoLog(String ubicacionArchivoLog) {
        this.ubicacionArchivoLog = ubicacionArchivoLog;
    }

    public Integer getIdEstEjecucion() {
        return idEstEjecucion;
    }

    public void setIdEstEjecucion(Integer idEstEjecucion) {
        this.idEstEjecucion = idEstEjecucion;
    }

    public Integer getIdFormaCargaInformacion() {
        return idFormaCargaInformacion;
    }

    public void setIdFormaCargaInformacion(Integer idFormaCargaInformacion) {
        this.idFormaCargaInformacion = idFormaCargaInformacion;
    }

    public Integer getIdFormatoOrigenDato() {
        return idFormatoOrigenDato;
    }

    public void setIdFormatoOrigenDato(Integer idFormatoOrigenDato) {
        this.idFormatoOrigenDato = idFormatoOrigenDato;
    }

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

     */
}