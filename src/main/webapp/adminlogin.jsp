<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LongTail:BookShop</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
    <link rel="stylesheet" href="CSS/styleMain.css">
  
</head>
<body>


	<div class="mainContainer">
			
		<h3>Login as Admin</h3>
		<div class="box col-sm-4">
		 <form action="weblogin" method="post">
			User Name: <input required type="text" name="user_name" class="form-control" /><br />
			Password: <input required type="password" name="pass" class="form-control"/><br /> 
			<input type="submit" value="Login" class="btn btn-success"/>
			<input type="hidden" name="logintype" value="admin"/>	
		</form> 
		<span style="color: red">${err_msg}</span>
		</div>
	</div>
	<hr>

</body>
</html>