package com.ixo.movieinfo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IxoDocumentsDto {

	private Long id;
	private Long docId;
	private String docUrl;
	private String docName;
	private String status;
	private LocalDate uploadOn;
	private String uploadedName;
	
}
