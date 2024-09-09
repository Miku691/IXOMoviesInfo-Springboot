package com.ixo.movieinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ixo.movieinfo.dto.IxoUserFamilyDto;
import com.ixo.movieinfo.services.IxoUserFamilyService;

@RestController
@RequestMapping(path = "/api/userFamily")
public class IxoUserFamilyController {
	
	@Autowired
	private IxoUserFamilyService ixoUserFamilyService;
	
	@PostMapping(path = "/userId/{id}")
	public ResponseEntity<IxoUserFamilyDto> createUserFamily(
			@RequestBody IxoUserFamilyDto ixoUserFamilyDto,
			@PathVariable("id") Integer id
			){
		
		IxoUserFamilyDto ixoUserFamilyDtoSaved = this.ixoUserFamilyService.createUserFamily(ixoUserFamilyDto, id);
		
		return new ResponseEntity<IxoUserFamilyDto>(ixoUserFamilyDtoSaved, HttpStatus.CREATED);
	}
	
	@GetMapping(path="/{userFamilyId}")
	public ResponseEntity<IxoUserFamilyDto> getUserFamilyById(@PathVariable("userFamilyId") Integer userFamilyId){
		IxoUserFamilyDto ixoUserFamilyDto = this.ixoUserFamilyService.getUserFamilyById(userFamilyId);
		return new ResponseEntity<IxoUserFamilyDto>(ixoUserFamilyDto, HttpStatus.OK);
	}
	
}
