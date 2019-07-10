package cn.kgc.tangcco.zhangqing.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginFilter")
public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		// 用户访问当前项目的路径。
		String path = request.getServletPath();

		// 如果用户访问的页面是“login.jsp”
		if (path.equals("/login.jsp")) {
			arg2.doFilter(arg0, arg1);// 则过滤乱码
			return;// 不走下面的代码了。
		}
		// 如果当前用户名为空，则重定向到index.jsp页面
		if (request.getSession().getAttribute("hou_uName") == null
				|| "".equals(request.getSession().getAttribute("hou_uName"))) {
			response.sendRedirect("/quanxian0627/login.jsp");
		} else {// 否则就过滤乱码
			arg2.doFilter(arg0, arg1);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
