<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring-mvc" %>
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
			padding-top: 40px;
			padding-bottom: 40px;
			background-color: #eee;
		}

		.form-signin {
			max-width: 330px;
			padding: 15px;
			margin: 0 auto;
		}

		.form-signin .form-signin-heading,
		.form-signin .checkbox {
			margin-bottom: 10px;
		}

		.form-signin .checkbox {
			font-weight: normal;
		}

		.form-signin .form-control {
			position: relative;
			height: auto;
			-webkit-box-sizing: border-box;
			-moz-box-sizing: border-box;
			box-sizing: border-box;
			padding: 10px;
			font-size: 16px;
		}

		.form-signin .form-control:focus {
			z-index: 2;
		}

		.form-signin input[type="email"] {
			margin-bottom: -1px;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 0;
		}

		.form-signin input[type="password"] {
			margin-bottom: 10px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
		}
	</style>
</head>

<body>

<div class="container">

	<form class="form-signin" action="<c:url value='/login'/>" method="POST">

		<h2 class="form-signin-heading">Please sign in</h2>

		<c:if test="${param.error != null}">
			<div class="error">
				<p>Login error: <c:out value="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}"/><br>
					Please try again.</p>
			</div>
		</c:if>

		<label for="username" class="sr-only">Username</label>
		<input type="text" name="username" id="username" class="form-control" placeholder="username" required autofocus>
		<label for="password" class="sr-only">Password</label>
		<input type="password" name="password" id="password" class="form-control" placeholder="Password" required>

		<input class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="Login">

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</div>
<!-- /container -->


<script src="<c:url value="/assets/js/jquery-1.11.3.min.js"/>"></script>
<script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
</body>
</html>
