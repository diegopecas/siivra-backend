package com.geotek.siivra.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.geotek.siivra.entity.common.CommonLists;

@Repository
public interface ICommonRepository extends CrudRepository<CommonLists, Long> {
	
}
