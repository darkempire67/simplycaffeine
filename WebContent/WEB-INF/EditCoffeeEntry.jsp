<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<div class="container">
	<form action="Edit" method="post">
		<input class="form-control" id="disabledInput" type="text"
			name="coffeeName" placeholder="${coffeeEntry.coffeeName}" disabled>
		<input type="text" name="quantity" value="${coffeeEntry.quantity}">
		<br> <input type="hidden" name="id" value="${coffeeEntry.id}">
		<br> <br> <input type="submit" value="Save">
	</form>
</div>
</body>
</html>