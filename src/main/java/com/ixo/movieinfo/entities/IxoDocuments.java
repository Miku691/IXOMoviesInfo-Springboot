package com.ixo.movieinfo.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "IXO_DOCUMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IxoDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long docId;
	private String docUrl;
	private String docName;
	private String status;
	private LocalDate uploadOn;
	private String uploadedName;
	
	@ManyToOne
	@JoinColumn(name="actor_id")
	private IxoUserEntity ixoUser;
}
