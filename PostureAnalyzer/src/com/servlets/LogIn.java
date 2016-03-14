package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.UserSqlImplement;
import com.userdata.Notification;
import com.userdata.User;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	UserSqlImplement dbActions;

	public LogIn() {
		super();
		dbActions = new UserSqlImplement();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		User user = new User(request.getParameter("email"),
				request.getParameter("password"));
		// System.out.println(user.getEmail() + user.getPassword());
		if ((user = dbActions.findUser(user.hashCode())) != null) {

			//loadUserLists(user);
			// user.addFriend(dbActions.findUser(106323914));
			// dbActions.loadFriendList(user.getFriendList(), user.getId());
			// System.out.println(user.getMyNotifications().get(0));

			// String notifications= new
			// Gson().toJson(user.getMyNotifications());

			request.getSession().setAttribute("currentUser", user);
			
			// request.getSession().setAttribute("notificationList",
			// notifications);
			Cookie userid = new Cookie("userId", "" + user.getId());
			userid.setMaxAge(60 * 60 * 24);

			response.addCookie(userid);

			response.sendRedirect("main.jsp");

		}

	}
/*
	@SuppressWarnings("unchecked")
	private void loadUserLists(User user) {
		user.setMyNotifications((ArrayList<Notification>) dbActions
				.getNotifications(user.getId()));

	}
	*/
}
