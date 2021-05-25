package com.stonks.countydatamanagement.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_county")
public class County implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String countyName;
	private Long population;
	private String mayorName;
	
	@OneToOne(mappedBy = "county")
	private WebSite webSite;
	
	@OneToMany (mappedBy = "county")
	private List<Income> income = new ArrayList<>();
	
	@OneToMany(mappedBy = "county")
	private List<Expense> expenses = new ArrayList<>();
	
	public County() {
		
	}

	public County(Long id, String countyName, Long population, String mayorName) {
		super();
		this.id = id;
		this.countyName = countyName;
		this.population = population;
		this.mayorName = mayorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String name) {
		this.countyName = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getMayorName() {
		return mayorName;
	}

	public void setMayorName(String mayorName) {
		this.mayorName = mayorName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		County other = (County) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
