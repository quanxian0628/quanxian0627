$(document).ready(function() {
	loadUser();
	loadRole();
	
	//加载权限
	function loadUser() {
		$.post("SelectUserServlet", "", function(json) {
			var i=1;
			$(json).each(function() {
				var $tr="<tr align='center'><td>"+i+"</td><td><input type='hidden' class='rId' value='"+this.uId+"'/>"+this.uName+"</td></tr>";
				$(".selectUser").append($tr);
				i++;
			});
			
			//姓名行点击事件
			$(".selectUser tr").click(function(){
				trClick($(this));
			});
			
			
		}, "json");
	}
	
	//加载权限
	function loadRole() {
		$.post("SelectRoleServlet", "", function(json) {
			$(json).each(function() {
				var $li="<li><label><input type='checkbox'><i>✓</i>"+this.rName+"</label></li>";
				$(".manageList").append($li);
			});
			

			$(".manageList li label input[type='checkbox']").click(function(){
				alert("方块");
				roleIsChecked($(this));
			});
			$(".manageList li label i").click(function(){
				//roleIsChecked2($(this));
			});
			
		}, "json");
	}
	
	//姓名行点击方法
	function trClick($this){
		$(".selectUser tr:gt(0)").css("background-color","white");
		$this.css("background-color","#F2DEDE");
	}
	
	//折叠
	var count=0;
	$(".quanXuan .qieHuan").click(function(){
		count++;
		if(count%2==1){
			$(this).next().slideUp();
			$(this).text("展开");
		}else{
			$(this).next().slideDown();
			$(this).text("隐藏");
		}
	});
	
	//全选/全不选
	$(".quanXuan input[type='checkbox']").click(function(){
		if($(this).is(':checked')) {
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").css("background","#2489c5");
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").prop("checked",true);
			alert(1);
		}else{
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").css("background","white");
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").prop("checked",false);
			alert(2);
		}
	});
	
	//实现角色反选
	function roleIsChecked($this){
		if($this.is(':checked')) {
			$this.css("background-color","#2489c5");
			$this.next().css("background-color","#2489c5");
			alert("下拉框 蓝色");
		}else{
			$this.css("background-color","white");
			$this.next().css("background-color","white");
			alert("下拉框 白色");
		}
	}
});