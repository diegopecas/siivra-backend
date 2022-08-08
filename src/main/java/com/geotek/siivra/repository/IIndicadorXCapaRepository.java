package com.geotek.siivra.repository;

import com.geotek.siivra.entity.common.IndicadorXCapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IIndicadorXCapaRepository extends JpaRepository<IndicadorXCapa,  Integer> {

    @Modifying
    @Query("select di from IndicadorXCapa di where di.idIndicador in (?1)")
    List<IndicadorXCapa> findIndicadorXCapa (Long id);

    @Transactional
    @Modifying
    @Query("delete from IndicadorXCapa ixc where ixc.idIndicador = :id")
    void deleteByIdIndicador(@Param("id")Long id);
}
