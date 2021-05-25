package com.stonks.countydatamanagement.dto;

import java.io.Serializable;
import java.time.Instant;

import com.stonks.countydatamanagement.entities.Income;

public class IncomeDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private Double budgetedValue;
	private Double collectedValue;
	private Instant incomeDate;
	private String font;
	private String application;
	private Integer type;
	
	public IncomeDTO() {
		
	}

	public IncomeDTO(Long id, String description, Double budgetedValue, Double collectedValue, Instant incomeDate,
			String font, String application, Integer type) {
		super();
		this.id = id;
		this.description = description;
		this.budgetedValue = budgetedValue;
		this.collectedValue = collectedValue;
		this.incomeDate = incomeDate;
		this.font = font;
		this.application = application;
		this.type = type;
	}
	
	public IncomeDTO(Income entity) {
		id = entity.getId();
		description = entity.getDescription();
		budgetedValue = entity.getBudgetedValue();
		collectedValue = entity.getCollectedValue();
		incomeDate = entity.getIncomeDate();
		font = entity.getFont();
		application = entity.getApplication();
		type = entity.getType().getCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
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
		IncomeDTO other = (IncomeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
