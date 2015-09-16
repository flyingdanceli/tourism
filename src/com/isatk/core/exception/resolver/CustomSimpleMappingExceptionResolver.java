package com.isatk.core.exception.resolver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isatk.core.exception.SysException;
import com.isatk.ge.context.cache.MessageManagerEngine;
import com.isatk.ge.context.ce.HttpResponseStatusEnum;
import com.isatk.ge.model.bean.MessageBox;
import com.isatk.ge.utils.GEUtils;
import com.isatk.ge.utils.JsonConverter;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver{
	
	private static Logger log = Logger.getLogger(CustomSimpleMappingExceptionResolver.class);
	
	private String lastErrorView;

	public String getLastErrorView() {
		return lastErrorView;
	}

	public void setLastErrorView(String lastErrorView) {
		this.lastErrorView = lastErrorView;
	}

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,HttpServletResponse response, Object handler, Exception ex) 
	{
		ex.printStackTrace();
		String viewName=null;
		SysException se=null;		
		if(ex instanceof SysException)
		{
			se=(SysException)ex;
			viewName = determineViewName(se, request);
		}
		else if(ex instanceof NullPointerException)
		{
			viewName = determineViewName(ex, request);
		}
		else
		{
			viewName = determineViewName(ex, request);
		}

		writeExceptionLog(ex);
		if(GEUtils.hasJsonRequest(request)) 
		{// JSON格式返回
			try 
			{
				String msgCode=readDone(ex);//写日志
				ObjectMapper jm = JsonConverter.getMapper();		
				PrintWriter writer = response.getWriter();			
				MessageBox done=new MessageBox();
				String txt="";
				try
				{
					txt= MessageManagerEngine.getTxt(msgCode == null ? "04-1000-2001" : msgCode);
				}
				catch(Exception e)
				{
					txt=MessageManagerEngine.getTxt("04-1000-2001");
				}
				done.setTxt(txt);
				done.setStatus(HttpResponseStatusEnum.s700.getNumeric());
				response.setStatus(HttpResponseStatusEnum.s700.getNumeric());	
				done.setCode(msgCode);
				done.setFlag(0);
				//response.sendError(paramInt, paramString);会跳转到web.xml中配置的错误页面。
				response.setStatus(HttpResponseStatusEnum.s700.getNumeric());
				jm.writeValue(writer,done);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			return null;				
		} 
		else //如果是非json请求
		{   	
			//是否异步请求
			if(GEUtils.hasAsynRequest(request))
			{//如果是异步请求，且是非json请求
				try 
				{	
					response.setStatus(HttpResponseStatusEnum.s700.getNumeric());
					response.getWriter().write("");					
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				return null;
			}
			else//如果是同步非json请求
			{
				if (viewName != null) 
				{
					// 如果不是异步请求
					// Apply HTTP status code for error views, if specified.
					// Only apply it if we're processing a top-level request.
					Integer statusCode = determineStatusCode(request, viewName);
					if (statusCode != null) 
					{
						applyStatusCodeIfPossible(request, response, statusCode);
					}		
					return getModelAndView(viewName, ex, request);
				}
				else 
				{
					return new ModelAndView(this.lastErrorView);
				}
			}			
		} 	
	}
	
	private void writeExceptionLog(Exception e)
	{
		if(e instanceof SysException)
    	{
			SysException se=((SysException)e);	
			se.writeLog();		
    	}
		else
		{
			log.error(e);
		}
	}
	
	private String readDone(Exception e)
	{
		if(e instanceof SysException)
    	{
			SysException se=((SysException)e);	
			return se.getCode();
    	}
		return null;
	}
}
