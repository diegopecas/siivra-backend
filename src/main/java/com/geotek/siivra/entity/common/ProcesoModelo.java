package com.geotek.siivra.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geotek.siivra.entity.Modelo;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="siivrat_proceso_modelo")
public class ProcesoModelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique=true, nullable=false)
    private Long id;

    // @ManyToOne
    // @JoinColumn(name="id_rutina", nullable=false, insertable = false, updatable = false)
    // private Rutine rutine;
    @Column(name = "id_rutina")
    private Long idRutine;

    // @ManyToOne
    // @JoinColumn(name="id_usuario", nullable=false, insertable = false, updatable = false)
    // private Usuario usuario;
    @Column(name = "id_usuario")
    private Long idUsuario;

    // @ManyToOne
    // @JoinColumn(name="id_forma_carga_informacion", nullable=false, insertable = false, updatable = false)
    // private FormaCargaInformacion formaCargaInformacion;
    @Column(name = "id_forma_carga_informacion")
    private Long idFormaCargaInformacion;

    // @ManyToOne
    // @JoinColumn(name="id_est_ejecucion", nullable=false, insertable = false, updatable = false)
    // private EstEjecucion estEjecucion;
    @Column(name = "id_est_ejecucion")
    private Long idEstEjecucion;

    // @ManyToOne
    // @JoinColumn(name="id_modelo", nullable=false, insertable = false, updatable = false)
    // private Modelo modelo;
    @Column(name = "id_modelo")
    private Long idModelo;

    @Column(name = "fecha_carga")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaCarga;

    @Column(name="descripcion_ejecucion", length=4000)
    private String descripcionEjecucion;

    @Column(name="periodo_inicial_validez", length=8)
    private String periodoInicialValidez;

    @Column(name="periodo_final_validez", length=8)
    private String periodoFinalValidez;

    @Column(name="ubicacion_archivo_log", length=500)
    private String ubicacionArchivoLog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRutine() {
        return idRutine;
    }

    public void setIdRutine(Long idRutine) {
        this.idRutine = idRutine;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdFormaCargaInformacion() {
        return idFormaCargaInformacion;
    }

    public void setIdFormaCargaInformacion(Long idFormaCargaInformacion) {
        this.idFormaCargaInformacion = idFormaCargaInformacion;
    }

    public Long getIdEstEjecucion() {
        return idEstEjecucion;
    }

    public void setIdEstEjecucion(Long idEstEjecucion) {
        this.idEstEjecucion = idEstEjecucion;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getDescripcionEjecucion() {
        return descripcionEjecucion;
    }

    public void setDescripcionEjecucion(String descripcionEjecucion) {
        this.descripcionEjecucion = descripcionEjecucion;
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

    public String getUbicacionArchivoLog() {
        return ubicacionArchivoLog;
    }

    public void setUbicacionArchivoLog(String ubicacionArchivoLog) {
        this.ubicacionArchivoLog = ubicacionArchivoLog;
    }

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rutine getRutine() {
        return rutine;
    }

    public void setRutine(Rutine rutine) {
        this.rutine = rutine;
    }

    public Integer getIdRutine() {
        return idRutine;
    }

    public void setIdRutine(Integer idRutine) {
        this.idRutine = idRutine;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public FormaCargaInformacion getFormaCargaInformacion() {
        return formaCargaInformacion;
    }

    public void setFormaCargaInformacion(FormaCargaInformacion formaCargaInformacion) {
        this.formaCargaInformacion = formaCargaInformacion;
    }

    public Integer getIdFormaCargaInformacion() {
        return idFormaCargaInformacion;
    }

    public void setIdFormaCargaInformacion(Integer idFormaCargaInformacion) {
        this.idFormaCargaInformacion = idFormaCargaInformacion;
    }

    public EstEjecucion getEstEjecucion() {
        return estEjecucion;
    }

    public void setEstEjecucion(EstEjecucion estEjecucion) {
        this.estEjecucion = estEjecucion;
    }

    public Integer getIdEstEjecucion() {
        return idEstEjecucion;
    }

    public void setIdEstEjecucion(Integer idEstEjecucion) {
        this.idEstEjecucion = idEstEjecucion;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Integer getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getDescripcionEjecucion() {
        return descripcionEjecucion;
    }

    public void setDescripcionEjecucion(String descripcionEjecucion) {
        this.descripcionEjecucion = descripcionEjecucion;
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

    public String getUbicacionArchivoLog() {
        return ubicacionArchivoLog;
    }

    public void setUbicacionArchivoLog(String ubicacionArchivoLog) {
        this.ubicacionArchivoLog = ubicacionArchivoLog;
    }

     */
}
