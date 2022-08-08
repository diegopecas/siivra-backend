package com.geotek.siivra.dto.response.common;

import java.io.Serializable;

public class CompDesagregacionResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idComponenteDesagregaPadre;
    private Long idEstado;
    private Long idDatoMaestro;
    private String nombre;
    private Long idCapaGeografica;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdComponenteDesagregaPadre() {
        return idComponenteDesagregaPadre;
    }

    public void setIdComponenteDesagregaPadre(Long idComponenteDesagregaPadre) {
        this.idComponenteDesagregaPadre = idComponenteDesagregaPadre;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public Long getIdDatoMaestro() {
        return idDatoMaestro;
    }

    public void setIdDatoMaestro(Long idDatoMaestro) {
        this.idDatoMaestro = idDatoMaestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getIdCapaGeografica() {
        return idCapaGeografica;
    }

    public void setIdCapaGeografica(Long idCapaGeografica) {
        this.idCapaGeografica = idCapaGeografica;
    }

}
