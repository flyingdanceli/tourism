package com.isatk.util;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PageTag extends TagSupport {
	
	
	private static final long serialVersionUID = -762377716208917345L;
	
	
	private String layout;
	
	
	
	public String getLayout() {
		if(layout==null || layout.trim().length()==0)
		{
			layout="center";
		};
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	private String pageCss="";
	
	public String getPageCss() {
		if(pageCss==null || pageCss.trim().length()==0)
		{
			pageCss="";
		}
		return pageCss;
	}

	public void setPageCss(String pageCss) {
		this.pageCss = pageCss;
	}

	private String searchFunction;//蹇呴』鏄鍑芥暟鐨勫紩鐢ㄦ爣璇�

	public String getSearchFunction() {
		if(searchFunction==null || searchFunction.trim().length()==0)
		{
			searchFunction="doSearch";
		}
		return searchFunction;
	}

	public void setSearchFunction(String searchFunction) {
		this.searchFunction = searchFunction;
	}

	/**
	 * 椤靛墠椤电涓�潯鏁版嵁鐨勪笅鏍�
	 */
	private int currentPageIndex;
	/**
	 * 褰撳墠椤电爜
	 */
	private int currentPageNum = 1;
	
	/**
	 * 涓嬩竴椤甸〉鐮�
	 */
	
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}



	
	public int getCurrentPageNum() {
		return currentPageNum;
	}

	public void setCurrentPageNum(int currentPageNum) {
		this.currentPageNum = currentPageNum;
	}

	private int nextPageNum;

	/**
	 * 涓婁竴椤甸〉鐮�
	 */
	private int prePageNum;
	
	/**
	 * 绗竴椤甸〉鐮�
	 */
	private int firstPageNum;

	/**
	 * 鏈�悗涓�〉椤电爜
	 */
	private int lastPageNum;
	
	
	private int thisPageNum;
	
	
	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getPrePageNum() {
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getFirstPageNum() {
		return firstPageNum;
	}

	public void setFirstPageNum(int firstPageNum) {
		this.firstPageNum = firstPageNum;
	}

	public int getLastPageNum() {
		return lastPageNum;
	}

	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}

	public int getThisPageNum() {
		return thisPageNum;
	}

	public void setThisPageNum(int thisPageNum) {
		this.thisPageNum = thisPageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRowsCount() {
		return rowsCount;
	}

	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	

	
	/**
	 * 椤电殑澶у皬
	 */
	private int pageSize = 10;
	
	/**
	 * 鎬诲叡璁板綍鏁�
	 */
	private int rowsCount;
	
	/**
	 * 鎬诲叡椤垫暟
	 */
	private int pageCount;
	
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return this.EVAL_PAGE;   
	}

	
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out=pageContext.getOut();
		StringBuffer result = new StringBuffer("");
		result.append("<div style='padding-left:4px;padding-right:4px;text-align:"+getLayout()+"' class='").append(this.pageCss).append("'>");
		result.append("<input type='hidden' id='firstPageNum' name='firstPageNum'	value='").append(this.firstPageNum).append("' />");
		result.append("<input type='hidden' id='lastPageNum' name='lastPageNum'	value='").append(this.lastPageNum).append("' />");
		result.append("<input type='hidden' id='prePageNum' name='prePageNum'	value='").append(this.prePageNum).append("' />");
		result.append("<input type='hidden' id='nextPageNum' name='nextPageNum'  value='").append(this.nextPageNum).append("' />");
		result.append("<input type='hidden' id='thisPageRows' name='rows'  value='").append(this.rowsCount).append("' />");
		result.append("<input type='hidden' id='pageSize' name='pageSize'  value='").append(this.pageSize).append("' />");
		
		result.append("鎬昏 <span style='color: red;'>").append(this.rowsCount).append("</span>鏉¤褰�nbsp;&nbsp;&nbsp;&nbsp;");
		result.append("<a href='javascript:doPageFirst();'>绗竴椤�/a>&nbsp;&nbsp;");
		result.append("<a href='javascript:doPagePre();'>涓婁竴椤�/a>&nbsp;&nbsp;");
		result.append("<a href='javascript:doPageNext();'>涓嬩竴椤�/a>&nbsp;&nbsp;");
		result.append("<a href='javascript:doPageLast();'>鏈�悗涓�〉</a>");		
		result.append("&nbsp;&nbsp;杞埌绗�input style='text-align:right' id='thisPageNum' name='p' value='").append(this.currentPageNum).append("' size='2' />&nbsp;/<span id='lastPageNumShow'>"+this.lastPageNum+"</span> 椤�nbsp;");
		result.append("<a href='javascript:doPageGo();' style='color:#9944aa;font-size:14px;cursor:hand;font-weight:blod;'>&nbsp;GO>>&nbsp;</a></div>");
		
		StringBuffer js=new StringBuffer();
		js.append("<script type='text/javascript'> " +
				"function doPageNext() {var l=document.getElementById('lastPageNum');var t=document.getElementById('thisPageNum');" +
				"if(t.value<l.value){t.value++;}else{t.value=l.value}" +
				getSearchFunction()+"(t.value,l.value);}");
		js.append("function doPagePre() {var f=document.getElementById('firstPageNum');var t=document.getElementById('thisPageNum');var l=document.getElementById('lastPageNum');" +
				"if(t.value>f.value){t.value--;}else{t.value=f.value}"+			
				getSearchFunction()+"(t.value,l.value);}");
		js.append("function doPageFirst(){var f=document.getElementById('firstPageNum');var t=document.getElementById('thisPageNum');var l=document.getElementById('lastPageNum');" +
				"t.value = f.value;"+getSearchFunction()+"(t.value,l.value);}");
		js.append("function doPageLast(){var f=document.getElementById('firstPageNum');var t=document.getElementById('thisPageNum');var l=document.getElementById('lastPageNum');" +
				"t.value = l.value;"+getSearchFunction()+"(t.value,l.value)}");
		js.append("function doPageGo(){var f=document.getElementById('firstPageNum');var t=document.getElementById('thisPageNum');var l=document.getElementById('lastPageNum');" +
				"var p = t.value;if(!/^[1-9]\\d*$/.test(p)){return;}");
		js.append("if (parseInt(p) > parseInt(document.getElementById('lastPageNum').value)) {t.value = l.value;}");
		js.append("if (parseInt(p) < parseInt(document.getElementById('firstPageNum').value)) {t.value = f.value;}");
		js.append(getSearchFunction()+"(t.value,l.value);}" +
				"function resetPageParam(v){var l=document.getElementById('lastPageNum');var ps=document.getElementById('pageSize');var rs=document.getElementById('thisPageRows');" +
				"var nrs=rs.value*1+v;if(nrs>(l.value*ps.value)){l.value++;document.getElementById('lastPageNumShow').innerHTML=''+l.value;rs.value=nrs*1;}" +
				"else{if(nrs<=((l.value-1)*ps.value)){l.value--;document.getElementById('lastPageNumShow').innerHTML=''+l.value;}rs.value=nrs*1;}}" +
				"</script>");	
		
		try 
		{
			out.write(js.toString());
			out.write(result.toString());

		} 
		catch (IOException e) 
		{
			System.out.println("在标签处理类输出的时候出现异常");
			e.printStackTrace();
		}
		return this.EVAL_BODY_INCLUDE;
	}

}
