package com.ixo.movieinfo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ixo.movieinfo.dto.IxoUserDto;
import com.ixo.movieinfo.services.IxoUserService;
import com.ixo.movieinfo.utility.ApiResponse;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path = "/api/user")
public class IxoUserController {

	@Autowired
	IxoUserService ixoUserService;
	
	@PostMapping
	public ResponseEntity<IxoUserDto> createUser(@Valid @RequestBody IxoUserDto ixoUserDto){
		IxoUserDto ixoUserDtoSaved = this.ixoUserService.createUser(ixoUserDto);
		return new ResponseEntity<IxoUserDto>(ixoUserDtoSaved, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/{userId}")
	public ResponseEntity<IxoUserDto> getUserById(@PathVariable("userId") Integer userId){
		IxoUserDto ixoUserDto = this.ixoUserService.getUserById(userId);
		return new ResponseEntity<IxoUserDto>(ixoUserDto, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<IxoUserDto>> getUsers(){
		return new ResponseEntity<List<IxoUserDto>>(this.ixoUserService.getUsers(), HttpStatus.OK);
	}
	
	@GetMapping(path = "/name/{userName}")
	public ResponseEntity<IxoUserDto> getUserByName(@PathVariable("userName") String userName){
		return new ResponseEntity<IxoUserDto>(this.ixoUserService.getUserByName(userName), HttpStatus.OK);
	}
	
	@PutMapping(path = "/{userId}")
	public ResponseEntity<IxoUserDto> updateUserDetails(
			@PathVariable("userId") Integer userId,
			@RequestBody IxoUserDto ixoUserDto
			){
		return new ResponseEntity<IxoUserDto>(this.ixoUserService.updateUserDetails(ixoUserDto, userId), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
		this.ixoUserService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
	//pagination - getPosts
	@GetMapping(path = "/pagination")
	public ResponseEntity<List<IxoUserDto>> getUserByPaginatiioin(
			@RequestParam(value = "pageNumber", defaultValue="10", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "0", required = false) Integer pageSize
			){
		List<IxoUserDto> allPaginationUsers = this.ixoUserService.getUsersWithPagination(pageNumber, pageSize);
		return new ResponseEntity<List<IxoUserDto>>(allPaginationUsers, HttpStatus.OK);
	}
	
}
