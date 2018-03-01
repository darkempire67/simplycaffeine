<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Simply Caffeine</title>
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

<body>
	<header class="zoom">
		<img
			src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/logo/LOGOpage.jpg"
			height="250" />


	</header>
	<%-- 	<div class="header">
		<center>
			<img
				src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/logo/LOGOpage.jpg"
				height="250" />
		</center>
	</div> --%>

	<div class="content">
		<form action="Homepage" method="post">
		<div class="choices">
			<div class="picture">
				<img
					src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/americano.jpg" />
			</div>

			<div class="details">
				<div class="description">
					<h1>Americano</h1>
					<h3>A drink comprised of espresso and hot water.</h3>
				</div>

				<div class="addorder">
					 Qty: <input type="text" name="quantity" id="americano" />
						<input type="hidden" name="coffeeName" value="americano" />
					<button type="button" > Add to Order</button>
				</div>
			</div>
		</div>

		<div class="choices">
			<div class="picture">
				<img
					src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/cafemocha.jpg" />
			</div>

			<div class="details">
				<div class="description">
					<h1>Caffe Mocha</h1>
					<h3>A drink comprised of espresso and hot water.</h3>
				</div>

				<div class="addorder">
					 Qty: <input type="text" name="quantity" id="caffemocha" />
					<input type="hidden" name="coffeeName"	value="caffemocha" />
					<button type="button">Add to Order</button>
				</div>
			</div>
		</div>

		<div class="choices">
			<div class="picture">
				<img
					src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/caffelatte.jpeg" />
			</div>

			<div class="details">
				<div class="description">
					<h1>Caffe Latte</h1>
					<h3>A drink comprised of espresso and hot water.</h3>
				</div>

				<div class="addorder">
					Qty: <input	type="text" name="quantity" id="caffelatte" />
						<input type="hidden" name="coffeeName"	value="caffelatte" /> 
					<button type="button" >Add to Order</button>
				</div>
			</div>
		</div>

		<div class="choices">
			<div class="picture">
				<img
					src="https://raw.githubusercontent.com/giantolentino/simplycaffeine/master/menu/espresso.jpg" />
			</div>

			<div class="details">
				<div class="description">
					<h1>Espresso</h1>
					<h3>A drink comprised of espresso and hot water.</h3>
				</div>
				<!-- value = cost -->
				<div class="addorder">
					
					Qty: <input type="text"	name="quantity" id="espresso" />
						<input type="hidden" name="coffeeName" value="espresso" />
					<button type="button" >Add to Order</button>
				</div>
			</div>
		</div>
			<div class="submitButton">
					<input type="submit" name="order" value="Continue to checkout!" />
				</div>
			</form>
	</div>
</body>
</html>
