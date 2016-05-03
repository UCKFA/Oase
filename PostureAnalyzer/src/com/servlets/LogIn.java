package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.UserSqlImplement;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.userdata.User;

/**
 * Servlet implementation class LogIn
 */
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	protected UserSqlImplement dbActions;

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
		
		doAction(request, response);
		

	}
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws JsonIOException, JsonSyntaxException, IOException{
		JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
		response.setContentType("application/json");
		
		
		User user = new User(obj.get("email").getAsString(),
				obj.get("password").getAsString());
		 
		if ((user = dbActions.findUser(user.hashCode())) != null) {
			response.getWriter().println(new Gson().toJson(user));
		
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
