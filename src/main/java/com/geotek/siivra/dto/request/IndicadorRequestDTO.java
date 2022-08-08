package com.geotek.siivra.dto.request;

import com.geotek.siivra.dto.request.common.AuditoriaRequestDTO;
import com.geotek.siivra.dto.request.common.IndicadorXCapaRequestDTO;
import com.geotek.siivra.dto.request.common.IndicadorXVarIndRequestDTO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class IndicadorRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long Id;
    private Long IdRutina;
    private Long IdCompDesagregacion;
    private Long IdAdaptacionNivel;
    private Long IdDimension;
    private Long IdClasificacionAdap;
    private Long IdIndicadorSubindice;
    private Long IdIndicadorIndice;
    private Long IdModeloCompone;
    private Long IdIndicadorSeccion;
    private Long IdUnidadMedida;
    private Long IdTipoSalidaGeografica;
    private Long IdIndicadorTipo;
    private Long IdAlcanceInformacion;
    private Long IdPeriodicidad;
    private Long IdPlanAdaptacion;
    private Long IdEstado;
    private String Nombre;
    private String Codigo;
    private Date FechaPublicacion;
    private String Descripcion;
    private String ArchivoFicha;
    private String UrlFicha;
    private String UrlPublicacion;
    private String Observaciones;
    private Date FechaPlazoMeta;
    private String EtiquetasPublicacion;
    private String CalcularValoresJerarquia;
    private String NecesitaValidar;
    private String NecesitaAprobar;
    private Long IdFormaAlmacenarInfo;
    private Long IdDisposicionInfo;
    private Long IdFormatoOrigenDatos;
    private String AlmacenarGeografia;
    private List<IndicadorXVarIndRequestDTO> listIndicadorXVarInd;
    private List<IndicadorXCapaRequestDTO> listIndicadorXCapa;

    // private AuditoriaRequestDTO auditoria;
    // private String auditoria;

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

    public Long getIdCompDesagregacion() {
        return IdCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        IdCompDesagregacion = idCompDesagregacion;
    }

    public Long getIdAdaptacionNivel() {
        return IdAdaptacionNivel;
    }

    public void setIdAdaptacionNivel(Long idAdaptacionNivel) {
        IdAdaptacionNivel = idAdaptacionNivel;
    }

    public Long getIdDimension() {
        return IdDimension;
    }

    public void setIdDimension(Long idDimension) {
        IdDimension = idDimension;
    }

    public Long getIdClasificacionAdap() {
        return IdClasificacionAdap;
    }

    public void setIdClasificacionAdap(Long idClasificacionAdap) {
        IdClasificacionAdap = idClasificacionAdap;
    }

    public Long getIdIndicadorSubindice() {
        return IdIndicadorSubindice;
    }

    public void setIdIndicadorSubindice(Long idIndicadorSubindice) {
        IdIndicadorSubindice = idIndicadorSubindice;
    }

    public Long getIdIndicadorIndice() {
        return IdIndicadorIndice;
    }

    public void setIdIndicadorIndice(Long idIndicadorIndice) {
        IdIndicadorIndice = idIndicadorIndice;
    }

    public Long getIdModeloCompone() {
        return IdModeloCompone;
    }

    public void setIdModeloCompone(Long idModeloCompone) {
        IdModeloCompone = idModeloCompone;
    }

    public Long getIdIndicadorSeccion() {
        return IdIndicadorSeccion;
    }

    public void setIdIndicadorSeccion(Long idIndicadorSeccion) {
        IdIndicadorSeccion = idIndicadorSeccion;
    }

    public Long getIdUnidadMedida() {
        return IdUnidadMedida;
    }

    public void setIdUnidadMedida(Long idUnidadMedida) {
        IdUnidadMedida = idUnidadMedida;
    }

    public Long getIdTipoSalidaGeografica() {
        return IdTipoSalidaGeografica;
    }

    public void setIdTipoSalidaGeografica(Long idTipoSalidaGeografica) {
        IdTipoSalidaGeografica = idTipoSalidaGeografica;
    }

    public Long getIdIndicadorTipo() {
        return IdIndicadorTipo;
    }

    public void setIdIndicadorTipo(Long idIndicadorTipo) {
        IdIndicadorTipo = idIndicadorTipo;
    }

    public Long getIdAlcanceInformacion() {
        return IdAlcanceInformacion;
    }

    public void setIdAlcanceInformacion(Long idAlcanceInformacion) {
        IdAlcanceInformacion = idAlcanceInformacion;
    }

    public Long getIdPeriodicidad() {
        return IdPeriodicidad;
    }

    public void setIdPeriodicidad(Long idPeriodicidad) {
        IdPeriodicidad = idPeriodicidad;
    }

    public Long getIdPlanAdaptacion() {
        return IdPlanAdaptacion;
    }

    public void setIdPlanAdaptacion(Long idPlanAdaptacion) {
        IdPlanAdaptacion = idPlanAdaptacion;
    }

    public Long getIdEstado() {
        return IdEstado;
    }

    public void setIdEstado(Long idEstado) {
        IdEstado = idEstado;
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

    public Long getIdDisposicionInfo() {
        return IdDisposicionInfo;
    }

    public void setIdDisposicionInfo(Long idDisposicionInfo) {
        IdDisposicionInfo = idDisposicionInfo;
    }

    public Long getIdFormatoOrigenDatos() {
        return IdFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        IdFormatoOrigenDatos = idFormatoOrigenDatos;
    }

    public String getAlmacenarGeografia() {
        return AlmacenarGeografia;
    }

    public void setAlmacenarGeografia(String almacenarGeografia) {
        AlmacenarGeografia = almacenarGeografia;
    }

    public List<IndicadorXVarIndRequestDTO> getListIndicadorXVarInd() {
        return listIndicadorXVarInd;
    }

    public void setListIndicadorXVarInd(List<IndicadorXVarIndRequestDTO> listIndicadorXVarInd) {
        this.listIndicadorXVarInd = listIndicadorXVarInd;
    }

    public List<IndicadorXCapaRequestDTO> getListIndicadorXCapa() {
        return listIndicadorXCapa;
    }

    public void setListIndicadorXCapa(List<IndicadorXCapaRequestDTO> listIndicadorXCapa) {
        this.listIndicadorXCapa = listIndicadorXCapa;
    }

    /*public AuditoriaRequestDTO getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(AuditoriaRequestDTO auditoria) {
        this.auditoria = auditoria;
    }*/
/*
    public String getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(String auditoria) {
        this.auditoria = auditoria;
    }

 */
}
