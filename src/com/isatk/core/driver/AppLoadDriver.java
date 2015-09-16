package com.isatk.core.driver;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.log4j.Logger;

/**
 * @author Treasar
 *
 */
public class AppLoadDriver {

	private static final long serialVersionUID = 6791997528213344495L;

	private static Logger log = Logger.getLogger(AppLoadDriver.class);

	private static boolean isSucess = true;

	public static void init(ServletContext ctx) throws ServletException {
		System.out
				.println("###################         服务器启动加载项                  ###################");
		putRequestBaseUrl(ctx);
	}

	/**
	 * 加载应用路径到servlet 的 application上下文中，用于页面获取基础应用路径
	 * 
	 * @param ctx
	 */
	private static void putRequestBaseUrl(ServletContext ctx) {
		/*
		 * String b="/"+ctx.getServletContextName().trim(); //读取web.xml 文件 根节点下
		 * display-name 节点数据 String b=ctx.getContextPath().trim(); String
		 * b=ctx.getContextPath(); //应用根和路径 websphere
		 * 6.1的servlet版本不支持getContextPath() ctx.setAttribute("appPath", b);
		 * System.out.println("应用的相对Url根：["+b+"]");
		 */
		try {
			String b = ctx.getServletContextName();
			if (b != null && !"".equals(b)) {
				b = "/" + b;
			}
			ctx.setAttribute("appPath", b);
			ctx.setAttribute("abp", b);// application base path
			System.out.println("应用的相对Url根：[ " + b + " ]");
			isSucess = true;
		} catch (Exception e) {
			log.info("加载应用初始URL失败");
			isSucess = false;
		}
	}
}
