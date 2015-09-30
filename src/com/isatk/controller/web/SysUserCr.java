package com.isatk.controller.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isatk.controller.base.BaseController;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.ge.utils.code.SNPool;
import com.isatk.model.dao.SysUserMapper;
import com.isatk.model.dto.SysPoint;
import com.isatk.model.dto.SysUser;
import com.isatk.model.dto.SysUserExample;
import com.isatk.service.base.SysPointService;
import com.isatk.service.base.SysUserService;

@Controller
@RequestMapping("/sysUser")
public class SysUserCr extends BaseController{
	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysUserMapper userMapper;
	@Autowired
	private SysPointService sysPointService;
	@RequestMapping("/userIndex.html")
	public ModelAndView toIndex(HttpServletRequest request,HttpServletResponse response,PageBean<SysUser, SysUser> page,SysUser sysUser,String act){
		if(page==null){
			page = new PageBean<SysUser,SysUser>();
		}
		List<SysPoint> point = sysPointService.findList(null, null);
		Map<Long,SysPoint> pm = new HashMap<Long,SysPoint>();
		for(SysPoint sp:point){
			pm.put(sp.getId(), sp);
		}
		ModelAndView mv=new ModelAndView("web/sysuser/index");
		page.setParameterEntity(sysUser);
		page.setHasEnable(1);
		page = sysUserService.findListData(page);
		for(SysUser su:page.getDataList()){
			if(su.getFaRange()!=null){
				su.setFaRangeName(pm.get(su.getFaRange()).getName());
			}
			if(su.getSoRange()!=null){
				su.setSoRangeName(pm.get(su.getSoRange()).getName());
			}
		}
		mv.addObject("page", page);
		mv.addObject("act", act);
		return mv;
	}
	
	@RequestMapping("/addUser.html")
	public ModelAndView toAddUser(HttpServletRequest request,HttpServletResponse response,Long id){
		ModelAndView mv=new ModelAndView("web/sysuser/add");
		List<SysPoint> fa = sysPointService.findList(1, 0);
		List<SysPoint> so = sysPointService.findList(0, 1);
		if(id != null){
			SysUser user = sysUserService.findOneRecord(id);
			mv.addObject("user", user);
		}
		mv.addObject("fa", fa);
		mv.addObject("so", so);
		return mv;
	}
	@RequestMapping("/updateUser.html")
	public ModelAndView toUpdateUser(HttpServletRequest request,HttpServletResponse response,Long id){
		ModelAndView mv=new ModelAndView("web/sysuser/update");
		List<SysPoint> fa = sysPointService.findList(1, 0);
		List<SysPoint> so = sysPointService.findList(0, 1);
		if(id != null){
			SysUser user = sysUserService.findOneRecord(id);
			mv.addObject("user", user);
		}
		mv.addObject("fa", fa);
		mv.addObject("so", so);
		return mv;
	}
	@RequestMapping("/saveUser.mo")
	public ModelAndView saveUser(SysUser user){
		if(user.getId()!=null){
			sysUserService.updateOneRecord(user);
		}else{
			user.setId(SNPool.createInstance().getNextID());
			user.setInsTime(new Date());
			sysUserService.addOneRecord(user);
		}
		List<SysUser> userList = userMapper.selectByExample(new SysUserExample());
		ModelAndView mv=new ModelAndView("redirect:/sysUser/userIndex.html");
		mv.addObject("userList", userList);
		mv.addObject("res","操作成功");
		return mv;
	}
	
	@RequestMapping("/delUser.mo")
	public ModelAndView deleteUser(Long id){
		userMapper.deleteByPrimaryKey(id);
		List<SysUser> userList = userMapper.selectByExample(new SysUserExample());
		ModelAndView mv=new ModelAndView("web/sysuser/index");
		mv.addObject("userList", userList);
		mv.addObject("res","操作成功");		
		return mv;
	}
	
	@RequestMapping("/toChangePassword.html")
	public ModelAndView toChangePassword(){
		ModelAndView mv = new ModelAndView("web/sysuser/changepwd");//成功
		
		return mv;
	}
	@RequestMapping("/doChangePassword.html")
	public ModelAndView doChangePassword(HttpServletRequest request,HttpServletResponse response,String pwd,String pwd1,String pwd2){
		ModelAndView mv = new ModelAndView("web/sysuser/changepwd");//成功
		SysUser su = (SysUser) request.getSession().getAttribute(_USER);
		su = userMapper.selectByPrimaryKey(su.getId());
		if(su.getPwd().equals(pwd)){
			su.setPwd(pwd1);
			userMapper.updateByPrimaryKeySelective(su);
			mv.addObject("res", "密码修改成功！");
			mv.addObject("status", "success");
		}else{
			mv.addObject("res", "原密码错误！");
			mv.addObject("status", "danger");
		}
		return mv;
	}
}
