<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/add-to-cart" />
<c:url var="NewURL" value="/add-to-cart" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"><script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>

<style type="text/css">
  <link href="<c:url value='/template/shopcart/css/cart.css'/>"
	</style>
</head>
<body>

	<div class="container">
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Tên sản phẩm</th>
					<th style="width: 10%">Giá</th>
					<th style="width: 8%">Số lượng</th>
					<th style="width: 22%" class="text-center">Thành tiền</th>
					<th style="width: 10%"></th>
				</tr>
			</thead>
			<tbody>
			<form id="formSubmit">
			<c:forEach var="o" items="${ListCardetail }">
				<tr>
					<td data-th="Product">
						<div class="row">
							<div class="col-sm-2 hidden-xs">
								<img
									src="${o.image }"
									alt="Sản phẩm 1" class="img-responsive" width="100">
							</div>
							<div class="col-sm-10">
								<h4 class="nomargin">${o.nameProduct }</h4>
								<p>Mô tả của sản phẩm 1</p>
							</div>
						</div>
					</td>
					<td data-th="Price">${o.priceProduct }</td>
					<td data-th="Quantity"><label class="form-control text-center"
						value="${o.soLuongMua }" type="number">${o.soLuongMua }
                    </td>
					<td data-th="Subtotal" class="text-center" id="subtotal">${o.priceProduct * o.soLuongMua}</td>

					<td class="actions" data-th="">


						  <input type="hidden" class="form-control" id="idSanPham" name="idSanPham"
								         value="${o.idSanPham }" />
                        <a class="btn btn-danger btn-sm btnDelete" data-id="${o.idSanPham}" >Xóa</a>



					</td>
				</tr>
				</c:forEach>
			</form>

				<td><a href="/MVC/trang-chu" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua hàng</a></td>
				<td colspan="2" class="hidden-xs"> </td>

				<td><a href="http://hocwebgiare.com/" class="btn btn-success btn-block">Thanh toán <i class="fa fa-angle-right"></i></a></td>


		</table>
	</div>

<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>

<script>
    $('.btnDelete').click(function(e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function(i, v) {
            data[v.name] = v.value;
        });
        // Lấy idSanPham cụ thể được liên kết với nút xóa được nhấp
        var idSanPham = $(this).data('id');
        data['idSanPham'] = idSanPham;

        Xoa(data);
    });

    function Xoa(data) {
        $.ajax({
            url : '${APIurl}',
            type : 'DELETE',
            contentType : 'application/json',
            data : JSON.stringify(data),
            dataType : 'json',
            success : function(result) {
                alert('Bạn đã Xóa Thành công');
                window.location.href = "${NewURL}?idUser=NV002";
            },
        });
    }
</script>
</body>

</html>