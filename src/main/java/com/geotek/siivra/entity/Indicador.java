package com.geotek.siivra.entity;

import com.fasterxml.jackson.annotation.JsonFormat;;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_indicador")
public class Indicador implements Serializable {

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

    // @ManyToOne()
    // @JoinColumn(name = "id_comp_desagregacion", insertable = false, updatable = false)
    // private CompDesagregacion compDesagregacion;
    @Column(name = "id_comp_desagregacion")
    private Long idCompDesagregacion;

    // @ManyToOne()
    // @JoinColumn(name = "id_adaptacion_nivel", insertable = false, updatable = false)
    // private AdaptacionNivel adaptacionNivel;
    @Column(name = "id_adaptacion_nivel")
    private Long idAdaptacionNivel;

    // @ManyToOne()
    // @JoinColumn(name = "id_dimension", insertable = false, updatable = false)
    // private Dimension dimension;
    @Column(name = "id_dimension")
    private Long idDimension;

    // @ManyToOne()
    // @JoinColumn(name = "id_clasificacion_adap", insertable = false, updatable = false)
    // private ClasificacionAdap clasificacionAdap;
    @Column(name = "id_clasificacion_adap")
    private Long idClasificacionAdap;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador_subindice", insertable = false, updatable = false)
    // private IndicadorSubindice indicadorSubindice;
    @Column(name = "id_indicador_subindice")
    private Long idIndicadorSubindice;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador_indice", insertable = false, updatable = false)
    // private IndicadorIndice indicadorIndice;
    @Column(name = "id_indicador_indice")
    private Long idIndicadorIndice;

    // @ManyToOne()
    // @JoinColumn(name = "id_modelo_compone", insertable = false, updatable = false)
    // private ModeloComponente modeloComponente;
    @Column(name = "id_modelo_compone")
    private Long idModeloCompone;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador_seccion", insertable = false, updatable = false)
    // private IndicadorSeccion indicadorSeccion;
    @Column(name = "id_indicador_seccion")
    private Long idIndicadorSeccion;

    // @ManyToOne()
    // @JoinColumn(name = "id_unidad_medida", insertable = false, updatable = false)
    // private UnidadMedida unidadMedida;
    @Column(name = "id_unidad_medida")
    private Long idUnidadMedida;

    // @ManyToOne()
    // @JoinColumn(name = "id_tipo_salida_geografica", insertable = false, updatable = false)
    // private TipoSalidaGeografica tipoSalidaGeografica;
    @Column(name = "id_tipo_salida_geografica")
    private Long idTipoSalidaGeografica;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador_tipo", insertable = false, updatable = false)
    // private IndicadorTipo indicadorTipo;
    @Column(name = "id_indicador_tipo")
    private Long idIndicadorTipo;

    // @ManyToOne()
    // @JoinColumn(name = "id_alcance_informacion", insertable = false, updatable = false)
    // private AlcanceInformacion alcanceInformacion;
    @Column(name = "id_alcance_informacion")
    private Long idAlcanceInformacion;

    // @ManyToOne()
    // @JoinColumn(name = "id_periodicidad", insertable = false, updatable = false)
    // private Periodicidad periodicidad;
    @Column(name = "id_periodicidad")
    private Long idPeriodicidad;

    // @ManyToOne()
    // @JoinColumn(name = "id_plan_adaptacion", insertable = false, updatable = false)
    // private PlanAdaptacion planAdaptacion;
    @Column(name = "id_plan_adaptacion")
    private Long idPlanAdaptacion;

    // @ManyToOne()
    // @JoinColumn(name = "id_estado", insertable = false, updatable = false)
    // private Estado estado;
    @Column(name = "id_estado")
    private Long idEstado;

    @Column(name = "nombre", length = 500)
    private String nombre;

    @Column(name = "codigo", length = 30 )
    private String codigo;

    @Column(name = "fecha_publicacion")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaPublicacion;

    @Column(name = "descripcion", length = 4000)
    private String descripcion;

    @Column(name = "archivo_ficha")
    private String archivoFicha;

    @Column(name = "url_ficha", length =1000)
    private String urlFicha;

    @Column(name = "url_publicacion", length =1000)
    private String urlPublicacion;

    @Column(name = "observaciones", length = 4000)
    private String observaciones;

    @Column(name = "fecha_plazo_meta")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaPlazoMeta;

    @Column(name = "etiquetas_publicacion", length = 2000)
    private String etiquetasPublicacion;

    @Column(name = "calcular_valores_jerarquia", length = 1)
    private String calcularValoresJerarquia;

    @Column(name = "necesita_validar", length = 2000)
    private String necesitaValidar;

    @Column(name = "necesita_aprobar", length = 2000)
    private String necesitaAprobar;

    // @ManyToOne()
    // @JoinColumn(name = "id_forma_almacenar_info", insertable = false, updatable = false)
    // private FormaAlmacenarInfo formaAlmacenarInfo;
    @Column(name = "id_forma_almacenar_info")
    private Long idFormaAlmacenarInfo;

    // @ManyToOne()
    // @JoinColumn(name = "id_disposicion_info", insertable = false, updatable = false)
    // private DisposicionInfo disposicionInfo;
    @Column(name = "id_disposicion_info")
    private Long idDisposicionInfo;

    // @ManyToOne()
    // @JoinColumn(name = "id_formato_origen_datos", insertable = false, updatable = false)
    // private FormatoOrigenDatos formatoOrigenDatos;
    @Column(name = "id_formato_origen_datos")
    private Long idFormatoOrigenDatos;

    @Column(name = "almacenar_geografia", length = 1)
    private String almacenarGeografia;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public Long getIdAdaptacionNivel() {
        return idAdaptacionNivel;
    }

    public void setIdAdaptacionNivel(Long idAdaptacionNivel) {
        this.idAdaptacionNivel = idAdaptacionNivel;
    }

    public Long getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(Long idDimension) {
        this.idDimension = idDimension;
    }

    public Long getIdClasificacionAdap() {
        return idClasificacionAdap;
    }

    public void setIdClasificacionAdap(Long idClasificacionAdap) {
        this.idClasificacionAdap = idClasificacionAdap;
    }

    public Long getIdIndicadorSubindice() {
        return idIndicadorSubindice;
    }

    public void setIdIndicadorSubindice(Long idIndicadorSubindice) {
        this.idIndicadorSubindice = idIndicadorSubindice;
    }

    public Long getIdIndicadorIndice() {
        return idIndicadorIndice;
    }

    public void setIdIndicadorIndice(Long idIndicadorIndice) {
        this.idIndicadorIndice = idIndicadorIndice;
    }

    public Long getIdModeloCompone() {
        return idModeloCompone;
    }

    public void setIdModeloCompone(Long idModeloCompone) {
        this.idModeloCompone = idModeloCompone;
    }

    public Long getIdIndicadorSeccion() {
        return idIndicadorSeccion;
    }

    public void setIdIndicadorSeccion(Long idIndicadorSeccion) {
        this.idIndicadorSeccion = idIndicadorSeccion;
    }

    public Long getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Long idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public Long getIdTipoSalidaGeografica() {
        return idTipoSalidaGeografica;
    }

    public void setIdTipoSalidaGeografica(Long idTipoSalidaGeografica) {
        this.idTipoSalidaGeografica = idTipoSalidaGeografica;
    }

    public Long getIdIndicadorTipo() {
        return idIndicadorTipo;
    }

    public void setIdIndicadorTipo(Long idIndicadorTipo) {
        this.idIndicadorTipo = idIndicadorTipo;
    }

    public Long getIdAlcanceInformacion() {
        return idAlcanceInformacion;
    }

    public void setIdAlcanceInformacion(Long idAlcanceInformacion) {
        this.idAlcanceInformacion = idAlcanceInformacion;
    }

    public Long getIdPeriodicidad() {
        return idPeriodicidad;
    }

    public void setIdPeriodicidad(Long idPeriodicidad) {
        this.idPeriodicidad = idPeriodicidad;
    }

    public Long getIdPlanAdaptacion() {
        return idPlanAdaptacion;
    }

    public void setIdPlanAdaptacion(Long idPlanAdaptacion) {
        this.idPlanAdaptacion = idPlanAdaptacion;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getUrlPublicacion() {
        return urlPublicacion;
    }

    public void setUrlPublicacion(String urlPublicacion) {
        this.urlPublicacion = urlPublicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaPlazoMeta() {
        return fechaPlazoMeta;
    }

    public void setFechaPlazoMeta(Date fechaPlazoMeta) {
        this.fechaPlazoMeta = fechaPlazoMeta;
    }

    public String getEtiquetasPublicacion() {
        return etiquetasPublicacion;
    }

    public void setEtiquetasPublicacion(String etiquetasPublicacion) {
        this.etiquetasPublicacion = etiquetasPublicacion;
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

    public Long getIdFormaAlmacenarInfo() {
        return idFormaAlmacenarInfo;
    }

    public void setIdFormaAlmacenarInfo(Long idFormaAlmacenarInfo) {
        this.idFormaAlmacenarInfo = idFormaAlmacenarInfo;
    }

    public Long getIdDisposicionInfo() {
        return idDisposicionInfo;
    }

    public void setIdDisposicionInfo(Long idDisposicionInfo) {
        this.idDisposicionInfo = idDisposicionInfo;
    }

    public Long getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
    }

    public String getAlmacenarGeografia() {
        return almacenarGeografia;
    }

    public void setAlmacenarGeografia(String almacenarGeografia) {
        this.almacenarGeografia = almacenarGeografia;
    }

    /*
    public Integer getId() {
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

    public Integer getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(Long idRutina) {
        this.idRutina = idRutina;
    }

    public CompDesagregacion getCompDesagregacion() {
        return compDesagregacion;
    }

    public void setCompDesagregacion(CompDesagregacion compDesagregacion) {
        this.compDesagregacion = compDesagregacion;
    }

    public Integer getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public AdaptacionNivel getAdaptacionNivel() {
        return adaptacionNivel;
    }

    public void setAdaptacionNivel(AdaptacionNivel adaptacionNivel) {
        this.adaptacionNivel = adaptacionNivel;
    }

    public Integer getIdAdaptacionNivel() {
        return idAdaptacionNivel;
    }

    public void setIdAdaptacionNivel(Long idAdaptacionNivel) {
        this.idAdaptacionNivel = idAdaptacionNivel;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Integer getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(Long idDimension) {
        this.idDimension = idDimension;
    }

    public ClasificacionAdap getClasificacionAdap() {
        return clasificacionAdap;
    }

    public void setClasificacionAdap(ClasificacionAdap clasificacionAdap) {
        this.clasificacionAdap = clasificacionAdap;
    }

    public Integer getIdClasificacionAdap() {
        return idClasificacionAdap;
    }

    public void setIdClasificacionAdap(Long idClasificacionAdap) {
        this.idClasificacionAdap = idClasificacionAdap;
    }

    public IndicadorSubindice getIndicadorSubindice() {
        return indicadorSubindice;
    }

    public void setIndicadorSubindice(IndicadorSubindice indicadorSubindice) {
        this.indicadorSubindice = indicadorSubindice;
    }

    public Integer getIdIndicadorSubindice() {
        return idIndicadorSubindice;
    }

    public void setIdIndicadorSubindice(Long idIndicadorSubindice) {
        this.idIndicadorSubindice = idIndicadorSubindice;
    }

    public IndicadorIndice getIndicadorIndice() {
        return indicadorIndice;
    }

    public void setIndicadorIndice(IndicadorIndice indicadorIndice) {
        this.indicadorIndice = indicadorIndice;
    }

    public Integer getIdIndicadorIndice() {
        return idIndicadorIndice;
    }

    public void setIdIndicadorIndice(Long idIndicadorIndice) {
        this.idIndicadorIndice = idIndicadorIndice;
    }

    public ModeloComponente getModeloComponente() {
        return modeloComponente;
    }

    public void setModeloComponente(ModeloComponente modeloComponente) {
        this.modeloComponente = modeloComponente;
    }

    public Integer getIdModeloCompone() {
        return idModeloCompone;
    }

    public void setIdModeloCompone(Long idModeloCompone) {
        this.idModeloCompone = idModeloCompone;
    }

    public IndicadorSeccion getIndicadorSeccion() {
        return indicadorSeccion;
    }

    public void setIndicadorSeccion(IndicadorSeccion indicadorSeccion) {
        this.indicadorSeccion = indicadorSeccion;
    }

    public Integer getIdIndicadorSeccion() {
        return idIndicadorSeccion;
    }

    public void setIdIndicadorSeccion(Long idIndicadorSeccion) {
        this.idIndicadorSeccion = idIndicadorSeccion;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(Long idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
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

    public void setIdTipoSalidaGeografica(Long idTipoSalidaGeografica) {
        this.idTipoSalidaGeografica = idTipoSalidaGeografica;
    }

    public IndicadorTipo getIndicadorTipo() {
        return indicadorTipo;
    }

    public void setIndicadorTipo(IndicadorTipo indicadorTipo) {
        this.indicadorTipo = indicadorTipo;
    }

    public Integer getIdIndicadorTipo() {
        return idIndicadorTipo;
    }

    public void setIdIndicadorTipo(Long idIndicadorTipo) {
        this.idIndicadorTipo = idIndicadorTipo;
    }

    public AlcanceInformacion getAlcanceInformacion() {
        return alcanceInformacion;
    }

    public void setAlcanceInformacion(AlcanceInformacion alcanceInformacion) {
        this.alcanceInformacion = alcanceInformacion;
    }

    public Integer getIdAlcanceInformacion() {
        return idAlcanceInformacion;
    }

    public void setIdAlcanceInformacion(Long idAlcanceInformacion) {
        this.idAlcanceInformacion = idAlcanceInformacion;
    }

    public Periodicidad getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(Periodicidad periodicidad) {
        this.periodicidad = periodicidad;
    }

    public Integer getIdPeriodicidad() {
        return idPeriodicidad;
    }

    public void setIdPeriodicidad(Long idPeriodicidad) {
        this.idPeriodicidad = idPeriodicidad;
    }

    public PlanAdaptacion getPlanAdaptacion() {
        return planAdaptacion;
    }

    public void setPlanAdaptacion(PlanAdaptacion planAdaptacion) {
        this.planAdaptacion = planAdaptacion;
    }

    public Integer getIdPlanAdaptacion() {
        return idPlanAdaptacion;
    }

    public void setIdPlanAdaptacion(Long idPlanAdaptacion) {
        this.idPlanAdaptacion = idPlanAdaptacion;
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

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public String getUrlPublicacion() {
        return urlPublicacion;
    }

    public void setUrlPublicacion(String urlPublicacion) {
        this.urlPublicacion = urlPublicacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaPlazoMeta() {
        return fechaPlazoMeta;
    }

    public void setFechaPlazoMeta(Date fechaPlazoMeta) {
        this.fechaPlazoMeta = fechaPlazoMeta;
    }

    public String getEtiquetasPublicacion() {
        return etiquetasPublicacion;
    }

    public void setEtiquetasPublicacion(String etiquetasPublicacion) {
        this.etiquetasPublicacion = etiquetasPublicacion;
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

    public FormaAlmacenarInfo getFormaAlmacenarInfo() {
        return formaAlmacenarInfo;
    }

    public void setFormaAlmacenarInfo(FormaAlmacenarInfo formaAlmacenarInfo) {
        this.formaAlmacenarInfo = formaAlmacenarInfo;
    }

    public Integer getIdFormaAlmacenarInfo() {
        return idFormaAlmacenarInfo;
    }

    public void setIdFormaAlmacenarInfo(Long idFormaAlmacenarInfo) {
        this.idFormaAlmacenarInfo = idFormaAlmacenarInfo;
    }

    public DisposicionInfo getDisposicionInfo() {
        return disposicionInfo;
    }

    public void setDisposicionInfo(DisposicionInfo disposicionInfo) {
        this.disposicionInfo = disposicionInfo;
    }

    public Integer getIdDisposicionInfo() {
        return idDisposicionInfo;
    }

    public void setIdDisposicionInfo(Long idDisposicionInfo) {
        this.idDisposicionInfo = idDisposicionInfo;
    }

    public FormatoOrigenDatos getFormatoOrigenDatos() {
        return formatoOrigenDatos;
    }

    public void setFormatoOrigenDatos(FormatoOrigenDatos formatoOrigenDatos) {
        this.formatoOrigenDatos = formatoOrigenDatos;
    }

    public Integer getIdFormatoOrigenDatos() {
        return idFormatoOrigenDatos;
    }

    public void setIdFormatoOrigenDatos(Long idFormatoOrigenDatos) {
        this.idFormatoOrigenDatos = idFormatoOrigenDatos;
    }*/
}
