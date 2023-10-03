
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>

	<div class="main-content">
		<form action="<c:url value='/admin-product'/>" id="formSubmit"
			method="get">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
								chủ</a></li>
					</ul>
					<!-- /.breadcrumb -->
				</div>
				<div class="page-content">
					<div class="row">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th>numOrDer</th>
										<th>id</th>
										<th>tên Sản Phẩm</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.listResulset}">
										<tr>
											<td>${item.numOrDer }</td>
											<td>${item.idProduct }</td>
											<td>${item.nameProduct }</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" id="page" name="page">
							<input type="hidden" value="" id="maxPageItem" name="maxPageItem">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- main conten/ -->
	<script>
	    $(function () {
	    	var curentpage = ${model.page};
			var totalpages = ${model.totalPage};
			var limit=2;
	        window.pagObj = $('#pagination').twbsPagination({
	        	totalPages : 3,
				visiblePages : 10,
				startPage:curentpage,
	            onPageClick: function (event, page) {
	            	if(curentpage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
	            }
	           }
	        });
	    });

	</script>

</body>

</html>