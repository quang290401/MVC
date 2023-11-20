
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<nav class="navbar navbar-expand-lg navbar-light bg-warning ">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="#!">Start Bootstrap</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href='<c:url value="/trang-chu"/>'>Trang Chủ |</a></li>

				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#!">Đăng Kí |</a></li>
				<c:if test="${not empty USERMODEL}">
					<li><a class="nav-item"><a class="nav-link active"
					aria-current="page" href='#'>Xin chào,${USERMODEL.fullName } |</a></li>
					<li><a class="nav-item"><a class="nav-link active"
							aria-current="page"
							href='<c:url value="/dang-xuat?action=logout"/>'>Thoát |</a></li>
				</c:if>
				<c:if test="${ empty USERMODEL}">
					<li class="nav-item">
					<a class="nav-link"href='<c:url value="/dang-nhap?action=login"/>'>Đăng Nhập |</a>
				</li>
				</c:if>
			</ul>
			<form class="d-flex" >
				
			 
					<a class="bi-cart-fill me-1" href="<c:url value="/add-to-cart?idUser=${USERMODEL.idUser}"/>"></a> Cart <span
						class="badge bg-dark text-white ms-1 rounded-pill">0</span>
				
			</form>
			
		</div>
	</div>
</nav>
