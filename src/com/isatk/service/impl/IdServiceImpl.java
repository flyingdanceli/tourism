package com.isatk.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.isatk.model.dao.FaInvoiceMapper;
@Component
public class IdServiceImpl  {
	@Autowired
	private FaInvoiceMapper faInvoiceMapper;
	
	private DateFormat df = new SimpleDateFormat("yyyyMMdd");
	private static Integer order = null;
	
	public int getOrder(){
		if(order == null){
			//去数据库查询最大的订单号
			Integer i = faInvoiceMapper.selectMaxId();
			if(i == null){
				order = 100000000;
			}else{
				order = i;
			}
		}
		String d = df.format(new Date());
		if(!String.valueOf(order).substring(0, 5).equals(d)){
			order = Integer.valueOf(d) * 10000;
		}
		return ++order;
	}
	
	
}
