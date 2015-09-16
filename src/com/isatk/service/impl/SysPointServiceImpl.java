package com.isatk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isatk.core.exception.SysException;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.model.dao.SysPointMapper;
import com.isatk.model.dto.SysPoint;
import com.isatk.model.dto.SysPointExample;
import com.isatk.model.dto.SysPointExample.Criteria;
import com.isatk.service.base.SysPointService;
@Component
public class SysPointServiceImpl implements SysPointService {
	@Autowired
	private SysPointMapper sysPointMapper;
	@Override
	public SysPoint findOneRecord(String dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysPoint findOneRecord(Long dbid) throws SysException {
		// TODO Auto-generated method stub
		return sysPointMapper.selectByPrimaryKey(dbid);
	}

	@Override
	public SysPoint findOneRecord(SysPoint dto) throws SysException {
		// TODO Auto-generated method stub
		return findOneRecord(dto.getId());
	}

	@Override
	public PageBean<SysPoint, SysPoint> findListData(
			PageBean<SysPoint, SysPoint> page) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOneRecord(SysPoint dto) throws SysException {
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
	public void addOneRecord(SysPoint dto) throws SysException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOneRecord(SysPoint dto) throws SysException {
		// TODO Auto-generated method stub

	}

	@Override
	public Long findMaxID() throws SysException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<SysPoint> findList(Integer isFa, Integer isSo)throws SysException {
		SysPointExample example = new SysPointExample();
		Criteria c = example.createCriteria();
		if(isFa!=null){
			c.andIsFaEqualTo(isFa);
		}
		if(isSo!=null){
			c.andIsSoEqualTo(isSo);
		}
		return sysPointMapper.selectByExample(example);
	}

}
