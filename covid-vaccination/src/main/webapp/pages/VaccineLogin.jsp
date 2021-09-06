<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Vaccine Login</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./css/main.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="#">Welcome to Login Page</a>


	</nav>

	<h5 class="success">${ succesregistrationmessage}</h5>

	<div class="login-form">
		<form action="login.all" method="post">

			<h2 class="text-center">Log In</h2>



			<div class="form-group">
				<input type="text" class="form-control" name="email"
					placeholder="Email Id"> <small class="small-text">${messageinfo}</small>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password"
					placeholder="Password"> <small class="small-text">${messageinfopassword}</small>

				<small class="small-text">${messagefromLoginController}</small>


			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
			</div>
			<p class="anchor-text">
				Don't have an account? <a href=getloginpage.all>Sign up here!</a>
			</p>
			<p class="anchor-text">
				Forgot Password? <a href=getResetPage.all>Click here to reset
					password!</a>
			</p>

		</form>

		<div>
			<footer className="footert">
				<span>All rights reserved @Sanjay Kumar BR</span>

			</footer>

		</div>

	</div>


</body>
</html>