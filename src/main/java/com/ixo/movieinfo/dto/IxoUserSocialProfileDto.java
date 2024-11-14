package com.ixo.movieinfo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IxoUserSocialProfileDto {
	private Integer id;
	private String socialMedia;
	private String socialMediaUrl;
	private Long followerCount;
//	private IxoUserDto ixoUser;
}
