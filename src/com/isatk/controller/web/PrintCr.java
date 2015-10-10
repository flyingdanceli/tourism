package com.isatk.controller.web;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.pool.DruidDataSource;

@Controller
@RequestMapping("/print")
public class PrintCr {
	
	@RequestMapping("/ptint.html")
	public ModelAndView ptint(String autoPrint,String autoView,String reportUrl,Long invoiceId) {
		ModelAndView mv=new ModelAndView("common/printer");
		if(autoPrint==null||"".equals(autoPrint))
			autoPrint="true";
		if(autoView==null||"".equals(autoView))
			autoView="true";
		mv.addObject("autoPrint", autoPrint);
		mv.addObject("autoView", autoView);
		reportUrl="http://192.168.6.205/print/printReport.html?invoiceId="+invoiceId;
		mv.addObject("reportUrl", reportUrl);
		return mv;
	}
	@RequestMapping("/printReport.html")
	public String printReport(HttpServletRequest request,HttpServletResponse response,Long invoiceId,String jasper) throws SQLException{
		System.out.println(request.getSession().getId());
		if(jasper == null)
			jasper ="test";
		File reportFile = new File(request.getRealPath("/reports/"+jasper+".jasper"));
		if (!reportFile.exists())
			throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
		Map parameters = new HashMap();
		parameters.put("invoice_id", invoiceId);
		parameters.put("SUBREPORT_DIR", request.getRealPath("/reports")+"/");
		JasperPrint jasperPrint = null;
		try
		{
			JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reportFile);

			
			ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
			DruidDataSource datasource=(DruidDataSource)ct.getBean("dataSource");
			Connection con=datasource.getConnection();

			jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,con);
			exportPrint(jasperPrint, request, response);
		}catch (JRException e)		{
			e.printStackTrace();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 打印
	 */
	public static void exportPrint(JasperPrint jasperPrint,
			HttpServletRequest request,HttpServletResponse response)
			throws IOException {
		response.setContentType("application/octet-stream");
		ServletOutputStream ouputStream = response.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
		
		oos.writeObject(jasperPrint);
		oos.flush();
		oos.close();
		ouputStream.flush();
		ouputStream.close();
	}
	
	 /**
     * 导出为pdf文件
     * @param response
     * @param conn
     */
	@RequestMapping("/printPdf.html")
    private void exportPdf(HttpServletRequest request, HttpServletResponse response,Long invoiceId,String jasper) {
		if(jasper == null)
			jasper ="test";
        try {
            File jasperFile = new File(request.getServletContext().getRealPath("/reports/"+jasper+".jasper"));
    		if (!jasperFile.exists())
    			throw new JRRuntimeException("File WebappReport.jasper not found. The report design must be compiled first.");
            
    		Map parameters = new HashMap();
    		parameters.put("invoice_id", invoiceId);
    		parameters.put("SUBREPORT_DIR", request.getRealPath("/reports")+"/");
    		ApplicationContext ct=new ClassPathXmlApplicationContext("applicationContext.xml");
			DruidDataSource datasource=(DruidDataSource)ct.getBean("dataSource");
			Connection con=datasource.getConnection();
            JasperReport jasperReport =(JasperReport)JRLoader.loadObject(jasperFile);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, con);
            JRPdfExporter exporter = new JRPdfExporter();  
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, response.getOutputStream());
            response.setHeader("Content-Disposition", "inline;filename="+invoiceId+".pdf");
            response.setContentType("application/pdf");
            response.setCharacterEncoding("UTF-8");  
            exporter.exportReport();
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
