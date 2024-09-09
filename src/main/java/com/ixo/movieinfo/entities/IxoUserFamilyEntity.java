package com.ixo.movieinfo.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IXO_USER_FAMILY")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class IxoUserFamilyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fatherName;
	private String motherName;
	private boolean maritalStatus;
	private String spouseName;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private IxoUserEntity ixoUser;
}
