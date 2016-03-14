<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">



<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/mainStyle.css">
<link rel="stylesheet" type="text/css" href="css/formStyles.css">



<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="scripts/transitionScript.js"></script>
<script src="scripts/chatMethods.js"></script>
<script src="scripts/searchScript.js"></script>
<script src="scripts/notificationScript.js"></script>
<script src="scripts/postTopic.js"></script>
<script src="scripts/topicGenerator.js"></script>

<script>
	var u = "${currentUser.name }";
	var not = ${notificationList};
</script>


<title>MainPage</title>
</head>
<body>


	<div class="container-fluid">
		<nav class="navbar navbar-default" style="margin:0">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SocialChat</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li id="changeNew"><a href="#">Page 1</a></li>
					<li id="changeCars"><a href="#">Page 2</a></li>
					<li id="PostTopic"><a href="#">POST</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">

					<li><a href="#">${currentUser.name }, log out</a></li>

				</ul>
				<form class="navbar-form navbar-right search" role="search">
					<div class="form-group">
						<input class="form-control" id="search" placeholder="Find"
							type="text">
						<button class="btn">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</div>

				</form>

			</div>
		</div>
		</nav>




		<div class="container-fluid ">

			<div class="col-md-2 panel panel-default userInfo" id="userInfo">
				<div class="panel-heading">User info</div>
			</div>

			<div class="col-md-7 searchResults" id="results"></div>

			<div class="col-md-7 postTopicForm" id="postTopicForm"
				style="display: none;">
				<form class="form-horizontal" method="POST" action="AddTopic"
					enctype="multipart/form-data">
					<fieldset>
						<legend>Load Image</legend>
						<div class="form-group">
							<div class="col-lg-10">
								<input type="file" class="form-control" name="file" />
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
							<button type="reset" class="btn btn-default"
								style="margin-top: 10px;" id="cancelPost">Cancel</button>
						</div>
					</fieldset>
				</form>
			</div>


			<div class=" col-md-7 topics" id="topicContainer">/* STUFF IS
				ADDED HERE */</div>







			<div class="col-md-3" id="chat">
				<ul class="nav nav-tabs">

					<li class="dropdown"><a aria-expanded="false"
						class="dropdown-toggle" data-toggle="dropdown" href="#"> <span
							class="plus"> <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#dropdown1" data-toggle="tab">Action</a></li>
							<li class="divider"></li>
							<li><a href="#dropdown2" data-toggle="tab">Another
									action</a></li>
						</ul></li>
				</ul>
				<div id="myTabContent" class="tab-content"></div>


				<form action="">

					<input id="userInput" type="text" name="textArea"
						placeholder="Text " autocomplete="off"> <input
						class="subimt" id="send" type="button" name="commit" value="Send">

				</form>
			</div>



			<div class="col-md-3 panel panel-default friendList" id="friendList">
				<div class="panel-heading">Friends</div>


			</div>

		</div>




		<div class="footer">THERE WILL BE A FOOTER HERE</div>
	</div>

</body>
</html>