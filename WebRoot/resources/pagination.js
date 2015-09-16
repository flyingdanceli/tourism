$(function(){
	$(".panelBar .pagination-box").each(function(){
		var _this=$(this);
		var totalcount = parseInt(_this.attr("totalcount"));//总条数
		var numperpage = parseInt(_this.attr("numperpage"));//每页条数
		var pagenumshown = parseInt(_this.attr("pagenumshown"));//最多多少个页码
		var currentpage = parseInt(_this.attr("currentpage"));//当前页
		initPagination(totalcount,numperpage,pagenumshown,currentpage,_this.find(".pagination"))
		
	});
	function initPagination(totalcount,numperpage,pagenumshown,currentpage,obj ){
		var pagenum = totalcount / numperpage;
		var html="";
		var start=currentpage-parseInt(pagenumshown/2);
		var end,isstart,isend;
		if(start < 0){
			end=currentpage+parseInt(pagenumshown/2)-start;
			start=0;
			
		}else{
			end=currentpage+parseInt(pagenumshown/2);
			isstart=(start>0);
		}
		if(end > pagenum){
			start = parseInt(start-(end-pagenum));
			if(start < 0)
				start=0;
			end=pagenum;
			
		}else{
			isend=(end < pagenum);
		}
		if(currentpage==1)
			html = '<li class="disabled"><a href="javascript:">&nbsp;<i class="fa fa-step-backward"></i></a></li>';
		else
			html = '<li class="prev" data-num="1"><a href="javascript:">&nbsp;<i class="fa fa-step-backward"></i></a></li>';
		if(isstart)
			html += '<li class="disabled"><a href="javascript:">...</a></li>';
		var n=1;
		for(var i=start;i<end;i++){
			n=i+1;
			if(n==currentpage)
				html += "<li class='active' data-num='"+n+"' ><a href='javascript:'>"+n+"</a></li>";
			else
				html += "<li data-num='"+n+"' ><a href='javascript:'>"+n+"</a></li>";
		}
		if(isend)
			html += '<li class="disabled"><a href="javascript:">...</a></li>';
		if(currentpage==n)
			html += '<li class="disabled"><a href="javascript:"><i class="fa fa-step-forward"></i>&nbsp;</a></li>';
		else
			html += '<li class="last" data-num="'+n+'" ><a href="javascript:"><i class="fa fa-step-forward"></i>&nbsp;</a></li>';
		obj.append(html);
		$(".pagination-box li").click(function(){
			if($(this).data("num")){
				$("#pagerForm [name=pageNum]").val($(this).data("num"));
				var jsFlag=$("#pagerForm").attr("jsFlag");//是否调用js函数的标识
				if(typeof(jsFlag) == "undefined"){
					$("#pagerForm").submit();
				}
				else{
					pageAjaxInit($(this).data("num"));
				}
			}
		});
	}

});