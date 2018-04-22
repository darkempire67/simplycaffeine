<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Current Orders</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />

</head>

<body>
	<div class="container">
		<h1 class="text-center">Current Orders</h1>

		<table class="table table-hover">
			<thead class="thead-dark text-center">
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Coffee</th>
					<th>Quantity</th>
					<th>Place</th>
					<th>Time</th>
					<th></th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${entries}" var="entry"> 
			<tr>
						<td class="text-center">${entry.id}</td>
						<td class="text-center">${entry.first}</td>
						<td class="text-center">${entry.coffeeName}</td>
						<td class="text-center">${entry.quantity}</td>
						<td class="text-center">${entry.building} &nbsp; ${entry.roomNumber}
						</td>
						<td class="text-center">${entry.hour}:${entry.minutes}&nbsp;
							${entry.period}</td>
						<td class="text-center btn btn-outline-success"><a
							href='Delivered?id=${entry.id}'> &radic; </a></td>
					</tr>
				</c:forEach>
	

			</tbody>
		</table>
	</div>

</body>

</html>
