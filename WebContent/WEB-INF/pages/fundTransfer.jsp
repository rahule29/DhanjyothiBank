<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Fund Transfer</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td class="head_sec"><jsp:include page="header.jsp" /></td>
		</tr>

		<tr>
			<td class="body_sec">
				<label class="page_desc">Fund Transfer</label><br>
				<h3 style="font: message-box;"> ${MSG}</h3>
				<form:form method="POST" action="transferamt.htm" >
					<table class="table_content">
						<c:choose>
							<c:when test="${pageStatus == 'view'}">
								<tr>
									<td>
										Transfered successfully Amount: $${transaction.transactionAmount} to ${transaction.benificiary.beneficiaryNickName } with Transaction Id: ${transaction.transactionId}
									</td>
								</tr>
							</c:when>
							<c:otherwise>
								<thead>
									<tr>
										<td><label>Beneficiaries</label></td>
										<td><label>Amount</label></td>
										<td><label>Remarks</label></td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<select name="beneficiary">
											   <option value="NONE">--- Select ---</option>
											   <c:forEach var="beneficiary" items="${beneficiries}">
											   		<option value="${beneficiary.beneficiaryId}" >${beneficiary.beneficiaryNickName}</option>
											   </c:forEach>
											</select>
										</td>
										<td><input type="text" id="amount" name="amount"/></td>
										<td><input ty id="remarks" name="remarks"/></td>
									</tr>
									<tr>
							 			<td colspan="3" align="center"><input id="submit" name="submit" type="submit" value="Transfer" /></td>
									</tr>
								</tbody>
							</c:otherwise>
						</c:choose>
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