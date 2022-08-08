package com.geotek.siivra.controller;


import com.geotek.siivra.dto.CompDesagregacionItemDTO;
import com.geotek.siivra.service.IComponenteDesagreacionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comdesagregacionitem")
public class ComDesagregacionItemController {

    @Autowired
    IComponenteDesagreacionItemService compDesagregacionItemDto;

    @GetMapping
    public List<CompDesagregacionItemDTO> getAll(){
        return compDesagregacionItemDto.getAll();
    }
}
