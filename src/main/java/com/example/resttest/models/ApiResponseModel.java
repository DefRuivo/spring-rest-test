package com.example.resttest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="COMICS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(cascade=CascadeType.ALL)
	private DataApi data;
	@ManyToMany
	@Column(nullable = true)
	private List<UserModel> users;

	public DataApi getData() {
		return data;
	}
	
	public void setData(DataApi data) {
		this.data = data;
	}
	
	public Long getId() {
		return id;
	}

	public ApiResponseModel() {}

	@Override
	public String toString() {
		return "ApiResponseModel [id=" + id + ", data=" + data + "]";
	}
	
}
