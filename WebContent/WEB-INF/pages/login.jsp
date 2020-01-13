<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login Dhanjyothi Bank</title>
	
	
	<spring:url value="/resources/images/icons/favicon.ico" var="favicon" />
	
	<spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" var="bootstrapmin" />
	<spring:url value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css" var="fontawesomemin" />
	<spring:url value="/resources/fonts/iconic/css/material-design-iconic-font.min.css" var="materialdesigniconicfontmin" />
	<spring:url value="/resources/vendor/animate/animate.css" var="animateCss" />
	<spring:url value="/resources/vendor/css-hamburgers/hamburgers.min.css" var="hamburgersmin" />
	<spring:url value="/resources/vendor/animsition/css/animsition.min.css" var="animsitionminCss" />
	<spring:url value="/resources/vendor/select2/select2.min.css" var="select2mincss" />
	<spring:url value="/resources/vendor/daterangepicker/daterangepicker.css" var="daterangepickercss" />
	<spring:url value="/resources/css/util.css" var="utilCSS" />
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/images/bg-01.jpg" var="bg01Jpg" />
	
	<spring:url value="/resources/vendor/jquery/jquery-3.2.1.min.js" var="jquery321minjs" />
	<spring:url value="/resources/vendor/animsition/js/animsition.min.js" var="animsitionminjs" />
	<spring:url value="/resources/vendor/bootstrap/js/popper.js" var="popperjs" />
	<spring:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" var="bootstrapminjs" />
	<spring:url value="/resources/vendor/daterangepicker/moment.min.js" var="momentminjs" />
	<spring:url value="/resources/vendor/daterangepicker/daterangepicker.js" var="daterangepickerJs" />
	<spring:url value="/resources/vendor/countdowntime/countdowntime.js" var="countdowntimejs" />
	<spring:url value="/resources/js/main.js" var="mainjs" />
	
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${favicon }"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${bootstrapmin }">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${fontawesomemin }">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${materialdesigniconicfontmin }">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${animateCss }">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${hamburgersmin }">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${animsitionminCss }">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${select2mincss }">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${daterangepickercss }">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${utilCSS }">
	<link rel="stylesheet" type="text/css" href="${mainCss }">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('${bg01Jpg}');">
			<div class="wrap-login100">
				<form:form class="login100-form validate-form" method="POST" action="${pageContext.request.contextPath}/login/submit.htm">
					<span class="login100-form-logo">
						<i class="zmdi zmdi-landscape"></i>
					</span>

					<span class="login100-form-title p-b-34 p-t-27">
						Log in
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100" data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100" data-placeholder="&#xf191;"></span>
					</div>

					<div class="contact100-form-checkbox">
						<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
						<label class="label-checkbox100" for="ckb1">
							Remember me
						</label>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Login
						</button>
					</div>
					<br>
					<span>${errorMsg}</span>

					<div class="text-center p-t-90">
						Don't have account <a class="txt1" href="${pageContext.request.contextPath}/register/signup.htm">
							SignUp
						</a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="${jquery321minjs }"></script>
<!--===============================================================================================-->
	<script src="${animsitionminjs }"></script>
<!--===============================================================================================-->
	<script src="${popperjs }"></script>
	<script src=""></script>
<!--===============================================================================================-->
	<script src="${bootstrapminjs }"></script>
<!--===============================================================================================-->
	<script src="${momentminjs }"></script>
	<script src="${daterangepickerJs }"></script>
<!--===============================================================================================-->
	<script src="${countdowntimejs }"></script>
<!--===============================================================================================-->
	<script src="${mainjs }"></script>

</body>
</html>