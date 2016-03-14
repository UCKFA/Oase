package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbstuff.UserSqlImplement;
import com.google.gson.Gson;
import com.userdata.Notification;
import com.userdata.User;

/**
 * Servlet implementation class NotificationServlet
 */
public class NotificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private UserSqlImplement userDbActions;

	public NotificationServlet() {
		super();
		userDbActions = new UserSqlImplement();
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
		String data = request.getParameter("data");
		String[] users = data.split(",");
		response.setContentType("application/json");

		if (users[3].equals("friendRequest")) {
			response.getWriter().println(handleFriendRequest(users));

		} else if (users[3].equals("rejectrequest")) {
			handleRejectRequest(users);
		} else {
			handleAcceptRequest(users);
		}

	}

	private void handleRejectRequest(String[] users) {
		User userA = userDbActions.findUser(users[0]);
		User userB = userDbActions.findUser(users[1]);
		
		
		updateNotificationLists(userA, users[2]);
		updateNotificationLists(userB, users[2]);
		
		
		
	}

	private void handleAcceptRequest(String[] users) {

		User userA = userDbActions.findUser(users[0]);
		User userB = userDbActions.findUser(users[1]);


		updateNotificationLists(userA, users[2]);
		updateNotificationLists(userB, users[2]);
		// String lists=new Gson().toJson(userB.getFriendList());
		// lists+="|"+new Gson().toJson(userB.getMyNotifications());
		// System.out.println(lists +"asdasdasda");
		// return lists;

	}

	@SuppressWarnings("unchecked")
	private void updateNotificationLists(User a, String notid) {
		int id = Integer.parseInt(notid);
		// System.out.println(id);

		a.setMyNotifications((List<Notification>) userDbActions
				.getNotifications(a.getId()));
		a.removeNotification(id);
		userDbActions.loadNotifications(a.getMyNotifications(), a.getId());

	}

	
	@SuppressWarnings("unchecked")
	private String handleFriendRequest(String[] users) {

		User userA = userDbActions.findUser(users[0]);
		User userB = userDbActions.findUser(users[1]);

		userA.setMyNotifications((List<Notification>) userDbActions
				.getNotifications(userA.getId()));

		Notification n = new Notification("Friend request", userB.getName(),
				userA.getName());
		userA.addNotification(n);

		userDbActions.loadNotifications(userA.getMyNotifications(),
				userA.getId());

		userB.setMyNotifications((List<Notification>) userDbActions
				.getNotifications(userB.getId()));

		int id = n.getId();
		// System.out.println("id:"+id);
		n = new Notification(id, userA.getName(), "Pending");
		userB.addNotification(n);
		userDbActions.loadNotifications(userB.getMyNotifications(),
				userB.getId());
		System.out.println(this.getClass().getName() + ": "
				+ new Gson().toJson(userB.getMyNotifications()));
		return new Gson().toJson(userB.getMyNotifications().get(
				userB.getMyNotifications().size() - 1));

	}

}
