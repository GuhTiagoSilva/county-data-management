package com.stonks.countydatamanagement.entities.enums;

public enum ExpenseType {

	TYPE_1(1, "TIPO_1"), 
	TYPE_2(2, "TIPO_2");
	
	private Integer code; 
	private String description;
	
	private ExpenseType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static ExpenseType toEnum(Integer code) {
		if (code == null)
			return null;
		
		for(ExpenseType type : ExpenseType.values()) {
			if(type.getCode().equals(code)) {
				return type;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id: " + code);
	}
}
