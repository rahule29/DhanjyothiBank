<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Account Summary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td class="head_sec"><jsp:include page="header.jsp" /></td>
		</tr>

		<tr>
			<td class="body_sec">
				<label class="page_desc">Account Summary</label><br>
				<h4>Savings Account</h4>
				<table class="table_content">
					<thead>
						<tr>
							<td><label>Account Number</label></td>
							<td><label>Account Type</label></td>
							<td><label>Account Balance</label></td>
							<td><label>Created Date</label></td>
							<td><label>Updated Date</label></td>
							<td>&nbsp;</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${savingsAccount.accountId }</td>
							<td>${savingsAccount.accountType }</td>
							<td>${savingsAccount.accountDeposit }</td>
							<td>${savingsAccount.accountCreatedDate }</td>
							<td>${savingsAccount.accountUpdatedDate }</td>
							<td><a href="${pageContext.request.contextPath}/accounts/viewtransactions.htm">View</a></td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>


		<tr>
			<td class="footer_sec"><jsp:include page="footer.jsp" /></td>
		</tr>

	</table>
</body>

</html>