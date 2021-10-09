<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
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

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/students">Student Management</a>
      </li>
      
    </ul>
  </div>
</nav>

	<div class = "container">
		<div class = "row">
			<div class = "col-lg-6 col-md-6 col-sm-6 container justify-content-center card">
				<h1 class ="text-center"> Update New Student</h1>
					<div class = "card-body">
					<form action="/studentsUpdate/${update.getId()}" method="post">
					<div class = "form-group">
					<input type="text" name = "name" value= " ${update.getName()}" class="form-control"></div>
					<div class = "form-group">
					<input type="text" name = "age" value="${update.getAge()}" class="form-control"></div>
					<div class = "form-group">
					<input type="email" name = "email" value="${update.getEmail()}" class="form-control"></div>					
					<div class = "box-footer">
						<button type="submit" class = "btn btn-primary">Update Details</button>
					
					</div>
					
					</form>
					</div>
			</div>
				
		</div>
	
	</div>

</body>
</html>