<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Error</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<spring:url value="/resources/images/dhanjyothiLogo.png" var="dhanjyothiLogo" />
<spring:url value="/resources/images/icons/error.png" var="errorLogo" />
<spring:url value="/resources/css/generic.css" var="genericCss" />

<link rel="stylesheet" type="text/css" href="${genericCss }">
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
				<label class="page_desc">Error Page</label><br><br>
				<img alt="logo" src="${errorLogo}" style="height: 180px;"><br><br>
				
				<strong>Error Message:</strong> ${errorMessage }
				<br><br>
				<strong>For detailed exception, please refer application logs.</strong>
				
				<br><br>
				<button style="margin-left: 50%;" onclick="history.back()" value="back">Back</button>
				
			</td>
		</tr>


		<tr>
			<td class="footer_sec"><jsp:include page="footer.jsp" /></td>
		</tr>

	</table>
</body>

</html>		
				

