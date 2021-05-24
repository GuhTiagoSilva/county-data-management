package com.stonks.countydatamanagement.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stonks.countydatamanagement.entities.enums.IncomeType;

@Entity
@Table(name = "tb_income")
public class Income implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private Double budgetedValue;
	private Double collectedValue;
	private Instant incomeDate;
	private String font;
	private String application;
	private Integer type;

	@ManyToOne
	@JoinColumn(name = "county_id")
	private County county;

	public Income() {

	}

	public Income(Long id, String description, Double budgetedValue, Double collectedValue, Instant incomeDate,
			String font, String application, County county, IncomeType type) {
		super();
		this.id = id;
		this.description = description;
		this.budgetedValue = budgetedValue;
		this.collectedValue = collectedValue;
		this.incomeDate = incomeDate;
		this.font = font;
		this.application = application;
		this.county = county;
		this.type = type == null ? null : type.getCode();
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

	public County getCounty() {
		return county;
	}

	public void setCounty(County county) {
		this.county = county;
	}

	public IncomeType getType() {
		return IncomeType.toEnum(this.type);
	}

	public void setType(IncomeType type) {
		this.type = type.getCode();
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
		Income other = (Income) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
