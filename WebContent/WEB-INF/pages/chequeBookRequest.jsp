<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Cheque Book Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<spring:url value="/resources/images/icons/delete-sign.png" var="deletesignpng" />
<spring:url value="/resources/images/icons/delete-sign--v2.png" var="deletesignv2png" />
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td class="head_sec"><jsp:include page="header.jsp" /></td>
		</tr>

		<tr>
			<td class="body_sec">
				<label class="page_desc">Cheque Book Request</label><br>
				<h3 style="font: message-box;"> You will receive your Cheque book within 7 business working days.</h3>
			</td>
		</tr>


		<tr>
			<td class="footer_sec"><jsp:include page="footer.jsp" /></td>
		</tr>

	</table>
</body>

</html>