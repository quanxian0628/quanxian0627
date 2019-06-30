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
import cn.kgc.tangcco.zhangqing.entity.User;
import cn.kgc.tangcco.zhangqing.service.UserService;
import cn.kgc.tangcco.zhangqing.service.impl.UserServiceImpl;

@WebServlet("/SelectUserServlet")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		UserService us = (UserService) PropertiesFactory.getInstance("UserService");

		//UserService us=new UserServiceImpl();
		
		List<User> rList = us.selectUser();

		String json = JSON.toJSONString(rList);

		response.getWriter().print(json);

	}

}
