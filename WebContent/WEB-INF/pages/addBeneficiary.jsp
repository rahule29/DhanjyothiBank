<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Add Beneficiary</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<spring:url value="/resources/images/icons/delete-sign.png" var="deletesignpng" />
<spring:url value="/resources/images/icons/delete-sign--v2.png" var="deletesignv2png" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" ></script>

<script type="text/javascript">
function deleteBeneficiary(beneficiaryId){
	if(confirm("This beneficiary will permanently deleted and cannot be recovered. Are you sure?")){
		$.ajax({url: "${pageContext.request.contextPath}/fundTransfer/deleteBeneficiary/"+beneficiaryId+'.htm', success: function(result){}});
		$('#tableRow'+beneficiaryId).remove();
	}
}
</script>
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td class="head_sec"><jsp:include page="header.jsp" /></td>
		</tr>

		<tr>
			<td class="body_sec">
				<label class="page_desc">Add Beneficiary</label><br>
				<h3 style="font: message-box;"> ${MSG}</h3>
				<form:form method="POST" action="savebeneficiary.htm" modelAttribute="beneficiaries">
					<table class="table_content">
						<thead>
							<tr>
								<td><form:label path="beneficiaryNickName">Nick Name</form:label></td>
								<td><form:label path="beneficiaryName">Name</form:label></td>
								<td><form:label path="beneficiaryAccountNo">Account No</form:label></td>
								<td><form:label path="beneficiaryAccountNo">Confirm Account No</form:label></td>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${pageStatus == 'view'}">
									<tr>
										<td><form:input id="beneficiaryNickName" path="beneficiaryNickName" disabled="true"/></td>
										<td><form:input id="beneficiaryName" path="beneficiaryName" disabled="true"/></td>
										<td><form:input id="beneficiaryAccountNo" path="beneficiaryAccountNo" disabled="true"/></td>
									</tr>
								</c:when>
								<c:otherwise>
									<tr>
										<td><form:input id="beneficiaryNickName" path="beneficiaryNickName"/></td>
										<td><form:input id="beneficiaryName" path="beneficiaryName"/></td>
										<td><form:input id="beneficiaryAccountNo" path="beneficiaryAccountNo"/></td>
										<td><input id="confirmBeneficiaryAccountNo" name="confirmBeneficiaryAccountNo" type="password" /></td>
									</tr>
									<tr>
							 			<td colspan="4" align="center"><input id="submit" name="submit" type="submit" value="Add" /></td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</form:form>
				
				<br><br>
				<h4>Registered Beneficiary</h4>
				<table class="table_content">
					<thead>
						<tr>
							<td>&nbsp;</td>
							<td>Beneficiary Nick Name</td>
							<td>Beneficiary Name</td>
							<td>Beneficiary Account Number</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="beneficiary" items="${allBeneficiaries}">
							<tr id="tableRow${beneficiary.beneficiaryId}">
								<td><img alt="delete" style="height: 25px; width: 25px;" src="${deletesignpng }" onmouseover="this.src='${deletesignv2png}'" onmouseout="this.src='${deletesignpng }'" onclick="deleteBeneficiary(${beneficiary.beneficiaryId})"> </td>
								<td>${beneficiary.beneficiaryNickName}</td>
								<td>${beneficiary.beneficiaryName}</td>
								<td>${beneficiary.beneficiaryAccountNo}</td>
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