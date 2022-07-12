
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clinic Management</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <link href="./assets/themes/krajee-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/select2.min.css" />
        <link rel="stylesheet" href="./assets/css/select2-bootstrap-5-theme.min.css" />
        <link rel="stylesheet" href="./assets/css/custom.css" />
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        .list{
            background-color:#F0F0F0;

            padding: 20px;
            border-radius: 10px;
            width: 75%;
            margin: 0 auto;
            margin-top: 30px;

        }
        .infor{
            margin-left: 30px;
        }
        .feedback{
            padding:10px;
            background-color: red;
            border-radius: 10px;
            color: white;
            text-align: center;
            font-weight: bold;
        }
        .status{
            padding:10px;
            background-color: red;
            border-radius: 10px;
            color: white;
            text-align: center;
            font-weight: bold;
        }
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 80%; /* Could be more or less, depending on screen size */
        }

        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        .item_header {
            display: flex;
            width: 100%;
            justify-content: space-between;
        }

        .item__content {
            border: 1px solid #e6e6e6;
            margin-top: 10px;
            border-radius: 5px;
            padding: 10px;
        }
    </style>
    <body>
        <%@include file="components/customerHeader.jsp" %>
        <div class="container-fluid m-0 p-0">
            <h3 style="margin-left:20px">Reservation List</h3>
            <div style="margin-left: 80%">
                <form action="../ClinicManagement/ViewCustomerReservationsList" method="GET">
                    <label for="status">Choose a status</label>
                    <select name="status" id="status">
                        <option selected value="${status}">
                            ${status}
                        </option>
                        <option value="Đã khám">Đã khám</option>
                        <option value="Chờ duyệt">Chờ duyệt</option>
                        <option value="Đặt thành công">Đặt thành công</option>
                        <option value="Đã hủy">Đã hủy</option>
                    </select>
                    <button class="btn-primary" type="submit">Lọc</button>
                </form>
            </div>

            <div class="container-fluid">
                <c:forEach var="reservation" items="${reservations.data}">
                    <div class="row list">
                        <div class="d-flex col-8" style="margin-left:150px">
                            <div>
                                <img src="https://thumbs.dreamstime.com/z/doctor-medical-icon-cdr-187019168.jpg" style="width: 150px; height: 150px;">
                            </div>
                            <div class="infor col-4">
                                <p>Dịch vụ: <b>${reservation.serviceName}</b></p>
                                <p>Gói: <b>${reservation.packageTitle}</b></p>
                                <div class="row">
                                    <button class="btn btn-success mx-1" data-toggle="modal" data-target="#myModal${reservation.id}"> Xem chi tiết</button>
                                    <c:if test="${reservation.reservationStatus eq 'Đã khám'}">
                                        <button class="btn btn-primary mx-1" data-toggle="modal" data-target="#myModal2${reservation.id}"> Phản hồi</button>
                                    </c:if>
                                </div>
                                <div class="modal fade" id="myModal${reservation.id}" data-backdrop="false" data-keyboard="true">
                                    <div class="modal-dialog modal-lg">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="btn btn-primary" data-dismiss="modal">Trở lại</button>
                                            </div>
                                            <div class="modal-body">
                                                <p>Dịch vụ: <b>${reservation.serviceName}</b></p>
                                                <p>Gói: <b>${reservation.packageTitle}</b></p>

                                                <p>Giá: <b> ${reservation.price} đ</b></p>
                                                <p class="status">${reservation.reservationStatus}</p>
                                                <h4>Chi tiết lịch đặt</h4>
                                                Ngày yêu cầu khám bệnh :${(reservation.requestExaminationDate != null)?reservation.requestExaminationDate:'Không có'}
                                                <br/>
                                                Ngày khám bệnh xác nhận :${(reservation.confirmedExaminationDate != null)?reservation.confirmedExaminationDate:'Chưa có'}
                                                <br/>
                                                Yêu cầu y tế :${(reservation.medicalRequest != "")?reservation.medicalRequest:'Không có yêu cầu y tế'}
                                            </div>
                                            <div class="modal-footer" hidden="true">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${reservation.reservationStatus eq 'Đã khám'}">
                                    <div class="modal fade" id="myModal2${reservation.id}" data-backdrop="false" data-keyboard="true">
                                        <div class="modal-dialog modal-lg">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <button type="button" class="btn btn-primary" data-dismiss="modal">Trở lại</button>
                                                </div>
                                                <div class="modal-body">
                                                    <form action="AddFeedbackController" method="POST">
                                                        <div class="row-fluid">
                                                            <div class="form-group">
                                                                <label for="feedbackContent"><b>Nội dung phản hồi</b></label>
                                                                <textarea class="form-control" name="content" id="feedbackContent" rows="3"></textarea>
                                                            </div>
                                                            <div hidden>
                                                                <input name="examinationId"value="${reservation.id}">
                                                            </div>
                                                            <div hidden>
                                                                <input name="serviceId"value="${reservation.serviceId}">
                                                            </div>
                                                            <button class="btn btn-primary float-right mt-3" type="submit">Phản hồi</button>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer" hidden="true">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <div style="margin-top:30px;">
                            <p>Giá: <b> ${reservation.price} đ</b></p>  
                            <p class="status"> ${reservation.reservationStatus}</p>
                        </div>
                    </div>
                </c:forEach>
                <c:if test="${reservations.totalItem == 0}">
                    <div class="col-12">
                        <p class="text-center">Không có dữ liệu</p>
                    </div>
                </c:if>
                <div class="row mt-5">
                    <div class="col-12 text-center">
                        <ul>
                            <c:if test="${reservations.currentPage > 1}">
                                <a class="btn btn-light" href="ViewCustomerReservationsList?page=${reservations.currentPage-1}">Trang trước</a>
                            </c:if>
                            <c:forEach var="pageNumber" begin="1" end="${reservations.totalPage}" step="1">
                                <c:if test="${reservations.currentPage == pageNumber}">
                                    <a class="btn btn-success" href="#">${pageNumber}</a>
                                </c:if>
                                <c:if test="${reservations.currentPage != pageNumber}">
                                    <a class="btn btn-light" href="ViewCustomerReservationsList?page=${pageNumber}">${pageNumber}</a>
                                </c:if>
                            </c:forEach>
                            <c:if test="${reservations.currentPage < reservations.totalPage}">
                                <a class="btn btn-light" href="ViewCustomerReservationsList?page=${reservations.currentPage+1}">Trang sau</a>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="components/footer.jsp" %>
        <script src="./assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="./assets/js/popper.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>
    <script>
        $("p:contains('Chờ duyệt')").css("background-color", "orange");
        $("p:contains('Đã khám')").css("background-color", "blue");
        $("p:contains('Đặt thành công')").css("background-color", "green");
    </script>
</html>
