package com.geotek.siivra.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

@Repository
public class ProcedureInvoker {

    private final EntityManager entityManager;

    @Autowired
    public ProcedureInvoker(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public  void crearProcedimiento(String json, String motivo){
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("siivrat_pr_auditoria");

        storedProcedureQuery.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        // Configuramos el valor de entrada
        storedProcedureQuery.setParameter(1, json);
        if(motivo != null || motivo != ""){
            storedProcedureQuery.setParameter(2, "");
        }else{
            storedProcedureQuery.setParameter(2, motivo);
        }

        // Realizamos la llamada al procedimiento
        storedProcedureQuery.execute();

    }

}
