
<%@include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:url var="APIurl" value="/api-admin" />
<c:url var="NewURL" value="/admin-product" />
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
					<div class="widget-box table-filter">
						<div class="table-btn-controls">
							<div class="pull-right tableTools-container">
								<div class="dt-buttons btn-overlap btn-group">
									<a flag="info"
										class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
										data-toggle="tooltip" title='Thêm bài viết'
										href='<c:url value="/admin-product?type=edit"/>'> <span>
											<i class="fa fa-plus-circle bigger-110 purple"></i>
									</span>
									</a>
									<button id="btnDelete" type="button"
										class="dt-button buttons-html5 btn btn-white btn-primary btn-bold"
										data-toggle="tooltip" title='Xóa bài viết'>
										<span> <i class="fa fa-trash-o bigger-110 pink"></i>
										</span>
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="table-responsive">
							<table class="table table-bordered">
								<thead>
									<tr>
										<th><input type="checkbox" id="checkAll"></th>
										<th>numOrDer</th>
										<th>id</th>
										<th>tên Sản Phẩm</th>
										<th>Giá Sản Phẩm</th>
										<th>Thao Tác</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${model.listResulset}">
										<tr>
											<td><input type="checkbox"
												id="checkAll_${item.numOrDer }" value="${item.numOrDer }"></td>
											<td>${item.numOrDer }</td>
											<td>${item.idProduct }</td>
											<td>${item.nameProduct }</td>
											<td>${item.priceProduct }</td>
											<td><a class="btn btn-sm btn-primary btn-edit"
												data-toggle="tooltip" title="Cập nhật bài viết"
												href='<c:url value="/admin-product?type=edit&idProduct=${item.idProduct }"/>'><i
													class="fa fa-pencil-square-o" aria-hidden="true"></i> </a></td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
							<ul class="pagination" id="pagination"></ul>
							<input type="hidden" value="" id="page" name="page"> <input
								type="hidden" value="" id="maxPageItem" name="maxPageItem">
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- main conten/ -->
	<script>
	$(function () {
	    var currentPage = ${model.page};
	    var totalPages = ${model.totalPage};
	    var limit = 4;

	    window.pagObj = $('#pagination').twbsPagination({
	        totalPages: 2,
	        visiblePages: 10,
	        startPage: currentPage,
	        onPageClick: function (event, page) {
	            if (currentPage != page) {
	                // Lấy URL hiện tại
	                var currentURL = window.location.href;

	                // Kiểm tra xem URL đã chứa tham số type=list hay chưa
	                if (currentURL.includes('type=list')) {
	                    // Nếu đã có, chỉ cập nhật tham số page và maxPageItem
	                    var newURL = currentURL.replace(/(\?|&)page=\d+/, '$1page=' + page);
	                    newURL = newURL.replace(/(\?|&)maxPageItem=\d+/, '$1maxPageItem=' + limit);
	                } else {
	                    // Nếu chưa có, thêm tham số type=list
	                    newURL = currentURL + (currentURL.includes('?') ? '&' : '?') + 'page=' + page + '&maxPageItem=' + limit + '&type=list';
	                }

	                // Chuyển đến URL mới
	                window.location.href = newURL;
	            }
	        }
	    });
	});
	$("#btnDelete").click(function(){
		 var data={};
		 var ids = $('tbody input[type=checkbox]:checked').map(function () {
	            return $(this).val();
	        }).get();
			data['ids'] = ids;
			deleteNew(data);
		});
	function deleteNew(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${NewURL}?type=list&maxPageItem=4&page=1";
            },
            error: function (error) {
            	window.location.href = "${NewURL}?type=list&maxPageItem=4&page=1";
            }
        });
    }
	</script>

</body>

</html>