$(function(){
    $.ajax({
        xhrFields: {
            withCredentials: true
        },
        type:"POST",
        url:ajaxurl+"user/userinfo",
        dataType:"json",
        contentType:"application/json",
        data:{},
        success:function (data) {
            // $(".user_head_img").attr("src",data.headImage);
            $(".user_name").html(data.realname);
        }
    });
});