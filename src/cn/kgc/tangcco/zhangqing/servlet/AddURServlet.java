package cn.kgc.tangcco.zhangqing.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.service.User_RoleService;

@WebServlet("/AddURServlet")
public class AddURServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 参数一：uId
		int uId = Integer.valueOf(request.getParameter("uId"));
		String str=request.getParameter("arr2");
		
		// 参数二：String[]类型数组
		String[] arr2 = str.split(",");

		//System.out.println("uId:" + uId);

		/*
		 * for (String string : arr2) { System.out.print(string + "  "); }
		 */

		//System.out.println();
		// 创建泛型集合
		List<Integer> arr2List = new ArrayList<Integer>();
		// 将String[]存入List<Integer>中
		for (int i = 0; i < arr2.length; i++) {
			//System.out.println("39行："+arr2[i]);
			arr2List.add(Integer.valueOf(arr2[i]));
		}

		User_RoleService ms = (User_RoleService) PropertiesFactory.getInstance("User_RoleService");
		boolean bo = ms.addUR(uId, arr2List);
		
		response.getWriter().print(bo);
	}

}
