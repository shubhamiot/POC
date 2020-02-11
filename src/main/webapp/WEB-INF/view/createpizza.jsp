<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>Add New Pizza</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<c:choose>
		<c:when test="${mode=='ADD_PIZZA' }">
			<div class="container text-center">
				<h3>New Pizza</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/save-pizza">
				<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<input type="hidden" name="id" value="${pizza.id }" />
					<div class="form-group">
						<label class="control-label col-md-3">Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="name"
								value="${pizza.name }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Topping</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="topping"
								value="${pizza.topping }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Crust</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="crust"
								value="${pizza.crust }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Price</label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="price"
								value="${pizza.price }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Add Pizza" />
					</div>
				</form>
			</div>
		</c:when>
</c:choose>

<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>