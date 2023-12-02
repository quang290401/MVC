<%--
  Created by IntelliJ IDEA.
  User: Quang
  Date: 27/11/2023
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Title</title>
    <title>Registation Form * Form Tutorial</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<form action="<c:url value='/Add-user?id=${usert.idUser}'/>" method="post">
<div class="container">

    <div class="panel panel-primary">
        <div class="panel-heading">
            <h2 class="text-center">Registation Form - Input User's Detail Information</h2>
        </div>
        <div class="panel-body">
         <div class="form-group">
                <label for="usr">Name:</label>
                <input required="true" type="hidden" class="form-control" id="usr" name="idUser">
            </div>
            <div class="form-group">
                <label for="usr">Name:</label>
                <input required="true" type="text" class="form-control" id="usr" name="fullName">
            </div>
            <div class="form-group">
                <label for="pwd">Tài Khoản:</label>
                <input required="true" type="text" class="form-control" id="pwd" name="taiKhoan">
            </div>


            <div class="form-group">
                <label for="pwd">Password:</label>
                <input required="true" type="password" class="form-control" id="pwd" name="matKhau">
            </div>
            <div class="form-group">
                <label for="confirmation_pwd">Confirmation Password:</label>
                <input required="true" type="password" class="form-control" id="confirmation_pwd" name="matKhau">
            </div>

            <button class="btn btn-success">Đăng Kí</button>
        </div>
    </div>
</div>
</form>
</body>
</html>
