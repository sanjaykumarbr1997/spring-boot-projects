<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Reset Password</title>
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
		<a class="navbar-brand" href="#">Welcome to Reset Page</a>


	</nav>


	<div class="login-form">
		<form action="reset.all" method="post">

			<h2 class="text-center">Reset Password</h2>



			<div class="form-group">
				<input type="text" class="form-control" name="email"
					placeholder="Email Id"> <small class="small-text">${messageinfo}</small>
			</div>
			<div class="form-group">
				<input type="password" class="form-control" name="password"
					placeholder="Password"> <small class="small-text">${messageinfopassword}</small>

			</div>

			<div class="form-group">
				<input type="password" class="form-control" name="confirmPassword"
					placeholder="Confirm Password"> <small class="small-text">${messageinfoconfirmpassword}</small>

				<small class="small-text">${messagefromLoginController}</small>

			</div>


			<div class="form-group">
				<button type="submit" class="btn btn-primary btn-lg btn-block">Reset</button>
			</div>


		</form>
		<footer>
			<p>Copyright Sanjay Kumar BR@2021</p>
		</footer>
	</div>
</body>
</html>