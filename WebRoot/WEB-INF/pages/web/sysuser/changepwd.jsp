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
<link href="${appPath }/resources/bootstrap-datetimepicker-master/build/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
<script type="text/javascript" src="${appPath }/resources/moment/moment.min.js"></script>
<script type="text/javascript" src="${appPath }/resources/moment/zh-cn.js"></script>

</head>
<body data-menu="0">
<jsp:include page="/WEB-INF/pages/common/menu.jsp"></jsp:include>

 <div class="container" >
       <br><br><br><br><br>
		<div class="row">
			<div class="col-md-3">&nbsp;
			</div>
		  	<div class="col-md-6">
				<div class="panel panel-default ">
				  <!-- Default panel contents -->
				  <div class="panel-heading"><i class="fa fa-th-list"></i> 修改个人密码 </div>
				  <div class="panel-body">
				  		<form class="" action="${appPath }/sysUser/doChangePassword.html" method="post" onsubmit="return checkpwd()">
						  <div class="form-group">
						    <label for="exampleInputEmail1">原密码</label>
						    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="请输入原始密码">
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">新密码</label>
						    <input type="password" class="form-control" id="pwd1" name="pwd1" placeholder="请输入新密码">
						  </div>
						  <div class="form-group">
						    <label for="exampleInputFile">确认新密码</label>
						    <input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="请再次输入新密码">
						  </div>
						  <button type="submit" class="btn btn-default">修改</button>
						</form>
						<c:if test="${res!=null }">
						<div class="alert alert-${status } alert-dismissible fade in" role="alert">
					      <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
					      <strong><i class="fa fa-exclamation-triangle"></i> ${res}</strong>
					    </div>
					    </c:if>
				  </div>
				</div>
			</div>
		  </div>
    </div> <!-- /container -->
<jsp:include page="/WEB-INF/pages/common/foot.jsp"></jsp:include>
</body>
<script type="text/javascript">
	function checkpwd(){
		if($("#pwd1").val() == ""){
			alert("新密码不能为空！");
		}
		if($("#pwd1").val() != $("#pwd2").val()){
			alert("两次输入密码不一致！");
			return false;
		}
		return true;
			
	}
</script>
</html>