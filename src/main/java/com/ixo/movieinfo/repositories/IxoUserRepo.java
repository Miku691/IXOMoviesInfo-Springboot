package com.ixo.movieinfo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ixo.movieinfo.entities.IxoUserEntity;

public interface IxoUserRepo extends JpaRepository<IxoUserEntity, Integer>{

	//custom finder method
	IxoUserEntity findByName(String name);
	
	
}
