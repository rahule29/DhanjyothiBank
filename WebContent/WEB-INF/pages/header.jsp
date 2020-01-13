<%@page import="com.dhanjyothi.util.Constants"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>header</title>

<spring:url value="/resources/images/dhanjyothiLogo.png" var="dhanjyothiLogo" />
<spring:url value="/resources/css/generic.css" var="genericCss" />

<link rel="stylesheet" type="text/css" href="${genericCss }">

</head>

<body>
	<div>
		<a href="${pageContext.request.contextPath}/login/accsummary.htm"><img alt="logo" src="${dhanjyothiLogo}" style="height: 40px;"></a>
		<label style="float: right; font-weight: bold;">Welcome ${loggedUser.firstName }</label>
	</div>
	
	<br>

	<div class="navbar">
		<div class="dropdown">
			<button class="dropbtn">Account</button>
			<div class="dropdown-content">
				<%
					if(null != session.getAttribute(Constants.IS_SA_ACCOUNT_EXISTS) && (Boolean) session.getAttribute(Constants.IS_SA_ACCOUNT_EXISTS)){
				%>
					<a href="${pageContext.request.contextPath}/accounts/createsavingsaccount.htm">Savings Account</a> 
					<a href="#">Create Loan Account</a> 
					<a href="#">Create Fixed Account</a>
				<%
				
					}else{
				%>
					<a href="${pageContext.request.contextPath}/accounts/createsavingsaccount.htm">Create Savings Account</a> 				
				<%	
					}
				%>
				
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">Fund Transfer</button>
			<div class="dropdown-content">
				<%
					if(null != session.getAttribute(Constants.IS_SA_ACCOUNT_EXISTS) && (Boolean) session.getAttribute(Constants.IS_SA_ACCOUNT_EXISTS)){
				%>
					<a href="${pageContext.request.contextPath}/fundTransfer/loadbeneficiary.htm">Add Beneficiary</a> 
					<a href="${pageContext.request.contextPath}/fundTransfer/loadtransfer.htm">Fund Transfer</a> 
				<%
					}
				%>
				
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">Others</button>
			<div class="dropdown-content">
				<a href="${pageContext.request.contextPath}/accounts/chequeBookRequest.htm">Cheque Book Request</a> 
				<a href="#">Others</a> 
				<a href="${pageContext.request.contextPath}/errors.htm">Throw Exception</a>
			</div>
		</div>
		<div style="float: right;">
			<a href="${pageContext.request.contextPath}/login/logout.htm">Logout</a> 
		</div>
	</div>
	<% 
		HttpSession currentSession = request.getSession(false);
		if(currentSession == null || currentSession.getAttribute("loggedUser") == null){
			response.sendRedirect(request.getContextPath()+"/login/logout.htm");
		}
	%>
</body>
</html>
