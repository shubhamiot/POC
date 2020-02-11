<%@ page language="java" contentType="hidden/html; charset=ISO-8859-1"
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
<title>ITEM PREVIEW</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<meta charset="ISO-8859-1">

</head>
<body>
<c:choose>
<c:when test="${mode=='MODE_PREVIEW' }">
			<div class="container hidden-center">
				<h3>ITEM PREVIEW</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/savetocart">
				<div class="form-group">
					<label class="control-label col-md-3">ID</label>
						<div class="col-md-7">
							<input type="hidden" class="form-control" name="id"
								value="${product.id }" />
						</div>
						</div>
					<div class="form-group">
						<!--  <label class="control-label col-md-3">Pizza Name</label>-->
						<div class="col-md-7">
							<input type="hidden" class="form-control" name="name"
								value="${pizza.name }" />
						</div>
					</div>
					<div class="form-group">
						<!-- <label class="control-label col-md-3">Topping</label> -->
						<div class="col-md-7">
							<input type="hidden" class="form-control" name="topping"
								value="${pizza.topping}" />
						</div>
					</div>
					<div class="form-group">
						<!-- <label class="control-label col-md-3">Crust</label> -->
						<div class="col-md-7">
							<input type="hidden" class="form-control" name="crust"
								value="${pizza.crust }" />
						</div>
					</div>
					<div class="form-group">
						<!-- <label class="control-label col-md-3">Price </label> -->
						<div class="col-md-3">
							<input type="hidden" class="form-control" name="price"
								value="${pizza.price }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Quantity </label>
						<div class="col-md-3">
							<input type="hidden" class="form-control" name="quantity" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="ADD ITEM" />
					</div>
				</form>
			</div>
		</c:when>
		</c:choose>
</body>
</html> 