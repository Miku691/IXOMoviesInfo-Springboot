package com.ixo.movieinfo.services;

import com.ixo.movieinfo.dto.IxoUserSocialProfileDto;

public interface IxoUserSocialProfileService {
	
	//create social profile
	IxoUserSocialProfileDto createSocialProfile(IxoUserSocialProfileDto userSocialProfileDto, Integer userId);
	
	//get social profile by id
	IxoUserSocialProfileDto getSocialProfileById(Integer socialProfileId);
}
