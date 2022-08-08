package com.geotek.siivra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geotek.siivra.dto.response.common.DataResponseDTO;
import com.geotek.siivra.service.ICommonService;

@RestController
@RequestMapping("/common")

public class CommonController {

	
	  @Autowired 
	  private ICommonService iCommonService;
	  
	  @GetMapping("/") public DataResponseDTO getAll() {
	  
	  DataResponseDTO response = new DataResponseDTO();
	  
	  response.setCode(200); 
	  response.setMsg("Listas");
	  response.setData(iCommonService.getCommonData());
	  
	  return response; }
	 

}
