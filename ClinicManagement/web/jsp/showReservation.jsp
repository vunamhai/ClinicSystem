<%-- 
    Document   : showReservation
    Created on : 01-07-2022, 08:12:25
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>ClinicManagement</title>
          <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <link href="./assets/themes/krajee-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/select2.min.css" />
        <link rel="stylesheet" href="./assets/css/select2-bootstrap-5-theme.min.css" />
        <link rel="stylesheet" href="./assets/css/custom.css" />
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
 
    <body>
      <header>
        <jsp:include page="./components/managerHeader.jsp" />
    </header>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6 text-center mb-5">
                    <h2 class="heading-section">Duyệt lịch đặt chỗ</h2>
                </div>
            </div>
            <div class="row">
                 
                <div class="col-md-12">
                    
                    <div class="table-wrap">
                               <div class="col-md-12 mx-auto">
                <form class="form-inline" action="" method="GET">
<!--                <input class="form-control mr-sm-2"name="search" type="search" placeholder="Search" aria-label="Search" value="">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>-->
            </form>
            </div>
                        <table class="table align-middle mb-0 bg-white">
                      
                            <thead class="bg-light">
                                <tr>
                                    <th>Bệnh nhân</th>
                                    <th>Dịch vụ</th>
                                    <th>Gói</th>
                                    <th>Thời gian bệnh nhân yêu cầu</th>
                                    <th>Thời gian đặt chỗ</th>
                                    <th>Trạng thái</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${reservations.data}" var="reservation"  varStatus="counter" >
                                    <tr>
                                        <td>${reservation.patientName}</td>
                                        <td>${reservation.service}</td>
                                        <td>${reservation.packageService}</td>

                                        <c:choose>
                                            <c:when test="${reservation.requestDate == null}">
                                                <td>Không có</td>
                                            </c:when> 
                                            <c:otherwise>
                                                <td>${reservation.requestDate}</td>
                                            </c:otherwise>
                                        </c:choose>


                                        <td>${reservation.confirmDate}</td>
                                        <td><span class="badge badge-warning rounded-pill">${reservation.status}</span></td>
                                        <td>
                                            <button type="button" class="btn btn-success btn-sm btn-rounded" data-toggle="modal" data-target="#confirm${reservation.reservationId}">
                                                Xác nhận
                                            </button>
                                            <button type="button" class="btn btn-danger btn-sm btn-rounded" onclick="cancel('${reservation.reservationId}')" data-toggle="modal" data-target="#cancel${reservation.reservationId}">
                                                Hủy
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <c:forEach items="${reservations.data}" var="reservation"  varStatus="counter" >
            <form action="ConfirmReservationController" method="GET">
                <div class="modal fade" id="confirm${reservation.reservationId}" tabindex="-1" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Xác nhận lịch khám bênh</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <label for="name" class="col-form-label">Họ và tên</label>
                                    <input type="text" class="form-control" id="name${reservation.reservationId}" readonly value="${reservation.patientName}">
                                </div>
                                <div class="form-group">
                                    <label for="service" class="col-form-label">Dịch vụ</label>
                                    <input type="text" class="form-control" id="service${reservation.reservationId}" readonly value="${reservation.service}">
                                </div>
                                <div class="form-group">
                                    <label for="package" class="col-form-label">Gói</label>
                                    <input type="text" class="form-control" id="package${reservation.reservationId}" readonly value="${reservation.packageService}">
                                </div>
                                <div class="form-group">
                                    <label for="request-time" class="col-form-label">Đã đặt lịch ngày</label>
                                    <input type="text" class="form-control" id="request-time${reservation.reservationId}" readonly value="${reservation.requestDate}">
                                </div>
                                <div class="form-group">
                                    <label for="request-time" class="col-form-label">Thời gian khám bệnh mong muốn</label>
                                    <input type="text" class="form-control" id="confirmed-time${reservation.reservationId}" readonly
                                           value="${reservation.confirmDate}">
                                </div>
                                <div class="form-group">
                                    <label for="request-time" class="col-form-label">Yêu cầu khám bệnh</label>
                                    <textarea class="form-control" id="request-time${reservation.reservationId}" readonly value="${reservation.medicalRequest}"></textarea>
                                </div>
                                <div class="form-group">
                                    <label for="doctor-lists">Danh sách bác sĩ</label>
                                    <select class="form-control" id="doctor-lists" name="doctor">
                                        <c:forEach items="${doctors}" var="doctor"  varStatus="counter" >
                                            <option  value="${doctor.id}">${doctor.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label for="confirmed-date" class="col-form-label">Ngày khám bệnh</label>
                                    <input type="date" class="form-control" id="confirmed-date${reservation.reservationId}" name="date" required>
                                </div>
                                <div class="form-group">
                                    <label for="confirm-time">Thời gian khám bệnh</label>
                                    <select class="form-control" id="confirm-time${reservation.reservationId}" name="time">
                                        <option>07:00:00</option>
                                        <option>08:00:00</option>
                                        <option>08:00:00</option>
                                        <option>09:00:00</option>
                                        <option>10:00:00</option>
                                        <option>11:00:00</option>
                                        <option>13:00:00</option>
                                        <option>14:00:00</option>
                                        <option>15:00:00</option>
                                        <option>16:00:00</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group" hidden>
                                <input type="text" class="form-control" name="id" value="${reservation.reservationId}">
                            </div>

                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Xác nhận</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </c:forEach>
        <div class="modal" id="cancel${reservation.reservationId}" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Xác nhận hủy lịch đặt</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>Bạn có đồng ý hủy lịch khám bệnh ko</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary">Có</button>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Không</button>
                    </div>
                </div>
            </div>
        </div>

        <c:if test="${reservations.totalItem == 0}">
            <div class="col-12">
                <p class="text-center">Không có dữ liệu</p>
            </div>
        </c:if>
        <div class="row mt-5">
            <div class="col-12 text-center">
                <ul>
                    <c:if test="${reservations.currentPage > 1}">
                        <a class="btn btn-light" href="BookScheduleController?page=${reservations.currentPage-1}">Trang trước</a>
                    </c:if>
                    <c:forEach var="pageNumber" begin="1" end="${reservations.totalPage}" step="1">
                        <c:if test="${reservations.currentPage == pageNumber}">
                            <a class="btn btn-success" href="#">${pageNumber}</a>
                        </c:if>
                        <c:if test="${reservations.currentPage != pageNumber}">
                            <a class="btn btn-light" href="BookScheduleController?page=${pageNumber}">${pageNumber}</a>
                        </c:if>
                    </c:forEach>
                    <c:if test="${reservations.currentPage < reservations.totalPage}">
                        <a class="btn btn-light" href="BookScheduleController?page=${reservations.currentPage+1}">Trang sau</a>
                    </c:if>
                </ul>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
                integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
                integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous">
        </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
                integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous">
        </script>
        <script>
            function cancel(id) {
             console.log(id);
		if (confirm("Do you want to cancel reservation with id " + id) == true) {
			 console.log("Ok "+id);
                         window.location.href = "CancelPendingReservationController?id=" + id;
		} 
            }
        </script>
    </body>
</html>
