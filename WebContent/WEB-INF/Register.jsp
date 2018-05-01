<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="icon" type="image/png" sizes="32x32"
	href="https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-32x32.png">

<link rel="icon" type="image/png" sizes="16x16"
	href="https://raw.githubusercontent.com/giantolentino/simplycaffeine/test/WebContent/WEB-INF/favicon-16x16.png">

<title>Register</title>
</head>

<body>

	<div class="container ">
		<h1 class="display-1 ">Register</h1>

		<form action="Register " method="post ">
			<%-- 		<c:choose>
				<c:when test="${param.enter=='1'}">
        pizza. 
        <br />
				</c:when>
				<c:otherwise>
        pizzas. 
        <br />
				</c:otherwise>
			</c:choose> --%>

			<div class="form-group">
				<label for="name">Full Name</label>
				<c:choose>
					<c:when test="${not empty nameError}">
						<input class="form-control is-invalid" value=""${param.name}""
							type="text" name="name" id="name"
							placeholder="Enter your first and last names">

						<div class="invalid-feedback">${nameError}</div>
					</c:when>
					<c:otherwise>
						<input class="form-control" type="text" value="" ${param.name}""
							name="name" id="name"
							placeholder="Enter your first and last names">
					</c:otherwise>
				</c:choose>

			</div>

			<div class="form-group">
				<label for="email">E-mail Address</label>
				<c:if test="${not empty emailError}">

					<input class="form-control is-invalid " value="" ${param.email}
						type="email " name="email " id="email "
						placeholder="Enteryoure-mailaddress ">

					<div class="invalid-feedback ">${emailError}</div>
				</c:if>
				<input class="form-control " value="" ${param.email} type="email "
					name="email " id="email " placeholder="Enter your e-mail address ">

			</div>

			<div class="form-group ">
				<label for="password ">Credit Card Number</label>
				<c:if test="${not empty passwordError }">

					<input class="form-control is-invalid " value=""
						${param.password1 } type="password " name="password1 "
						id="password1 " placeholder="Enter your credit card number ">
					<div class="invalid-feedback ">${passwordError}</div>
				</c:if>
				<input class="form-control " value="" ${param.password1}
					type="password " name="password1 " id="password1 "
					placeholder="Enter your credit card number ">
			</div>

			<div class="form-group ">
				<label for="password ">Re-Enter Credit Card Number</label> <input
					class="form-control " value="" ${param.password2} type="password "
					name="password2 " id="password2 "
					placeholder="Re-enter your credit card number ">
			</div>

			<div class="form-group ">

				<button type="submit" class="btn btn-primary ">Register</button>

			</div>

		</form>

		<p>
			Already have an account? <a href="Login ">Login</a>
		</p>

	</div>

</body>
</html>
