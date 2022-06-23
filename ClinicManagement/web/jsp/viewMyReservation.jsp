
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/functions.tld" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8;">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Clinic Management System</title>
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        @media screen and (min-width: 676px) {
            .modal-ex-lg {
                max-width: 1000px; /* New width for default modal */
            }
        }
    </style>
    <body>
        <!--Import header-->
        <%@include file="components/doctorHeader.jsp" %>
        <!--Start main content-->
        <div>
            <div class="container-fluid p-0">
                <div class="row justify-content-center mt-3 mr-0">
                    <h4>Lịch hẹn của tôi</h4>
                </div>
                <form id="myForm" action="${pageContext.request.contextPath}/viewMyReservation" method="POST">
                    <div class="row justify-content-end mt-3 mr-0">
                        <div class="col-lg-2 mr-5">
                            <h6 class="float-right">Hôm nay</h6>
                            <input type="text" class="form-control" id="datepicker" name="viewDay">
                        </div>
                    </div>
                    <div class="row justify-content-end mt-3 mr-0">
                        <div class="col-lg-2 mr-5">
                            <h6 class="float-right">Ngày trong tuần</h6>
                            <input type="text" hidden="enabled" id="startWeek" name="startWeek">
                            <input type="text" hidden="enabled" id="endWeek" name="endWeek">
                            <input type="text" class="form-control" id="weekRange" aria-label="Disabled input example" disabled readonly>
                        </div>
                    </div>
                </form>
                <div class="container-fluid mt-5 m-0 p-0">
                    <div class="table-responsive overflow-auto">
                        <table class="table table-bordered text-center ">
                            <tr>
                                <th  scope="col" class="bg-light"></th>
                                <th scope="col" class="${(today eq dayOfWeek[0]) ? "bg-primary text-white" : "bg-dark text-white"}" id="Mon">Thứ Hai<br/><c:out value="${dayOfWeek[0]}"/></th>
                                <th scope="col" class="${(today eq dayOfWeek[1]) ? "bg-primary text-white" : "bg-dark text-white"}" id="Tue">Thứ Ba<br/><c:out value="${dayOfWeek[1]}"/></th>
                                <th scope="col" class="${(today eq dayOfWeek[2]) ? "bg-primary text-white" : "bg-dark text-white"}" id="Wed">Thứ Tư<br/><c:out value="${dayOfWeek[2]}"/></th>
                                <th scope="col" class="${(today eq dayOfWeek[3]) ? "bg-primary text-white" : "bg-dark text-white"}" id="Thu">Thứ Năm<br/><c:out value="${dayOfWeek[3]}"/></th>
                                <th scope="col" class="${(today eq dayOfWeek[4]) ? "bg-primary text-white" : "bg-dark text-white"}" id="Fri">Thứ Sáu<br/><c:out value="${dayOfWeek[4]}"/></th>
                                <th scope="col" class="${(today eq dayOfWeek[5]) ? "bg-primary text-white" : "bg-dark text-white"}" id="Sat">Thứ Bảy<br/><c:out value="${dayOfWeek[5]}"/></th>
                                <th scope="col" class="${(today eq dayOfWeek[6]) ? "bg-primary text-white" : "bg-dark text-white"}" id="Sun">Chủ Nhật<br/><c:out value="${dayOfWeek[6]}"/></th>
                            </tr>
                            <c:forEach begin="7" end="16" step="1" var="k">
                                <c:choose>
                                    <c:when test="${k eq 12}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">12:00</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-dark text-white m-0 p-0":"bg-light text-dark m-0 p-0"}">12:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-dark text-white m-0 p-0":"bg-light text-dark m-0 p-0"}">12:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-dark text-white m-0 p-0":"bg-light text-dark m-0 p-0"}">12:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-dark text-white m-0 p-0":"bg-light text-dark m-0 p-0"}">12:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-dark text-white m-0 p-0":"bg-light text-dark m-0 p-0"}">13:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and k lt 10}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-1-0${k}">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-2-0${k}">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-3-0${k}">${k}:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-4-0${k}">${k+1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and (k gt 10 or k eq 10)}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-1-${k}">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-2-${k}">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-3-${k}">${k}:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${dayOfWeek}">
                                                <td class="${(today eq i) ? "bg-info text-white m-0 p-0" : "bg-white text-dark m-0 p-0"}" id="${i}-4-${k}">${k+1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="viewDetailReservationPopup" data-backdrop="true" data-keyboard="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn btn-primary" data-dismiss="modal">Trở lại</button>
                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">
                            <div class="row mt-2 mb-5" id="viewDetailReservationPopupContent">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer" hidden="true">
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="viewExaminationHistoryPopup" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-ex-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#viewDetailReservationPopup" data-dismiss="modal">Trở lại</button>
                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">
                            <div class="row mt-2 mb-5" id="viewExaminationHistoryPopupContent">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer" hidden="true">
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="viewExaminationDetailPopup" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#viewExaminationHistoryPopup" data-dismiss="modal">Trở lại</button>
                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">
                            <div class="row mt-2 mb-5" id="viewExaminationDetailPopupContent">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer" hidden="true">
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="addNewExaminationPopup" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#viewDetailReservationPopup" data-dismiss="modal">Trở lại</button>
                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">
                            <div class="row mt-2" id="addNewExaminationPopupContent">
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer" hidden="true">
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="cancelReservationPopup" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog modal-md">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="container-fluid">
                            <div class="row mt-2" id="cancelExaminationPopupContent">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--Import js lib-->
        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="./assets/js/popper.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./assets/js/jquery-ui.min.js" type="text/javascript"></script>
        <!--Import js code-->
        <script>
            function openViewReservationDetailPopup(elem) {
                var id = $(elem).attr("id");
                $.ajax({
                    url: "${pageContext.request.contextPath}/viewMyReservationDetail",
                    type: "post",
                    dataType: "text",
                    data: {
                        reservationId: id
                    },
                    success: function (result) {
                        $("#viewDetailReservationPopupContent").html(result);
                    }
                });
            }
            function openViewExaminationHistoryPopup(elem) {
                var id = $(elem).attr("id");
                var currentPage = $(elem).val();
                $.ajax({
                    url: "${pageContext.request.contextPath}/viewExaminationHistory",
                    type: "post",
                    dataType: "text",
                    data: {
                        customerId: id,
                        currentPage: currentPage
                    },
                    success: function (result) {
                        $("#viewExaminationHistoryPopupContent").html(result);
                    }
                });
            }
            function openViewExaminationDetailPopup(elem) {
                var id = $(elem).attr("id");
                $.ajax({
                    url: "${pageContext.request.contextPath}/viewExaminationHistoryDetail",
                    type: "post",
                    dataType: "text",
                    data: {
                        examinationId: id,
                    },
                    success: function (result) {
                        $("#viewExaminationDetailPopupContent").html(result);
                    }
                });
            }
            function openAddNewExaminationPopup(elem) {
                var id = $(elem).attr("id");
                $.ajax({
                    url: "${pageContext.request.contextPath}/viewExaminationHistoryDetail",
                    type: "post",
                    dataType: "text",
                    data: {
                        reservationId: id,
                        isAddNew: 1
                    },
                    success: function (result) {
                        $("#addNewExaminationPopupContent").html(result);
                    }
                });
            }
            function openCancelReservationConfirmDialog(elem) {
                var id = $(elem).attr("id");
                $.ajax({
                    url: "${pageContext.request.contextPath}/cancelReservation",
                    type: "get",
                    dataType: "text",
                    data: {
                        reservationId: id
                    },
                    success: function (result) {
                        $("#cancelExaminationPopupContent").html(result);
                    }
                });
            }
            $(document).ready(function () {
                var weekday = new Array(7);
                weekday[0] = "Monday";
                weekday[1] = "Tuesday";
                weekday[2] = "Wednesday";
                weekday[3] = "Thursday";
                weekday[4] = "Friday";
                weekday[5] = "Saturday";
                weekday[6] = "Sunday";
                function convert(str) {
                    var date = new Date(str),
                            mnth = ("0" + (date.getMonth() + 1)).slice(-2),
                            day = ("0" + date.getDate()).slice(-2);
                    return [mnth, day, date.getFullYear()].join("/");
                }
                $("#datepicker").datepicker({
                    firstDay: 1,
                    changeMonth: true,
                    maxDate: '+6D',
                    onSelect: function () {
                        var date = $(this).datepicker('getDate');
                        var dayOfWeek = weekday[date.getUTCDay()];
                        var startWeek = $(this).datepicker('getDate');
                        var endWeek = $(this).datepicker('getDate');
                        if (dayOfWeek === "Monday") {
                            endWeek.setDate(endWeek.getDate() + 6);
                        } else if (dayOfWeek === "Tuesday") {
                            startWeek.setDate(startWeek.getDate() - 1);
                            endWeek.setDate(endWeek.getDate() + 5);
                        } else if (dayOfWeek === "Wednesday") {
                            startWeek.setDate(startWeek.getDate() - 2);
                            endWeek.setDate(endWeek.getDate() + 4);
                        } else if (dayOfWeek === "Thursday") {
                            startWeek.setDate(startWeek.getDate() - 3);
                            endWeek.setDate(endWeek.getDate() + 3);
                        } else if (dayOfWeek === "Friday") {
                            startWeek.setDate(startWeek.getDate() - 4);
                            endWeek.setDate(endWeek.getDate() + 2);
                        } else if (dayOfWeek === "Saturday") {
                            startWeek.setDate(startWeek.getDate() - 5);
                            endWeek.setDate(endWeek.getDate() + 1);
                        } else if (dayOfWeek === "Sunday") {
                            startWeek.setDate(startWeek.getDate() - 6);
                            endWeek.setDate(endWeek.getDate());
                        }
                        $("#startWeek").val(convert(startWeek));
                        $("#endWeek").val(convert(endWeek));
                        $("#weekRange").val(convert(startWeek) + " - " + convert(endWeek));
                        document.getElementById("myForm").submit();
                    },
                });
                $("#startWeek").val('${startWeek}');
                $("#endWeek").val('${endWeek}');
                $("#weekRange").val('${startWeek}' + " - " + '${endWeek}');
                $("#datepicker").val('${viewDay}'); //set date want to view for datepicker
            <c:forEach items="${reservations}" var="i" varStatus="status">
                var servicePackageId = '${i.servicePackage.packageId}';
                var confirmedExaminationTime = '${i.confirmedExaminationTime}'.split(":")[0];
                var confirmedExaminationDate = '${i.confirmedExaminationDate}';
                var idProperties = confirmedExaminationDate + '-' + servicePackageId + '-' + confirmedExaminationTime;
                $("#" + idProperties).text("");
                var reservationStatus = '${i.reservationStatus}';
                if (reservationStatus === 'Đặt thành công') {
                    $("#" + idProperties).append("<div class=\"rounded bg-primary text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><a class=\"text-white\" href=\"#viewDetailReservationPopup\" id=\"${i.reservationId}\" data-toggle=\"modal\" onClick=\"openViewReservationDetailPopup(this)\">Chi tiết</a></div>");
                } else if (reservationStatus === 'Đã khám') {
                    $("#" + idProperties).append("<div class=\"rounded bg-success text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><i>${i.reservationStatus}</i></div>");
                } else if (reservationStatus === 'Đã hủy') {
                    $("#" + idProperties).append("<div class=\"rounded bg-danger text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><i>${i.reservationStatus}</i></div>");
                } else {
                    $("#" + idProperties).append("<div class=\"rounded bg-secondary text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><a class=\"text-white\" href=\"#\">Chi tiết</a></div>");
                }
            </c:forEach>
            });
        </script>
    </body>
</html>