package com.isatk.util;

public class EventContent {
	private long workId ;//做题ID
	private long questionId ;

	private int time ;//时长
	private String finalAnswer = "" ; //用户选择的答案，不考虑多选
	private String firstAnswer = "" ; //用户初次选的答案
	private String paperCode = "" ;  //
	private long sectionId;
	
	public EventContent(){
		super();
	}
	public EventContent(long workId){
		this.workId=workId;
	}
	public EventContent(long workId,long questionId){
		this.workId=workId;
		this.questionId=questionId;
	}
	public long getWorkId() {
		return workId;
	}
	public EventContent setWorkId(long workId) {
		this.workId = workId;
		return this;
	}
	public long getQuestionId() {
		return questionId;
	}
	public EventContent setQuestionId(long questionId) {
		this.questionId = questionId;
		return this;
	}

	public int getTime() {
		return time;
	}
	public String getPaperCode() {
		return paperCode;
	}
	public EventContent setPaperCode(String paperCode) {
		this.paperCode = paperCode;
		return this;
	}
	public long getSectionId() {
		return sectionId;
	}
	public EventContent setSectionId(long sectionId) {
		this.sectionId = sectionId;
		return this;
	}
	public EventContent setTime(int time) {
		this.time = time;
		return this;
	}
	public String getFinalAnswer() {
		return finalAnswer;
	}
	public EventContent setFinalAnswer(String finalAnswer) {
		this.finalAnswer = finalAnswer;
		return this;
	}
	public String getFirstAnswer() {
		return firstAnswer;
	}
	public EventContent setFirstAnswer(String firstAnswer) {
		this.firstAnswer = firstAnswer;
		return this;
	}

}
