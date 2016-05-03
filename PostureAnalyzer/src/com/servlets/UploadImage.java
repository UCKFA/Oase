package com.servlets;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.dbstuff.ImageSqlImplement;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.imagedata.UserImage;
import com.imageprocess.Analyzer;
import com.userdata.User;

import javafx.geometry.Point2D;

/**
 * Servlet implementation class AddTopic
 */
@MultipartConfig
public class UploadImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ImageSqlImplement dbActions;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadImage() {
		super();
		dbActions = new ImageSqlImplement();
		// TODO Auto-generated constructor stub
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
		/*
		 * response.setContentType("text/html");
		 * 
		 * Topic topic = new Topic(request.getParameter("title"),
		 * request.getParameter("content"), -1);
		 * System.out.println(request.getParameter("file"));
		 * dbActions.addItem(topic);
		 */
		
		
		UserImage image;
		User user = (User) request.getSession().getAttribute("currentUser");
		response.setContentType("multipart/form-data");
		

		Part filePart = request.getPart("file");
		Part points = request.getPart("points");
		BufferedReader in = new BufferedReader(new InputStreamReader(points.getInputStream()));
		//JSONObject j = (JSONObject) JSONValue.parse(in.readLine().toString());
	
		Point2D[] p = new Gson().fromJson(new Gson().toJson(in.readLine()),Point2D[].class);
		System.err.println(new Gson().toJson(in.readLine()));
		
		
		if (filePart.getSize() != 0) {
			InputStream fileContent = filePart.getInputStream();
			BufferedImage subjectImage = ImageIO.read(fileContent);

			ArrayList<Point2D> m = new ArrayList<>();
			m.addAll(Arrays.asList(new Point2D(88, 144), new Point2D(412, 179), new Point2D(152, 285),
					new Point2D(322, 291), new Point2D(122, 483), new Point2D(355, 458), new Point2D(260, 86),
					new Point2D(245, 164), new Point2D(239, 440)));
			Analyzer.analyze(subjectImage, m);

			FileOutputStream output = new FileOutputStream(getServletContext().getRealPath("/") + "/files/"
					+ java.io.File.separator + filePart.getSubmittedFileName());

			ImageIO.write(subjectImage, "png", output);

		//	image = new UserImage(user.getId() , "files/" + filePart.getSubmittedFileName(), m);
			//dbActions.addItem(image);

		}

		//response.sendRedirect("main.jsp");

	}

}
