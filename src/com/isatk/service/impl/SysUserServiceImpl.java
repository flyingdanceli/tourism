package com.isatk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isatk.core.exception.SysException;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.model.dao.SysUserMapper;
import com.isatk.model.dto.SysUser;
import com.isatk.model.dto.SysUserExample;
import com.isatk.service.base.SysUserService;
@Component
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapper sysUserMapper;
	@Override
	public SysUser findOneRecord(String dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser findOneRecord(Long dbid) throws SysException {
		return sysUserMapper.selectByPrimaryKey(dbid);
	}

	@Override
	public SysUser findOneRecord(SysUser dto) throws SysException {
		return findOneRecord(dto.getId());
	}

	@Override
	public PageBean<SysUser, SysUser> findListData(
			PageBean<SysUser, SysUser> page) throws SysException {
		SysUser dto=page.getParameterEntity();
		page.putLastRowNum(sysUserMapper.countByCondiction(dto));
		List<SysUser> list=sysUserMapper.selectListByCondiction(dto);
		page.setDataList(list);
		return page;
	}
	@Override
	public SysUser findUserByLoginName(String loginName){
		loginName = loginName.replaceAll("%", "");
		SysUserExample example = new SysUserExample();
		example.createCriteria().andLoginNameEqualTo(loginName);
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	
	@Override
	public void deleteOneRecord(SysUser dto) throws SysException {
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
	public void addOneRecord(SysUser dto) throws SysException {
		// TODO Auto-generated method stub
		sysUserMapper.insertSelective(dto);
	}

	@Override
	public void updateOneRecord(SysUser dto) throws SysException {
		// TODO Auto-generated method stub
		SysUser su = findOneRecord(dto.getId());
		su.setFaRange(dto.getFaRange());
		su.setFaRangeName(dto.getFaRangeName());
		su.setIsDisable(dto.getIsDisable());
		su.setLoginName(dto.getLoginName());
		su.setName(dto.getName());
		if(dto.getPwd() != null && !dto.getPwd().equals("")){
			su.setPwd(dto.getPwd());
		}
		su.setSoRange(dto.getSoRange());
		su.setSoRangeName(dto.getSoRangeName());
		sysUserMapper.updateByPrimaryKey(su);
		//sysUserMapper.updateByPrimaryKeySelective(dto);
	}

	@Override
	public Long findMaxID() throws SysException {
		// TODO Auto-generated method stub
		SysUserExample example = new SysUserExample();
		return null;
	}

}
