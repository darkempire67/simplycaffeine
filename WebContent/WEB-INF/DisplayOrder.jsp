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

 <!-- <style>
 .body {
	
   background-image: url("image/background.jpg");
	
}

#header {
	width: 100%;
	height: 30px;
	background-color: coral;
	padding-bottom: 30px;
	text-align: center;
}

table.GeneratedTable {
	width: 40%;
	background-color: #FFFFFF;
	border-collapse: collapse;
	border-width: 1px;
	border-color: sandybrown;
	border-style: solid;
	color: #000000;
	display: inline-table;
	vertical-align: top;
}

table.GeneratedTable td, table.GeneratedTable th {
	border-width: 1px;
	border-color: #336600;
	border-style: solid;
	padding: 2px;
}

table.GeneratedTable thead {
	background-color: sandybrown;
	padding-top: 25px;
}
</style>  -->



<!-- <script>
function myFunction() {
    document.getElementById("checked").style.color = "red";
}
</script> -->
</head>

<body>
	<div class="container">
		<h1 class="text-center">Current Orders</h1>

		<table class="table table-hover">
			<thead class="thead-dark text-center">
				<tr>
					<th>Order Number</th>
					<th>Building</th>
					<th>Room Number</th>
					<th>Hour</th>
					<th>Minutes</th>
					<th>Period</th>
					<th>Done</th>
				</tr>
			</thead>
			<tbody id="checked">
				<c:forEach items="${entries}" var="entry">
					<tr>
						<td class="text-center">${entry.id}</td>
						<td class="text-center">${entry.building}</td>
						<td class="text-center">${entry.roomNumber}</td>
						<td class="text-center">${entry.hour}</td>
						<td class="text-center">${entry.minutes}</td>
						<td class="text-center">${entry.period}</td>
						<td class="text-center btn btn-primary"><a href='Delivered?id=${entry.id}'>Delivered</a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

</body>

</html>
