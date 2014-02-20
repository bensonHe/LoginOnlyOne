package com.he.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 模拟登录
 * 
 * @author 何锦彬    QQ 277803242
 *
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO 用于模拟检测用户登录
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		if (name.equals("test01".trim()) && "123456".equals(password)) {
			request.getSession().setAttribute("userName", "test01");
		}
		response.sendRedirect("main.jsp");
	}

}
