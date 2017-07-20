<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href=../style/loginform.css type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div id="pic">
		<img src="../images/logo.png" alt="Long Tail Books account logo picture"
			height="50px" width="200px" />
	</div>
	<div id="login">

		<form action="../LoginController" method="post">


			<fieldset>
				<h1>
					<strong>Sign in</strong>
				</h1>
				<h5>Username</h5>
				<p>
					<input type="text" name="user_name"
						onBlur="if(this.value=='')this.value='Username'"
						onFocus="if(this.value=='Username')this.value='' ">
				</p>
				<h5>Password</h5> 
				<p>
					<input type="password" name="pass"
						pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,})"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters"
						onBlur="if(this.value=='')this.value='Password'"
						onFocus="if(this.value=='Password')this.value='' ">
				</p>
				<p>
					<input type="submit" value="Sign in">
				</p>
				<p>
					<input type="checkbox" value="Keep Me Signed In" />Keep me signed
					in.
				</p>
				
				<p id="new">New to Long Tail Books account?</p>

				<button id="but">
					<a href="registerform.jsp">Create your Long Tail Books AccounT</a>
				</button>
			</fieldset>
		</form>
	<span style="color: red">${err_msg}</span>

	</div>

</body>
</html>