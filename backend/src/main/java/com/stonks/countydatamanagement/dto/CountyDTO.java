package com.stonks.countydatamanagement.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CountyDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Long population;
	private String mayorName;
	private WebSiteDTO webSite;
	private List<IncomeDTO> incomes = new ArrayList<>();
	private List<ExpenseDTO> expenses = new ArrayList<>();

	public CountyDTO() {

	}

	public CountyDTO(Long id, String name, Long population, String mayorName, WebSiteDTO webSite,
			List<IncomeDTO> incomes, List<ExpenseDTO> expenses) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
		this.mayorName = mayorName;
		this.webSite = webSite;
		this.incomes = incomes;
		this.expenses = expenses;
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

	public WebSiteDTO getWebSite() {
		return webSite;
	}

	public void setWebSite(WebSiteDTO webSite) {
		this.webSite = webSite;
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
