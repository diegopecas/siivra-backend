package com.geotek.siivra.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geotek.siivra.dto.CommonDTO;
import com.geotek.siivra.entity.common.CommonLists;
import com.geotek.siivra.repository.ICommonRepository;

@Service
public class ICommonServiceImpl implements ICommonService {

    @Autowired
    private ICommonRepository iCommonRepository;
    
    @Override
    public List<CommonDTO> getCommonData() {

        List<CommonDTO> resultado = new ArrayList<>();
        Iterable<CommonLists> listaCommons
                = iCommonRepository.findAll();
        Iterator it = listaCommons.iterator();
        while(it.hasNext()) {
            CommonDTO commonDTO = new CommonDTO();
            BeanUtils.copyProperties(it.next(), commonDTO);
            if(commonDTO.getId() != 0){
                resultado.add(commonDTO);
            }
        }

        return resultado;

    }
	
	
}
