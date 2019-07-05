$(document).ready(function() {
	var global_rId=0;//全局rId
	var global_arr=new Array();//全局的数组
	var global_arr2=new Array();//全局的数组2
	loadRole();
	loadMenu();

	//加载用户
	function loadRole() {
		$.post("SelectRoleServlet", "", function(json) {
			var i=1;
			$(json).each(function() {
				var $tr="<tr align='center'><td>"+i+"</td><td><input type='hidden' class='rId' value='"+this.rId+"'/>"+this.rName+"</td></tr>";
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
	var matchId=0;//匹配id
	function trClick($this){
		//当点击每行时，取消全选
		$("input[type='checkbox']").prop("checked",false);
		
		$(".selectUser tr:gt(0)").css("background-color","white");
		$this.css("background-color","#F2DEDE");
		
		global_arr=new Array();
		global_arr2=new Array();
		matchId=0;
		
		//将当前选中行的rId赋值给全局的rId
		global_rId=$this.find(".rId").val();
		
		$.post("SelectmIdByRid","rId="+global_rId,function(json){
			
			if(json.length==0){
				$(".manageList li").find("input[type='checkbox']").prop("checked",false);
				return;
			}
			for(var i=0;i<json.length;i++){
				
				var menuLi=$(".manageList li");
				var ckI=1;
				$(menuLi).each(function(){
					var mId=$(this).find(".mId").val();
					if(json[i]==mId){
						$(this).find("input[id='checkbox"+ckI+"']").prop("checked",true);
						global_arr[matchId]=mId;
						//alert("mId："+mId+"===(i)"+i);
						matchId++;
						if(matchId==menuLi.length){
							$(".quanXuan input[type='checkbox']").prop("checked",true);
						}
					}else{
						//$(this).find("input[id='checkbox"+ckI+"']").prop("checked",false);
						//alert("60行，进来了");
					}
					ckI++;
				});
			}
			//alert(global_arr.toString());
			
			global_arr2=new Array();//数组2清空
			//将数组1的内容赋值给数组2
			for(var i=0;i<global_arr.length;i++){
				global_arr2[i]=global_arr[i];
			}
		},"json");
	}
	
	//加载用户
	function loadMenu() {
		$.post("SelectMenuServlet", "", function(json) {
			var i=1;
			$(json).each(function() {
				var $ck="<li><input type='checkbox' id='checkbox"+i+"'/> <label for='checkbox"+i+"'>"+this.mName+"["+this.mURL+"]</label><input type='hidden' class='mId' value='"+this.mId+"'/></li>";
				$(".manageList").append($ck);
				i++;
			});
			
			$(".manageList li").css({"height":"30px","line-height":"30px"});
			
			//菜单单个选择
			$(".manageList li input[type='checkbox']").click(function(){
				menuIsChecked($(this));
			});
			
		}, "json");
	}
	
	//菜单单个选择
	function menuIsChecked($this){

		//global_arr2=global_arr;//将数组1给数组2
		
		var mId=$this.next().next().val().trim();
		
		
		/////////////////////
		
		if($this.is(':checked')){
			//alert("117行！！！");
			
			//alert("数组2的长度："+global_arr2.length);
			global_arr2[global_arr2.length]=mId;
			
			if(global_arr2.length==$(".manageList li").length){
				$(".quanXuan>input[type='checkbox']").prop("checked",true);
			}
			
			//alert("数组2："+global_arr2.toString());
			//alert(global_arr.sort().toString()+"==="+global_arr2.sort().toString());
			
		}else{
			var hidMid=$this.next().next().val().trim();
			//判断数组中是否包含某值。如果包含则返回下标（从0开始计算），否则返回-1
			var isIndex=$.inArray(hidMid,global_arr2);
			if(isIndex!=-1){
				//alert("123行！！！");
				//删除数组里面的元素
				for (var i = 0; i < global_arr2.length; i++) {
					if (global_arr2[i] == hidMid) {
						//alert("127行，进来了");
						global_arr2.splice(i, 1);
						//alert("删除后的数组："+global_arr2.sort().toString());
						break;
					}
				}
				if(global_arr2.length<$(".manageList li").length){
					//alert(111);
					$(".quanXuan>input[type='checkbox']").prop("checked",false);
				}
			}
		}
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
			$(this).parents("li").find(".manageList").find("input[type='checkbox']").prop("checked",true);
			//如果rId不为0
			if(global_rId!=0){
				//循环遍历，将li里面的值赋给数组2
				for(var i=0;i<$(".manageList li").length;i++){
					var hidMid=$(".manageList li input[id='checkbox"+(i+1)+"']").next().next().val().trim();
					global_arr2[i]=hidMid;
				}
			}
		}else{
			$(this).parents("li").find(".manageList").find("input[type='checkbox']").prop("checked",false);
			if(global_rId!=0){
				global_arr2[i]=new Array();
			}
		}
	});
	
	//更新
	$(".btnRMSave").click(function(){
		
		alert(global_arr.sort().toString()+"==="+global_arr2.sort().toString());
		
	});
	
});