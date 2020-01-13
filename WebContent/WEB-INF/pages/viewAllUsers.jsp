<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>All Users</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/js/jquery.dataTables.min.js" var="jquerydataTablesminjs" />
<spring:url value="/resources/images/icons/red-button-icon.png" var="redbuttoniconpng" />
<spring:url value="/resources/images/icons/green-button-icon.png" var="greenbuttoniconpng" />

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" ></script>
<script type="text/javascript" src="${jquerydataTablesminjs }" ></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js" ></script>

<script type="text/javascript">
$(document).ready(function() {
    $('#transactionTable').DataTable();
} );

function changeStatus(userId){
	$.ajax({url: "${pageContext.request.contextPath}/register/changeStatus/"+userId+'.htm', success: function(result){}});
	$('#'+userId+' img').fadeOut().attr('src' , swapIcons($('#'+userId+' img').attr('src'))).fadeIn();
}

function changeRole(userId, role){
	$.ajax({url: "${pageContext.request.contextPath}/register/changeRole/"+userId+".htm?role="+role, success: function(result){}});
	$('#userRoleSelect'+userId).after('<span  class="messagepop">Updated Successfully</span>');
	setTimeout(function() {
        $( ".messagepop" ).remove().fadeOut();
      }, 1000 );
	//$(".messagepop").fade();
}
	
function swapIcons(imgSrc){
	if(imgSrc.includes("green")){
		return imgSrc.replace("green", "red");
	}else{
		return imgSrc.replace("red", "green");
	}
}
</script>

<style type="text/css">
.messagepop {
  color: red;
  margin-left: 5px;
}
</style>
</head>
<body>
	<table style="width:100%;">
		<tr>
			<td class="head_sec"><jsp:include page="header.jsp" /></td>
		</tr>

		<tr>
			<td class="body_sec">
				<label class="page_desc">All Users</label><br>
				<br><br>
				
				<table id="transactionTable" class="table table-striped table-bordered">
					<thead>
						<tr>
							<td>User Id</td>
							<td>First Name</td>
							<td>Last Name</td>
							<td>User Name</td>
							<td>Role</td>
							<td>Status</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.userId}</td>
								<td>${user.firstName}</td>
								<td>${user.lastName}</td>
								<td>${user.userName}</td>
								<td>
									<select id="userRoleSelect${user.userId}" name="userRoleSelect${user.userId}" onchange="changeRole(${user.userId}, this.value)">
										<option value="none">--Select--</option>
										<c:if test="${user.userRole == 'admin'}">
											<option value="admin" selected="selected">Admin</option>
										</c:if>
										<c:if test="${user.userRole != 'admin'}">
											<option value="admin">Admin</option>
										</c:if>
										
										<c:if test="${user.userRole == 'customer'}">
											<option value="customer" selected="selected">Customer</option>
										</c:if>
										<c:if test="${user.userRole != 'customer'}">
											<option value="customer">Customer</option>
										</c:if>
										
										<c:if test="${user.userRole == 'employee'}">
											<option value="employee" selected="selected">Employee</option>
										</c:if>
										<c:if test="${user.userRole != 'employee'}">
											<option value="employee">Employee</option>
										</c:if>
									</select>
								</td>
								<td style="text-align: center;">
									<div id="${user.userId}" onclick="changeStatus(this.id)">
										<c:choose>
											<c:when test="${user.userStatus == 'active'}">
												<img alt="active" src="${greenbuttoniconpng }" id="userStatus" style="height: 20px; width: 20px;" >
											</c:when>
											<c:otherwise>
												<img alt="active" src="${redbuttoniconpng }" id="userStatus" style="height: 20px; width: 20px;" >
											</c:otherwise>
										</c:choose>
									</div>
								</td>
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