<html>
<head>
<%@include file="./base.jsp"%>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-5">Welcome to Product Base</h1>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Name</th>
							<th scope="col">Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="p">
							<tr>
								<th scope="row">${p.id }</th>
								<td>${p.name }</td>
								<td>${p.description }</td>
								<td class="font-weight-bold">&#x20A8; ${p.price }</td>
								<td>
								<a href="delete/${p.id}"><i class="fa-solid fa-trash text-danger"></i></a>
								<a href="update/${p.id}" class="ms-2"><i class="fa-solid fa-pen-nib text-primary"></i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="container text-center">
					<a class="btn btn-outline-success" href="add-product">Add
						Product</a>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
