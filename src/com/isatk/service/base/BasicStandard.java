package com.isatk.service.base;

import com.isatk.core.exception.SysException;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.model.dto.BasClientele;


public interface BasicStandard<T,P> {
		
	public T findOneRecord(String dbid) throws SysException;
	
	public T findOneRecord(Long dbid) throws SysException;
	
	public T findOneRecord(T dto) throws SysException;
	
	public PageBean<T,P> findListData(PageBean<T,P> page) throws SysException;
	
	public void deleteOneRecord(T dto) throws SysException;
	
	public void deleteOneRecord(String dbid) throws SysException;
	
	public void deleteOneRecord(Long dbid) throws SysException;
	
	public void addOneRecord(T dto) throws SysException;
	
	public void updateOneRecord(T dto) throws SysException;
	
	public Long findMaxID() throws SysException;


	
}
