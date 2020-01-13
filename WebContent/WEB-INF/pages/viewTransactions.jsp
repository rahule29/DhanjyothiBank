<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Transactions</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/js/jquery.dataTables.min.js" var="jquerydataTablesminjs" />

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" ></script>
<script type="text/javascript" src="${jquerydataTablesminjs }" ></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js" ></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#transactionTable').DataTable();
} );
</script>
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td class="head_sec"><jsp:include page="header.jsp" /></td>
		</tr>

		<tr>
			<td class="body_sec">
				<label class="page_desc">Transactions</label><br>
				<br><br>
				
				<table id="transactionTable" class="table table-striped table-bordered">
					<thead>
						<tr>
							<td>Transaction Id</td>
							<td>Transaction Description</td>
							<td>Transaction Amount</td>
							<td>Transaction Type</td>
							<td>Transaction Date</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="transaction" items="${transactions}">
							<tr>
								<td>${transaction.transactionId}</td>
								<td>${transaction.transactionDescription}</td>
								<td>${transaction.transactionAmount}</td>
								<td>${transaction.transactionType}</td>
								<td>${transaction.transactionDate}</td>
							</tr>
				    	</c:forEach>
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