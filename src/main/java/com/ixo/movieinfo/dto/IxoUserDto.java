package com.ixo.movieinfo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IxoUserDto {

	private Integer userId;
	
	@NotEmpty(message = "User Type is Mandatory")
	private String userType; //Movie actor/actress, singer, comedian, or others
	
	@NotEmpty(message = "User Name is Mandatory") 
	@Size(min = 3, max = 30, message = "Name must be between 2 and 30 characters")
	private String name;
	
	@NotNull(message = "User Age is mandatory")
	private Integer age;
	
	@NotNull(message = "User date of birth is mandatory")
	@Past(message = "Date of birth should be some past date")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message = "User Gender is mandatory")
	private String gender;
	private LocalDateTime createdOn;
	
	private IxoUserFamilyDto ixoUserFamily;
	
	private List<IxoUserSocialProfileDto> ixoUserSocialProfile;
}
