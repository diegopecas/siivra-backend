package com.geotek.siivra.entity.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geotek.siivra.entity.Variable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_proceso_variable")
public class ProcesoVariable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_variable", insertable = false, updatable = false)
    // private Variable idvariable;
    @Column(name = "id_variable")
    private Long idVariable;

    // @ManyToOne()
    // @JoinColumn(name = "id_rutina", insertable = false, updatable = false)
    // private Rutine idrutina;
    @Column(name = "id_rutina")
    private Long idRutina;

    // @ManyToOne()
    // @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    // private Usuario idusuario;
    @Column(name = "id_usuario")
    private Long idUsuario;

    // @ManyToOne()
    // @JoinColumn(name = "id_forma_carga_informacion", insertable = false, updatable = false)
    // private FormaAlmacenarInfo idformacargainformacion;
    @Column(name = "id_forma_carga_informacion")
    private Long idFormaCargaInformacion;

    // @ManyToOne()
    // @JoinColumn(name = "id_est_ejecucion", insertable = false, updatable = false)
    // private EstEjecucion idestejecucion;
    @Column(name = "id_est_ejecucion")
    private Long idEstEjecucion;

    // @ManyToOne()
    // @JoinColumn(name = "id_formato_origen_datos", insertable = false, updatable = false)
    // private FormatoOrigenDatos idformatoorigendatos;
    @Column(name = "id_formato_origen_datos")
    private Long idFormatoOrigenDatos;

    @Column(name = "fecha_carga")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaCarga;

    @Column(name = "descripcion_ejecucion")
    private String descripcionEjecucion;

    @Column(name = "datos_ubicacion")
    private String datosUbicacion;

    @Column(name = "periodo_inicial_validez")
    private String periodoInicialValidez;

    @Column(name = "periodo_final_validez")
    private String periodoFinalValidez;

    @Column(name = "ubicacion_archivo_log")
    private String ubicacionArchivoLog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
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

    public Long getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
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

    public String getDatosUbicacion() {
        return datosUbicacion;
    }

    public void setDatosUbicacion(String datosUbicacion) {
        this.datosUbicacion = datosUbicacion;
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

    public Variable getIdvariable() {
        return idvariable;
    }

    public void setIdvariable(Variable idvariable) {
        this.idvariable = idvariable;
    }

    public Integer getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Integer idVariable) {
        this.idVariable = idVariable;
    }

    public Rutine getIdrutina() {
        return idrutina;
    }

    public void setIdrutina(Rutine idrutina) {
        this.idrutina = idrutina;
    }

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Integer idRutina) {
        this.idRutina = idRutina;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public FormaAlmacenarInfo getIdformacargainformacion() {
        return idformacargainformacion;
    }

    public void setIdformacargainformacion(FormaAlmacenarInfo idformacargainformacion) {
        this.idformacargainformacion = idformacargainformacion;
    }

    public Integer getIdFormaCargaInformacion() {
        return idFormaCargaInformacion;
    }

    public void setIdFormaCargaInformacion(Integer idFormaCargaInformacion) {
        this.idFormaCargaInformacion = idFormaCargaInformacion;
    }

    public EstEjecucion getIdestejecucion() {
        return idestejecucion;
    }

    public void setIdestejecucion(EstEjecucion idestejecucion) {
        this.idestejecucion = idestejecucion;
    }

    public Integer getIdEstEjecucion() {
        return idEstEjecucion;
    }

    public void setIdEstEjecucion(Integer idEstEjecucion) {
        this.idEstEjecucion = idEstEjecucion;
    }

    public FormatoOrigenDatos getIdformatoorigendatos() {
        return idformatoorigendatos;
    }

    public void setIdformatoorigendatos(FormatoOrigenDatos idformatoorigendatos) {
        this.idformatoorigendatos = idformatoorigendatos;
    }

    public Integer getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Integer idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
    }

    public Date getFechaCarga() {
        return fechaCarga;
    }

    public void setFechaCarga(Date fechaCarga) {
        this.fechaCarga = fechaCarga;
    }

    public String getDescripcionejecucion() {
        return descripcionejecucion;
    }

    public void setDescripcionejecucion(String descripcionejecucion) {
        this.descripcionejecucion = descripcionejecucion;
    }

    public String getDatosubicacion() {
        return datosubicacion;
    }

    public void setDatosubicacion(String datosubicacion) {
        this.datosubicacion = datosubicacion;
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

    public String getUbicacionarchivolog() {
        return ubicacionarchivolog;
    }

    public void setUbicacionarchivolog(String ubicacionarchivolog) {
        this.ubicacionarchivolog = ubicacionarchivolog;
    }
    */

}
