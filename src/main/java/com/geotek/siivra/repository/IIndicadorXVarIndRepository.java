package com.geotek.siivra.repository;

import com.geotek.siivra.entity.common.IndicadorXVarInd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface IIndicadorXVarIndRepository extends JpaRepository<IndicadorXVarInd, Long>{

    @Modifying
    @Query("select di from IndicadorXVarInd di where di.idIndicador in (?1)")
    List<IndicadorXVarInd> findindicadorXVarInd (Long id);

    @Query("select di from IndicadorXVarInd di where di.idVariableCalculo in (?1)")
    List<IndicadorXVarInd> findindicadorXVarIndByVar (Long id);

    @Query("select di from IndicadorXVarInd di where di.idIndicadorCalculo in (?1)")
    List<IndicadorXVarInd> findindicadorXVarIndByIdIndHijo (Long id);

    @Query("select di from IndicadorXVarInd di where di.idIndicador in (?1)")
    List<IndicadorXVarInd> findindicadorXVarIndByIdIndPadre (Long id);

    @Transactional
    @Modifying
    @Query("delete from IndicadorXVarInd ixv where ixv.idIndicador = :id")
    void deleteByIdIndicador(@Param("id")Long id);

}
