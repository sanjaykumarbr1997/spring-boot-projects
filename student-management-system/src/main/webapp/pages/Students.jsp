<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management System</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Student Management System</a>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="students">Student Management</a>
      </li>
      
    </ul>
  </div>
</nav>

<div class = "container">
	<div class = "row">
		<h1>List Students</h1>
		<h3>${display} </h3>
	</div>
	<div class = "row">
		<div class= "col-lg-3">
			<a href ="student/new" class = "btn btn-primary btn-sm mb-3" >Add Student</a>
		</div>
	
	</div>
	
	<table class="table table-striped table-bordered">
  <thead class= "table-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Student Name</th>
      <th scope="col">Student Age</th>
      <th scope="col">Student Email</th>
      <th scope="col">Actions</th>
    </tr>
    
    
  </thead>
  <tbody>
    <c:forEach var="members" items="${students}">

    <tr>
     
      			<td>${members.getId() }</td>
     			 <td>${members.getName() }</td>
				<td>${members.getAge()}</td>
				<td>${members.getEmail()}</td>
				<td>
					<a href="studentedit/${members.getId()}"
					class = "btn btn-primary">Update </a>
					
					<a href="studentedelete/${members.getId()}"
					class = "btn btn-danger">Delete </a>
				
				 </td>
    </tr>
    </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>