package com.isatk.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isatk.controller.base.BaseController;
import com.isatk.model.dto.SysUser;
import com.isatk.service.base.BasClienteleService;
import com.isatk.service.base.SysUserService;

@Controller
@RequestMapping("/login")
public class LoginCr extends BaseController{
	@Autowired
	BasClienteleService clienteleService;
	@Autowired
	SysUserService sysUserService;
	
	@RequestMapping("/index.html")
	public ModelAndView index(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("web/login/index");
		return mv;
	}
	
	@RequestMapping("/doLogin.html")
	public ModelAndView doLogin(HttpServletRequest request,SysUser sysUser){
		ModelAndView mv = new ModelAndView("redirect:/invoice/mine.html");//成功
		if(StringUtils.isBlank(sysUser.getLoginName())){
			mv.setViewName("web/login/index");
			mv.addObject("res", "登陆账号不能为空");
			return mv;
		}
		if(StringUtils.isBlank(sysUser.getPwd())){
			mv.setViewName("web/login/index");
			mv.addObject("res", "登陆密码不能为空");
			return mv;
		}
		SysUser su =  sysUserService.findUserByLoginName(sysUser.getLoginName());
		if(su!=null&&sysUser.getPwd().equals(su.getPwd())){
			request.getSession(true).setAttribute(_USER, su);
			return mv;
		}
		mv.setViewName("web/login/index");
		mv.addObject("res", "用户或密码错误！");
		return mv;
	}
}
