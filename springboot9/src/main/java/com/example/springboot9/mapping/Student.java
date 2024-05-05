package com.example.springboot9.mapping;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.criteria.Fetch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Student {
	
	@Id
	private int id;
	private String name;
	private  int age;
	
	// @JsonIgnoreProperties("student")
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student")
	private Pancard pancard;
}
