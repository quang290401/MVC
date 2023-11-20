<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin" />
<c:url var="NewURL" value="/admin-product" />
<html>
<head>
<title>Chỉnh sửa Sản Phẩm</title>

</head>
<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li class="active">Chỉnh sửa sản phẩm</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<form id="formSubmit">
							<br /> <br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Tên
									Sản Phẩm</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="nameProduct"
										name="nameProduct" value="${model.nameProduct }" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Giá
									Sản Phẩm</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="priceProduct"
										name="priceProduct" value="${model.priceProduct }" />
								</div>
							</div>

							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Thể
									loại Giày</label>
								<div class="col-sm-9">
									<select class="form-control" id="categoryProduct"
										name="categoryProduct">
										<option value="">Chọn Thể loại</option>
										<c:if test="${empty model.categoryProduct}">
											<c:forEach var="item" items="${listCatgory}">
												<option value="${item.idCatagory }">${item.nameCatagory }</option>
											</c:forEach>
										</c:if>
										<c:if test="${not empty model.categoryProduct}">
											<c:forEach var="item" items="${listCatgory}">
												<c:if test="${item.idCatagory== model.categoryProduct}">
													<option value="${item.idCatagory }" selected="selected">${item.nameCatagory }</option>
												</c:if>

											</c:forEach>
										</c:if>

									</select>
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Số
									Lượng</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="quantity"
										name="quantity" value="${model.quantity }" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Trạng
									Thái</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="status"
										name="status" value="${model.status }" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right">Ảnh
									mô tả</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="image" name="image"
										value="${model.image }" />
								</div>
							</div>
							<br /> <br />
							<div class="form-group">
								<div class="col-sm-12">
									<c:if test="${not empty model.categoryProduct}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Cập nhật bài viết" id="btnAddOrUpdateProduct" />
									</c:if>
									<c:if test="${ empty model.categoryProduct}">
										<input type="button"
											class="btn btn-white btn-warning btn-bold"
											value="Thêm bài viết" id="btnAddOrUpdateProduct" />
									</c:if>
								</div>
							</div>
							<input type="hidden" id="idProduct" name="idProduct"
								value="${model.idProduct }" />

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('#btnAddOrUpdateProduct').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function(i, v) {
				console.log(v)
				data["" + v.name + ""] = v.value;
			});
			var id = $('#idProduct').val();
			if (id == "") {
				addNew(data);
			} else {
				updateNew(data);
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
							window.location.href = "${NewURL}?type=list&maxPageItem=4&page=1";

						},
						error : function(error) {

						}
					});
		}
		function updateNew(data) {
			$
					.ajax({
						url : '${APIurl}',
						type : 'PUT',
						contentType : 'application/json',
						data : JSON.stringify(data),
						dataType : 'json',
						success : function(result) {
							window.location.href = "${NewURL}?type=list&maxPageItem=4&page=1";
						},
						error : function(error) {

						}
					});
		}
	</script>

</body>

</html>