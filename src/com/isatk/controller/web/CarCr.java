package com.isatk.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.isatk.ge.model.bean.PageBean;
import com.isatk.model.dto.BasClientele;
import com.isatk.model.dto.Car;
import com.isatk.model.dto.CarFee;
import com.isatk.service.base.CarFeeService;
import com.isatk.service.base.CarService;

@Controller
@RequestMapping("/car")
public class CarCr {
	@Autowired
	private CarService carService;
	
	@Autowired
	private CarFeeService carFeeService;
	
	@RequestMapping("/index.html")
	public ModelAndView toIndex(HttpServletRequest request,HttpServletResponse response,PageBean<Car, Car> page,Car car){
		if(page==null){
			page = new PageBean<Car,Car>();
		}
		ModelAndView mv=new ModelAndView("web/car/index");
		page.setParameterEntity(car);
		page = carService.findListData(page);
		mv.addObject("page", page);
		return mv;
	}
	
	@RequestMapping("/add.html")
	public ModelAndView toAdd(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("web/car/add");
		
		return mv;
	}
	@RequestMapping("/doAdd.html")
	public ModelAndView doAdd(HttpServletRequest request,HttpServletResponse response,Car car){
		ModelAndView mv=new ModelAndView("redirect:/car/index.html");
		carService.addOneRecord(car);
		return mv;
	}
	@RequestMapping("/addFee.html")
	public ModelAndView toAddFee(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView("web/car/addFee");
		
		return mv;
	}
	
	@RequestMapping("/doAddFee.html")
	public ModelAndView doAddFee(HttpServletRequest request,HttpServletResponse response,CarFee carFee){
		ModelAndView mv=new ModelAndView("redirect:/car/index.html");
		carFeeService.addOneRecord(carFee);
		return mv;
	}
	@RequestMapping("/carFee.html")
	public ModelAndView toCarFee(HttpServletRequest request,HttpServletResponse response,CarFee carFee,PageBean<CarFee, CarFee> page){
		ModelAndView mv=new ModelAndView("web/car/carFee");
		page.setParameterEntity(carFee);
		carFeeService.findListData(page);
		return mv;
	}
}
