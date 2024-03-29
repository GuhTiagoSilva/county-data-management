package com.stonks.countydatamanagement.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@Column(name = "name")
	private String name;
	private Long population;
	private String mayorName;
	
	@OneToOne
	@JoinColumn(name ="website_id")
	private Website webSite;
	
	@OneToMany (mappedBy = "county")
	private List<Income> incomes = new ArrayList<>();
	
	@OneToMany(mappedBy = "county")
	private List<Expense> expenses = new ArrayList<>();
	
	public County() {
		
	}

	public County(Long id, String name, Long population, String mayorName) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.mayorName = mayorName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public Website getWebSite() {
		return webSite;
	}
	
	public void setWebSite(Website webSite) {
		this.webSite = webSite;
	}
	
	public List<Income> getIncomes() {
		return incomes;
	}
	
	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}
	
	public List<Expense> getExpenses() {
		return expenses;
	}
	
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
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
