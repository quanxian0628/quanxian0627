<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<link rel="shortcut icon" href="img/lock_24px.ico" type="image/x-icon" />
<title>人员角色分配</title>
<link rel="stylesheet" type="text/css" href="css/xihua.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script src="js/jquery-3.4.1.js" type="text/javascript"></script>
<script src="js/xihua.js" type="text/javascript"></script>
</head>

<body>
	<h1>
		人员权限细化 ☞ <a href="rolefenpei.jsp">跳转至“人员角色分配”页面</a>
	</h1>

	<div class="role_main">
		<!--下面是左边的开始-->
		<div class="role_left">
			<table class="table table-bordered table-hover selectUser">
				<tr align="center" class="trOne">
					<td>序号</td>
					<td>角色</td>
				</tr>
			</table>
		</div>
		<!--上面是左边的结束-->
		<!--下面是中间的开始-->
		<div class="role_center">
			<ul>
				<li class="quanXuan"><input type="checkbox" id="checkbox_all"/> <label for="checkbox_all">全选</label>
					<a href="javascript:void(0)" class="qieHuan">折叠</a>
					<ul class="manageList">
					</ul>
				</li>
			</ul>
		</div>
		<!--上面是中间的结束-->
		<!--下面是右边的开始-->
		<div class="role_right">
			<button class="btn btn-info btn-lg btnRMSave">更 新</button>
		</div>
		<!--上面是右边的结束-->
		<div class="clear"></div>
	</div>

</body>

</html>