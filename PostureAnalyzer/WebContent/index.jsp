<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/loginStyle.css">
<link rel="stylesheet" type="text/css" href="css/formStyles.css">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="scripts/transitionScript.js"></script>

<title>Welcome</title>
</head>

<body>
	<div class="container">
		<div class="login" id="login">
			<h1>Login</h1>
			<form method="POST" action="LogIn">
				<p>
					<input type="text" name="email" value="" placeholder="Email ">
				</p>
				<p>
					<input type="password" name="password" value=""
						placeholder="Password">
				</p>
				<p class="submit">
					<button type="button" name="commit" id="registerButton">Register</button>
					<input type="submit" name="commit" value="Login">
				</p>
			</form>
		</div>


		<div class="register" id="register" style="display: none;">
			<h1>Register</h1>
			<form method="POST" action="Register">
				<p>
					<input type="text" name="username" placeholder="Username">
				</p>
				<p>
					<input type="password" name="password" placeholder="Password">
				</p>
				<p>
					<input type="password" name="repeatPassword"
						placeholder="Repeat Password">
				</p>
				<p>
					<input type="text" name="email" placeholder="Email">
				</p>
				<p class="submit">
					<input type="submit" name="commit" value="Register">
				</p>
			</form>
		</div>
	</div>

	</div>

</body>
</html>