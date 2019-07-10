package cn.kgc.tangcco.zhangqing.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.service.UserService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		String uName = request.getParameter("uName");
		String uPwd = request.getParameter("uPwd");

		//System.out.println("进来了：" + uName + "，" + uPwd);

		UserService us = (UserService) PropertiesFactory.getInstance("UserService");
		boolean bo = us.login(uName, uPwd);

		if (bo == true) {
			request.getSession().setAttribute("hou_uName", uName);
		}

		response.getWriter().print(bo);

	}

}
