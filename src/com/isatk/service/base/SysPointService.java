package com.isatk.service.base;

import java.util.List;

import com.isatk.core.exception.SysException;
import com.isatk.model.dto.SysPoint;

public interface SysPointService  extends BasicStandard<SysPoint,SysPoint>{

	List<SysPoint> findList(Integer isFa, Integer isSo) throws SysException;

}
