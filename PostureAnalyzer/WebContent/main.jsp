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



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="scripts/transitionScript.js"></script>
<script src="scripts/searchScript.js"></script>
<script src="scripts/postTopic.js"></script>
<script src="scripts/topicGenerator.js"></script>
<script src="scripts/imageCoordSelectorScript.js"></script>

<script>
	var u = "${currentUser.name }";
</script>


<title>MainPage</title>
</head>
<body>


	<div class="container-fluid">
		<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Oase</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li id="PostTopic"><a href="#">UPLOAD IMAGE</a></li>
					<li id="specialist_form"><a href="#">CONTACT SPECIALIST</a></li>
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
			<div class="col-md-7">
			
				<div class="searchResults" id="results"></div>

				<div  id="postTopicForm"
					style="display: none;">
					<form class="form-horizontal" method="POST" action="UploadImage"
						enctype="multipart/form-data" onsubmit="return  getImageCoordinates()">
						<fieldset>
							<legend>Load Image</legend>
							<div class="form-group">
								<div class="col-lg-10">
									<input type="file"  id="inputFileToLoad" class="form-control" name="file" />
								</div>
								<button type="submit" class="btn btn-primary">Submit</button>
								<button type="reset" class="btn btn-default" id="cancelPost">Cancel</button>
							</div>
						</fieldset>
					</form>
				</div>
				
				<div class="searchResults" id="topicContainer"></div>
			</div>
			<div class="col-md-3 panel panel-default notifications"
				id="notifications">
				<div class="panel-heading">Notifications</div>
			</div>



		
		</div>
</body>
</html>