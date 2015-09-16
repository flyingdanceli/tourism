<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<div class="container">
		<form id="mineform" class="form-horizontal"
			action="${appPath }/car/doAdd.html" method="post" autocomplete="off">
			<ol class="breadcrumb main">
				<li><a href="#"><i class="fa fa-truck"></i> 鄂西快运</a></li>
				<li><a href="#">车辆管理</a></li>
				<li class="active">新增车辆</li>
			</ol>
			<div class="jumbotron">
				<div class="form-group">
					<label class="col-sm-2 control-label">车牌号</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" placeholder="车牌号，必填" name="code" required="required" />
					</div>
					<div class="col-sm-6">
						<button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i> 保 存</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="${appPath }/car/index.html" class="btn btn-default"><i class="fa fa-history"></i> 取消</a>
					</div>
				</div>
			</div>
		</form>
	</div>
	<!-- /container -->
	<jsp:include page="/WEB-INF/pages/common/foot.jsp"></jsp:include>
</body>
</html>