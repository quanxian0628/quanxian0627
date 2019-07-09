$(document).ready(function() {
	var global_uId=0;//全局uId
	var global_arr_rId=new Array();//全局的id
	
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
		global_arr_rId=new Array();//清空数组1
		global_arr_rId2=new Array();//清空数组2
		checkedCount=0;//每换一个人，checkedCount清0。
		
		$(".selectUser tr:gt(0)").css("background-color","white");
		$this.css("background-color","#F2DEDE");
		//
		global_uId=$this.find(".uId").val();
		clearCheckboxStyle();
		$.post("SelectRIdByUIdServlet","uId="+global_uId,function(json){
			var matchId=0;
			for(var i=0;i<json.length;i++){
				//matchRoleId(json[i]);
				var roleLi=$(".manageList li");
				
				$(roleLi).each(function(){
					var rId=$(this).find(".rId").val();
					if(json[i]==rId){
						global_arr_rId[matchId]=rId;
						$(this).find("input[type='checkbox']+i").css("background-color","#2489c5");
						matchId++;
					}
				});
			}
			
			//alert("数组1："+global_arr_rId.toString()+"==="+"数组2："+global_arr_rId2.toString());
			
		},"json")
	}
	
	//根据uId匹配rId
	function matchRoleId(urId){
		
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
		global_arr_rId2=new Array();//清空数组2
		if($(this).is(':checked')) {
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").css("background-color","#2489c5");
		}else{
			$(this).parents("li").find(".manageList").find("input[type='checkbox']+i").css("background-color","white");
		}
	});
	
	var checkedCount=0;
	//实现角色反选
	function roleIsChecked($this){
		global_arr_rId2=new Array();//清空数组2
		//判断当前选中角色的背景颜色
		var bgColor=$this.next().css("background-color");
		//alert(bgColor);
		if(bgColor=="rgb(36, 137, 197)"){//如果是蓝色，则变成白色
			$this.css("background-color","white");
			$this.next().css("background-color","white");
		}else if(bgColor=="rgb(255, 255, 255)"){//如果是白色，则变成蓝色
			$this.css("background-color","#2489c5");
			$this.next().css("background-color","#2489c5");
			//alert("隐藏的id："+$this.parent().next().val());
			global_arr_rId[checkedCount]=$this.parent().next().val();
		}else{
			if($this.is(':checked')) {//如果点击状态，则变成蓝色的
				$this.css("background-color","#2489c5");
				$this.next().css("background-color","#2489c5");
				//alert("隐藏的id222："+$this.parent().next().val());
				global_arr_rId[checkedCount]=$this.parent().next().val();
			}else{
				$this.css("background-color","white");//否则白色的
				$this.next().css("background-color","white");
			}
		}
		checkedCount++;
		//alert("checkedCount==="+checkedCount);
	}
	
	//更新按钮点击事件
	$(".btnURSave").click(function(){
		global_arr_rId2=new Array();//清空数组2
		if(global_uId==0||global_arr_rId==""){
			alert(global_uId+"---长度："+global_arr_rId.length);
			alert("请为人员分配角色！");
			return;
		}
		//alert(global_uId);
		//判断uId在UR表中是否存在
		//先删除uId
		$.post("ExistsUIdForURServlet2","uId="+global_uId,function(data){
			//alert(data);
			if(data=="true"){
				//存在
				//alert("存在");
				//情况1：没有变更
				//情况2：有变更（先删除，再添加）
				getCurRoleId(global_arr_rId);
			}else{
				//不存在，直接添加
				//alert("不存在，直接添加");
				global_arr_rId2=global_arr_rId;//把数组1给数组2
				add_uIdForUR();
			}
		})
		
		
		
		//再添加
		
		
	});
	
	//判断是否有变更
	var global_arr_rId2=new Array();
	var ckCount=0;
	function getCurRoleId(global_arr_rId){
		ckCount=0;
		var roleLi=$(".manageList li");
		
		$(roleLi).each(function(){
			var bgColor=$(this).find("input[type='checkbox']+i").css("background-color");
			if(bgColor=="rgb(36, 137, 197)"){
				var cur_rId=$(this).find(".rId").val();
				global_arr_rId2[ckCount]=cur_rId;
				//alert(ckCount+"次数");
				ckCount++;
			}
		});
		
		//alert("数组一："+global_arr_rId.sort().toString()+"====数组二："+global_arr_rId2.sort().toString());
		
		if(ckCount!=global_arr_rId.length){
			//有变更（先删除，再添加）
			//alert("有变更（先删除，再添加）");
			del_uIdForUR();
		}else{
			
			if(global_arr_rId.sort().toString()==global_arr_rId2.sort().toString()){
				alert("人员角色无变更！");
			}else{
				//有变更（先删除，再添加）
				//alert("有变更（先删除，再添加）2222222222222222");
				del_uIdForUR();
			}
		}
		
	}
	
	//在ur表中先删除rId
	function del_uIdForUR(){
		$.post("DeluIdServlet","uId="+global_uId,function(data){
			if(data=="true"){
				//alert("删除成功！");
				//数组长度不为2，才添加
				if(global_arr_rId2.length!=0){
					add_uIdForUR();
				}else{
					alert("更新成功，此人已无任何权限！");
				}
			}else{
				//alert("删除失败！");
				alert("更新失败！");
			}
		})
	}
	
	//在ur表中再添加rId
	function add_uIdForUR(){
		$.post("AddURServlet","uId="+global_uId+"&arr2="+global_arr_rId2,function(data){
			if(data=="true"){
				alert("更新成功！");
				//alert("添加成功！");
			}else{
				//alert("添加失败！");
				alert("更新失败！");
			}
		})
	}
	
});