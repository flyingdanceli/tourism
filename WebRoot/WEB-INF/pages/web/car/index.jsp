<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>鄂西快运</title>
<jsp:include page="/WEB-INF/pages/common/head.jsp"></jsp:include>
</head>
<body data-menu="3">
<jsp:include page="/WEB-INF/pages/common/menu.jsp"></jsp:include>
 <div class="container" >
       	<ol class="breadcrumb main" >
		  <li><a href="#"><i class="fa fa-truck"></i> 鄂西快运</a></li>
		  <li  class="active">车辆管理</li>
		</ol>
		<form class="form-inline" id="pagerForm" action="${appPath}/invoice/mine.html" method="post">
     	<div class="well">
     		
			<input type="hidden" name="pageNum" value="1">
			  <div class="form-group">
			    <label>车牌号：</label>
			    <input type="text" class="form-control"  placeholder="车牌号">
			  </div>
			  <button type="submit" class="btn btn-default"><i class="fa fa-search"></i> 搜 索</button>
			
     	</div>
		<div class="panel panel-default">
		  <!-- Default panel contents -->
		  <div class="panel-heading"><i class="fa fa-th-list"></i> 车辆管理 <div class="pull-right"><a href="${appPath }/car/add.html" class="btn btn-success btn-xs"><i class="fa fa-plus"></i> 添加车辆</a></div></div>
		
		  <!-- Table -->
		  <table class="table">
		  	<thead>
		  	<tr>
		  		<th>车牌号</th>
		   		<th>油费</th>
		   		<th>过路费</th>
		   		<th>加水费</th>
		   		<th>机油费</th>
		   		<th>维修费</th>
		   		<th>黄油费</th>
		   		<th>其它费用</th>
		   		<th>操作</th>
		   	</tr>
		   	</thead>
		   	<tbody>
		   	<c:forEach items="${page.dataList}" var="v" varStatus="s">
			   	<tr>
			   		<td class="text-danger"><strong>${v.code }</strong></td>
			   		<td>${v.sumCarFee.gas}</td>
			   		<td>${v.sumCarFee.tolls}</td>
			   		<td>${v.sumCarFee.water}</td>
			   		<td>${v.sumCarFee.engineOil}</td>
			   		<td>${v.sumCarFee.service}</td>
			   		<td>${v.sumCarFee.butter}</td>
			   		<td>${v.sumCarFee.other}</td>
			   		<td>
			   			<div class="btn-group btn-group-sm ">
						  <a type="button" class="btn btn-default" href="${appPath }/car/addFee.html?carId=${v.id}">添加费用</a>
						  <a type="button" class="btn btn-default" href="${appPath }/car/showFee.html?carId=${v.id}">费用明细</a>
						</div>
			   		</td>
			   	</tr>
		   	</c:forEach>
		   	</tbody>
		  </table>
		</div>
		<hr />
					<div class="panelBar row" >
				        <div class="pages col-md-3 pagination">
				            <span>&nbsp;每页&nbsp;</span>
				            <span class="sel">
				            ${page.pageSize }
				            </span>
				            <span>&nbsp;条，共 ${page.lastRowNum} 条</span>
				        </div>
				        <div class="pagination-box col-md-9" totalcount="${page.lastRowNum}" numperpage="20" pagenumshown="10" currentpage="${page.pageNum}">
				        	<nav class="pull-right">
							  <ul class="pagination">
							   
							  </ul>
							</nav>
				        </div>
				    </div>
		</form>
    </div> <!-- /container -->
<jsp:include page="/WEB-INF/pages/common/foot.jsp"></jsp:include>
</body>
</html>