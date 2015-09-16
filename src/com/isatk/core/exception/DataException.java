package com.isatk.core.exception;

public class DataException extends RuntimeException {
	
	private Throwable root = null;
	
	private String errorCode="";
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public DataException()
	{
	}
	
	public DataException(String message)
	{
		super(message);
	}
	
	public DataException(String message,Throwable root)
	{
		super(message);
		this.root = root;
	}
	
	public DataException(String message,String errCode,Throwable root)
	{
		super(message);
		errorCode=errCode;
		this.root = root;
	}
}
