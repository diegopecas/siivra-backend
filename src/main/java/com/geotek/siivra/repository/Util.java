package com.geotek.siivra.repository;

import com.geotek.siivra.entity.Variable;
import com.geotek.siivra.service.IVariableService;
import org.springframework.beans.factory.annotation.Autowired;

public class Util {

    @Autowired
    private IVariableRepository iVariableRepository;

    String validarTipoEstado(Long idVariable){
        Variable variable = iVariableRepository.findOne(idVariable);
        String tipoEstado = null;

        if (variable.getNecesitaValidar().equals("1") &&  variable.getNecesitaAprobar().equals("1")){
            tipoEstado = "1";
        }else if (variable.getNecesitaValidar().equals("0") &&  variable.getNecesitaAprobar().equals("0")){
            tipoEstado = "4";
        }else if (variable.getNecesitaValidar().equals("1") &&  variable.getNecesitaAprobar().equals("0")){
            tipoEstado = "1";
        }else if(variable.getNecesitaValidar().equals("0") &&  variable.getNecesitaAprobar().equals("1")){
            tipoEstado = "3";
        }
        return tipoEstado;
    }

}
