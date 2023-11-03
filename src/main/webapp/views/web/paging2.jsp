<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/template/web/csspaging/styles.css'/>"
	rel="stylesheet" type="text/css" media="all" />
</head>
<body>
		
			<div class="row gx-4 gx-lg-5 align-items-center">
				<div class="col-md-6">
					<img class="card-img-top mb-5 mb-md-0"
						src="${detailSP.image }" alt="..." />
				</div>
				<div class="col-md-6">
					<div class="small mb-1">SKU: BST-498</div>
					<h1 class="display-5 fw-bolder">${ detailSP.nameProduct}</h1>
					<div class="fs-5 mb-5">
						<span class="text-decoration-line-through">$1245.00</span> <span>${detailSP.priceProduct}</span>
					</div>
					<p class="lead">Lorem ipsum dolor sit amet consectetur
						adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi
						consequatur obcaecati excepturi alias magni, accusamus eius
						blanditiis delectus ipsam minima ea iste laborum vero?</p>
					<div class="d-flex">
						<input class="form-control text-center me-3" id="inputQuantity"
							type="num" value="1" style="max-width: 3rem" />
						<button class="btn btn-outline-dark flex-shrink-0" type="button">
							<i class="bi-cart-fill me-1"></i> Add to cart
						</button>
					</div>
				</div>
			</div>
	
	<!-- Related items section-->
		
			<h2 class="fw-bolder mb-4">Có Thể Bạn Quan Tâm ?</h2>
			
			<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach items="${topProduct}" var='o'>
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="card-img-top"
							src="${o.image }" alt="..." />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${o.nameProduct}</h5>
								<!-- Product price-->
								${o.priceProduct }
							</div>
						</div>
						
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="<c:url value="/detail?idProduct=${o.idProduct }"/>">View
									options</a>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				
			</div>
	
	<!-- Footer-->

</body>
</html>