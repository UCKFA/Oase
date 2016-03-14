package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.ImageSqlImplement;
import com.google.gson.Gson;
import com.imagedata.UserImage;
import com.userdata.User;

/**
 * Servlet implementation class GetPosts
 */
public class GetPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ImageSqlImplement dbActions;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPosts() {
		super();
		dbActions = new ImageSqlImplement();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		ArrayList<UserImage> images = dbActions
				.getImagesForUser(((User) request.getSession().getAttribute("currentUser")).getId());
		String gson = new Gson().toJson(images);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println(gson);

	}

}
