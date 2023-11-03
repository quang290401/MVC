<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="card bg-light mb-3">
		<div class="card-header bg-primary text-white text-uppercase">
			<i class="fa fa-list"></i> Categories
		</div>
		<ul class="list-group category_block">
			<c:forEach items="${litsC}" var="o">
				<li class="list-group-item text-white"><a href="catagory?cid=${o.idCatagory}">${o.nameCatagory}</a></li>
			</c:forEach>

		</ul>
	</div>

	<div
		class="row gx-4 gx-lg-5 row-cols-1 row-cols-md-2 row-cols-lg-3 justify-content-center">

		<div class="card bg-light mb-3 col-md-4 mb-5 border rounded ">
			<div class="card-header bg-success text-white text-uppercase">Sản
				Phẩm Mới Nhất</div>
			<div class="card-body">
				<img class="img-fluid" src="${litsT.image}" alt="..." />
				<h5 class="card-title">${litsT.nameProduct}</h5>
				<p class="card-text">Mẫu giày chơi tết</p>
				<p class="bloc_left_price">${litsT.priceProduct}$</p>
			</div>
		</div>

		<c:forEach items="${listP}" var='o'>
			<div class="col-md-4 mb-5">
				<!-- Đổi lớp col thành col-md-4 -->
				<div class="card h-70">
					<!-- Product image-->
					<img class="card-img-top" src="${o.image}" alt="..." />
					<!-- Product details-->
					<div class="card-body p-4">
						<div class="text-center">
							<!-- Product name-->
							<h5 class="fw-bolder">${o.nameProduct}</h5>
							<!-- Product price-->
							${o.priceProduct}
						</div>
					</div>
					<!-- Product actions-->
					<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
						<div class="text-center">
							<a class="btn btn-outline-dark mt-auto" href="paging.jsp">View
								options</a>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>


</body>
</html>