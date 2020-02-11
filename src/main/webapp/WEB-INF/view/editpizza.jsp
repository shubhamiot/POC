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
<title>Pizza Menu</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
</head>
<body>
<form>
<c:choose>

<c:when test="${mode=='ALL_PIZZA' }">
			<div class="container" id="homediv">
				<div class="jumbotron text-center">
					<h1>Available Pizza</h1>
				</div>
			</div>
			
				<hr>
				<div>
				<form class="form-horizontal" action="/save-pizza">
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Topping</th>
								<th>Crust</th>
								<th>Price</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pizza" items="${pizzas }">
								<tr>
									<td>${pizza.id}</td>
									<td>${pizza.name}</td>
									<td>${pizza.topping}</td>
									<td>${pizza.crust}</td>
									<td>${pizza.price}</td>
									<td><a href="/delete-pizza?id=${pizza.id }" action="/save-pizza">
									<span class="glyphicon glyphicon-trash"></span></a></td>
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