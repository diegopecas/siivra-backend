package com.geotek.siivra.repository;

import com.geotek.siivra.entity.Auditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigInteger;

@Repository
public interface AuditoriaRepository extends JpaRepository<Auditoria,Long> {

    @Procedure(name = "registrar_auditoria")
    void procedureName(@Param("registrar") String registrar, @Param("justificar") String justificar, @Param("tabla") String tabla, @Param("clave") Long clave);

}


