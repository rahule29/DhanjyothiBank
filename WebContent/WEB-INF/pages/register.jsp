<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>User Register</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<spring:url value="/resources/images/dhanjyothiLogo.png" var="dhanjyothiLogo" />
<spring:url value="/resources/css/generic.css" var="genericCss" />

<link rel="stylesheet" type="text/css" href="${genericCss }">

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	$('#submitButton').click(function() {
	  var first_name = $('#firstName').val();
	  var last_name = $('#lastName').val();
	  var email = $('#email').val();
	  var password = $('#password').val();
	  var confirmPassword = $('#confirmPassword').val();
	  var mobileNumber = $('#mobileNumber').val();
	  var userName = $('#userName').val();
	  var addressLine1 = $('#addressLine1').val();
	  var city = $('#city').val();
	  var state = $('#state').val();
	  var pin = $('#pin').val();
	  var aadhar = $('#aadhar').val();
	  var pan = $('#pan').val();
	  var dob = $('#dob').val();
	  
	  
	    $(".error").remove();

	    if (first_name.length < 1) {
	        $('#firstName').parent().after('<td class="error"><span class="error">This field is required</span></td>');
	      }
	      if (last_name.length < 1) {
	        $('#lastName').parent().after('<td class="error"><span class="error">This field is required</span></td>');
	      }
	      
	      
	      if (email.length < 1) {
	        $('#email').parent().after('<td class="error"><span class="error">This field is required</span></td>');
	      } else {
	        var regEx = /^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	        var validEmail = regEx.test(email);
	        if (!validEmail) {
	          $('#email').parent().after('<td class="error"><span class="error">Enter a valid email</span></td>');
	        }
	      }
	      
	      if (password.length < 8) {
	        $('#password').parent().after('<td class="error"><span class="error">Password must be at least 8 characters long</span></td>');
	      }else if(password != confirmPassword){
	    	  $('#confirmPassword').parent().after('<td class="error"><span class="error">Password and Confirm Password should be same</span></td>');
	      }
	      
	      if (userName.length < 1) {
		        $('#userName').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      if (addressLine1.length < 1) {
		        $('#addressLine1').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      if (city.length < 1) {
		        $('#city').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      if (state.length < 1) {
		        $('#state').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      if (pin.length < 1) {
		        $('#pin').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      if (aadhar.length < 1) {
		        $('#aadhar').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      if (pan.length < 1) {
		        $('#pan').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      if (dob.length < 1) {
		        $('#dob').parent().after('<td class="error"><span class="error">This field is required</span></td>');
		      }
	      
	      if(!$(".error").length){
	    	  $("form").submit();
	      }
	  });
});
</script>
<!-- End -->
<style type="text/css">
form label {
  display: inline-block;
  width: 100px;
}

form div {
  margin-bottom: 10px;
}

.error {
  color: red;
  margin-left: 5px;
}

label.error {
  display: inline;
}
</style>
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td class="head_sec">
				<div>
					<a href="${pageContext.request.contextPath}/login.htm"><img alt="logo" src="${dhanjyothiLogo}" style="height: 40px;"></a>	<br>
				</div>
				<div class="navbar">&nbsp;</div>
			</td>
		</tr>

		<tr>
			<td class="body_sec">
				<label class="page_desc">Customer Registration</label><br>
				
				<form:form method="POST" action="save.htm" modelAttribute="user" id="regForm" name="regForm">
					<table class="table_content">
						<tr>
							<td><form:label path="firstName">First Name</form:label></td>
							<td><form:input id="firstName" path="firstName" /></td>
						</tr>
						<tr>
							<td><form:label path="lastName">Last Name</form:label></td>
							<td><form:input id="lastName" path="lastName"/></td>
						</tr>
						<tr>
							<td><form:label path="email">Email</form:label></td>
							<td><form:input id="email" path="email" type="email"/></td>
						</tr>
						<tr>
							<td><form:label path="mobileNumber">Mobile Number</form:label></td>
							<td><form:input id="mobileNumber" path="mobileNumber"/></td>
						</tr>
						<tr>
							<td><form:label path="userName">Username</form:label></td>
							<td><form:input id="userName" path="userName"/></td>
						</tr>
						<tr>
							<td><form:label path="password">Password</form:label></td>
							<td><form:password id="password" path="password"/></td>
						</tr>
						<tr>
							<td><label>Confirm Password</label></td>
							<td><input id="confirmPassword" name="confirmPassword" type="password"/></td>
						</tr>
						<tr>
							<td><form:label path="dob">Date of Birth</form:label></td>
							<td><form:input id="dob" path="dob" type="date" /></td>
						</tr>
						<tr>
							<td><form:label path="addressLine1">Address Line 1</form:label></td>
							<td><form:textarea id="addressLine1" path="addressLine1" type="notes"/></td>
						</tr>
						<tr>
							<td><form:label path="addressLine2">Address Line 2</form:label></td>
							<td><form:textarea id="addressLine2" path="addressLine2" type="notes"/></td>
						</tr>
						<tr>
							<td><form:label path="city">City</form:label></td>
							<td><form:input id="city" path="city"/></td>
						</tr>
						<tr>
							<td><form:label path="state">State</form:label></td>
							<td><form:input id="state" path="state"/></td>
						</tr>
						<tr>
							<td><form:label path="pin">Pin Code</form:label></td>
							<td><form:input id="pin" path="pin"/></td>
						</tr>
						<tr>
							<td><form:label path="aadhar">AADHAR</form:label></td>
							<td><form:input id="aadhar" path="aadhar"/></td>
						</tr>
						<tr>
							<td><form:label path="pan">PAN</form:label></td>
							<td><form:input id="pan" path="pan"/></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<input id="cancel" name="cancel" type="button" value="Cancel" onclick="location.href = '<%=request.getContextPath() %>/login.htm';" />
				 				<input id="submitButton" name="submitButton" type="button" value="Register" />
				 			</td>
						</tr>
					</table>
				</form:form>
				
			</td>
		</tr>


		<tr>
			<td class="footer_sec"><jsp:include page="footer.jsp" /></td>
		</tr>

	</table>
</body>

</html>