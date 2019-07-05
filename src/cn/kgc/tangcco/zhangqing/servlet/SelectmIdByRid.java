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
import cn.kgc.tangcco.zhangqing.service.Role_MenuService;

@WebServlet("/SelectmIdByRid")
public class SelectmIdByRid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Role_MenuService rms = (Role_MenuService) PropertiesFactory.getInstance("Role_MenuService");

		Integer rId = Integer.valueOf(request.getParameter("rId"));

		//System.out.println(rId);
		
		List<Integer> mList = rms.getMidByRid(rId);

		String json=JSON.toJSONString(mList);
		//System.out.println(json);
		response.getWriter().print(json);
	}

}
