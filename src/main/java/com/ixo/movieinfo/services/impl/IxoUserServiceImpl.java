package com.ixo.movieinfo.services.impl;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ixo.movieinfo.dto.IxoUserDto;
import com.ixo.movieinfo.entities.IxoUserEntity;
import com.ixo.movieinfo.exception.ResourceNotFoundException;
import com.ixo.movieinfo.repositories.IxoUserRepo;
import com.ixo.movieinfo.services.IxoUserService;

@Service
public class IxoUserServiceImpl implements IxoUserService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	IxoUserRepo ixoUserRepo;
	
	@Override
	public IxoUserDto createUser(IxoUserDto ixoUserDto) {
		IxoUserEntity ixoUserEntity = this.modelMapper.map(ixoUserDto, IxoUserEntity.class);
		LocalDateTime userCreatedOn = LocalDateTime.now();
		ixoUserEntity.setCreatedOn(userCreatedOn);
		
		IxoUserEntity savedUserEntity = this.ixoUserRepo.save(ixoUserEntity);
		return this.modelMapper.map(savedUserEntity, IxoUserDto.class);
	}

	@Override
	public IxoUserDto getUserById(Integer userId) {
		IxoUserEntity ixoUserEntity = this.ixoUserRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		IxoUserDto ixoUserDto = this.modelMapper.map(ixoUserEntity, IxoUserDto.class);
		return ixoUserDto;
	}

	@Override
	public List<IxoUserDto> getUsers() {
		List<IxoUserEntity> ixoUserEntities = this.ixoUserRepo.findAll();
		List<IxoUserDto> ixoUserDtos = ixoUserEntities.stream().map(ixoUserEntity -> this.modelMapper.map(ixoUserEntity, IxoUserDto.class)).collect(Collectors.toList());
		return ixoUserDtos;
	}

	@Override
	public IxoUserDto getUserByName(String userName) {
		IxoUserEntity ixoUserEntity = this.ixoUserRepo.findByName(userName);
		return this.modelMapper.map(ixoUserEntity, IxoUserDto.class);
	}

	@Override
	public IxoUserDto updateUserDetails(IxoUserDto ixoUserDto, Integer userId) {
		IxoUserEntity ixoUserEntity = this.ixoUserRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		ixoUserEntity.setAge(ixoUserDto.getAge());
		ixoUserEntity.setDateOfBirth(ixoUserDto.getDateOfBirth());
		ixoUserEntity.setGender(ixoUserDto.getGender());
		ixoUserEntity.setName(ixoUserDto.getName());
		ixoUserEntity.setUserType(ixoUserDto.getUserType());
		
		IxoUserEntity savedIxoUserEntity = this.ixoUserRepo.save(ixoUserEntity);
		return this.modelMapper.map(savedIxoUserEntity, IxoUserDto.class);
	}

	@Override
	public void deleteUser(Integer userId) {
		IxoUserEntity ixoUserEntity = this.ixoUserRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		this.ixoUserRepo.delete(ixoUserEntity);
	}

	@Override
	public List<IxoUserDto> getUsersWithPagination(Integer pageNumber, Integer pageSize) {
		//creating a pageable object
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<IxoUserEntity> pageUsers = this.ixoUserRepo.findAll(p);
		List<IxoUserEntity> allUsers = pageUsers.getContent();
		
		List<IxoUserDto> allUsersDto = allUsers.stream().map(user -> this.modelMapper.map(user, IxoUserDto.class)).collect(Collectors.toList());
		
		return allUsersDto;
	}

}
