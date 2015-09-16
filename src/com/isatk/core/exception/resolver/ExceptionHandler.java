package com.isatk.core.exception.resolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

import com.isatk.core.exception.SysException;

public class ExceptionHandler extends HandlerExceptionResolverComposite {
	
	@Override  
    public ModelAndView resolveException(HttpServletRequest request,  
            HttpServletResponse response, Object handler, Exception ex) {  
        // TODO Auto-generated method stub  
        if (ex instanceof NumberFormatException) 
        {  
            //doSomething...  
            return new ModelAndView("number");  
        } 
        else if (ex instanceof NullPointerException) 
        {  
            //doSomething...  
            return new ModelAndView("null");  
        }  
        else if(ex instanceof SysException)
    	{
    		((SysException)ex).writeLog();
    		
    	}
        else
        {
        	
        }
        return new ModelAndView("exception");  
    }  

}
