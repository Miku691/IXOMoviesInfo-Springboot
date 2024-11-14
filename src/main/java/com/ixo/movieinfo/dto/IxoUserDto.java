package com.ixo.movieinfo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ixo.movieinfo.entities.IxoDocuments;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IxoUserDto {

//	private Integer userId;
//	
//	@NotEmpty(message = "User Type is Mandatory")
//	private String userType; //Movie actor/actress, singer, comedian, or others
//	
//	@NotEmpty(message = "User Name is Mandatory") 
//	@Size(min = 3, max = 30, message = "Name must be between 2 and 30 characters")
//	private String name;
//	
//	@NotNull(message = "User Age is mandatory")
//	private Integer age;
//	
//	@NotNull(message = "User date of birth is mandatory")
//	@Past(message = "Date of birth should be some past date")
//	private LocalDate dateOfBirth;
//	
//	@NotEmpty(message = "User Gender is mandatory")
//	private String gender;
//	private LocalDateTime createdOn;
	
	private Integer Id;
	private String type; //Movie actor/actress, singer, comedian, or others
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	@JsonProperty("death")
	private boolean death;
	private LocalDate dateOfDeath;
	private String gender;
	private int age;
	private String birthPlace;
	private String state;
	private String country;
	private String actorPoster;
	private LocalDateTime createdOn;
	
	private IxoUserFamilyDto ixoUserFamily;
	
	private List<IxoUserSocialProfileDto> ixoUserSocialProfile;
	
	private Set<IxoMoviesDto> ixoMovies;
	
	private List<IxoDocuments> ixoDocuments;
	
	 @JsonProperty("death")
	    public boolean getDeath() {
	        return death;
	    }
}
