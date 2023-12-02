
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Shop Homepage - Start Bootstrap Template</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Bootstrap icons-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- Core theme CSS (includes Bootstrap)-->
<link href="<c:url value='/template/web/css/styles.css'/>"
	rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!-- Navigation-->

	<!-- Header-->
	<%@ include file="/common/web/header.jsp"%>
	<!-- Header-->
	<header class="bg-dark py-4">
		<div class="container px-3 px-lg-4 my-4">
			<div class="text-center text-white">
				<div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <div class="container px-4 px-lg-5 my-5">
                    <div class="text-center text-white">
                        <img class="card-img-top img-fluid" src="img/baner1.png" alt="..." style="width: 2000px; height: 350px;" />
                        <p class="lead fw-normal text-white-50 mb-0">With this shop homepage template</p>
                    </div>
                </div>
            </div>

            <div class="carousel-item">
                <div class="container px-4 px-lg-5 my-5">
                    <div class="text-center text-white">
                        <img class="card-img-top img-fluid" src="img/banner2.jpg" alt="..." style="width: 2000px; height: 350px;" />
                        <p class="lead fw-normal text-white-50 mb-0">With this shop homepage template</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
			</div>
		</div>
	</header>
	<!-- body -->
	<section class="py-5">
		<div class="container px-4 px-lg-5 mt-5">
			<dec:body />
		</div>
	</section>
	<!-- body -->
	<!-- Footer-->
	<%@ include file="/common/web/foodter.jsp"%>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->

	<script>
        document.addEventListener('DOMContentLoaded', function () {
            var myCarousel = new bootstrap.Carousel(document.getElementById('myCarousel'), {
                interval: 4000 // Đặt thời gian chờ giữa các ảnh là 3000 mili giây (3 giây)
            });
        });
    </script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

