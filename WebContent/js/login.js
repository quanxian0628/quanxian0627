$(document).ready(function () {

	$("form").submit(function () {

		var uName = $("input[type=text]").val().trim();
		var uPwd = $("input[type=password]").val().trim();

		var json = { "uName": uName, "uPwd": uPwd };

		$.post("LoginServlet", json, function (data) {
			if (data =="true") {
				alert("欢迎您："+uName+"！");
				location.href = "rolefenpei.jsp";
			} else {
				alert("登录失败！");
			}
		});
		return false;
	});
});