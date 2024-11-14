package com.ixo.movieinfo.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IXO_USER")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IxoUserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String type; //Movie actor/actress, singer, comedian, or others
	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private boolean death;
	private LocalDate dateOfDeath;
	private String gender;
	private int age;
	private String birthPlace;
	private String state;
	private String country;
	private String actorPoster;
	private LocalDateTime createdOn;
	
	@OneToOne(mappedBy = "ixoUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private IxoUserFamilyEntity ixoUserFamily;
	
	@OneToMany(mappedBy = "ixoUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<IxoUserSocialProfile> ixoUserSocialProfile;
	
	@ManyToMany(mappedBy = "ixoUser")
	private Set<IxoMovies> ixoMovies = new HashSet<>();
	
	@OneToMany(mappedBy = "ixoUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<IxoDocuments> ixoDocuments;
			
}
