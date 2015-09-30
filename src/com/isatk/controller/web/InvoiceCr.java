package com.isatk.controller.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.isatk.controller.base.BaseController;
import com.isatk.ge.model.bean.PageBean;
import com.isatk.ge.utils.code.SNPool;
import com.isatk.model.dto.AjaxMessage;
import com.isatk.model.dto.BankName;
import com.isatk.model.dto.BasClientele;
import com.isatk.model.dto.CargoDetails;
import com.isatk.model.dto.FaInvoice;
import com.isatk.model.dto.SysPoint;
import com.isatk.model.dto.SysUser;
import com.isatk.service.base.BankNameService;
import com.isatk.service.base.BasClienteleService;
import com.isatk.service.base.FaInvoiceService;
import com.isatk.service.base.SysPointService;
import com.isatk.service.impl.IdServiceImpl;

@Controller
@RequestMapping("/invoice")
public class InvoiceCr extends BaseController {
	@Autowired
	private FaInvoiceService faInvoiceService;
	@Autowired
	private SysPointService sysPointService;
	@Autowired
	private BankNameService bankNameService;
	@Autowired
	BasClienteleService clienteleService;
	@Autowired
	IdServiceImpl idServiceImpl;
	
	@RequestMapping("/mine.html")
	public ModelAndView mine(HttpServletRequest request,HttpServletResponse response,PageBean<FaInvoice, FaInvoice> page,FaInvoice faInvoice ,Integer timeType,Date time){
		SysUser su = (SysUser) request.getSession().getAttribute(_USER);
		if("".equals(faInvoice.getSoPhone()))
			faInvoice.setSoPhone(null);
		if("".equals(faInvoice.getSoName()))
			faInvoice.setSoName(null);
		if("".equals(faInvoice.getFaNo()))
			faInvoice.setFaNo(null);
		/*List<SysPoint> fa = sysPointService.findList(1, 0);
		List<SysPoint> so = sysPointService.findList(0, 1);*/
		List<SysPoint> fa = null;
		List<SysPoint> so = null;
		if(su.getFaRange()!=null && su.getSoRange()!=null){
			fa = sysPointService.findList(1, 0);
			so = sysPointService.findList(0, 1);
		}else{
			if(su.getFaRange()!=null){
				faInvoice.setFaPoint(su.getFaRange());
				SysPoint sp = sysPointService.findOneRecord(su.getFaRange());
				fa = new ArrayList();
				fa.add(sp);
				so = sysPointService.findList(0, 1);
			}
			if(su.getSoRange()!=null){
				faInvoice.setSoPoint(su.getSoRange());
				SysPoint sp = sysPointService.findOneRecord(su.getSoRange());
				so = new ArrayList();
				so.add(sp);
				fa = sysPointService.findList(1, 0);
			}
		}
		
		if(timeType !=null && timeType == 1){
			faInvoice.setFaTime(time);
		}else if(timeType !=null && timeType == 2){
			faInvoice.setSoTime(time);
		}else if(timeType !=null && timeType == 3){
			faInvoice.setCollectionTime(time);
		}
		
		if(page==null){
			page = new PageBean<FaInvoice,FaInvoice>();
		}
		
		
		faInvoice.setOrderString(" ins_time desc ");
		ModelAndView mv=new ModelAndView("web/invoice/mine");
		
		page.setParameterEntity(faInvoice);
		page.setHasEnable(1);
		page = faInvoiceService.findListData(page);
		
		FaInvoice countFi = faInvoiceService.findCountFaInvoice(faInvoice);
		mv.addObject("countFi", countFi);
		mv.addObject("page", page);
		mv.addObject("fa", fa);
		mv.addObject("so", so);
		mv.addObject(_USER, request.getSession().getAttribute(_USER));
		mv.addObject("faInvoice", faInvoice);
		return mv;
	}
	@RequestMapping("/add.html")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response){
		int id = idServiceImpl.getOrder();
		SysUser su = (SysUser) request.getSession().getAttribute(_USER);
		ModelAndView mv=new ModelAndView("web/invoice/add");
		//List<SysPoint> fa = sysPointService.findList(1, 0);
		List<SysPoint> fa = new ArrayList<SysPoint>();
		List<SysPoint> so = sysPointService.findList(0, 1);
		List<BankName> bankNames=bankNameService.findList(null);
		SysPoint sp = sysPointService.findOneRecord(su.getFaRange());
		fa.add(sp);
		mv.addObject("fa", fa);
		mv.addObject("so", so);
		mv.addObject("ordId",id);
		mv.addObject("bankNames", bankNames);
		mv.addObject("date", new Date());
		return mv;
	}
	@RequestMapping("/doAdd.html")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response,FaInvoice faInvoice ,String[] name ,String[] num,Integer[] insurance,
			String faPhone,String soPhone,
			String faName,String soName,
			String faBankCode,String soBankCode,
			String faCardNo,String soCardNo
			){
		Date date = new Date();
		ModelAndView mv=new ModelAndView("redirect:/invoice/mine.html");
		//System.out.println(idServiceImpl.getOrder());
		//long id = SNPool.createInstance().getNextID();
		Long id = 0L;
		if(faInvoice.getFaNo() == null){
			id = (long) idServiceImpl.getOrder();
		}else{
			id = Long.valueOf(faInvoice.getFaNo());
		}
			
		
		faInvoice.setId(id);
		if(StringUtils.isBlank(faInvoice.getFaNo())){
			faInvoice.setFaNo(faInvoice.getId()+"");
		}
		faInvoice.setUpTime(date);
		faInvoice.setInsTime(date);
		Integer collection = faInvoice.getCollection();
		if(collection!=null&&collection!=0){
			if(collection<3000){
				faInvoice.setFee(3);
			}else if(3000<=collection&&collection<6000){
				faInvoice.setFee( 5 );
			}else if(6000<=collection&&collection<10000){
				faInvoice.setFee( 10 );
			}else if(10000<=collection&&collection<13000){
				faInvoice.setFee( 13 );
			}else if(13000<=collection && collection<16000){
				faInvoice.setFee( 16 );
			}else if(16000<=collection && collection<20000){
				faInvoice.setFee( 20 );
			}else if(20000<=collection && collection<23000){
				faInvoice.setFee(23  );
			}else if(23000<collection && collection<26000){
				faInvoice.setFee( 26 );
			}else if(26000<=collection){
				faInvoice.setFee( 30 );
			}
			
		}else{
			faInvoice.setFee(0);
		}
		int j =0;
		int k = 0;
		List<CargoDetails> cds = new ArrayList<CargoDetails>();
		if(name != null){
			for(int i=0;i<name.length;i++){
				if(StringUtils.isNotBlank(name[i])){
					CargoDetails cd = new CargoDetails();
					cd.setId(SNPool.createInstance().getNextID());
					cd.setName(name[i]);
					cd.setInsurance(insurance[i]==null?0:insurance[i]);
					cd.setNum(StringUtils.isBlank(num[i])?"1":num[i]);
					cd.setFaId(id);
					cds.add(cd);
					j=j+cd.getInsurance();
					k+= Integer.valueOf(cd.getNum());
				}
			}
		}
		faInvoice.setStatus(0);
		faInvoice.setCountInsurance(j);
		faInvoice.setCargoNum(k);
		faInvoice.setCargoDetailsSet(cds);
		faInvoice.setBankCode(faBankCode);
		faInvoice.setCardNo(faCardNo);//卡号
		BasClientele basClienteleF = new BasClientele();
		basClienteleF.setPhone(faPhone);
		basClienteleF.setName(faName);
		basClienteleF.setCardNo(faCardNo);
		basClienteleF.setBankCode(faBankCode);
		BasClientele basClienteleS = new BasClientele();
		basClienteleS.setPhone(soPhone);
		basClienteleS.setName(soName);
		faInvoice.setBasClienteleF(basClienteleF);
		faInvoice.setBasClienteleS(basClienteleS);
		faInvoiceService.addOneRecord(faInvoice);
		return mv;
	}
	
	@RequestMapping("/findClientele.ajax")
	@ResponseBody
	public List<BasClientele> findClientele(String key,Integer maxLength){
		List<BasClientele> list = clienteleService.findRecordByKey(key);
		return list;
	}
	@RequestMapping("/findClienteleByPhone.ajax")
	@ResponseBody
	public BasClientele findClienteleByPhone(String phone){
		BasClientele basClientele =clienteleService.findOneRecordByPhone(phone);
		if(basClientele==null){
			basClientele = new BasClientele();
		}
		return basClientele;
	}
	
	@RequestMapping("/updateStstus.ajax")
	@ResponseBody
	public AjaxMessage updateStstus(FaInvoice faInvoice){
		FaInvoice dto = new FaInvoice();
		dto.setId(faInvoice.getId());
		dto.setStatus(faInvoice.getStatus());
		faInvoiceService.updateOneRecord(dto);
		AjaxMessage  am =  new AjaxMessage();
		return am;
	}
	@RequestMapping("/status.html")
	public ModelAndView status(Long id,Integer status){
		ModelAndView mv=new ModelAndView("redirect:/invoice/mine.html");
		FaInvoice dto = new FaInvoice();
		
		if(status==1){
			dto.setSoTime(new Date());
			FaInvoice fi = faInvoiceService.findOneRecord(id);
			if(fi!=null && fi.getCollection() == 0){
				dto.setStatus(3);
			}
		}
		if(status==2||status==3){
			dto.setCollectionTime(new Date());
		}
		dto.setId(id);
		dto.setStatus(status);
		faInvoiceService.updateOneRecord(dto);
		return mv;
	}
	
}
