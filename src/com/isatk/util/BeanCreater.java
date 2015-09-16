package com.isatk.util;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class BeanCreater {
	
	private static ApplicationContext ctx;
	

	/**
	 * web应用启动时初始化spring Bean上下文
	 * 要求：需要在web.xml中配置spring 监听器
	 * @param servletContext
	 * @throws Exception
	 */
	public static void initApplicationContext(ServletContext servletContext) throws Exception 
	{
			ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
	}

	
	public static Object getBean(String beanname) 
	{
		return ctx.getBean(beanname);
	}

	/**
	 * 用指定的类路径下配置文件集初始化spring Bean上下文
	 * @param xmlConfig
	 * @throws Exception
	 */
	public static void initApplicationContext(String[] xmlConfig) throws Exception 
	{
		ctx = new ClassPathXmlApplicationContext(xmlConfig);		
	}
	

	public static ApplicationContext getApplicationContext() 
	{
		return ctx;
	}

	public static void setApplicationContext(ApplicationContext appCtx) 
	{
		ctx=appCtx;
	}
}
