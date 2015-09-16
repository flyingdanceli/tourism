package com.isatk.controller.base;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.isatk.ge.adapter.spring.DateEditor;
import com.isatk.ge.adapter.spring.DoubleEditor;
import com.isatk.ge.adapter.spring.FloatEditor;
import com.isatk.ge.adapter.spring.IntegerEditor;
import com.isatk.ge.adapter.spring.LongEditor;
public abstract class BaseController {
	
	Logger logger = Logger.getLogger(BaseController.class);

	public static final String _DATA_KEY = "dataEntity";
	
	public static final String _USER = "user";
	
	/**
	 * 解决日期数字类型表单绑定问题
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(int.class, new CustomNumberEditor(int.class, true));
//		binder.registerCustomEditor(long.class, new CustomNumberEditor(long.class, true));		
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(float.class, new FloatEditor());
	}
	
	
			
}
