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
<title>鄂西快运欢迎您</title>
<jsp:include page="/WEB-INF/pages/common/head.jsp"></jsp:include>
<script type="text/javascript">
	if("${res}"){
		alert("${res}");
	}

</script>
</head>
<body  data-menu="2">
<jsp:include page="/WEB-INF/pages/common/menu.jsp"></jsp:include>
<div class="container">
	<ol class="breadcrumb main" >
	  <li><a href="#"><i class="fa fa-truck"></i> 鄂西快运</a></li>
	  <li><a href="#">客户管理</a></li>
	  <li>新增客户</li>
	</ol>
      <div class="jumbotron">
       <form class="form-horizontal" id="clientele_form" action="${appPath }/clientele/saveClientele.mo" method="post">
       <input type="hidden" id="id" name="id" value="${basClient.id }" />
        <div class="form-group">
		    <label for="inputName" class="col-sm-2 control-label">姓名</label>
		    <div class="col-sm-4">
		      <input type="text" id="name" name="name" class="form-control" placeholder="姓名" value="${basClient.name }">
		    </div>
		    <label for="inputPhone" class="col-sm-2 control-label">电话</label>
		    <div class="col-sm-4">
		      <input type="text" id="phone" name="phone" class="form-control" placeholder="电话" value="${basClient.phone }">
		    </div>
		  </div>		         
		  <div class="form-group">
		    <label for="inputDatetime" class="col-sm-2 control-label">昵称 </label>
		    <div class="col-sm-4">
		      <input type="text" id="nick" name="nick" class="form-control" placeholder="昵称" value="${basClient.nick }">
		    </div>
		    <label for="inputIsDisable" class="col-sm-2 control-label">是否禁用</label>
		    <div class="col-sm-4">
		      <select class="form-control" id="isDisable" name="isDisable">
		      	<option value="0" <c:if test="${basClient.isDisable=='0' }">selected</c:if>>否</option>
		      	<option value="1" <c:if test="${basClient.isDisable=='1' }">selected</c:if>>是</option>
		      </select>
		    </div>
		  </div> 
		  <div class="form-group">
		    <label for="inputIsSo" class="col-sm-2 control-label">是否收货</label>
		    <div class="col-sm-4">
		       <select class="form-control" id="isSo" name="isSo">
		      	<option value="0" <c:if test="${basClient.isSo=='0' }">selected</c:if>>否</option>
		      	<option value="1" <c:if test="${basClient.isSo=='1' }">selected</c:if>>是</option>
		      </select>
		    </div>
		    <label for="inputIsFa" class="col-sm-2 control-label">是否发货</label>
		    <div class="col-sm-4">
		       <select class="form-control" id="isFa" name="isFa">
		      	<option value="0" <c:if test="${basClient.isFa=='0' }">selected</c:if>>否</option>
		      	<option value="1" <c:if test="${basClient.isFa=='1' }">selected</c:if>>是</option>
		      </select>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i> 保 存</button>&nbsp;&nbsp;&nbsp;&nbsp;
		      <a href="${appPath }/clientele/index.html" class="btn btn-default"><i class="fa fa-history"></i> 取消</a>
		    </div>
		  </div>
		</form>
      </div>		
    </div> <!-- /container -->
<jsp:include page="/WEB-INF/pages/common/foot.jsp"></jsp:include>
</body>
</html>