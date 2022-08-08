package com.geotek.siivra.dto.response;

public interface VariableResponseDTO {

    Long getId();
    Long getIdRutina();
    String getNombreRutina();
    Long getIdFormaAlmacenarInfo();
    String getNombreFormaAlmacenarInfo();
    Long getIdTipoUbicacionInfo();
    String getNombreTipoUbicacionInfo();
    Long getIdFormatoOrigenDatos();
    String getNombreFormatoOrigenDatos();
    Long getIdCompDesagregacion();
    String getNombreCompDesagregacion();
    Long getIdDisposicionInfo();
    String getNombreDisposicionInfo();
    Long getIdUnidadMedida();
    String getNombreUnidadMedida();
    Long getIdPeriodicidad();
    String getNombrePeriodicidad();
    Long getIdEntidad();
    String getNombreEntidad();
    Long getIdEstado();
    String getNombreEstado();
    Long getIdProyecto();
    String getNombreProyecto();
    Long getIdCapaGeograficaReferencia();
    String getNombreCapaGeograficaReferencia();
    String getNombre();
    String getArchivoDefinicion();
    String getDependencia();
    String getContactoNombre();
    String getContactoCargo();
    String getContactoCorreo();
    String getContactoTelefono();
    String getDatosUbicacion();
    String getObservaciones();
    String getCalcularValoresJerarquia();
    String getUrlFicha();
    Long getIdTipoVariable();
    String getNombreTipoVariable();
    String getFechaCreacion();
    String getAlmacenarGeografia();
    String getNecesitaValidar();
    String getNecesitaAprobar();
    String getUsuario();
    String getContrasenia();
    Integer getAsociada();
    String getAuditoria();

}