package com.isatk.service.base;

import com.isatk.model.dto.SysUser;

public interface SysUserService extends BasicStandard<SysUser,SysUser> {

	SysUser findUserByLoginName(String loginName);

}
