//清除文本框
function clearText() {
	$("#content").val("");
}
//提交内容
function sub() {
	let email = $("#email").val();
	let content = $("#content").val();
	console.log(email);
	console.log(content);
	$.ajax({

    });
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