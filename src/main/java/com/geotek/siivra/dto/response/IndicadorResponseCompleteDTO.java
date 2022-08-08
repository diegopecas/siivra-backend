package com.geotek.siivra.dto.response;

import java.util.Date;
import java.util.List;

public class IndicadorResponseCompleteDTO {

    Long Id;
    Long IdRutina;
    String NombreRutina;
    Long IdCompDesagregacion;
    String NombreCompDesagregacion;
    Long IdAdaptacionNivel;
    String NombreAdaptacionNivel;
    Long IdDimension;
    String NombreDimension;
    Long IdClasificacionAdap;
    String NombreClasificacionAdap;
    Long IdIndicadorSubindice;
    String NombreIndicadorSubindice;
    Long IdIndicadorIndice;
    String NombreIndicadorIndice;
    Long IdModeloCompone;
    String NombreModeloCompone;
    Long IdIndicadorSeccion;
    String NombreIndicadorSeccion;
    Long IdUnidadMedida;
    String NombreUnidadMedida;
    Long IdTipoSalidaGeografica;
    String NombreTipoSalidaGeografica;
    Long IdIndicadorTipo;
    String NombreIndicadorTipo;
    Long IdAlcanceInformacion;
    String NombreAlcanceInformacion;
    Long IdPeriodicidad;
    String NombrePeriodicidad;
    Long IdPlanAdaptacion;
    String NombrePlanAdaptacion;
    Long IdEstado;
    String NombreEstado;
    String Nombre;
    String Codigo;
    Date FechaPublicacion;
    String Descripcion;
    String ArchivoFicha;
    String UrlFicha;
    String UrlPublicacion;
    String Observaciones;
    Date FechaPlazoMeta;
    String EtiquetasPublicacion;
    String CalcularValoresJerarquia;
    String NecesitaValidar;
    String NecesitaAprobar;
    Long IdFormaAlmacenarInfo;
    String NombreFormaAlmacenarInfo;
    Long IdDisposicionInfo;
    String NombreDisposicionInfo;
    Long IdFormatoOrigenDatos;
    String NombreFormatoOrigenDatos;
    String AlmacenarGeografia;
    List<IndicadorCgResponseDTO> listIndicadorXCapa;
    List<IndicadorIndVarResponseDTO> listIndicadorXVarInd;
    Integer Asociada;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getIdRutina() {
        return IdRutina;
    }

    public void setIdRutina(Long idRutina) {
        IdRutina = idRutina;
    }

    public String getNombreRutina() {
        return NombreRutina;
    }

    public void setNombreRutina(String nombreRutina) {
        NombreRutina = nombreRutina;
    }

    public Long getIdCompDesagregacion() {
        return IdCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        IdCompDesagregacion = idCompDesagregacion;
    }

    public String getNombreCompDesagregacion() {
        return NombreCompDesagregacion;
    }

    public void setNombreCompDesagregacion(String nombreCompDesagregacion) {
        NombreCompDesagregacion = nombreCompDesagregacion;
    }

    public Long getIdAdaptacionNivel() {
        return IdAdaptacionNivel;
    }

    public void setIdAdaptacionNivel(Long idAdaptacionNivel) {
        IdAdaptacionNivel = idAdaptacionNivel;
    }

    public String getNombreAdaptacionNivel() {
        return NombreAdaptacionNivel;
    }

    public void setNombreAdaptacionNivel(String nombreAdaptacionNivel) {
        NombreAdaptacionNivel = nombreAdaptacionNivel;
    }

    public Long getIdDimension() {
        return IdDimension;
    }

    public void setIdDimension(Long idDimension) {
        IdDimension = idDimension;
    }

    public String getNombreDimension() {
        return NombreDimension;
    }

    public void setNombreDimension(String nombreDimension) {
        NombreDimension = nombreDimension;
    }

    public Long getIdClasificacionAdap() {
        return IdClasificacionAdap;
    }

    public void setIdClasificacionAdap(Long idClasificacionAdap) {
        IdClasificacionAdap = idClasificacionAdap;
    }

    public String getNombreClasificacionAdap() {
        return NombreClasificacionAdap;
    }

    public void setNombreClasificacionAdap(String nombreClasificacionAdap) {
        NombreClasificacionAdap = nombreClasificacionAdap;
    }

    public Long getIdIndicadorSubindice() {
        return IdIndicadorSubindice;
    }

    public void setIdIndicadorSubindice(Long idIndicadorSubindice) {
        IdIndicadorSubindice = idIndicadorSubindice;
    }

    public String getNombreIndicadorSubindice() {
        return NombreIndicadorSubindice;
    }

    public void setNombreIndicadorSubindice(String nombreIndicadorSubindice) {
        NombreIndicadorSubindice = nombreIndicadorSubindice;
    }

    public Long getIdIndicadorIndice() {
        return IdIndicadorIndice;
    }

    public void setIdIndicadorIndice(Long idIndicadorIndice) {
        IdIndicadorIndice = idIndicadorIndice;
    }

    public String getNombreIndicadorIndice() {
        return NombreIndicadorIndice;
    }

    public void setNombreIndicadorIndice(String nombreIndicadorIndice) {
        NombreIndicadorIndice = nombreIndicadorIndice;
    }

    public Long getIdModeloCompone() {
        return IdModeloCompone;
    }

    public void setIdModeloCompone(Long idModeloCompone) {
        IdModeloCompone = idModeloCompone;
    }

    public String getNombreModeloCompone() {
        return NombreModeloCompone;
    }

    public void setNombreModeloCompone(String nombreModeloCompone) {
        NombreModeloCompone = nombreModeloCompone;
    }

    public Long getIdIndicadorSeccion() {
        return IdIndicadorSeccion;
    }

    public void setIdIndicadorSeccion(Long idIndicadorSeccion) {
        IdIndicadorSeccion = idIndicadorSeccion;
    }

    public String getNombreIndicadorSeccion() {
        return NombreIndicadorSeccion;
    }

    public void setNombreIndicadorSeccion(String nombreIndicadorSeccion) {
        NombreIndicadorSeccion = nombreIndicadorSeccion;
    }

    public Long getIdUnidadMedida() {
        return IdUnidadMedida;
    }

    public void setIdUnidadMedida(Long idUnidadMedida) {
        IdUnidadMedida = idUnidadMedida;
    }

    public String getNombreUnidadMedida() {
        return NombreUnidadMedida;
    }

    public void setNombreUnidadMedida(String nombreUnidadMedida) {
        NombreUnidadMedida = nombreUnidadMedida;
    }

    public Long getIdTipoSalidaGeografica() {
        return IdTipoSalidaGeografica;
    }

    public void setIdTipoSalidaGeografica(Long idTipoSalidaGeografica) {
        IdTipoSalidaGeografica = idTipoSalidaGeografica;
    }

    public String getNombreTipoSalidaGeografica() {
        return NombreTipoSalidaGeografica;
    }

    public void setNombreTipoSalidaGeografica(String nombreTipoSalidaGeografica) {
        NombreTipoSalidaGeografica = nombreTipoSalidaGeografica;
    }

    public Long getIdIndicadorTipo() {
        return IdIndicadorTipo;
    }

    public void setIdIndicadorTipo(Long idIndicadorTipo) {
        IdIndicadorTipo = idIndicadorTipo;
    }

    public String getNombreIndicadorTipo() {
        return NombreIndicadorTipo;
    }

    public void setNombreIndicadorTipo(String nombreIndicadorTipo) {
        NombreIndicadorTipo = nombreIndicadorTipo;
    }

    public Long getIdAlcanceInformacion() {
        return IdAlcanceInformacion;
    }

    public void setIdAlcanceInformacion(Long idAlcanceInformacion) {
        IdAlcanceInformacion = idAlcanceInformacion;
    }

    public String getNombreAlcanceInformacion() {
        return NombreAlcanceInformacion;
    }

    public void setNombreAlcanceInformacion(String nombreAlcanceInformacion) {
        NombreAlcanceInformacion = nombreAlcanceInformacion;
    }

    public Long getIdPeriodicidad() {
        return IdPeriodicidad;
    }

    public void setIdPeriodicidad(Long idPeriodicidad) {
        IdPeriodicidad = idPeriodicidad;
    }

    public String getNombrePeriodicidad() {
        return NombrePeriodicidad;
    }

    public void setNombrePeriodicidad(String nombrePeriodicidad) {
        NombrePeriodicidad = nombrePeriodicidad;
    }

    public Long getIdPlanAdaptacion() {
        return IdPlanAdaptacion;
    }

    public void setIdPlanAdaptacion(Long idPlanAdaptacion) {
        IdPlanAdaptacion = idPlanAdaptacion;
    }

    public String getNombrePlanAdaptacion() {
        return NombrePlanAdaptacion;
    }

    public void setNombrePlanAdaptacion(String nombrePlanAdaptacion) {
        NombrePlanAdaptacion = nombrePlanAdaptacion;
    }

    public Long getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(Long idEstado) {
        IdEstado = idEstado;
    }

    public String getNombreEstado() {
        return NombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        NombreEstado = nombreEstado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    public Date getFechaPublicacion() {
        return FechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        FechaPublicacion = fechaPublicacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getArchivoFicha() {
        return ArchivoFicha;
    }

    public void setArchivoFicha(String archivoFicha) {
        ArchivoFicha = archivoFicha;
    }

    public String getUrlFicha() {
        return UrlFicha;
    }

    public void setUrlFicha(String urlFicha) {
        UrlFicha = urlFicha;
    }

    public String getUrlPublicacion() {
        return UrlPublicacion;
    }

    public void setUrlPublicacion(String urlPublicacion) {
        UrlPublicacion = urlPublicacion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public Date getFechaPlazoMeta() {
        return FechaPlazoMeta;
    }

    public void setFechaPlazoMeta(Date fechaPlazoMeta) {
        FechaPlazoMeta = fechaPlazoMeta;
    }

    public String getEtiquetasPublicacion() {
        return EtiquetasPublicacion;
    }

    public void setEtiquetasPublicacion(String etiquetasPublicacion) {
        EtiquetasPublicacion = etiquetasPublicacion;
    }

    public String getCalcularValoresJerarquia() {
        return CalcularValoresJerarquia;
    }

    public void setCalcularValoresJerarquia(String calcularValoresJerarquia) {
        CalcularValoresJerarquia = calcularValoresJerarquia;
    }

    public String getNecesitaValidar() {
        return NecesitaValidar;
    }

    public void setNecesitaValidar(String necesitaValidar) {
        NecesitaValidar = necesitaValidar;
    }

    public String getNecesitaAprobar() {
        return NecesitaAprobar;
    }

    public void setNecesitaAprobar(String necesitaAprobar) {
        NecesitaAprobar = necesitaAprobar;
    }

    public Long getIdFormaAlmacenarInfo() {
        return IdFormaAlmacenarInfo;
    }

    public void setIdFormaAlmacenarInfo(Long idFormaAlmacenarInfo) {
        IdFormaAlmacenarInfo = idFormaAlmacenarInfo;
    }

    public String getNombreFormaAlmacenarInfo() {
        return NombreFormaAlmacenarInfo;
    }

    public void setNombreFormaAlmacenarInfo(String nombreFormaAlmacenarInfo) {
        NombreFormaAlmacenarInfo = nombreFormaAlmacenarInfo;
    }

    public Long getIdDisposicionInfo() {
        return IdDisposicionInfo;
    }

    public void setIdDisposicionInfo(Long idDisposicionInfo) {
        IdDisposicionInfo = idDisposicionInfo;
    }

    public String getNombreDisposicionInfo() {
        return NombreDisposicionInfo;
    }

    public void setNombreDisposicionInfo(String nombreDisposicionInfo) {
        NombreDisposicionInfo = nombreDisposicionInfo;
    }

    public Long getIdFormatoOrigenDatos() {
        return IdFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        IdFormatoOrigenDatos = idFormatoOrigenDatos;
    }

    public String getNombreFormatoOrigenDatos() {
        return NombreFormatoOrigenDatos;
    }

    public void setNombreFormatoOrigenDatos(String nombreFormatoOrigenDatos) {
        NombreFormatoOrigenDatos = nombreFormatoOrigenDatos;
    }

    public String getAlmacenarGeografia() {
        return AlmacenarGeografia;
    }

    public void setAlmacenarGeografia(String almacenarGeografia) {
        AlmacenarGeografia = almacenarGeografia;
    }

    public List<IndicadorCgResponseDTO> getListIndicadorXCapa() {
        return listIndicadorXCapa;
    }

    public void setListIndicadorXCapa(List<IndicadorCgResponseDTO> listIndicadorXCapa) {
        this.listIndicadorXCapa = listIndicadorXCapa;
    }

    public List<IndicadorIndVarResponseDTO> getListIndicadorXVarInd() {
        return listIndicadorXVarInd;
    }

    public void setListIndicadorXVarInd(List<IndicadorIndVarResponseDTO> listIndicadorXVarInd) {
        this.listIndicadorXVarInd = listIndicadorXVarInd;
    }

    public Integer getAsociada() {
        return Asociada;
    }

    public void setAsociada(Integer asociada) {
        Asociada = asociada;
    }
}
