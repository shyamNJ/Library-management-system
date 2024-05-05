package com.example.springboot9.mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pancard {
	
	@Id
	private int id;
	private String panNumber;
	
	// @JsonIgnoreProperties("pancard")
	@OneToOne
	private Student student;

}
