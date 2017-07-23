<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style/styles.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="./js/script.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<img class="icons" src="images/description/logo1.png" alt="logo"
				height="50" width="100" />
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav pull-right">
				<li><a href="login.jsp"><span
						class="glyphicon glyphicon-user"></span>Login Admin</a></li>
				<li><a href="logout"><span
						class="glyphicon glyphicon-user"></span>Logout</a></li>
						
				<li><a href="addCustomerInfo.jsp"><span
						class="glyphicon glyphicon-user"></span> Sign Up</a></li>

				<li><a href="CartController"> <img
					src="images/description/cart.jpg" alt="cart" name="shooping cart"
					height="40" width="40" />
				</a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div>

<div>
 <%@ taglib uri="/WEB-INF/tags.tld" prefix="m" %>  
Date and Time is: <m:today/> 
</div>

</div>

	<div class="container">
		<div class="col-md-3">
			<div class="top">
			<h3>Categories</h3>
			<h5>feauters in book</h5>
			<ul class="catlist" id="categories"></ul>
		</div>
		
		</div>
		<div class="col-md-9">
			<div class="pic" id="items">
		
			</div>
		</div>
	</div>
</body>
</html>