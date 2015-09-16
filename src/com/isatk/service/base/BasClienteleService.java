package com.isatk.service.base;

import java.util.List;

import com.isatk.model.dto.BasClientele;

public interface BasClienteleService extends BasicStandard<BasClientele,BasClientele> {

	List<BasClientele> findRecordByKey(String key);

	BasClientele findOneRecordByPhone(String phone);

}
