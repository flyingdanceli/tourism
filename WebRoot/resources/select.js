$(function(){
	$("select").each(function(){
		if($(this).data("value")==undefined){
			return;
		}
		$(this).find("option[value='"+$(this).data("value")+"']").prop("selected",true);
	});
});
