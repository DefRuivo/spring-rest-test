package com.example.resttest.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="results")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsApi {
	
	@Id
	@JsonProperty("id")
	private Long comic_id;
	private String title;
	@OneToMany(cascade=CascadeType.ALL)
	private List<PricesDataApi> prices;
	@OneToOne(cascade=CascadeType.ALL)
	private CreatorsApi creators;
	private String isbn;
	@Size(max = 5000)
	private String description;

	public Long getComic_id() {
		return comic_id;
	}

	public void setComic_id(Long comic_id) {
		this.comic_id = comic_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<PricesDataApi> getPrices() {
//		for (int i = 0; i < this.prices.size(); i++) {
//			
//		}
		return prices;
	}

	public void setPrices(List<PricesDataApi> prices) {
		this.prices = prices;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public CreatorsApi getCreators() {
		return creators;
	}

	public void setCreators(CreatorsApi creators) {
		this.creators = creators;
	}

	public ResultsApi() {
	}

	@Override
	public String toString() {
		return "ResultsApi [comic_id=" + comic_id + ", title=" + title + ", prices=" + prices + ", creators=" + creators
				+ ", isbn=" + isbn + ", description=" + description + "]";
	}
	
	
	
	
}
