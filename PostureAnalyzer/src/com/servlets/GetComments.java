package com.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.CommentSqlImplement;
import com.google.gson.Gson;
import com.imagedata.Comment;

/**
 * Servlet implementation class GetComments
 */
@WebServlet("/GetComments")
public class GetComments extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CommentSqlImplement dbActions;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetComments() {
        super();
        dbActions = new CommentSqlImplement();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		ArrayList<Comment> comments= dbActions.getAll();
//		for ( Topic i : topics)
//			System.out.println(i.getTitle());
		String gson = new Gson().toJson(comments);
	
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		//String json = JSONValue.toJSONString(topics);
		
		System.out.println(gson);
		
		response.getWriter().println(gson);
	}

}
