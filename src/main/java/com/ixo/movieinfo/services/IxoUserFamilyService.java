package com.ixo.movieinfo.services;

import com.ixo.movieinfo.dto.IxoUserFamilyDto;

public interface IxoUserFamilyService {

	//create
	IxoUserFamilyDto createUserFamily(IxoUserFamilyDto ixoUserFamilyDto, Integer userId);
	
	//get by id
	IxoUserFamilyDto getUserFamilyById(Integer userFamilyId);
}
