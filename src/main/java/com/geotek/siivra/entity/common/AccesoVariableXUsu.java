package com.geotek.siivra.entity.common;

import com.geotek.siivra.entity.Variable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "siivrat_acceso_variable_x_usu")
public class AccesoVariableXUsu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    // @ManyToOne()
    // @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    // private Usuario idusuario;
    @Column(name = "id_usuario")
    private Long idUsuario;

    // @ManyToOne()
    // @JoinColumn(name = "id_variable", insertable = false, updatable = false)
    // private Variable idvariable;
    @Column(name = "id_variable")
    private Long idVariable;

    @Column(name = "acceso_negado")
    private String accesoNegado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdVariable() {
        return idVariable;
    }

    public void setIdVariable(Long idVariable) {
        this.idVariable = idVariable;
    }

    public String getAccesoNegado() {
        return accesoNegado;
    }

    public void setAccesoNegado(String accesoNegado) {
        this.accesoNegado = accesoNegado;
    }

    /*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAccesoNegado() {
        return accesoNegado;
    }

    public void setAccesoNegado(String accesoNegado) {
        this.accesoNegado = accesoNegado;
    }

 */
}
