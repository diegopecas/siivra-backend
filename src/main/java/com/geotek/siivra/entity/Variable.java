package com.geotek.siivra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_variable")
public class Variable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_rutina", insertable = false, updatable = false)
    // private Rutine rutine;
    @Column(name = "id_rutina")
    private Long idRutina;

    // @ManyToOne
    // @JoinColumn(name = "id_forma_almacenar_info", insertable = false, updatable = false)
    // private WayStoreInfo wayStoreInfo;
    @Column(name = "id_forma_almacenar_info")
    private Long idFormaAlmacenarInfo;

    // @ManyToOne()
    // @JoinColumn(name = "id_tipo_ubicacion_info", insertable = false, updatable = false)
    // private TypeLocationInfo typeLocationInfo;
    @Column(name = "id_tipo_ubicacion_info", nullable = false)
    private Long idTipoUbicacionInfo;

    // @ManyToOne()
    // @JoinColumn(name = "id_formato_origen_datos", insertable = false, updatable = false)
    // private FortmatDataSource formatDataSource;
    @Column(name = "id_formato_origen_datos", nullable = false)
    private Long idFormatoOrigenDatos;

    // @ManyToOne()
    // @JoinColumn(name = "id_comp_desagregacion", insertable = false, updatable = false)
    // private DissagregationComponent dissagregationComponent;
    @Column(name = "id_comp_desagregacion")
    private Long idCompDesagregacion;

    // @ManyToOne()
    // @JoinColumn(name = "id_disposicion_info", insertable = false, updatable = false)
    // private InfoProvision infoProvision;
    @Column(name = "id_disposicion_info", nullable = false)
    private Long idDisposicionInfo;

    // @ManyToOne()
    // @JoinColumn(name = "id_unidad_medida", insertable = false, updatable = false)
    // private UnitMeassurement unitMeassurement;
    @Column(name = "id_unidad_medida")
    private Long idUnidadMedida;

    // @ManyToOne()
    // @JoinColumn(name = "id_periodicidad", insertable = false, updatable = false)
    // private Periodicity periodicity;
    @Column(name = "id_periodicidad")
    private Long idPeriodicidad;

    // @ManyToOne
    // @JoinColumn(name = "id_entidad", insertable = false, updatable = false)
    // private Entidades entidad;
    @Column(name = "id_entidad")
    private Long idEntidad;

    // @ManyToOne
    // @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    // private Estado estado;
    @Column(name = "id_estado")
    public Long idEstado;

    // @ManyToOne()
    // @JoinColumn(name = "id_proyecto", insertable = false, updatable = false)
    // private Proyecto proyecto;
    @Column(name = "id_proyecto")
    private Long idProyecto;

    // @ManyToOne()
    // @JoinColumn(name = "id_capa_geografica_referencia", insertable = false, updatable = false)
    // private GeographicLayer geographicLayer;
    @Column(name = "id_capa_geografica_referencia")
    private Long idCapaGeograficaReferencia;

    @Column(name = "nombre", length = 500, nullable = false)
    private String nombre;

    @Column(name = "archivo_definicion", length = 2147483647)
    private String archivoDefinicion;

    @Column(name = "dependencia", length = 1000)
    private String dependencia;

    @Column(name = "contacto_nombre", length = 100)
    private String contactoNombre;

    @Column(name = "contacto_cargo", length = 100)
    private String contactoCargo;

    @Column(name = "contacto_correo", length = 100)
    private String contactoCorreo;

    @Column(name = "contacto_telefono", length = 30)
    private String contactoTelefono;

    @Column(name = "datos_ubicacion", length = 4000)
    private String datosUbicacion;

    @Column(name = "observaciones", length = 4000)
    private String observaciones;

    @Column(name = "calcular_valores_jerarquia", length = 1)
    private String calcularValoresJerarquia;

    @Column(name = "url_ficha", length = 1000)
    private String urlFicha;

    // @ManyToOne
    // @JoinColumn(name = "id_tipo_variable", insertable = false, updatable = false)
    // private TypeVariable typeVariable;
    @Column(name = "id_tipo_variable")
    private Long idTipoVariable;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    // @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaCreacion;

    @Column(name = "almacenar_geografia", length = 1)
    private String almacenarGeografia;

    @Column(name = "necesita_validar", length = 1)
    private String necesitaValidar;

    @Column(name = "necesita_aprobar", length = 1)
    private String necesitaAprobar;

    @Column(name = "usuario", length = 30)
    private String usuario;

    @Column(name = "contrasenia", length = 15)
    private String contrasenia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Long idRutina) {
        this.idRutina = idRutina;
    }

    public Long getIdFormaAlmacenarInfo() {
        return idFormaAlmacenarInfo;
    }

    public void setIdFormaAlmacenarInfo(Long idFormaAlmacenarInfo) {
        this.idFormaAlmacenarInfo = idFormaAlmacenarInfo;
    }

    public Long getIdTipoUbicacionInfo() {
        return idTipoUbicacionInfo;
    }

    public void setIdTipoUbicacionInfo(Long idTipoUbicacionInfo) {
        this.idTipoUbicacionInfo = idTipoUbicacionInfo;
    }

    public Long getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
    }

    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public Long getIdDisposicionInfo() {
        return idDisposicionInfo;
    }

    public void setIdDisposicionInfo(Long idDisposicionInfo) {
        this.idDisposicionInfo = idDisposicionInfo;
    }

    public Long getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Long idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Long getIdPeriodicidad() {
        return idPeriodicidad;
    }

    public void setIdPeriodicidad(Long idPeriodicidad) {
        this.idPeriodicidad = idPeriodicidad;
    }

    public Long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(Long idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Long getIdCapaGeograficaReferencia() {
        return idCapaGeograficaReferencia;
    }

    public void setIdCapaGeograficaReferencia(Long idCapaGeograficaReferencia) {
        this.idCapaGeograficaReferencia = idCapaGeograficaReferencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivoDefinicion() {
        return archivoDefinicion;
    }

    public void setArchivoDefinicion(String archivoDefinicion) {
        this.archivoDefinicion = archivoDefinicion;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getContactoNombre() {
        return contactoNombre;
    }

    public void setContactoNombre(String contactoNombre) {
        this.contactoNombre = contactoNombre;
    }

    public String getContactoCargo() {
        return contactoCargo;
    }

    public void setContactoCargo(String contactoCargo) {
        this.contactoCargo = contactoCargo;
    }

    public String getContactoCorreo() {
        return contactoCorreo;
    }

    public void setContactoCorreo(String contactoCorreo) {
        this.contactoCorreo = contactoCorreo;
    }

    public String getContactoTelefono() {
        return contactoTelefono;
    }

    public void setContactoTelefono(String contactoTelefono) {
        this.contactoTelefono = contactoTelefono;
    }

    public String getDatosUbicacion() {
        return datosUbicacion;
    }

    public void setDatosUbicacion(String datosUbicacion) {
        this.datosUbicacion = datosUbicacion;
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

    public String getUrlFicha() {
        return urlFicha;
    }

    public void setUrlFicha(String urlFicha) {
        this.urlFicha = urlFicha;
    }

    public Long getIdTipoVariable() {
        return idTipoVariable;
    }

    public void setIdTipoVariable(Long idTipoVariable) {
        this.idTipoVariable = idTipoVariable;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAlmacenarGeografia() {
        return almacenarGeografia;
    }

    public void setAlmacenarGeografia(String almacenarGeografia) {
        this.almacenarGeografia = almacenarGeografia;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

}