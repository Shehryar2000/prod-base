<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${title}</title>
<meta charset="UTF-8">

<%@include file="./base.jsp"%>

</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Update Product Details</h1>
				<form action="${pageContext.request.contextPath}/handle-product"
					method="post">
					<div class="form-group">
						<input type="hidden" class="form-control" name="id"
							value="${product.id}">
					</div>
					<div class="form-group">
						<label>Product Name</label> <input type="text"
							class="form-control" name="name" placeholder="Enter product name"
							value="${product.name}">
					</div>
					<div class="form-group mt-3">
						<label>Product Description</label>
						<textarea rows="5" class="form-control" name="description"
							placeholder="Enter product description">${product.description}</textarea>
					</div>
					<div class="form-group mt-3">
						<label>Product Price</label> <input type="text"
							class="form-control" name="price"
							placeholder="Enter product price" value="${product.price}">
					</div>
					<div class="container text-center mt-3">
						<a href="${pageContext.request.contextPath}/"
							class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-success">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>