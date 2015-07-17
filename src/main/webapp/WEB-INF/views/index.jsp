<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<title>Starter Template for Bootstrap</title>

	<link href="<c:url value="/assets/css/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/assets/css/bootstrap-theme.min.css"/>" rel="stylesheet">

	<style>
		body {
			padding-top: 50px;
		}

		.starter-template {
			padding: 40px 15px;
			text-align: center;
		}
	</style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
				aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Project name</a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
			</ul>
		</div>
	</div>
</nav>

<div class="container">

	<div class="starter-template">
		<h1>Bootstrap starter template</h1>

		<p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a
			mostly barebones HTML document.</p>
	</div>

</div>

<script src="<c:url value="/assets/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
</body>
</html>
