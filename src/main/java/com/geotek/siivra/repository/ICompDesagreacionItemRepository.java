package com.geotek.siivra.repository;

import com.geotek.siivra.entity.common.CompDesagregacion;
import com.geotek.siivra.entity.common.CompDesagregacionItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICompDesagreacionItemRepository extends CrudRepository<CompDesagregacionItem,Long> {


}
