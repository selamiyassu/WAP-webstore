<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>product detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="CSS/styleMain.css">

</head>
<body>
		<div class="mainContainer">
				<img style="float: left" alt="product_image" src="${book.image}" height="200px" width="200px">
				<br /><p><strong> ${book.title} </strong><em> by </em> <strong> ${book.author}</strong></p>
				<p><em>${book.price}</em>
				</p>
				
		
			<a href="HomeController?action=addToCart&bookId=<c:out value="${book.id}"/>">Add To Cart</a>
			|| <a href="index.jsp">Back to list of books</a>
		</div>
		
	
</body>
</html>