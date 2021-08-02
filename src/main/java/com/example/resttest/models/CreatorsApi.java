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
@Table(name="creators")
public class CreatorsApi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade=CascadeType.ALL)
	private List<AuthorsDataApi> items;

	public List<AuthorsDataApi> getItems() {
		return items;
	}

	public void setItems(List<AuthorsDataApi> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CreatorsApi [items=" + items + "]";
	}
	
	
}
