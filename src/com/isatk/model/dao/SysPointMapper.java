package com.isatk.model.dao;

import com.isatk.model.dto.SysPoint;
import com.isatk.model.dto.SysPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPointMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int countByExample(SysPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int deleteByExample(SysPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int insert(SysPoint record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int insertSelective(SysPoint record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	List<SysPoint> selectByExample(SysPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	SysPoint selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int updateByExampleSelective(@Param("record") SysPoint record,
			@Param("example") SysPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int updateByExample(@Param("record") SysPoint record,
			@Param("example") SysPointExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int updateByPrimaryKeySelective(SysPoint record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table sys_point
	 * @mbggenerated  Tue May 05 20:07:07 CST 2015
	 */
	int updateByPrimaryKey(SysPoint record);
}