package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.CommentSqlImplement;
import com.imagedata.Comment;

/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	CommentSqlImplement dbActions;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddComment() {
		super();
		dbActions = new CommentSqlImplement();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		System.out.println("HERE");
		System.out.println(request.getParameter("content"));
		System.out.println(request.getParameter("user-id"));
		System.out.println(request.getParameter("topic-id"));
		Comment comment = new Comment(request.getParameter("content"),
				Integer.parseInt(request.getParameter("user-id")),
				Integer.parseInt(request.getParameter("topic-id")));
				
		dbActions.addItem(comment);

		response.sendRedirect("main.jsp");
	}

}
