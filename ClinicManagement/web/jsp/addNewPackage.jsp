<%-- 
    Document   : addNewPackage
    Created on : 10-07-2022, 08:49:13
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <!-- Bootstrap Icon -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

    <link rel="stylesheet" href="./assets/service/style.css">
    <title>Clinic Management</title>
</head

<body>
    <form class="form-horizontal"  method="POST" action="../AddNewPackageController">
        <div class="modal-dialog modal-lg" id="editServiceModal">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="non-block"></div>
                    <h5>Thêm gói dịch vụ</h5>

                    <a href="../PackageManagementController?page=${page}">
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </a>
                </div>
                <!-- Table -->
                <p class="col-8"></p>
                <p class="col-8"></p>
                <div class="row mb-6">
                    <label for="service_name" class="col-4 col-form-label">Tên gói dịch vụ</label>
                    <div class="col-4">
                        <input type="text" class="form-control" name="service_name" required maxlength="50"
                               value="${services.packageTitle}">

                    </div>
                </div>
                <p class="col-8"></p>
                <div class="row mb-6">
                    <label for="service_examinationDuration" class="col-4 col-form-label">Thời gian khám </label>
                    <div class="col-4">
                        <input class="form-control" name="service_examinationDuration"  required maxlength="50"
                               value="${services.examinationDuration}">
                        <span id='error_desc' class="text-danger d-none"></span>
                    </div>
                </div>
                <p class="col-8"></p>
                <div class="row mb-6">
                    <label for="Price" class="col-4 col-form-label">Giá gói dịch vụ</label>
                    <div class="col-4">
                        <input class="form-control" name="Price" required maxlength="250" type="number"
                               value="${services.price}"> 
                        <p class="col-8"></p>
                        <span id='error_brief' class="text-danger d-none"></span>
                    </div>

                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary btn-xs btn-lg col-md-3" style="width: 30%; display: ">Lưu</button>
                </div>
            </div>
        </div>
    </div>
</form>

<!-- Bootstrap Bundle -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>

<body>
<html>
