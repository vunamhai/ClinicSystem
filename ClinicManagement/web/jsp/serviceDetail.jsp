
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <link href="./assets/themes/krajee-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/select2.min.css" />
        <link rel="stylesheet" href="./assets/css/select2-bootstrap-5-theme.min.css" />
        <link rel="stylesheet" href="./assets/css/custom.css" />
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:include page="./components/customerHeader.jsp" />
        <div class="container-fuild">
            <div class="row-fluid mb-5">
                <img class="col-lg-12 p-0" src="./assets/images/banner.jpg" alt="Banner"/>
            </div>
            <div class="row my-5">
                <div class="col-md-8 mx-auto bg-primary p-5 rounded">
                    <h2 class="text-white">Giới thiệu về ${service.serviceName}</h2>
                    <div class="row">
                        <div class="col-md-6 mt-5">
                            <img src="./assets/images/${service.serviceImage}" class="d-block w-100">
                        </div>
                        <div class="col-md-6 mt-5 p-5">
                            <h4 class="text-white">${service.serviceDescription}</h3>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row my-5">
                <c:set var = "count" scope = "page" value = "0"/>
                <c:forEach var="i" items="${packages}">
                    <c:set var = "count" scope = "page" value = "${count+1}"/>
                    <div class="col-md-2 mx-auto border rounded">
                        <div class="row">
                            <img src="./assets/images/gói ${count}.png" class="d-block w-100"/>
                        </div>
                        <div class="row pl-1 my-1">
                            <b>${i.packageTitle}</b>
                        </div>
                        <div class="row pl-1 my-1">
                            <span><b>Thời gian khám: </b><span class="font-italic">${i.examinationDuration}</span></span>
                        </div>
                        <div class="row pl-1 my-1">
                            <span class="justify-content-center"><b>Giá: </b><h3 class="font-weight-bold text-primary">${i.price} VND</h3></span>
                        </div>
                        <div class="row-fluid px-auto ml-5 my-1">
                            <a href="BookReservationController?serviceId=${service.serviceId}&packageId=${i.packageId}" class="button">
                                <button type="button" class="btn btn-primary w-75">Đăng ký</button>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <%@include file="components/footer.jsp" %>
        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>
</html>