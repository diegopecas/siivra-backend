package com.geotek.siivra.entity.common;

import com.geotek.siivra.entity.Indicador;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "siivrat_indicador_x_capa")
public class IndicadorXCapa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_comp_desagregacion", insertable = false, updatable = false)
    // private CompDesagregacion compDesagregacion;
    @Column(name = "id_comp_desagregacion", nullable = false)
    private Long idCompDesagregacion;

    // @ManyToOne()
    // @JoinColumn(name = "id_indicador", insertable = false, updatable = false)
    // private Indicador indicador;
    @Column(name = "id_indicador", nullable = false)
    private Long idIndicador;

    // @ManyToOne()
    // @JoinColumn(name = "id_capa_geografica", insertable = false, updatable = false)
    // private CapaGeografica capaGeografica;
    @Column(name = "id_capa_geografica", nullable = false)
    private Long idCapaGeografica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCompDesagregacion() {
        return idCompDesagregacion;
    }

    public void setIdCompDesagregacion(Long idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public Long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public Long getIdCapaGeografica() {
        return idCapaGeografica;
    }

    public void setIdCapaGeografica(Long idCapaGeografica) {
        this.idCapaGeografica = idCapaGeografica;
    }

    /*
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setIdCompDesagregacion(Integer idCompDesagregacion) {
        this.idCompDesagregacion = idCompDesagregacion;
    }

    public Indicador getIndicador() {
        return indicador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public Integer getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(Integer idIndicador) {
        this.idIndicador = idIndicador;
    }


    public CapaGeografica getCapaGeografica() {
        return capaGeografica;
    }

    public void setCapaGeografica(CapaGeografica capaGeografica) {
        this.capaGeografica = capaGeografica;
    }

    public Integer getIdCapaGeografica() {
        return idCapaGeografica;
    }

    public void setIdCapaGeografica(Integer idCapaGeografica) {
        this.idCapaGeografica = idCapaGeografica;
    }
*/

}
