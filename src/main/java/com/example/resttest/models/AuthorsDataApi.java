package com.example.resttest.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="authors")
public class AuthorsDataApi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthorsDataApi() {
	}

	@Override
	public String toString() {
		return "AuthorsDataApi [name=" + name + "]";
	}
	
	
	
}
