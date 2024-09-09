package com.ixo.movieinfo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ixo.movieinfo.dto.IxoUserFamilyDto;
import com.ixo.movieinfo.entities.IxoUserEntity;
import com.ixo.movieinfo.entities.IxoUserFamilyEntity;
import com.ixo.movieinfo.exception.ResourceNotFoundException;
import com.ixo.movieinfo.repositories.IxoUserFamilyRepo;
import com.ixo.movieinfo.repositories.IxoUserRepo;
import com.ixo.movieinfo.services.IxoUserFamilyService;

@Service
public class IxoUserFamilyServiceImpl implements IxoUserFamilyService {

	@Autowired
	IxoUserFamilyRepo ixoUserFamilyRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	IxoUserRepo ixoUserRepo;
	
	@Override
	public IxoUserFamilyDto createUserFamily(IxoUserFamilyDto ixoUserFamilyDto, Integer userId) {
		IxoUserEntity ixoUser = this.ixoUserRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "userId", userId));
		
		IxoUserFamilyEntity ixoUserFamilyEntity = this.modelMapper.map(ixoUserFamilyDto, IxoUserFamilyEntity.class);
		ixoUserFamilyEntity.setIxoUser(ixoUser);
		
		return this.modelMapper.map(this.ixoUserFamilyRepo.save(ixoUserFamilyEntity), IxoUserFamilyDto.class);
	}

	@Override
	public IxoUserFamilyDto getUserFamilyById(Integer userFamilyId) {
		IxoUserFamilyEntity ixoUserFamilyEntity = this.ixoUserFamilyRepo.findById(userFamilyId).orElseThrow(() -> new ResourceNotFoundException("User Family", "userFamilyId", userFamilyId));
		return this.modelMapper.map(ixoUserFamilyEntity, IxoUserFamilyDto.class);
	}

}
