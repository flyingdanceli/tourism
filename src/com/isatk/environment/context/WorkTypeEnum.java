package com.isatk.environment.context;

public enum WorkTypeEnum {
	
	exEveryDay("EX_EVERYDAY","25","每日一练",25),
	exErrorCorrection("EX_ERROR","24","错题练习",24),
	exCustomChoose("EX_CHOOSE","23","自选练习",23),
	exAthena("EX_ATHENA","22","智能练习",22),
	exActualCombat("EX_AC","21","真题练习",21);
	
	private String key;
	private String value;
	private String text;
	private int numeric;
	
	WorkTypeEnum()
	{
		
	}
	
	WorkTypeEnum(String k,String v,String t,int n)
	{
		this.key=k;
		this.value=v;
		this.text=t;
		this.numeric=n;
	}

	public String getKey() {
		return key;
	}

	public WorkTypeEnum setKey(String key) {
		this.key = key;
		return this;
	}

	public String getValue() {
		return value;
	}

	public WorkTypeEnum setValue(String value) {
		this.value = value;
		return this;
	}

	public String getText() {
		return text;
	}

	public WorkTypeEnum setText(String text) {
		this.text = text;
		return this;
	}

	public int getNumeric() {
		return numeric;
	}

	public WorkTypeEnum setNumeric(int numeric) {
		this.numeric = numeric;
		return this;
	}
	
	

}
