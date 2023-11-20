<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/add-to-cart" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value='/template/web/csspaging/styles.css'/>"
	rel="stylesheet" type="text/css" media="all" />
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	
</head>
<body>
       <form id="formSubmit">
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
						
						
						<input type="hidden" class="form-control" id="gioHang" name="gioHang"
								         value="${Cart.id }" />
					    <input type="hidden" class="form-control" id="sanPham" name="sanPham"
							         value="${detailSP.idProduct }" />
	                    <input class="form-control" value=1 type="number" id="soLuong" name ="soLuong">
						
							<a class="btn btn-outline-dark mt-auto" id="btnAddCart"> Add to cart </a> 
					
					</div>
				</div>
			</div>
			</form>
	
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
								<a class="btn btn-outline-dark mt-auto" href="<c:url value="/detail?idProduct=${o.idProduct }&idUser=${USERMODEL.idUser}"/>">View
									options</a>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				
			</div>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
   <script >
   
   $('#btnAddCart').click(function(e) {
		e.preventDefault();
		var data = {};
		var formData = $('#formSubmit').serializeArray();
		$.each(formData, function(i, v) {
			console.log(v)
			data["" + v.name + ""] = v.value;
		});
		if (true) {
			addNew(data);
		} 
	});
   function addNew(data) {
		$
				.ajax({
					url : '${APIurl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
				  alert('Sản Phẩm đã được thêm vào giỏ hàng');
					},
					error : function(error) {

					}
				});
	}
   </script>

</body>
</html>