
$(document).ready(function(){
	
	
	
	$.ajax({
		url:'user/login',
		data:{"userName":"admin","password":"123456","role":"1001"},
		type:'post',
		dataType:'json',
		success:function(result){
			alert("aaa");
			console.log(result);
		},
		error:function(err){
			console.log(err);
		}
	});
	
	
	
});