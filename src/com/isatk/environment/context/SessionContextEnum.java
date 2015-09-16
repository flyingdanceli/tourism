package com.isatk.environment.context;

public enum SessionContextEnum {
	
	userInformation("USER_INF","1","用户信息会话取值key",1),
	qqBindUserInf("USER_INF_FOR_QQBIND","2","用户信息会话取值key",2);
		
	private String key;
	private String value;
	private String text;
	private int numeric;
	
	SessionContextEnum()
	{
		
	}
	
	SessionContextEnum(String k,String v,String t,int n)
	{
		this.key=k;
		this.value=v;
		this.text=t;
		this.numeric=n;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumeric() {
		return numeric;
	}

	public void setNumeric(int numeric) {
		this.numeric = numeric;
	}
	
	

}
