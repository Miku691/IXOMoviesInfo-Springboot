package com.ixo.movieinfo.services;

import java.util.List;

import com.ixo.movieinfo.dto.IxoUserDto;

public interface IxoUserService {
	
	//create user
	IxoUserDto createUser(IxoUserDto ixoUserDto);
	
	//get all user
	IxoUserDto getUserById(Integer userId);
	
	//get all users
	List<IxoUserDto> getUsers();
	
	//get user by name
	IxoUserDto getUserByName(String userName);
	
	//update user
	IxoUserDto updateUserDetails(IxoUserDto ixoUserDto, Integer userId);
	
	//delete user
	void deleteUser(Integer userId);
	
	//get users with pagination
	List<IxoUserDto> getUsersWithPagination(Integer pageNumber, Integer pageSize);
}
