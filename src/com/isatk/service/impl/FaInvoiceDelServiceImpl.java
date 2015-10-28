package com.isatk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isatk.core.exception.SysException;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.model.dao.FaInvoiceDelMapper;
import com.isatk.model.dto.FaInvoice;
import com.isatk.model.dto.FaInvoiceDel;
import com.isatk.model.dto.FaInvoiceDelExample;
import com.isatk.service.base.FaInvoiceDelService;
@Component
public class FaInvoiceDelServiceImpl implements FaInvoiceDelService {
	@Autowired
	private FaInvoiceDelMapper faInvoiceDelMapper;

	@Override
	public FaInvoiceDel findOneRecord(String dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FaInvoiceDel findOneRecord(Long dbid) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FaInvoiceDel findOneRecord(FaInvoiceDel dto) throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageBean<FaInvoiceDel, FaInvoiceDel> findListData(
			PageBean<FaInvoiceDel, FaInvoiceDel> page) throws SysException {
		//page.setPage(page.createPage());
		FaInvoiceDel dto=page.getParameterEntity();
		FaInvoiceDelExample example = new FaInvoiceDelExample();
		example.setPage(page.createPage());
		page.putLastRowNum(faInvoiceDelMapper.countByExample(example));
		List<FaInvoiceDel> list = faInvoiceDelMapper.selectByExample(example);
		page.setDataList(list);
		return page;
	}

	@Override
	public void deleteOneRecord(FaInvoiceDel dto) throws SysException {
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
	public void addOneRecord(FaInvoiceDel dto) throws SysException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOneRecord(FaInvoiceDel dto) throws SysException {
		// TODO Auto-generated method stub

	}

	@Override
	public Long findMaxID() throws SysException {
		// TODO Auto-generated method stub
		return null;
	}

}
