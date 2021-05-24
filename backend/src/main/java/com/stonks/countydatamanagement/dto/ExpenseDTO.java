package com.stonks.countydatamanagement.dto;

import java.io.Serializable;
import java.time.Instant;

public class ExpenseDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private boolean isCommitted;
	private boolean isFinished;
	private boolean isPayed;
	private String creditorName;
	private Instant expenseDate;
	private String smash;
	private String subSmash;
	private Double hiredValue;
	private Double budgetedValue;
	private Integer type;
	
	public ExpenseDTO() {
		
	}

	public ExpenseDTO(Long id, boolean isCommitted, boolean isFinished, boolean isPayed, String creditorName,
			Instant expenseDate, String smash, String subSmash, Double hiredValue, Double budgetedValue, Integer type) {
		super();
		this.id = id;
		this.isCommitted = isCommitted;
		this.isFinished = isFinished;
		this.isPayed = isPayed;
		this.creditorName = creditorName;
		this.expenseDate = expenseDate;
		this.smash = smash;
		this.subSmash = subSmash;
		this.hiredValue = hiredValue;
		this.budgetedValue = budgetedValue;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCommitted() {
		return isCommitted;
	}

	public void setCommitted(boolean isCommitted) {
		this.isCommitted = isCommitted;
	}

	public boolean isFinished() {
		return isFinished;
	}

	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	public boolean isPayed() {
		return isPayed;
	}

	public void setPayed(boolean isPayed) {
		this.isPayed = isPayed;
	}

	public String getCreditorName() {
		return creditorName;
	}

	public void setCreditorName(String creditorName) {
		this.creditorName = creditorName;
	}

	public Instant getExpenseDate() {
		return expenseDate;
	}

	public void setExpenseDate(Instant expenseDate) {
		this.expenseDate = expenseDate;
	}

	public String getSmash() {
		return smash;
	}

	public void setSmash(String smash) {
		this.smash = smash;
	}

	public String getSubSmash() {
		return subSmash;
	}

	public void setSubSmash(String subSmash) {
		this.subSmash = subSmash;
	}

	public Double getHiredValue() {
		return hiredValue;
	}

	public void setHiredValue(Double hiredValue) {
		this.hiredValue = hiredValue;
	}

	public Double getBudgetedValue() {
		return budgetedValue;
	}

	public void setBudgetedValue(Double budgetedValue) {
		this.budgetedValue = budgetedValue;
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
		ExpenseDTO other = (ExpenseDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
