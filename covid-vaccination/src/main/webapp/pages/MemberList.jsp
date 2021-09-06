<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>List Of Members</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">


</head>
<body>

	<nav
		class="navbar navbar-expand-md bg-dark navbar-dark justify-content-between">
		<a id="white-text" class="navbar-brand">Welcome</a> <a
			class="btn btn btn-primary btn-lg" href="logout.all">Logout</a>

	</nav>



	<h1>${success}</h1>

	<div class="container">
		<div class="row">
			<h1>List Of Vaccinated Members</h1>
			<h3>${display}</h3>
		</div>

		<table class="table table-striped table-bordered">
			<thead class="table-dark">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Aadhar</th>
					<th>Mobile No</th>
					<th>Type of Vaccine</th>
					<th>Actions</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="members" items="${listOfMembers }">

					<tr>
						<td>${members.getId() }</td>
						<td>${members.getNameOfMember() }</td>
						<td>${members.getGenderOfMember()}</td>
						<td>${members.getAadharOfMember()}</td>
						<td>${members.getMobileNoOfMember() }</td>
						<td>${members.getTypeOfVaccine() }</td>
						<td><a href="memberedit/${members.getId()}.all"
							class="btn btn-primary">Update </a> <a
							href="memberdelete/${members.getAadharOfMember()}.all" class="btn btn-danger">Delete
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>



	<footer>
		<p>Copyright Sanjay Kumar BR@2021</p>
	</footer>
</body>
</html>