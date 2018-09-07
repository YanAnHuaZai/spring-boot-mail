//清除文本框
function clearText() {
	$("#content").val("");
}
//提交内容
function sub() {
	let email = $("#email").val();
	let content = $("#content").val();
	if (email!=null && email.trim()!="" && content!=null && content.trim()!="") {
        $.ajax({
            url: "sendSimpleEmail",
            data: {email: email,content: content},
            type: "POST",
            dataType: "json",
            success: function (data) {
                if (data.code==1) {
                    alert("发送成功");
                    $("#content").val("");
                }else {
                    alert(data.msg);
                }
            },
            error: function () {
                alert("出现错误,请稍后再试");
            }
        });
    }else {
	    alert("请填写完整哦");
    }
	return false;
}

//牺牲chrome自动填充表单的功能 //form加上autocomplete="off" 忽略chrome自动填充
// $(function() {
//     if (navigator.userAgent.toLowerCase().indexOf("chrome") >= 0) {
//         $(window).load(function(){
//             $('input').each(function(){
//                 var outHtml = this.outerHTML;
//                 $(this).append(outHtml);
//             });
//         });
//     }
// });