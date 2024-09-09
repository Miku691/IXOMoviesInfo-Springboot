package com.ixo.movieinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ixo.movieinfo.dto.IxoUserSocialProfileDto;
import com.ixo.movieinfo.services.IxoUserSocialProfileService;

@RestController
@RequestMapping(path="/api/socialProfile")
public class IxoUserSocialProfileController {

	@Autowired
	IxoUserSocialProfileService socialProfileService;
	
	@PostMapping(path="/user/{userId}")
	public ResponseEntity<IxoUserSocialProfileDto> createSocialProfile(
			@PathVariable("userId") Integer userId,
			@RequestBody IxoUserSocialProfileDto ixosocialProfileDto
			){
		IxoUserSocialProfileDto userProfileDto = this.socialProfileService.createSocialProfile(ixosocialProfileDto, userId);
		return new ResponseEntity<IxoUserSocialProfileDto>(userProfileDto, HttpStatus.CREATED);
	}
}
