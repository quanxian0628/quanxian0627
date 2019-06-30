package cn.kgc.tangcco.zhangqing.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.service.User_RoleService;

@WebServlet("/SelectRIdByUIdServlet")
public class SelectRIdByUIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int uId = Integer.valueOf(request.getParameter("uId"));

		User_RoleService ms = (User_RoleService) PropertiesFactory.getInstance("User_RoleService");
		
		List<Integer> rList = ms.getRIdByUId(uId);
		
		response.getWriter().print(JSON.toJSONString(rList));
	}
}
