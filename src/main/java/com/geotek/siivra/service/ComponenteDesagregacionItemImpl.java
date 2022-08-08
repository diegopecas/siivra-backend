package com.geotek.siivra.service;

import com.geotek.siivra.dto.CompDesagregacionItemDTO;
import com.geotek.siivra.entity.common.CompDesagregacion;
import com.geotek.siivra.entity.common.CompDesagregacionItem;
import com.geotek.siivra.repository.ICompDesagreacionItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ComponenteDesagregacionItemImpl implements IComponenteDesagreacionItemService {

    @Autowired
    private ICompDesagreacionItemRepository IComponenteDesagreacionRepository;

    @Override
    public List<CompDesagregacionItemDTO> getAll() {
        List<CompDesagregacionItemDTO> resultado = new ArrayList<>();
        Iterable<CompDesagregacionItem> listaDesagreacion = IComponenteDesagreacionRepository.findAll();
        Iterator it = listaDesagreacion.iterator();
        while (it.hasNext()){
            CompDesagregacionItemDTO compDesagregacionItemDto = new CompDesagregacionItemDTO();
            BeanUtils.copyProperties(it.next(),compDesagregacionItemDto);
            resultado.add(compDesagregacionItemDto);
        }
        return resultado;
    }
}
