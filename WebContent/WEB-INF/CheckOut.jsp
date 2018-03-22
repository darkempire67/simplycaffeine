<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Check Out</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<style>
.checkout_panel {
	font-family: 'Montserrat', sans-serif;
	background: white;
	box-shadow: 20px 20px 20px 0 rgba(.2, .1, .2, .1);
}

.panel_body {
	font-family: 'Montserrat', sans-serif;
	opacity: .75;
	color: darkgreen;
	background: white;
}

.submitButton {
	position: fixed;
	bottom: -4px;
	right: 10px;
	border-radius: 12px;
	padding: 10px 30px;
	border: 2px solid #4CAF50;
	background-color: white;
	color: black;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
}

input[type=submit] {
	border: none;
	padding: 16px 32px;
	text-decoration: none;
	margin: 4px 2px;
	cursor: pointer;
	background-color: white;
}

.submitButton:hover, input[type=submit]:hover {
	background-color: #4CAF50; /* Green */
	color: white;
}

.submitButton:active {
	background-color: #3e8e41;
	color: black;
	box-shadow: 0 5px #666;
	transform: translateX(20px);
}

.legendTag {
	font-family: cursive;
	font-size: 30px;
	font-weight: bold;
	color: darkgreen;
	font-weight: bold;
}
</style>
</head>
<body>


	<div class="checkout_panel">
		<div class="panel_body">
			<form action="CheckOut" method="post">
				<fieldset>
					<legend class="legendTag"> <br/> CheckOut.... </legend>
					<br /> <br /> <label for="Building"> <span>Building:</span>
						<strong><abbr title="required ">*</abbr></strong>
					</label> <input type="text" id="building" name="building" /><br /> <br />
					<label for="Room#"> <span>Room Number :</span> <strong><abbr
							title="required">*</abbr></strong>
					</label> <input type="text" id="roomNumber" name="roomNumber" /> <br /> <br />



					<!-- 	<p> -->
					<!-- 	<label for = "Time"> -->
					<!-- 	<span>Time to be delivered: </span> -->
					<!-- 	<strong><abbr title="required">*</abbr></strong> -->
					<!-- 	</label>  -->
					<!-- 	<input type ="text" id="time_" name="time"> -->
					<!-- 	</p> -->

					<label for="hour"> <span>Hour:</span>
					</label> <select id="hour" name="hour">
						<option value="1">01</option>
						<option value="2">02</option>
						<option value="3">03</option>
						<option value="4">04</option>
						<option value="5">05</option>
						<option value="6">06</option>
						<option value="7">07</option>
						<option value="8">08</option>
						<option value="9">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>

					</select> <br /> <br /> <label for="minutes"> <span>Minutes:
					</span>
					</label> <select id="minutes" name="minutes">
						<option value="00">00</option>
						<option value="05">05</option>
						<option value="10">10</option>
						<option value="15">15</option>
						<option value="20">20</option>
						<option value="25">25</option>
						<option value="30">30</option>
						<option value="35">35</option>
						<option value="40">40</option>
						<option value="45">45</option>
						<option value="50">50</option>
						<option value="55">55</option>

					</select> <br /> <br /> <label for="am"> <input type="radio"
						id="am" name="period" value="am" /> AM
					</label> <label for="pm"> <input type="radio" id="pm" name="period"
						value="pm" /> PM
					</label> <br /> <br />
					<h3>this is what you ordered...........................</h3>


					<table class="table table-hover">
						<thead class="thead-dark text-center">
							<tr>
								<th>Id</th>
								<th>Coffee</th>
								<th>Quantity</th>
								<th>Cost</th>
								<th>Total Cost</th>
								<th></th>

							</tr>
						</thead>
						<tbody id="checked" >
							<c:forEach items="${coffeeEntries}" var="coffeeEntry">
								<tr>
									<td class="text-center">${coffeeEntry.id}</td>
									<td class="text-center">${coffeeEntry.coffeeName}</td>
									<td class="text-center">${coffeeEntry.quantity}</td>
									<td class="text-center">${coffeeEntry.cost}</td>
								<td class="text-center">${coffeeEntry.cost}</td>
								<%-- 	<td class="text-center">${coffeeEntry.period}</td> --%>
									<td class="text-center"><a href='Delivered?id=${coffeeEntry.id}'>Edit</a></td>
								</tr>
							</c:forEach>

						</tbody>
					</table>

				</fieldset>

				<div class="submitButton">
					<input type="submit" name="order" value="Order my Coffee!" />
				</div>
			</form>

		</div>
	</div>

</body>
</html>
