package com.ixo.movieinfo.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Integer userId;
	private String userType; //Movie actor/actress, singer, comedian, or others
	private String name;
	private Integer age;
	private LocalDate dateOfBirth;
	private String gender;
	private LocalDateTime createdOn;
	
	@OneToOne(mappedBy = "ixoUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private IxoUserFamilyEntity ixoUserFamily;
	
	@OneToMany(mappedBy = "ixoUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<IxoUserSocialProfile> ixoUserSocialProfile;
}
