package com.isatk.core.driver;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

public class SpringUtil implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext paramApplicationContext)
			throws BeansException {
		applicationContext = paramApplicationContext;
	}
	
	public static Object getObject(String id) {
		Object object = null;
		object = applicationContext.getBean(id);
		return object;
	}
	
	/**
	 * 改变国际化的语言
	 * CookieLocaleResolver cr=(CookieLocaleResolver)SpringUtil.getObject("localeResolver");
		cr.setDefaultLocale(new Locale("en"));
		会话国际化
		request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,new Locale("en")); 
		
		jsp
		<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>  
		<spring:message code="test"/>
	 */

}
