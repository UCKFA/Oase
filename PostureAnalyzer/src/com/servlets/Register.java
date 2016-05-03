package com.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.userdata.User;

/**
 * Servlet implementation class Register
 */

public class Register extends LogIn {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3520193582868313883L;
	
	 public Register() {
		super();
	}
	
	protected void doAction(HttpServletRequest request,
			HttpServletResponse response) throws JsonIOException, JsonSyntaxException, IOException{
		
		JsonObject obj = (JsonObject) new JsonParser().parse(request.getReader());
	 System.out.println(obj);
		response.setContentType("application/json");
		
		
		User user = new User( obj.get("name").getAsString(),
				obj.get("surname").getAsString(),			
				obj.get("email").getAsString(),
				obj.get("birthDate").getAsString(),
				obj.get("password").getAsString()
				);
		
		user.setId(user.hashCode());
		System.out.println(user.toString());
		dbActions.addItem(user);
		

		
		 
		
		
	}
}
