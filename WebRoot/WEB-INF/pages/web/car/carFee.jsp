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
 <div class="container-fluid" >
       	<ol class="breadcrumb main" >
		  <li><a href="#"><i class="fa fa-truck"></i> 鄂西快运</a></li>
		  <li>车辆管理</li>
		  <li class="active">车辆费用明细</li>
		</ol>
		<form class="form-inline" id="pagerForm" action="${appPath}/car/carFee.html" method="post">
		<div class="panel panel-default">
		  <!-- Default panel contents -->
		  <div class="panel-heading"><i class="fa fa-th-list"></i> 车辆费用</div>
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
		   	</tr>
		   	</thead>
		   	<tbody>
		   	<c:forEach items="${page.dataList}" var="v" varStatus="s">
			   	<tr>
			   		<td class="text-danger"><strong>${code }</strong></td>
			   		<td>${v.gas}</td>
			   		<td>${v.tolls}</td>
			   		<td>${v.water}</td>
			   		<td>${v.engineOil}</td>
			   		<td>${v.service}</td>
			   		<td>${v.butter}</td>
			   		<td>${v.other}</td>
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