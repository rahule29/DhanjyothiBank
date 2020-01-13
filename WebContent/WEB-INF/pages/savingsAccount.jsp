<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Savings Account</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table style="width: 100%">
		<tr>
			<td class="head_sec"><jsp:include page="header.jsp" /></td>
		</tr>

		<tr class="body_sec">
			<td>
				<label class="page_desc">Savings Account Details</label><br><br>
				<form:form method="POST" action="createsavingsaccount.htm" modelAttribute="account">
					<table class="table_content">
						<thead>
							<tr>
								<td><form:label path="accountId">Account Number</form:label></td>
								<td><form:label path="accountType">Account Type</form:label></td>
								<td><form:label path="accountDeposit">Account Balance</form:label></td>
								<td><form:label path="accountCreatedDate">Created Date</form:label></td>
								<td><form:label path="accountUpdatedDate">Updated Date</form:label></td>
								<td>&nbsp;</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${account.accountId }</td>
								<td>${account.accountType }</td>
								<td>${account.accountDeposit }</td>
								<td>${account.accountCreatedDate }</td>
								<td>${account.accountUpdatedDate }</td>
								<td><a href="${pageContext.request.contextPath}/accounts/viewtransactions.htm">View</a></td>
							</tr>
						</tbody>
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