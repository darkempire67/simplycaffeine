<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="icon" type="image/png" sizes="32x32" href="https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16" href="https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-16x16.png">

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