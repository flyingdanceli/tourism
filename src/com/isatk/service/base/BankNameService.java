package com.isatk.service.base;

import java.util.List;

import com.isatk.model.dto.BankName;
import com.isatk.model.dto.FaInvoice;

public interface BankNameService extends BasicStandard<BankName,BankName>{

	List<BankName> findList(BankName dto);

}
