package com.ixo.movieinfo.services;

import com.ixo.movieinfo.dto.IxoDocumentsDto;

public interface IxoDocumentsService {

	
	//create new movie
	IxoDocumentsDto createDocuments(IxoDocumentsDto ixoDocumentsDto, Integer userId);
	
	//fetch movie by id
	IxoDocumentsDto getDocument(Long docId);
	
}
