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
import cn.kgc.tangcco.zhangqing.entity.Role;
import cn.kgc.tangcco.zhangqing.service.RoleService;

@WebServlet("/SelectRoleServlet")
public class SelectRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");

		RoleService rs = (RoleService) PropertiesFactory.getInstance("RoleService");
		
		//RoleService rs=new RoleServiceImpl();
		
		List<Role> rList = rs.selectRole();

		String json = JSON.toJSONString(rList);

		response.getWriter().print(json);

	}

}
