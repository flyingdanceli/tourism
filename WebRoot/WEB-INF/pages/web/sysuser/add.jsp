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
<body  data-menu="9">
<jsp:include page="/WEB-INF/pages/common/menu.jsp"></jsp:include>
<div class="container">
	<ol class="breadcrumb main" >
	  <li><a href="#"><i class="fa fa-truck"></i> 鄂西快运</a></li>
	  <li><a href="#">员工管理</a></li>
	  <li>新增员工</li>
	</ol>
      <div class="jumbotron">
       <form class="form-horizontal" id="user_form" action="${appPath }/sysUser/saveUser.mo" method="post">
       <input type="hidden" id="id" name="id" value="" />
        <div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">登录帐号</label>
		    <div class="col-sm-4">
		      <input type="text" id="loginName" name="loginName" class="form-control" placeholder="登录帐号" value="">
		    </div>
		    <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
		    <div class="col-sm-4">
		      <input type="text" id="name" name="name" class="form-control" placeholder="姓名" value="">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">发货点权限</label>
		    <div class="col-sm-4">
		      <select class="form-control" name="faRange" >
		      <option value="">无权限</option>
		      <c:forEach var="fa" items="${fa }">
		      	<option value="${fa.id }">${fa.name }</option>
		      </c:forEach>
		      </select>
		    </div>
		    <label class="col-sm-2 control-label">到货点权限</label>
		    <div class="col-sm-4">
		       <select class="form-control" name="soRange">
		       <option value="">无权限</option>
		      	<c:forEach var="so" items="${so }">
			      	<option value="${so.id }">${so.name }</option>
			      </c:forEach>
		      </select>
		    </div>
		  </div>
		  <div class="form-group">		    
		    <label for="inputPassword3" class="col-sm-2 control-label">是否禁用</label>
		    <div class="col-sm-4">
		      <select class="form-control" id="isDisable" name="isDisable" >
		      	<option value="0" >否</option>
		      	<option value="1">是</option>
		      </select>
		    </div>
		  </div>
		  <div class="form-group">
		    <div class="col-sm-offset-2 col-sm-10">
		      <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i> 保 存</button>&nbsp;&nbsp;&nbsp;&nbsp;
		      <a href="${appPath }/sysUser/userIndex.html" class="btn btn-default"><i class="fa fa-history"></i> 取消</a>
		    </div>
		  </div>
		</form>
      </div>		
    </div> <!-- /container -->
<jsp:include page="/WEB-INF/pages/common/foot.jsp"></jsp:include>
</body>
</html>