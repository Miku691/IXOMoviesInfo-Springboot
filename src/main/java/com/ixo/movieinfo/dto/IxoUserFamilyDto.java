package com.ixo.movieinfo.dto;




import java.time.LocalDate;

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
	private LocalDate marriageDate;
	private String children;
	private String siblings;
	
//	private IxoUserDto ixoUser;
	
}
