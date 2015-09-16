package com.isatk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isatk.core.exception.SysException;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.model.dao.BankNameMapper;
import com.isatk.model.dto.BankName;
import com.isatk.model.dto.BankNameExample;
import com.isatk.service.base.BankNameService;
@Component
public class BankNameServiceImpl implements BankNameService {
	@Autowired
	private BankNameMapper bankNameMapper;
	@Override
	public BankName findOneRecord(String dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankName findOneRecord(Long dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankName findOneRecord(BankName dto) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<BankName, BankName> findListData(
			PageBean<BankName, BankName> page) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOneRecord(BankName dto) throws SysException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOneRecord(String dbid) throws SysException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOneRecord(Long dbid) throws SysException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOneRecord(BankName dto) throws SysException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOneRecord(BankName dto) throws SysException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long findMaxID() throws SysException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BankName> findList(BankName dto){
		if(dto==null){
			BankNameExample example = new BankNameExample();
			return bankNameMapper.selectByExample(example);
		}
		return null;
	}

}
