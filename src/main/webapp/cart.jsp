<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart...</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="CSS/styleMain.css">

</head>
<body>

	<div class="mainContainer">
		
	<h3>List of selected products </h3></h4>
	<table class="table table-hover" >
		<thead>
			<tr>
				<th>Book Title</th>
				<th>Book Author</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart.books}" var="book">
				<tr>
					<td><c:out value="${book.title}" /></td>
					<td><c:out value="${book.author}" /></td>
					<td><c:out value="${book.price}" /></td>
 					<td><form  action="CartController" method="POST" >
 							<input type="hidden" name="bookId" value=<c:out value="${book.id}"/> />
 							<input type="submit" name="remove" value="Remove From Cart" class="btn btn-primary"/>
 						
 						</form>
 					</td>
 												 
				</tr>
			</c:forEach>
		</tbody>
	</table>
<c:if test="${ cart.books[0] != null }">
	<p><a href="AddressController">Continue to Billing and Shipping Address</a></p>
</c:if>
	</div>
<a href="index.jsp">Go To Main Page</a>
</body>
</html>