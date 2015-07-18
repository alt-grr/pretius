<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pretius" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring-mvc" uri="http://www.springframework.org/tags/form" %>
<%@ page %>

<!DOCTYPE html>
<html>
<head>
	<pretius:bootstrapHeadContent pageTitle="System raportowania Pretius - zaloguj się"/>

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

		.form-signin .form-signin-heading {
			margin-bottom: 10px;
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

		.form-signin input[type="text"] {
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

	<form class="form-signin" action="<c:url value='/login'/>" method="post">

		<h2 class="form-signin-heading">Formularz logowania</h2>

		<c:if test="${param.error != null}">
			<div class="alert bg-danger">
				<p>Błąd logowania: <c:out value="${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}"/><br>
					Spróbuj ponownie później.</p>
			</div>
		</c:if>

		<c:if test="${param.logout != null}">
			<div class="alert bg-info">
				<p>Wylogowano pomyślnie.</p>
			</div>
		</c:if>

		<label for="username" class="sr-only">Login</label>
		<input type="text" name="username" id="username" class="form-control" placeholder="Login" required autofocus>
		<label for="password" class="sr-only">Hasło</label>
		<input type="password" name="password" id="password" class="form-control" placeholder="Hasło" required>

		<input class="btn btn-lg btn-primary btn-block" type="submit" name="submit" value="Zaloguj się">

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</div>
<!-- /container -->

<pretius:bootstrapFooter/>
</body>
</html>
