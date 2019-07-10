<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
 <link rel="shortcut icon" href="img/lock_24px.ico" type="image/x-icon" />
<title>登录</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script>
	var __links = document.querySelectorAll('a');
	function __linkClick(e) {
		parent.window.postMessage(this.href, '*');
	};
	for (var i = 0, l = __links.length; i < l; i++) {
		if (__links[i].getAttribute('data-t') == '_blank') {
			__links[i].addEventListener('click', __linkClick, false);
		}
	}
</script>
<script src="js/jquery-3.4.1.js"></script>
<script src="js/login.js"></script>
<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
</head>
<body>
	<!-- contact-form -->
	<div class="message warning">
		<div class="inset">
			<div class="login-head">
				<h1 style="letter-spacing: 2px;">XXX权限管理系统</h1>
				<div class="alert-close"></div>
			</div>
			<form>
				<li><input type="text" class="text" placeholder="账号"><a
					href="#" class=" icon user"></a></li>
				<div class="clear"></div>
				<li><input type="password" placeholder="密码"> <a
					href="#" class="icon lock"></a></li>
				<div class="clear"></div>
				<div class="submit">
					<input type="submit" value="登&nbsp;&nbsp;&nbsp;录">
					<h4>
						<a href="#" style="letter-spacing: 2px;">忘记密码?</a>
					</h4>
					<div class="clear"></div>
				</div>

			</form>
		</div>
	</div>
	<div class="clear"></div>
	<!--- footer --->
	<div class="footer">
		<p>Copyright &copy; 2019.</p>
	</div>

</body>
</html>