<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
<h1>CUSTOMER DATABASE</h1>
<form>
<c:choose>

<c:when test="${mode=='ALL_CUSTOMERS' }">
			<div class="container text-center" id="tasksDiv">
				<h3>All CUSTOMERS</h3>
				<hr>
				<form class="form-horizontal" action="/login-admin">
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>UserName</th>
								<th>First Name</th>
								<th>LastName</th>
								<th>Age</th>
								<th>Password</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="customer" items="${customers }">
								<tr>
									<td>${customer.id}</td>
									<td>${customer.username}</td>
									<td>${customer.firstname}</td>
									<td>${customer.lastname}</td>
									<td>${customer.age}</td>
									<td>${customer.password}</td>
									<td><a href="/delete-customer?id=${customer.id }" action="/login-admin"><span
											class="glyphicon glyphicon-trash"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				</form>
			</div>
		</c:when>
		</c:choose>
		</form>
		
		<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>

</body>
</html>