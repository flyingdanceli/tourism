package com.isatk.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isatk.core.exception.SysException;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.ge.utils.code.SNPool;
import com.isatk.model.dao.CarMapper;
import com.isatk.model.dto.Car;
import com.isatk.model.dto.FaInvoice;
import com.isatk.service.base.CarService;
@Component
public class CarServiceImpl implements CarService {
	@Autowired
	private CarMapper carMapper;
	@Override
	public Car findOneRecord(String dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car findOneRecord(Long dbid) throws SysException {
		return carMapper.selectByPrimaryKey(dbid);
	}

	@Override
	public Car findOneRecord(Car dto) throws SysException {
		return findOneRecord(dto.getId());
	}

	@Override
	public PageBean<Car, Car> findListData(PageBean<Car, Car> page)
			throws SysException {
		Car dto=page.getParameterEntity();
		page.putLastRowNum(carMapper.countDetail(dto));
		List<Car> list=carMapper.selectDetail(dto);
		page.setDataList(list);
		return page;
	}

	@Override
	public void deleteOneRecord(Car dto) throws SysException {
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
	public void addOneRecord(Car dto) throws SysException {
		dto.setId(SNPool.createInstance().getNextID());
		Date date =new Date();
		dto.setInsDate(date);
		dto.setUpDate(date);
		carMapper.insertSelective(dto);
	}

	@Override
	public void updateOneRecord(Car dto) throws SysException {
		// TODO Auto-generated method stub

	}

	@Override
	public Long findMaxID() throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

}
