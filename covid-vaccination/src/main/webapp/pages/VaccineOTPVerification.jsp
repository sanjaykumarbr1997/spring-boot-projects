<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Student Login</title>
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
		<a class="navbar-brand" href="#">Welcome to OTP verification Page</a>


	</nav>


	<div class="login-form">
		<form action="verify.all" method="post">



			<h2 class="text-center">EMAIL CONFIRMATION</h2>


			<div class="form-group">
				<input type="text" class="form-control" name="otp" placeholder="OTP">
			</div>
			<small class="small-text">> Please enter OTP sent to verify
				your email</small> <br> <small class="small-text">${otpmessage}</small>

			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg btn-block">Verify
					Otp</button>
			</div>

		</form>


		<div>
			<footer className="footert">
				<span className="text-muted">All rights reserved @Sanjay
					Kumar BR</span>

			</footer>

		</div>
	</div>
</body>
</html>