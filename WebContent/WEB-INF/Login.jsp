<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">

<link rel="icon" type="image/png" sizes="32x32"
	href="https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-32x32.png">

<link rel="icon" type="image/png" sizes="16x16"
	href="https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-16x16.png">
<title>Login</title>
<style>
@keyframes slide { 0% {
	opacity: 0;
	transform: translateY(70%);
}

100%
{
opacity: 1;
transform: translateY(0%);
}
}
@-webkit-keyframes slide { 0% {
	opacity: 0;
	-webkit-transform: translateY(70%);
}

100%
{
opacity: 1;
-webkit-transform: translateY (0%);
}
}
@media screen and (max-width: 768px) {
	.col-sm-4 {
		text-align: center;
		margin: 25px 0;
	}
	.btn-lg {
		width: 100%;
		margin-bottom: 35px;
	}
}

@media screen and (max-width: 480px) {
	.logo {
		font-size: 150px;
	}
}
.jumbotron {
	background-color: #1C403E;
	color: #fff;
	padding-bottom: 2px;
	padding-top: 2px;
	font-family: Montserrat, sans-serif;
}


.picture img {
	max-width: 10%;
	min-width: 170px;
	height: auto;
}
</style>


</head>

<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<div class="jumbotron text-center">
		<img
			src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/oldfiles/logo/LOGOpage.jpg"
			width=20% height=10%>
		<h3>Simply Caffeine</h3>
		<p>We will deliver coffee to your class!</p>
	</div>
	<div class="container">

		<h1 class="display-3">Login</h1>

		<form action="Login" method="post">
			<c:if test="${ not empty loginError }">

				<p class="text-danger">Invalid username and/or password.</p>

			</c:if>
			<div class="form-group">
				<label for="email">E-mail Address</label> <input
					class="form-control" type="email" name="email" id="email"
					placeholder="Enter your e-mail address">
			</div>
			<div class="form-group">
				<label for="password">Credit Card Number</label> <input
					class="form-control" type="password" name="password" id="password"
					placeholder="Enter your last 4-digit credit card number">
			</div>

			<div class="form-group">

				<button type="submit" class="btn btn-primary">Login</button>

			</div>
		</form>

		<p>
			Don't have an account? <a href="Register">Sign-Up!</a>
		</p>

	</div>

</body>

</html>
