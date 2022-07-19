<%-- 
    Document   : viewAllReservation
    Created on : 12-07-2022, 08:06:13
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8;">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Clinic Management System</title>
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="./assets/css/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--Import header-->
        <%@include file="components/managerHeader.jsp" %>

        <!--Start main content-->
        <div class="">
            <div class="container-fluid p-0">
                <div class="row justify-content-center mt-3 mr-0">
                    <h4>Danh sách tất cả lịch khám bệnh</h4>
                </div>
                <form id="myForm" action="ViewAllReservationsController" method="POST">
                    <div class="row justify-content-end mt-3 mr-4">
                        <div class="mx-4">
                            <select name="serviceId" id="serviceId" class="form-control">
                                <option value="-1">Tất cả dịch vụ</option>
                                <c:forEach items="${services}" var="i">
                                    <option value="${i.serviceId}" ${(serviceId ne null and serviceId eq i.serviceId) ? "selected":""}>${i.serviceName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row justify-content-end mt-3 mr-0">
                        <div class="mr-5">
                            <input type="text" class="form-control" id="datepicker" name="viewDay">
                        </div>
                        <div class="mr-5">
                            <button type="button" class="btn btn-primary px-4" id="today">Hôm nay</button>
                        </div>
                    </div>
                </form>
                <div class="container-fluid mt-3 m-0 p-0">
                    <div class="table-responsive overflow-auto">
                        <table class="table table-bordered text-center ">
                            <tr>
                                <th  scope="col" class="bg-light"></th>
                                    <c:forEach var="i" items="${doctors}">
                                    <th scope="col" class="bg-dark text-white ">${i.fullName}<br/>(07:00AM-05:00PM)</th>
                                    </c:forEach>
                            </tr>
                            <c:forEach begin="7" end="16" step="1" var="k">
                                <c:choose>
                                    <c:when test="${k eq 12}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">12:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">12:45</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">13:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and k lt 10}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-1-0${k}">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-2-0${k}">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-3-0${k}">${k}:40</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-4-0${k}">${k+1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                    <c:when test="${k ne 12 and (k gt 10 or k eq 10)}">
                                        <tr>
                                            <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-light text-dark m-0 p-0">${k}:00</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">15</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-1-${k}">${k}:15</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">30</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-2-${k}">${k}:30</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">45</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-3-${k}">${k}:40</td>
                                            </c:forEach>
                                        </tr>
                                        <tr>
                                            <td class="bg-white text-dark m-0 p-0">60</td>
                                            <c:forEach var="i" items="${doctors}">
                                                <td class="bg-white text-dark m-0 p-0" id="${i.userId}-4-${k}">${k+1}:00</td>
                                            </c:forEach>
                                        </tr>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
            <!--End main content-->
        </div>
        <!--Import js lib-->
        <script src="./assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="./assets/js/popper.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./assets/js/jquery-ui.min.js" type="text/javascript"></script>
        <!--Import js code-->
        <script>
            $(document).ready(function () {
                //set date picker
                $("#datepicker").datepicker({
                    firstDay: 1,
                    changeMonth: true,
                    maxDate: '+6D',
                    onSelect: function () {
                        document.getElementById("myForm").submit();
                    },
                });
                $("#datepicker").val('${viewDay}'); //set date want to view for datepicker
            <c:forEach items="${reservations}" var="i" varStatus="status">
                var servicePackageId = '${i.servicePackage.packageId}';
                var confirmDoctorId = '${i.confirmedDoctor.userId}';
                var confirmedExaminationTime = '${i.confirmedExaminationTime}'.split(":")[0];
                var idProperties = confirmDoctorId + '-' + servicePackageId + '-' + confirmedExaminationTime;
                $("#" + idProperties).text("");
                var reservationStatus = '${i.reservationStatus}';
                if (reservationStatus === 'Đặt thành công') {
                    $("#" + idProperties).append("<div class=\"rounded bg-primary text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><b>Dịch vụ:  </b><i>${i.service.serviceName}</i></div>");
                } else if (reservationStatus === 'Đã khám') {
                    $("#" + idProperties).append("<div class=\"rounded bg-success text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><b>Dịch vụ:  </b><i>${i.service.serviceName}</i></div>");
                } else if (reservationStatus === 'Đã hủy') {
                    $("#" + idProperties).append("<div class=\"rounded bg-danger text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><b>Dịch vụ:  </b><i>${i.service.serviceName}</i></div>");
                } else {
                    $("#" + idProperties).append("<div class=\"rounded bg-secondary text-white m-0 p-0\"><b>${i.customer.fullName}</b><br/><b>Dịch vụ:  </b><i>${i.service.serviceName}</i></div>");
                }
            </c:forEach>
            });
            //set today for datepicker
            $("#today").click(function () {
                var today = new Date();
                console.log(today);
                var dd = String(today.getDate()).padStart(2, '0');
                var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
                var yyyy = today.getFullYear();
                today = mm + '/' + dd + '/' + yyyy;
                $("#datepicker").val(today);
                document.getElementById("myForm").submit();
            });
        </script>
    </body>
</html>
