package com.isatk.service.base;

import java.util.List;
import java.util.Map;

import com.isatk.model.dto.FaInvoice;

public interface FaInvoiceService extends BasicStandard<FaInvoice,FaInvoice> {

	int updateByIds(String ids);

	List<Map> findExcelDateByIds(String ids);

	FaInvoice findCountFaInvoice(FaInvoice fa);

}
