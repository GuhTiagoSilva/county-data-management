package com.stonks.countydatamanagement.entities.views;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CountyView implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String countyName;
	private Long population;
	@Column(name = "link")
	private String websiteLink;
	private String application;
	private Double budgetedValue;
	private Double collectedValue;
	private Instant incomeDate;
	private Integer type;
	
	public CountyView() {
		
	}

	public CountyView(Long id, String countyName, Long population, String websiteLink, String application,
			Double budgetedValue, Double collectedValue, Instant incomeDate, Integer type) {
		super();
		this.id = id;
		this.countyName = countyName;
		this.population = population;
		this.websiteLink = websiteLink;
		this.application = application;
		this.budgetedValue = budgetedValue;
		this.collectedValue = collectedValue;
		this.incomeDate = incomeDate;
		this.type = type;
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

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public Double getBudgetedValue() {
		return budgetedValue;
	}

	public void setBudgetedValue(Double budgetedValue) {
		this.budgetedValue = budgetedValue;
	}

	public Double getCollectedValue() {
		return collectedValue;
	}

	public void setCollectedValue(Double collectedValue) {
		this.collectedValue = collectedValue;
	}

	public Instant getIncomeDate() {
		return incomeDate;
	}

	public void setIncomeDate(Instant incomeDate) {
		this.incomeDate = incomeDate;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
		CountyView other = (CountyView) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
