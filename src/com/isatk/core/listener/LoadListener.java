/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isatk.core.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;

import org.springframework.web.context.ContextLoaderListener;

import com.isatk.core.driver.AppLoadDriver;

/**
 *
 * @author Administrator
 */
public class LoadListener extends ContextLoaderListener{


    public void contextInitialized(ServletContextEvent sce) {
    	super.contextInitialized(sce);
    	try 
    	{
			AppLoadDriver.init(sce.getServletContext());
		} 
    	catch (ServletException e) 
    	{
			
			e.printStackTrace();
		}
    }

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
      
}
