<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Simply Caffeine</title>
<!--
 <script>
	$(window).scroll(function() {
		var scroll = $(window).scrollTop();
		$(".zoom img").css({
			width : (100 + scroll / 5) + "%",
			top : -(scroll / 10) + "%",
			//		transform: "translate3d(-50%, -"+(scroll/100)+"%, 0) scale("+(100 + scroll/5)/100+")",
			//Blur suggestion from @janwagner: https://codepen.io/janwagner/ in comments
			"-webkit-filter" : "blur(" + (scroll / 200) + "px)",
			filter : "blur(" + (scroll / 200) + "px)"
		});
	});
</script>
<style>
body {
	margin: 0px;
}

/* .header {
	width: 100%;
	height: 250px;
	overflow: hidden;
	background: #1C403E;
	position: fixed;
	vertical-align: middle;
}
 */
.zoom {
	overflow: hidden;
	padding-bottom: 55%;
	width: 100%;
	height: 250px;
	overflow: hidden;
	background: #1C403E;
	position: fixed;
	vertical-align: middle;
	padding-bottom: 55%;
	
	@media	(min-width:600px){	
	padding-bottom:	50%;
	}

@media ( min-width : 700px) {
	padding-bottom: 45%;
}

}
.zoom img {
	position: fixed;
	top: 0%;
	left: 50%;
	max-width: none;
	transform: translateX(-50%);
}

.content {
	/* position: fixed; */
	 height: 100%;
	width: 100%;
	top: 250px;
	overflow: auto;
	padding-top: 20px;
	margin-bottom: 20px;
	background: #723D46;
	text-align: center;
	color: #DDDDD9;
	padding: 1% 0;
	position: relative;
}

.choices {
	padding-bottom: 40px;
}

/*.picture{
    vertical-align: middle;
    display: table-cell;
}

.details{
    vertical-align: top;
    display: table-cell;
}*/
.picture img {
	max-width: 25%;
	min-width: 200px;
	height: auto;
}

input[type="text"] {
	width: 25px;
	margin-right: 20px;
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
</style>

</head>
 -->

<!-- 
	<header class="zoom">
		<img
			src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/logo/LOGOpage.jpg"
			height="250" />


	</header>
	
	 -->
<%-- 	<div class="header">
		<center>
			<img
				src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/logo/LOGOpage.jpg"
				height="250" />
		</center>
	</div> --%>


<title>Simply Caffeine</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	font: 400 15px Lato, sans-serif;
	line-height: 1.8;
	color: #818181;
}

h2 {
	font-size: 24px;
	text-transform: uppercase;
	color: #303030;
	font-weight: 600;
	margin-bottom: 30px;
}

h4 {
	font-size: 19px;
	line-height: 1.375em;
	color: #303030;
	font-weight: 400;
	margin-bottom: 30px;
}

.jumbotron {
	background-color: #1C403E;
	color: #fff;
	padding-bottom: 50px;
	font-family: Montserrat, sans-serif;
}

.container-fluid {
	padding: 60px 50px;
}

.bg-grey {
	background-color: #f6f6f6;
}

.logo-small {
	color: #1C403E;
	font-size: 50px;
}

.logo {
	color: #1C403E;
	font-size: 200px;
}

.thumbnail {
	padding: 0 0 15px 0;
	border: none;
	border-radius: 0;
}

.thumbnail img {
	width: 100%;
	height: 100%;
	margin-bottom: 10px;
}

.carousel-control.right, .carousel-control.left {
	background-image: none;
	color: #1C403E;
}

.carousel-indicators li {
	border-color: #1C403E;
}

.carousel-indicators li.active {
	background-color: #1C403E;
}

.item h4 {
	font-size: 19px;
	line-height: 1.375em;
	font-weight: 400;
	font-style: italic;
	margin: 70px 0;
}

.item span {
	font-style: normal;
}

.panel {
	border: 1px solid #1C403E;
	border-radius: 0 !important;
	transition: box-shadow 0.5s;
}

.panel:hover {
	box-shadow: 5px 0px 40px rgba(0, 0, 0, .2);
}

.panel-footer .btn:hover {
	border: 1px solid #1C403E;
	background-color: #fff !important;
	color: #1C403E;
}

.panel-heading {
	color: #fff !important;
	background-color: #1C403E !important;
	padding: 25px;
	border-bottom: 1px solid transparent;
	border-top-left-radius: 0px;
	border-top-right-radius: 0px;
	border-bottom-left-radius: 0px;
	border-bottom-right-radius: 0px;
}

.panel-footer {
	background-color: white !important;
}

.panel-footer h3 {
	font-size: 32px;
}

.panel-footer h4 {
	color: #aaa;
	font-size: 14px;
}

.panel-footer .btn {
	margin: 15px 0;
	background-color: #1C403E;
	color: #fff;
}

.navbar {
	margin-bottom: 0;
	background-color: #1C403E;
	z-index: 9999;
	border: 0;
	font-size: 12px !important;
	line-height: 1.42857143 !important;
	letter-spacing: 4px;
	border-radius: 0;
	font-family: Montserrat, sans-serif;
}

.navbar li a, .navbar .navbar-brand {
	color: #fff !important;
}

.navbar-nav li a:hover, .navbar-nav li.active a {
	color: #1C403E !important;
	background-color: #fff !important;
}

.navbar-default .navbar-toggle {
	border-color: transparent;
	color: #fff !important;
}

.picture img {
	max-width: 10%;
	min-width: 170px;
	height: auto;
}

footer .glyphicon {
	font-size: 20px;
	margin-bottom: 20px;
	color: #1C403E;
}

.slideanim {
	visibility: hidden;
}

.slide {
	animation-name: slide;
	-webkit-animation-name: slide;
	animation-duration: 1s;
	-webkit-animation-duration: 1s;
	visibility: visible;
}

@
keyframes slide { 0% {
	opacity: 0;
	transform: translateY(70%);
}

100%
{
opacity






:



 



1;
transform






:



 



translateY






(0%);
}
}
@
-webkit-keyframes slide { 0% {
	opacity: 0;
	-webkit-transform: translateY(70%);
}

100%
{
opacity






:



 



1;
-webkit-transform






:



 



translateY






(0%);
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

.checkout_panel {
	font-family: 'Montserrat', sans-serif;
	background: white;
	box-shadow: 20px 20px 20px 0 rgba(.2, .1, .2, .1);
}

.panel_body {
	font-family: 'Montserrat', sans-serif;
	opacity: .75;
	color: #1C403E;
	background: white;
}

.submitButton {
	position: fixed;
	bottom: -4px;
	right: 10px;
	border-radius: 10px;
	padding: 8px 12px;
	border: 2px solid #1C403E;
	background-color: white;
	color: black;
	-webkit-transition-duration: 0.s; /* Safari */
	transition-duration: 0.s;
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
	background-color: #1C403E; /* Green */
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
<body id="myPage" data-spy="scroll" data-target=".navbar"
	data-offset="60">

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#myPage">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#about">ABOUT</a></li>
					<li><a href="#PRODUCTS">PRODUCTS</a></li>
					<li><a href="#portfolio">PORTFOLIO</a></li>
					<li><a href="#checkout">CHECKOUT</a></li>
					<li><a href="#contact">CONTACT</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="jumbotron text-center">
		<img
			src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/logo/LOGOpage.jpg"
			width=50% height=auto>
		<h1>Simply Caffeine</h1>
		<p>We will deliver coffee to your class!</p>
	</div>

	<!-- Container (About Section) -->
	<div id="about" class="container-fluid">
		<div class="row">
			<div class="col-sm-30">
				<h2>About Simply Caffeine</h2>
				<br>
				<h4>Simply Caffeine is a mobile friendly website that will
					allow users to order coffee through a web interface and have it be
					delivered to the any classroom on campus. The intended market would
					be people who are held late during long lectures, those who
					had/have no time to grab coffee, or simply those that are too lazy.
					The customer will first be presented with a simple interface that
					will include: images of the drink options, a description of each
					drink, price per drink, and customers can buy multiples of each
					item as well. Once they have finalized their order they will be
					redirected to a secondary page, “Checkout” page, in which they will
					be presented with the estimated time of delivery and total cost.
					Once the order is placed the customer will be redirected again to a
					new page that will confirm their order has been processed and
					countdown of the estimated delivery time will be prompted.</h4>
				<br>
				<h4>When the order is processed the orders will be sent to a
					webpage only viewable to the coffee shop. This page will have a
					list of orders the coffee shop needs to deliver: name, item(s),
					delivery destination</h4>
				<br>
				<h4>A separate page will then be available to the delivery
					person where they can view the customer name, item name, and
					destination. Once they arrive at the class room, they will press a
					button that notifies the customer, through email, that their order
					has arrived.</h4>
				<br>
				<h4>Project Members: Cris Ramos, Gian Tolentino, Leonardo
					Gallegos, Vay Tang</h4>
				<br>
			</div>
		</div>
	</div>


	<!-- Container (Products Section) -->
	<div id="PRODUCTS" class="container-fluid text-center">
		<h2>Products</h2>
		<h4>What we offer</h4>
		<br>
		<div class="row slideanim">
			<div class="col-sm-6">
				<div class="choices">
					<div class="picture">
						<img
							src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/americano.jpg" />
					</div>

					<div class="details">
						<div class="description">
							<h3>Americano</h3>
							<h4>A drink comprised of espresso and hot water.</h4>
						</div>

						<div class="addorder">
							<form action="Homepage" method="post">
								Qty: <input type="text" name="quantity" id="americano" /> <input
									type="hidden" name="coffeeName" value="americano" />
								<button type="button" class="btn btn-primary">Add to
									Order</button>

							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="choices">
					<div class="picture">
						<img
							src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/cafemocha.jpg" />
					</div>

					<div class="details">
						<div class="description">
							<h3>Caffe Mocha</h3>
							<h4>A drink comprised of espresso and hot water.</h4>
						</div>
						<div class="addorder">
							Qty: <input type="text" name="quantity" id="caffemocha" /> <input
								type="hidden" name="coffeeName" value="caffemocha" />
							<button type="button" class="btn btn-primary">Add to
								Order</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row slideanim">
			<div class="col-sm-6">
				<div class="choices">
					<div class="picture">
						<img
							src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/caffelatte.jpeg" />
					</div>

					<div class="details">
						<div class="description">
							<h3>Caffe Latte</h3>
							<h4>A drink comprised of espresso and hot water.</h4>
						</div>

						<div class="addorder">
							Qty: <input type="text" name="quantity" id="caffelatte" /> <input
								type="hidden" name="coffeeName" value="caffelatte" />
							<button type="button" class="btn btn-primary">Add to
								Order</button>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-6">
				<div class="choices">
					<div class="picture">
						<img
							src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/espresso.jpg" />
					</div>

					<div class="details">
						<div class="description">
							<h3>Espresso</h3>
							<h4>A drink comprised of espresso and hot water.</h4>
						</div>

						<div class="addorder">
							Qty: <input type="text" name="quantity" id="espresso" /> <input
								type="hidden" name="coffeeName" value="espresso" />
							<button type="button" class="btn btn-primary">Add to
								Order</button>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Container (Portfolio Section) -->
	<div id="portfolio" class="container-fluid text-center bg-grey">
		<h2>Portfolio</h2>
		<br>
		<h4>What we have created</h4>
		<div class="row text-center slideanim">
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="paris.jpg" alt="Paris" width="400" height="300">
					<p>
						<strong>Paris</strong>
					</p>
					<p>Yes, we built Paris</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="newyork.jpg" alt="New York" width="400" height="300">
					<p>
						<strong>New York</strong>
					</p>
					<p>We built New York</p>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="thumbnail">
					<img src="sanfran.jpg" alt="San Francisco" width="400" height="300">
					<p>
						<strong>San Francisco</strong>
					</p>
					<p>Yes, San Fran is ours</p>
				</div>
			</div>
		</div>
		<br>
		<h2>What our customers say</h2>
		<div id="myCarousel" class="carousel slide text-center"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<h4>
						"WOW!! Best coffee on campus!!!"<br>
						<span>Michael Roe, Vice President, Comment Box</span>
					</h4>
				</div>
				<div class="item">
					<h4>
						"One word... WOW!!"<br>
						<span>John Doe, Salesman, Rep Inc</span>
					</h4>
				</div>
				<div class="item">
					<h4>
						"Could I... BE any more happy with this company?"<br>
						<span>Chandler Bing, Actor, FriendsAlot</span>
					</h4>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<!-- Container (checkout Section) -->
	<div id="checkout" class="container-fluid">


		<div class="checkout_panel form-group">
			<div class="panel_body">
				<form action="Homepage" method="post">
					<fieldset>
						<legend class="legendTag">
							 CheckOut....
						</legend>
						 <label for="Building"> <span>Building:</span>
							<strong><abbr title="required ">*</abbr></strong>
						</label> <input type="text" id="building" name="building" class="form-control"  placeholder="Enter Building Name"/><br /> <br />
						<label for="Room#"> <span>Room Number :</span> <strong><abbr
								title="required">*</abbr></strong>
						</label> <input type="text" id="roomNumber" name="roomNumber" class="form-control"  placeholder="Enter Room Number" /> <br />
					
						<div class="form-group row form-inline">
						<label for="hour"> <span> Hour</span>
						</label> <select class="col-sm-2 col-form-label form-control" id="hour" name="hour">
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

						</select> <label for="minutes"> <span> Minutes
						</span>
						</label> <select class="col-sm-2 col-form-label form-control" id="minutes" name="minutes">
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

						</select>  
						</div>
						<label for="am"> <input  class="form-check form-check-inline" type="radio"
							id="am" name="period" value="am" /> AM
						</label> <label for="pm"> <input class="form-check form-check-inline" type="radio" id="pm"
							name="period" value="pm" /> PM
						</label>
						 <br /> <br />
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
							<tbody id="checked">
								<c:forEach items="${coffeeEntries}" var="coffeeEntry">
									<tr>
										<td class="text-center">${coffeeEntry.id}</td>
										<td class="text-center">${coffeeEntry.coffeeName}</td>
										<td class="text-center">${coffeeEntry.quantity}</td>
										<td class="text-center">${coffeeEntry.cost}</td>
										<td class="text-center">${coffeeEntry.cost}</td>
										<%-- 	<td class="text-center">${coffeeEntry.period}</td> --%>
										<td class="text-center"><a
											href='Delivered?id=${coffeeEntry.id}'>Edit</a></td>
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

	</div>


	<!-- Container (Contact Section) -->
	<div id="contact" class="container-fluid bg-grey">
		<h2 class="text-center">CONTACT</h2>
		<div class="row ">
			<div class=" text-center">
				<p>Contact us and we'll get back to you within 24 hours.</p>
				<p>
					<span class="glyphicon glyphicon-map-marker"></span> Los Angeles, US
				</p>
				<p>
					<span class="glyphicon glyphicon-phone"></span> +1-323-500-0000
				</p>
				<p>
					<span class="glyphicon glyphicon-envelope"></span>
					simplyCaffeine@gmail.com
				</p>
			</div>
			
		</div>
	</div>

	
	

	<footer class="container-fluid text-center">
		<a href="#myPage" title="To Top"> <span
			class="glyphicon glyphicon-chevron-up"></span>
		</a>
	
	</footer>

	<script>
		$(document).ready(
				function() {
					// Add smooth scrolling to all links in navbar + footer link
					$(".navbar a, footer a[href='#myPage']").on('click',
							function(event) {
								// Make sure this.hash has a value before overriding default behavior
								if (this.hash !== "") {
									// Prevent default anchor click behavior
									event.preventDefault();
									// Store hash
									var hash = this.hash;
									// Using jQuery's animate() method to add smooth page scroll
									// The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
									$('html, body').animate({
										scrollTop : $(hash).offset().top
									}, 900, function() {

										// Add hash (#) to URL when done scrolling (default click behavior)
										window.location.hash = hash;
									});
								} // End if
							});

					$(window).scroll(function() {
						$(".slideanim").each(function() {
							var pos = $(this).offset().top;
							var winTop = $(window).scrollTop();
							if (pos < winTop + 600) {
								$(this).addClass("slide");
							}
						});
					});
				})
	</script>

	<!-- 	<div class="content">
		<form action="Homepage" method="post">
	
			<div class="submitButton">
				<input type="submit" name="order" value="Continue to checkout!" />
			</div>
		</form>
	</div> -->
</body>
</html>
