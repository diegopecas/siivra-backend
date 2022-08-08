package com.geotek.siivra.dto.request;

import java.io.Serializable;
import java.util.Date;

public class VariableRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idRutina;
    private Long idFormaAlmacenarInfo;
    private Long idTipoUbicacionInfo;
    private Long idFormatoOrigenDatos;
    private Long idCompDesagregacion;
    private Long idDisposicionInfo;
    private Long idUnidadMedida;
    private Long idPeriodicidad;
    private Long idEntidad;
    private Long idEstado;
    private Long idProyecto;
    private Long idCapaGeograficaReferencia;
    private String nombre;
    private String archivoDefinicion;
    private String dependencia;
    private String contactoNombre;
    private String contactoCargo;
    private String contactoCorreo;
    private String contactoTelefono;
    private String datosUbicacion;
    private String observaciones;
    private String calcularValoresJerarquia;
    private String urlFicha;
    private Long idTipoVariable;
    private Date fechaCreacion;
    private String almacenarGeografia;
    private String necesitaValidar;
    private String necesitaAprobar;
    private String usuario;
    private String contrasenia;
    // private String auditoria;

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
/*
    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }
*/
}