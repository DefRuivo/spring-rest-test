package com.example.resttest.models;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.ListIterator;

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
	private LocalDate date;

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
		discount(isbn, prices);
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
	
	private boolean isbnCheck(String isbn) {
		if (isbn.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}	
	
	private boolean checkIsbnAgainstDOTW(String isbn) {
		if (DayOfTheWeek(date, getIsbnLastDigit(isbn))) {
			return true;
		} else {
			return false;
		}
	}
	
	private char getIsbnLastDigit(String isbn) {
		char[] charArray = isbn.toCharArray();
		char lastDigit = charArray[-1];
		return lastDigit;
	}
	
	
	private boolean DayOfTheWeek(LocalDate date, char lastDigit) {
		DayOfWeek day = date.getDayOfWeek();
		char dayOfTheWeek = (char) day.getValue();
		switch (dayOfTheWeek) {
			case 1:
				if (lastDigit == 0 | lastDigit == 1) {
					return true;
				}
			case 2:
				if (lastDigit == 2 | lastDigit == 3) {
					return true;
				}
			case 3:
				if (lastDigit == 4 | lastDigit == 5) {
					return true;
				}
			case 4:
				if (lastDigit == 6 | lastDigit == 7) {
					return true;
				}
			case 5:
				if (lastDigit == 8 | lastDigit == 9) {
					return true;
				}
		}
		return false;
	}
	
	
	private void discount(String isbn, List<PricesDataApi> OldPrices) {
		BigDecimal percentualDiscount = new BigDecimal("0.9");
		if (isbnCheck(isbn) && checkIsbnAgainstDOTW(isbn)) {
			for (int i = 0; i < OldPrices.size(); i++) {
				PricesDataApi pricesDataApi = OldPrices.get(i);
				BigDecimal value = pricesDataApi.getPrice();
				BigDecimal newValue = value.multiply(percentualDiscount);
				pricesDataApi.setPrice(newValue);
				}
		}
	}
}
