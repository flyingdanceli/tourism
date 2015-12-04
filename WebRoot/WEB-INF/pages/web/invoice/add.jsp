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
<script type="text/javascript" src="${appPath }/resources/bootstrap-datetimepicker-master/build/js/bootstrap-datetimepicker.min.js"></script>

</head>
<body  data-menu="0">
<jsp:include page="/WEB-INF/pages/common/menu.jsp"></jsp:include>
<div class="container">
<form id="mineform" class="form-horizontal" action="${appPath }/invoice/doAdd.html" method="post" autocomplete="off" onsubmit="return check();">
	<ol class="breadcrumb main" >
		  <li><a href="#"><i class="fa fa-truck"></i> 鄂西快运</a></li>
		  <li><a href="#">发货单</a></li>
		  <li  class="active">新增发货单</li>
		</ol>
      <div class="jumbotron">
        <div class="form-group">
		    <label class="col-sm-2 control-label">发货时间</label>
		    <div class="col-sm-4">
		    	<input type='text' class="form-control" id='faTime' name="faTime" value="<fmt:formatDate value="${date }"  pattern="yyyy-MM-dd" />" />
		     	<%--<input type="date" class="form-control" placeholder="默认当天" value="<fmt:formatDate value="${date }"  pattern="yyyy-MM-dd"></fmt:formatDate>" name="faTime" required="required" /> --%>
		    </div>
		    <label class="col-sm-2 control-label">运单号</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" placeholder="运单号，不填写可以自动生成" name="faNo" id="faNo" value="${ordId }">
		    </div>
		  </div>
        <div class="form-group">
		    <label class="col-sm-2 control-label">发货点</label>
		    <div class="col-sm-4">
		      <select class="form-control" name="faPoint" id="faPoint" required="required">
		      <c:forEach var="fa" items="${fa }">
		      	<option value="${fa.id }">${fa.name }</option>
		      </c:forEach>
		      </select>
		    </div>
		    <label class="col-sm-2 control-label">到货点</label>
		    <div class="col-sm-4">
		       <select class="form-control" name="soPoint" id="soPoint" required="required">
		      	<c:forEach var="so" items="${so }">
			      	<option value="${so.id }">${so.name }</option>
			      </c:forEach>
		      </select>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">发货人电话</label>
		    <div class="col-sm-4">
		      	<input type="text" class="form-control" id="faPhone" placeholder="发货人电话" name="faPhone" required="required">
		      	<input type="hidden" id="faClientele" name="faClientele" >
		    </div>
		    <label class="col-sm-2 control-label">收货人电话</label>
		    <div class="col-sm-4">
		      		<input type="text" class="form-control" id="soPhone" placeholder="收货人电话" name="soPhone" required="required">
		      		<input type="hidden" id="soClientele" name="soClientele" >
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">发货人名称</label>
		    <div class="col-sm-4">
		      		<input type="text" class="form-control" id="faName" placeholder="发货人名称" name="faName" required="required" disabled="disabled">
		    </div>
		    <label class="col-sm-2 control-label">收货人名称</label>
		    <div class="col-sm-4">
		      		<input type="text" class="form-control" id="soName" placeholder="收货人名称" name="soName" required="required"  disabled="disabled">
		    </div>
		  </div>
		   <div class="form-group" id="zhuanyundian" style="display:none;">
		    <label class="col-sm-2 control-label"><i class="fa fa-asterisk text-danger"></i> 转运点</label>
		    <div class="col-sm-4">
		      	<select class="form-control" name="soPointSubName" id="soPointSubName">
		      		<option value=""></option>
		      		<option value="恩施">恩施</option>
		      		<option value="利川">利川</option>
		      		<option value="来风">来风</option>
		      		<option value="鹤峰">鹤峰</option>
		      		<option value="宣恩">宣恩</option>
		      		<option value="咸丰">咸丰</option>
		      		<option value="巴东">巴东</option>
		      		<option value="建始">建始</option>
		      		<option value="野三关">野三关</option>
		      	</select>
		    </div>
		    <label class="col-sm-2 control-label"><i class="fa fa-asterisk text-danger"></i> 转运费</label>
		    <div class="col-sm-4">
		    	<div class="input-group">
				  <span class="input-group-addon">¥</span>
				  <input type="number" class="form-control"  id="soPointSubMoney"  name="soPointSubMoney" >
				  <span class="input-group-addon">.00</span>
				</div>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="col-sm-2 control-label">运费</label>
		    <div class="col-sm-4">
		      <div class="input-group">
				  <span class="input-group-addon">¥</span>
				  <input type="number" class="form-control" aria-label="Amount (to the nearest dollar)" name="freight" required="required">
				  <span class="input-group-addon">.00</span>
				</div>
		    </div>
		    <label class="col-sm-2 control-label">代收金额</label>
		    <div class="col-sm-4">
		      <div class="input-group">
				  <span class="input-group-addon">¥</span>
				  <input type="number" class="form-control" aria-label="Amount (to the nearest dollar)" name="collection">
				  <span class="input-group-addon">.00</span>
				</div>
		    </div>
		  </div>
		  <div class="form-group">
		    <label  class="col-sm-2 control-label">运费-付款方式</label>
		    <div class="col-sm-4">
		    	<label class="radio-inline">
				  <input type="radio" name="freightWay" id="freightWay2" value="0"> (自)已付
				</label>
				<label class="radio-inline">
				  <input type="radio" name="freightWay" id="freightWay1" value="1">  到付
				</label>
		    </div>
		    <label class="col-sm-2 control-label">代收-付款方式</label>
		    <div class="col-sm-4">
		       	<label class="radio-inline">
				  <input type="radio" name="collectionWay" id="collectionWay0" value="0"> 现金
				</label>
				<label class="radio-inline">
				  <input type="radio" name="collectionWay" id="collectionWay1" value="1"> 银行 <i class="fa fa-asterisk text-danger"></i>
				</label>
		    </div>
		  </div>
		  <div class="form-group" id="dsyh"  style="display:none;">
		  	<label class="col-sm-2 control-label"><i class="fa fa-asterisk text-danger"></i> 代收银行</label>
		    <div class="col-sm-4">
		       <select class="form-control" name="faBankCode" id="faBankCode">
		       		<option value="">请选择</option>
		       	  <c:forEach var="v" items="${bankNames }">
			      	<option value="${v.code }">${v.name }（${v.code }）</option>
			      </c:forEach>
		      </select>
		    </div>
		    <label class="col-sm-2 control-label"><i class="fa fa-asterisk text-danger"></i> 代收银行卡号</label>
		    <div class="col-sm-4">
		      <input type="text" class="form-control" id="faCardNo"  placeholder="代收银行卡号" name="faCardNo">
		    </div>
		    
		  </div>
		  <div class="form-group">
		  <label  class="col-sm-2 control-label">收货方式</label>
		    <div class="col-sm-4">
		      <label class="radio-inline">
				  <input type="radio" name="soWay" id="soWay1" value="0"> 自提&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				</label>
				<label class="radio-inline">
				  <input type="radio" name="soWay" id="soWay2" value="1">  送货
				</label>
		    </div>
		    <div class="col-sm-offset-2 col-sm-4">
		      <button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i> 保 存</button>&nbsp;&nbsp;&nbsp;&nbsp;
		      <a href="${appPath }/invoice/mine.html" class="btn btn-default"><i class="fa fa-history"></i> 取消</a>
		    </div>
		  </div>
		
      </div>
		<div class="panel panel-default">
		  <!-- Default panel contents -->
		  <div class="panel-heading"><i class="fa fa-th-list"></i> 货物明细 <div class="pull-right" data-toggle="tooltip" data-placement="top" title="如果有明细，货物名称必须填写！"><i class="fa fa-question-circle text-danger"></i></div></div>
		
		  <!-- Table -->
		  <table class="table">
		  	<thead>
		  	<tr>
		   		<th>名称（选择或填写名称后才有效）</th>
		   		<th>件数(不填默认为1)</th>
		   		<th>保险费（¥）零可以不填写</th>
		   	</tr>
		   	</thead>
		   	<tbody>
			   	<tr>
			   		<td>
			   			<select class="form-control" name="name" placeholder="货物名称">
			   				<option>配件</option>
			   				<option>保险杠</option>
			   				<option>车门</option>
			   				<option>机油</option>
			   				<option>车胎</option>
			   			</select>
			   		</td>
			   		<td><input type="text" class="form-control" name="num" placeholder="请输入货物件数"></td>
			   		<td><input type="number" class="form-control" name="insurance" placeholder="千分之三"></td>
			   	</tr>
		   		<tr>
			   		<td>
			   			<select class="form-control" name="name" placeholder="货物名称">
			   				<option value="">无--请选择</option>
			   				<option>配件</option>
			   				<option>保险杠</option>
			   				<option>车门</option>
			   				<option>机油</option>
			   				<option>车胎</option>
			   			</select>
			   		</td>
			   		<td><input type="text" class="form-control" name="num" placeholder="请输入货物件数"></td>
			   		<td><input type="number" class="form-control" name="insurance" placeholder="千分之三"></td>
			   	</tr>	
		   		<tr>
			   		<td>
			   			<select class="form-control" name="name" placeholder="货物名称">
			   				<option value="">无--请选择</option>
			   				<option>配件</option>
			   				<option>保险杠</option>
			   				<option>车门</option>
			   				<option>机油</option>
			   				<option>车胎</option>
			   			</select>
			   		</td>
			   		<td><input type="text" class="form-control" name="num" placeholder="请输入货物件数"></td>
			   		<td><input type="number" class="form-control" name="insurance" placeholder="千分之三"></td>
			   	</tr>	
		   		<tr>
			   		<td><input type="text" class="form-control" name="name" placeholder="请输入货物名称"></td>
			   		<td><input type="text" class="form-control" name="num" placeholder="请输入货物件数"></td>
			   		<td><input type="number" class="form-control" name="insurance" placeholder="千分之三"></td>
			   	</tr>	
		   		
		   	</tbody>
		  </table>
		</div>
		</form>
    </div> <!-- /container -->
<jsp:include page="/WEB-INF/pages/common/foot.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$("#faPhone").focus(function(){
		$("#faName").val("").attr("disabled","disabled");
	}).blur(function(){
		$("#faName").val("");
		if($(this).val()=="")return;
		$.getJSON("${appPath}/invoice/findClienteleByPhone.ajax",{phone:$(this).val()},function(json){
			if(json==null){
				
			}else{
				$("#faName").val(json.name);
				$("#faBankCode option[value='"+json.bankCode+"']").attr("selected","selected");
				$("#faCardNo").val(json.cardNo);
			}
			$("#faName").removeAttr("disabled");
		});
	});
	$("[name=collectionWay]").change(function(){
		if($("#collectionWay1").prop("checked")){
			$("#dsyh").slideDown();
		}else{
			$("#dsyh").slideUp();
		}
	});
	$("#soPhone").focus(function(){
		$("#soName").val("").attr("disabled","disabled");
	}).blur(function(){
		$("#soName").val("");
		$("#bankCode option[value='']").attr("selected","selected");
		$("#cardNo").val("");
		if($(this).val()=="")return;
		$.getJSON("${appPath}/invoice/findClienteleByPhone.ajax",{phone:$(this).val()},function(json){
			if(json==null){
				
			}else{
				$("#soName").val(json.name);
			}
			$("#soName").removeAttr("disabled");
		});
	});
	
	//转运-恩施
	$("#soPoint").change(function(){
		if($(this).val()==8){
			$("#zhuanyundian").slideDown();
		}else{
			$("#zhuanyundian").slideUp();
		}
	}).change();
	//设置默认值
	//设置银行默认为农行短号
	$(function(){
		$("#faBankCode option[value='103']").attr("selected",true);
	});
});

function check(){
	if($("#faTime").val() == ""){
		alert("发货时间不能为空！");
		return false;
	}
	if($("[name=collection]").val()>0 && $("[name=collectionWay]:checked").size()==0){
		alert("有代收金额时，必须选择代收方式");
		return false;
	}
	return true;
}
//示例代码如下：

$('#faClientele').autocomplete({
	source:function(query,process){
	    var matchCount = this.options.items;//返回结果集最大数量
	    $.post("${appPath}/invoice/findClientele.ajax",{"key":query,"maxLength":matchCount},function(respData){
	        return process(respData);
	    });
	},
	formatItem:function(item){
	    return item["name"]+"("+item["phone"]+")";
	},
	setValue:function(item){
	    return {'data-value':item["name"]+"("+item["phone"]+")",'real-value':item["id"]};
	},
	minLength:2
});

$("#mineform").submit(function(){
	$('#faClientele').val($("#faClientele").attr("real-value"));
	$('#soClientele').val($("#soClientele").attr("real-value"));
	
});


$("#goBtn").click(function(){ //获取文本框的实际值
        var regionCode = $("#autocompleteInput").attr("real-value") || "";
        alert(regionCode);
    });

$(function () {
    $('#faTime').datetimepicker({
    	format:"YYYY-MM-DD",
    	useCurrent:true,
    	locale:"zh-cn",
    	showClear:true,
    	showTodayButton:true,
    	showClose:true,
    	tooltips: {
    	    today: '今天',
    	    clear: '清除',
    	    close: '关闭',
    	    selectMonth: '选择月份',
    	    prevMonth: '上一月',
    	    nextMonth: '下一月',
    	    selectYear: '选择年',
    	    prevYear: '上一年',
    	    nextYear: '下一年',
    	    selectDecade: 'Select Decade',
    	    prevDecade: 'Previous Decade',
    	    nextDecade: 'Next Decade',
    	    prevCentury: 'Previous Century',
    	    nextCentury: 'Next Century'
    	}
    });
});
</script>
</body>
</html>