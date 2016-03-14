package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.UserSqlImplement;
import com.userdata.User;

/**
 * Servlet implementation class Register
 */

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserSqlImplement dbActions;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
		dbActions = new UserSqlImplement();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		User user = new User(request.getParameter("email"),
				request.getParameter("password"),
				request.getParameter("username"),
				"M",
				"09-05-1994");
		user.setId(user.hashCode());

		dbActions.addItem(user);
		response.sendRedirect("index.jsp");
		// }

	}

}
