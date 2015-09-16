package com.isatk.controller.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

public interface BasicStandard {
	
	public ModelAndView toListPage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView toAddPage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView toEditPage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView toDetailPage(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView queryListData(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView queryAllListData(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView queryOneData(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView doAddSave(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView doEditSave(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView doRemove(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView doRemoves(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView doValidateForAdd(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
	public ModelAndView doValidateForEdit(HttpServletRequest request,HttpServletResponse response) throws Exception;
	
}
