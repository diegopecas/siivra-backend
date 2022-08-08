package com.geotek.siivra.entity;
import javax.persistence.*;

@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(

                name = "registrar_auditoria",
                procedureName = "siivra_conf.siivrat_pr_auditoria",
                parameters = {
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="registrar", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="justificar", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="tabla", type=String.class),
                        @StoredProcedureParameter(mode=ParameterMode.IN, name="clave", type=Long.class),

                })
})
public class Auditoria {

    public Auditoria() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String registrar;

    @Column
    private String justificar;

    @Column
    private String tabla;



    @Column
    private Long clave;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar;
    }

    public String getJustificar() {
        return justificar;
    }

    public void setJustificar(String justificar) {
        this.justificar = justificar;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }


    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }




}
