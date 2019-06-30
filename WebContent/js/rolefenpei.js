$(document).ready(function() {
	var global_uId=0;//全局uId
	var global_arr_rId=new Array(); 
	
	loadUser();
	loadRole();
	
	//加载权限
	function loadUser() {
		$.post("SelectUserServlet", "", function(json) {
			var i=1;
			$(json).each(function() {
				var $tr="<tr align='center'><td>"+i+"</td><td><input type='hidden' class='uId' value='"+this.uId+"'/>"+this.uName+"</td></tr>";
				$(".selectUser").append($tr);
				i++;
			});
			
			//姓名行点击事件
			$(".selectUser tr:gt(0)").click(function(){
				trClick($(this));
			});
			
			
		}, "json");
	}
	
	//姓名行点击方法
	function trClick($this){
		$(".selectUser tr:gt(0)").css("background-color","white");
		$this.css("background-color","#F2DEDE");
		//
		global_uId=$this.find(".uId").val();
		clearCheckboxStyle();
		$.post("SelectRIdByUIdServlet","uId="+global_uId,function(json){
			for(var i=0;i<json.length;i++){
				matchRoleId(json[i]);
			}
		},"json")
	}
	
	//根据uId匹配rId
	function matchRoleId(urId){
		var roleLi=$(".manageList li");
		var i=0;
		$(roleLi).each(function(){
			var rId=$(this).find(".rId").val();
			if(urId==rId){
				global_arr_rId[i]=rId;
				$(this).find("input[type='checkbox']+i").css("background-color","#2489c5");
			}
			i++;
		});
	}
	
	//清除角色复选框的样式
	function clearCheckboxStyle(){
		$(".quanXuan input[type='checkbox']+i").removeAttr("checked");
		$(".quanXuan input[type='checkbox']+i").css("background-color","white");
		$(".manageList").find("input[type='checkbox']+i").css("background","white");
	}
	
	//加载权限
	function loadRole() {
		$.post("SelectRoleServlet", "", function(json) {
			$(json).each(function() {
				var $li="<li><label><input type='checkbox'><i>✓</i>"+this.rName+"</label><input type='hidden' class='rId' value='"+this.rId+"'/></li>";
				$(".manageList").append($li);
			});
			//点击全选里面的角色
			$(".manageList li label input[type='checkbox']").click(function(){
				roleIsChecked($(this));
			});
		}, "json");
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
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").css("background-color","#2489c5");
		}else{
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").css("background-color","white");
		}
	});
	
	//实现角色反选
	function roleIsChecked($this){
		//判断当前选中角色的背景颜色
		var bgColor=$this.next().css("background-color");
		//alert(bgColor);
		if(bgColor=="rgb(36, 137, 197)"){//如果是蓝色，则变成白色
			$this.css("background-color","white");
			$this.next().css("background-color","white");
		}else if(bgColor=="rgb(255, 255, 255)"){//如果是白色，则变成蓝色
			$this.css("background-color","#2489c5");
			$this.next().css("background-color","#2489c5");
		}else{
			if($this.is(':checked')) {//如果点击状态，则变成蓝色的
				$this.css("background-color","#2489c5");
				$this.next().css("background-color","#2489c5");
			}else{
				$this.css("background-color","white");//否则白色的
				$this.next().css("background-color","white");
			}
		}
	}
	
	//更新按钮点击事件
	$(".btnURSave").click(function(){
		if(global_uId==0||global_arr_rId==""){
			alert("请为人员分配角色！");
			return;
		}
		alert(global_uId);
		//判断uId在UR表中是否存在
		//先删除uId
		$.post("ExistsUIdForURServlet2","uId="+global_uId,function(data){
			alert(data);
			if(data=="true"){
				//存在
				alert("存在");
			}else{
				//不存在
				alert("不存在");
			}
		})
		
		
		
		//再添加
		
		
	});
	
	function del_uIdForUR(){
		//先删除uId
		$("DeluIdServlet","uId="+global_uId,function(data){
			
		})
	}
	
	function add_uIdForUR(){
		//先删除uId
		$("DeluIdServlet","uId="+global_uId,function(data){
			
		})
	}
	
});