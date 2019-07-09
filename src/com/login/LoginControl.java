package com.login;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.student.Student;
import com.student.StudentDao;

public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher resJsp;

	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		resJsp = context.getRequestDispatcher("/WEB-INF/jsps/welcome.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String u1 = request.getParameter("username");
		String u2 = request.getParameter("password");
		Student s1 = StudentDao.getDetails(u1, u2);
		request.setAttribute("result1", s1);
		if(s1!=null) {
			resJsp.forward(request, response);
		}
		response.sendRedirect("failed.html");

	}

}
