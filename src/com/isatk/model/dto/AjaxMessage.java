package com.isatk.model.dto;

public class AjaxMessage {
	private String code;
	private String text;
	private Long id;
	
	public AjaxMessage(){
		this.code = "200";
		this.text = "操作完成";
	}
	public AjaxMessage(Long id){
		this.code = "200";
		this.text = "操作完成";
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
