<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=../style/registerform.css type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div id="pic">
		<img src="../images/logo.png" alt="Long Tail Books account logo picture"
			height="50px" width="200px" />
	</div>
	<div id="register">

		<form action="javascript:void(0);" method="get">


			<fieldset>
				<h1>
					<strong>Create account</strong>
				</h1>
				your name
				<p>
					<input type="text" name="Username">
				</p>
				Email 
				<p>
					<input type="text" name="Email">
				</p>
				Password 
				<p>
					<input type="password" name="Password"
						pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,})"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters">
				</p>
				Re-enter password 
				<p>
					<input type="password" name="Password"
						pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,})"	title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters">
				</p>

				<button ID="but">
					<a href="worringregisterform.html">Create your Long Tail Books
						accoun</a>
				</button>
				<p>
					Already have an account?<a href="woringregister.jsp">Sign in</a>
				</p>

			</fieldset>
		</form>


	</div>
</body>
</html>