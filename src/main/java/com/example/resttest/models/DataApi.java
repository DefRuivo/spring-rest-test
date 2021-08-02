package com.example.resttest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="data")
public class DataApi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade=CascadeType.ALL)
	private List<ResultsApi> results;
	
	public List<ResultsApi> getResults() {
		return results;
	}

	public void setResults(List<ResultsApi> results) {
		this.results = results;
	}

	public DataApi() {
	}

	@Override
	public String toString() {
		return "DataApi [results=" + results + "]";
	}
	
}