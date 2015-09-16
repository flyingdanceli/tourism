package com.isatk.core.exception;

import java.util.Calendar;

import org.apache.log4j.Logger;

import com.isatk.ge.context.cache.MessageManagerEngine;


public class BizException extends Exception {
	
	private Logger log;
	
	
	private String code;
	
	private String message;
	
	private String title;
	
	private String txt;
	
	private boolean flag=false;
	
	private int status=0;

	public BizException(String code,String message,String title) {
		super(title);
		this.code = code;
		this.message = message;
		this.title = title;	
		justWrite();
	}

	public BizException(String code) {
		super(code);
		this.code = code;
		this.message = code;
		this.title = code;
		justWrite();
	}
	
	public BizException() {
		
	}

	public BizException(String code,String message) {
		super(message);
		this.code = code;
		this.message = message;
		this.title = message;
		justWrite();
	}


	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}
	
	public void putLog(Logger log)
	{
		this.setLog(log);
		this.setTxt(MessageManagerEngine.getMessageTxt(this.getCode()));
	}
	
	public void putLog(Class c)
	{
		this.setLog(Logger.getLogger(c));
		this.setTxt(MessageManagerEngine.getMessageTxt(this.getCode()));
	}
	
	public void putLog(String txt)
	{
		this.setTxt(txt);
	}
	
	public void putLog(Logger log,String txt)
	{
		this.setLog(log);
		this.setTxt(txt);
	}
	
	public void putLog(Class c,String txt)
	{
		this.setLog(Logger.getLogger(c));
		this.setTxt(txt);
	}
	
	public String writeLog()
	{
		if(log==null)
		{
			log=Logger.getLogger(this.getClass());
		}
		log.error("[time:"+Calendar.getInstance().getTime().toString()+"][code:"+code+"][txt:"+txt+"]");
		return  txt;
	}
	
	private void justWrite()
	{
		if(this.getTxt()==null)
		{
			String t=null;
			try
			{
				t=MessageManagerEngine.getMessageTxt(this.getCode());
			}
			catch(NullPointerException e)
			{
				t=this.getCode();
			}
		}
		writeLog();
	}
	
}
