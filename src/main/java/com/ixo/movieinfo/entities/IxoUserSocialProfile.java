package com.ixo.movieinfo.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="IXO_USER_SOCIAL_PROFILE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IxoUserSocialProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String socialMedia;
	private String socialMediaUrl;
	private Long followerCount;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private IxoUserEntity ixoUser;
}
