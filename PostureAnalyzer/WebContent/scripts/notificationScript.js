/**
 * 
 */

function loadFriendRequestNotification(notification) {

	$("#userInfo").append(
			$(
					"<div class=\"panel-body friendRequest\" id=\"notificationTab\" 	data-user="
							+ notification.from + " data-notid="
							+ notification.id + "></div>").text(notification.type + ":" + notification.from));

}

function loadPendingNotification(notification) {
	$("#userInfo")
			.append($("<div class=\"panel-body notificationTab \" id=\"notificationTab\"></div>").text(notification.type + ": friend request to  "+ notification.to));
}


function sendFriendRequest(user) {

	var newNot="";
	$.ajax({
		type : "post",
		url : "NotificationServlet",
		data : "data=" + user + "," + u + ",0,friendRequest",
		success : function(response) {
			newNot=eval(response);
			loadPendingNotification(newNot);
			console.log("request sent");
		}

	});

}

function acceptFriendRequest(user, notid) {

	loadFriend(user);
	$.ajax({
		type : "post",
		url : "NotificationServlet",
		data : "data=" + user + "," + u + "," + notid + ",acceptRequest",
		dataType:"text",
		success : function() {
			
				console.log("request accepted");

		}
		
	

	});
}

function rejectFriendRequest(user,notid){
	$.ajax({
		type : "post",
		url : "NotificationServlet",
		data : "data=" + user + "," + u + "," + notid + ",rejectRequest",
		dataType:"text",
		success : function() {
			
				console.log("request accepted");

		}
		
	

	});
	
}

function initNotifications() {
	console.log(not + "Notification current state");

	$("#userInfo").find(".friendRequest").remove();

	for ( var notification in not) {
		console.log(not[notification].type);
		if (not[notification].type != "Pending") {
			loadFriendRequestNotification(not[notification]);

		} else {
			console.log("i try to append them.................");
			loadPendingNotification(not[notification]);

		}
	}
	$(".friendRequest")
			.append(
					"<span class=\" glyphicon glyphicon-ok\" onclick='acceptFriendRequest($(this).parent().data(\"user\"),$(this).parent().data(\"notid\")); $(this).closest(\"div\").fadeOut((300, function() { $(this).remove(); })) '></span>");
	$(".friendRequest").append(
			"<span class=\" glyphicon glyphicon-remove\" onclick='rejectFriendRequest($(this).parent().data(\"user\"),$(this).parent().data(\"notid\")); $(this).closest(\"div\").fadeOut((300, function() { $(this).remove(); }))'></span>");

}

$(window).load(function() {

	initNotifications();

});
