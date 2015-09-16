package com.isatk.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.isatk.ge.context.cache.ProfilesManagerEngine;
import com.isatk.landcenter.client.web.interceptor.process.TokenProcess;

public class WebInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object o) throws Exception {
		response.setHeader("P3P","CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
    	response.addHeader("Access-Control-Allow-Origin","*");//跨域限制设置 * 表示允许所有跨域
    	if("LOCAL".equalsIgnoreCase(ProfilesManagerEngine.getTxt("AUTHEN_METHOD")))
    	{
    		return this.preHandleLocal(request, response, o);
    	}
    	String tid=request.getParameter("tid");
    	if(tid==null)
    	{
    		tid=request.getHeader("tid");
    	}
    	if(tid==null)
    	{
    		tid=(String)request.getSession().getAttribute("tid");
    	}
    	TokenProcess tp=TokenProcess.createInstance();
    	if(tp.defaultResponse(request, response)==1)
    	{
    		return false;
    	}
        return true;
	}
	
	
	private boolean preHandleLocal(HttpServletRequest request, HttpServletResponse response,Object arg2) throws Exception {
		response.setHeader("P3P","CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
    	response.addHeader("Access-Control-Allow-Origin","*");//跨域限制设置 * 表示允许所有跨域
    	
    	String tid=request.getParameter("tid");
    	if(tid==null)
    	{
    		tid=request.getHeader("tid");
    	}
    	if(tid==null)
    	{
    		tid=(String)request.getSession().getAttribute("tid");
    	}
//    	if(tid==null)
//    	{
//    		Cookie[] cks=request.getCookies();
//    		for(Cookie tmp:cks)
//    		{
//    			if(tmp.getName().equals("tid"))
//    			{
//    				tid=tmp.getValue();
//    			}
//    		}
//    	}
    	
    	
        return true;
	}

}
