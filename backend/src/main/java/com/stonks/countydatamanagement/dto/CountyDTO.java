package com.stonks.countydatamanagement.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.stonks.countydatamanagement.entities.County;

public class CountyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String countyName;
	private Long population;
	private String mayorName;
	private Long webSiteId;
	private List<IncomeDTO> incomes = new ArrayList<>();
	private List<ExpenseDTO> expenses = new ArrayList<>();

	public CountyDTO() {

	}

	public CountyDTO(Long id, String countyName, Long population, String mayorName, Long webSiteId) {
		super();
		this.id = id;
		this.countyName = countyName;
		this.population = population;
		this.mayorName = mayorName;
		this.webSiteId = webSiteId;
	}
	
	public CountyDTO(County entity) {
		id = entity.getId();
		countyName = entity.getCountyName();
		population = entity.getPopulation();
		mayorName = entity.getMayorName();
		webSiteId = entity.getWebSite().getId();
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

	public Long getWebSiteId() {
		return webSiteId;
	}

	public void setWebSiteId(Long webSiteId) {
		this.webSiteId = webSiteId;
	}

	public List<IncomeDTO> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<IncomeDTO> incomes) {
		this.incomes = incomes;
	}

	public List<ExpenseDTO> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<ExpenseDTO> expenses) {
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
		CountyDTO other = (CountyDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
