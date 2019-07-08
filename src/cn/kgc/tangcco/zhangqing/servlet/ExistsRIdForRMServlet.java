package cn.kgc.tangcco.zhangqing.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.zhangqing.common.PropertiesFactory;
import cn.kgc.tangcco.zhangqing.service.Role_MenuService;

@WebServlet("/ExistsRIdForRMServlet")
public class ExistsRIdForRMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int rId = Integer.valueOf(request.getParameter("rId"));

		Role_MenuService rms = (Role_MenuService) PropertiesFactory.getInstance("Role_MenuService");

		boolean bo = rms.existsRidForRM(rId);

		response.getWriter().print(bo);

	}

}
