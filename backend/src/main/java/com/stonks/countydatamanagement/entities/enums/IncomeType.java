package com.stonks.countydatamanagement.entities.enums;

public enum IncomeType {
	TYPE_1(1, "TIPO 1"), TYPE_2(2, "TIPO 2"), TYPE_3(3, "TIPO 3");

	private int code;
	private String description;

	private IncomeType(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static IncomeType toEnum(Integer code) {
		if (code == null)
			return null;
		for (IncomeType type : IncomeType.values()) {
			if (code.equals(type.getCode())) {
				return type;
			}
		}

		throw new IllegalArgumentException("Invalid Id: " + code);
	}

}