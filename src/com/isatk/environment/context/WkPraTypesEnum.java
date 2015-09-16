package com.isatk.environment.context;

public enum WkPraTypesEnum {
	
	exActualCombat("EX_AC","21","真题练习",21),exCustomChoose("EX_CHOOSE","23","自选练习",23),exAthena("EX_ATHENA","","智能练习",22);
	
	private String key;
	private String value;
	private String text;
	private int numeric;
	
	WkPraTypesEnum()
	{
		
	}
	
	WkPraTypesEnum(String k,String v,String t,int n)
	{
		this.key=k;
		this.value=v;
		this.text=t;
		this.numeric=n;
	}

	public String getKey() {
		return key;
	}

	public WkPraTypesEnum setKey(String key) {
		this.key = key;
		return this;
	}

	public String getValue() {
		return value;
	}

	public WkPraTypesEnum setValue(String value) {
		this.value = value;
		return this;
	}

	public String getText() {
		return text;
	}

	public WkPraTypesEnum setText(String text) {
		this.text = text;
		return this;
	}

	public int getNumeric() {
		return numeric;
	}

	public WkPraTypesEnum setNumeric(int numeric) {
		this.numeric = numeric;
		return this;
	}
	

}
