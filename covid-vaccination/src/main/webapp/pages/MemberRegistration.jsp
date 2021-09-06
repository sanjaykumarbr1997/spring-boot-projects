<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Member registration</title>
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
		<a class="navbar-brand" href="#">Welcome to Member Registration
			Page</a>

	</nav>


	<h5 class="success">${ messagetodisplay}</h5>

	<div class="login-form">
		<form action="savememberdetails.all" method="post">



			<h2 class="text-center">Enter Details</h2>
			<div class="form-group">
				<input type="text" class="form-control" name="nameOfMember"
					placeholder="Name"> <small class="small-text">${messageenrollname}</small>
			</div>

			<div class="form-group">
				<label>Gender</label> <br> <input type="radio"
					name="genderOfMember" value="Male">Male <input type="radio"
					name="genderOfMember" value="Female">Female <small
					class="small-text">${messageenrollgender}</small>
			</div>

			<div class="form-group">
				<input type="number" class="form-control" name="aadharOfMember"
					placeholder="Aadhar Number"> <small class="small-text">${messageenrollaadhar}</small>
			</div>

			<div class="form-group">
				<input type="number" class="form-control" name="mobileNoOfMember"
					placeholder="Mobile Number"> <small class="small-text">${messageenrollmobile}</small>
			</div>




			<div class="form-group">
				<select class="form-control" name="typeOfVaccine">
					<option>Select vaccine type</option>
					<option value="Covaxin">Covaxin</option>
					<option value="Covishield">Covishield</option>
					<option value="Sputnik V">Sputnik V</option>
				</select> <small class="small-text">${messageenrolltype}</small> </select> <small
					class="small-text">${message}</small>
			</div>



			<div class="form-group">
				<button id="submit" type="submit"
					class="btn btn-primary btn-lg btn-block">Submit Details</button>
				<input type="reset" value="Clear">
			</div>


		</form>

		<footer>
			<p>Copyright Sanjay Kumar BR@2021</p>
		</footer>
	</div>

</body>
</html>