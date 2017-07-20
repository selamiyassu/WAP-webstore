<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href=../style/loginformworing.css type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div id="pic">
		<img src="../images/logo.png" alt="Long Tail Books account logo picture"
			height="50px" width="200px" />
	</div>
	<div id="login">

		<form action="javascript:void(0);" method="get">


			<fieldset>
				<h1>
					<strong>Sign in</strong>
				</h1>
				Username</br>
				<p>
					<input type="text" name="Username"
						onBlur="if(this.value=='')this.value='Username'"
						onFocus="if(this.value=='Username')this.value='' ">
				</p>
				<p class="par">! Enter your name</p>
				Password </br>
				<p>
					<input type="password" name="Password"
						pattern="((?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,})"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters"
						onBlur="if(this.value=='')this.value='Password'"
						onFocus="if(this.value=='Password')this.value='' ">
				</p>
				<p class="par">! Enter your Password</p>
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


	</div>
</body>
</html>