<%-- 
    Document   : PackageserviceManagementList
    Created on : 14-07-2022, 22:45:10
    Author     : Nguyen
--%>


<!doctype html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Clinic Management</title>

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Bootstrap Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <link rel="stylesheet" href="./assets/service/style.css">

    </head>
    <header>
        <jsp:include page="./components/managerHeader.jsp" />
    </header>
    <body>
        <div class="container" id="service-container">
            <!-- Header -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarClinicHeader" aria-controls="navbarClinicHeader" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                </div>
            </nav>

            <h1 id="title">
                Dach sách gói dịch vụ
            </h1>

            <div class="wrapper">
                <a id="add-btn" data-title="Add" class="btn btn-light mb-3" href="./jsp/addNewPackage.jsp" >
                    <i class="bi bi-plus-circle-fill"></i>
                    Thêm Gói Dịch Vụ
                </a>

                <!-- Table -->
                <table class="table table-bordered align-middle" id="table-services">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Mã ID</th>
                            <th scope="col">Tên gói dịch vụ</th>
                            <th scope="col">Thời gian khám</th>
                            <th scope="col">Giá gói dịch vụ</th>
                            <th scope="col">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${services.data}" var="service"  varStatus="counter" >
                            <tr>
                                <th scope="row">${counter.count}</th>
                                <td>${service.packageId}</td>
                                <td>${service.packageTitle}</td>
                                <td>${service.examinationDuration}</td>

                                <td>   <fmt:setLocale value = "vi-VN"/>
                                    <fmt:formatNumber value = "${service.price}" type = "currency"/></td>
                                <td>
                                    <div class="action">
                                        <button class="btn-only-ic">  </button>
                                        <button class="btn-only-ic" data-bs-target="#detailServiceModal">
                                            <a href="#" class="bi bi-eye-fill"></a>
                                        </button>
                                        <button class="btn-only-ic" data-bs-target="#editServiceModal">
                                            <a href="UpdatePackageServiceManagementController?Id=${service.packageId}&page=${page}" class="bi bi-pencil-fill"></a>
                                        </button>
                                        <button class="btn-only-ic" onclick="showDeleteServiceModal('${service.packageId}'), '${service.packageTitle}'">
                                            <i class="bi bi-trash-fill"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <!-- Pagination -->
                <div class="pagi-wrapper">
                    <c:if test="${services.totalPage > 1}">
                        <div class="row">
                            <div class="col-12 text-center">
                                <ul>
                                    <c:if test="${services.currentPage > 1}">
                                        <a class="btn btn-light" href="PackageManagementController?page=${restaurants.currentPage-1}">Trang trước</a>
                                    </c:if>
                                    <c:forEach var="pageNumber" begin="1" end="${services.totalPage}" step="1">
                                        <c:if test="${services.currentPage == pageNumber}">
                                            <a class="btn btn-success" href="#">${pageNumber}</a>
                                        </c:if>
                                        <c:if test="${services.currentPage != pageNumber}">
                                            <a class="btn btn-light" href="PackageManagementController?page=${pageNumber}">${pageNumber}</a>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${services.currentPage < services.totalPage}">
                                        <a class="btn btn-light" href="PackageManagementController?page=${services.currentPage+1}">Trang sau</a>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </c:if>
                </div>


            </div>
            <!-- Delete Service Modal -->
            <div class="modal fade" id="deleteServiceModal" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered modal-delete">
                    <div class="modal-content">
                        <div class="modal-header justify-content-center">
                            <h5 class="modal-title" id="staticBackdropLabel">Thông báo</h5>
                        </div>
                        <div class="modal-body text-center">
                            Bạn có muốn xóa gói dịch vụ <span id="service_name"></span> không?
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-light" data-bs-dismiss="modal">
                                Không</button>
                            <button id='delete-btn' class="btn btn-primary" data-bs-dismiss="modal">
                                Có
                            </button>
                        </div>
                    </div>
                </div>
            </div>


        </div>


        <!-- Bootstrap Bundle -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>


   

    </body>

</html>