package com.ixo.movieinfo.dto;



import com.ixo.movieinfo.entities.IxoUserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IxoUserFamilyDto {
	private Integer id;
	private String fatherName;
	private String motherName;
	private boolean maritalStatus;
	private String spouseName;
	
//	private IxoUserDto ixoUser;
	
}
