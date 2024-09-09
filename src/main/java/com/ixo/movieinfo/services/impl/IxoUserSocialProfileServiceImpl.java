package com.ixo.movieinfo.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ixo.movieinfo.dto.IxoUserSocialProfileDto;
import com.ixo.movieinfo.entities.IxoUserEntity;
import com.ixo.movieinfo.entities.IxoUserSocialProfile;
import com.ixo.movieinfo.exception.ResourceNotFoundException;
import com.ixo.movieinfo.repositories.IxoUserRepo;
import com.ixo.movieinfo.repositories.IxoUserSocialProfileRepo;
import com.ixo.movieinfo.services.IxoUserSocialProfileService;

@Service
public class IxoUserSocialProfileServiceImpl implements IxoUserSocialProfileService {

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	IxoUserSocialProfileRepo userSocialProfileRepo;
	
	@Autowired
	IxoUserRepo ixoUserRepo;
	
	@Override
	public IxoUserSocialProfileDto createSocialProfile(IxoUserSocialProfileDto userSocialProfileDto, Integer userId) {
		IxoUserEntity ixoUserEntity = this.ixoUserRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		
		IxoUserSocialProfile userSocialProfile = this.modelMapper.map(userSocialProfileDto, IxoUserSocialProfile.class);
		userSocialProfile.setIxoUser(ixoUserEntity);
		
		return this.modelMapper.map(this.userSocialProfileRepo.save(userSocialProfile), IxoUserSocialProfileDto.class);
	}

	@Override
	public IxoUserSocialProfileDto getSocialProfileById(Integer socialProfileId) {
		IxoUserSocialProfile ixoUserSocialProfile = this.userSocialProfileRepo.findById(socialProfileId).orElseThrow(() -> new ResourceNotFoundException("SOCIAL PROFILE", "social profile id", socialProfileId));
		return this.modelMapper.map(ixoUserSocialProfile, IxoUserSocialProfileDto.class);
	}

}
