package com.isatk.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isatk.core.exception.SysException;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.ge.utils.code.SNPool;
import com.isatk.model.dao.CarFeeMapper;
import com.isatk.model.dto.Car;
import com.isatk.model.dto.CarFee;
import com.isatk.model.dto.CarFeeExample;
import com.isatk.model.dto.CarFeeExample.Criteria;
import com.isatk.service.base.CarFeeService;
@Component
public class CarFeeServiceImpl implements CarFeeService {
	@Autowired
	private CarFeeMapper carFeeMapper;
	@Override
	public CarFee findOneRecord(String dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarFee findOneRecord(Long dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CarFee findOneRecord(CarFee dto) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<CarFee, CarFee> findListData(PageBean<CarFee, CarFee> page)
			throws SysException {
		CarFee dto=page.getParameterEntity();
		CarFeeExample cfe =  new CarFeeExample();
		Criteria c =cfe.createCriteria();
		if(dto!=null && dto.getCarId()!=null){
			c.andCarIdEqualTo(dto.getCarId());
		}
		page.putLastRowNum(carFeeMapper.countByExample(cfe));
		page.setDataList(carFeeMapper.selectByExample(cfe));
		return page;
	}

	@Override
	public void deleteOneRecord(CarFee dto) throws SysException {
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
	public void addOneRecord(CarFee dto) throws SysException {
		Date date =new Date();
		dto.setId(SNPool.createInstance().getNextID());
		dto.setInsDate(date);
		carFeeMapper.insertSelective(dto);
	}

	@Override
	public void updateOneRecord(CarFee dto) throws SysException {
		// TODO Auto-generated method stub

	}

	@Override
	public Long findMaxID() throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

}
