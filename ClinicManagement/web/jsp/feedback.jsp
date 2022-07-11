<!DOCTYPE html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <style>
            @media (min-width: 576px) {
                .container {
                    max-width: 540px;
                }
            }

            @media (min-width: 768px) {
                .container {
                    max-width: 720px;
                }
            }

            @media (min-width: 992px) {
                .container {
                    max-width: 960px;
                }
            }

            @media (min-width: 1200px) {
                .container {
                    max-width: 1140px;
                }
            }

            @media (min-width: 1500px) {
                .container {
                    max-width: 1440px;
                }
            }

            @media (min-width: 1600px) {
                .container {
                    max-width: 1560px;
                }
            }

            .container {
                padding-top: 20px
            }

            .fs-12-b {
                font-size: 12px;
                font-weight: bold;
            }

            .fs-12-i {
                font-size: 12px;
                font-style: italic;
            }

            .fs-12 {
                font-size: 12px;
            }

            .item {
                background: white;
                border: 1px solid #e6e6e6;
                margin-bottom: 20px;
                box-shadow: 2px 2px 7px;
                border-radius: 5px;
            }

            .item_container {
                padding: 20px;
                display: flex;
            }

            .item_container img {
                width: 24px;
                height: 24px;
                border-radius: 50%;
                margin-top: 3px;
                margin-right: 10px;
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

            .item__feedback {
                border: 1px solid #e6e6e6;
                margin-top: 10px;
                padding: 10px;
                border-radius: 5px;
                background: #F2F5F7
            }

            .service {
                background: white;
                border: 1px solid #e6e6e6;
                margin-bottom: 20px;
                box-shadow: 2px 2px 7px;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <%@include file="components/customerHeader.jsp" %>
        <div class="container-fluid m-0 p-5">
            <h5 style="margin-bottom: 20px;">Đánh giá dịch vụ</h5>
            <div style="margin-left: 80%">
                <form action="../ClinicManagement/ViewFeedBackListController" method="GET">
                    <label for="time">select time</label>
                    <select name="time" id="status">
                        <c:forEach items="${times}" var="time"  varStatus="counter" >
                            <option value="${time}">${time}</option>
                        </c:forEach>
                    </select>
                    <button class="btn-primary" type="submit">Lọc</button>
                </form>
            </div>
            <div class="row">
                <div class="col-lg-8">
                    <ul style="list-style: none; padding:0;">
                        <c:if test="${feedbacks.data.size()  == 0}">
                            <h1>No result</h1>
                        </c:if>
                        <c:forEach items="${feedbacks.data}" var="feedback"  varStatus="counter" >
                            <li class="item">
                                <form action="../ClinicManagement/AddFeedbackController">
                                    <div class="item_container">
                                        <img src="../assets/images/logo-gg-new.png">
                                        <div>
                                            <div class="item_header">
                                                <div style="display: flex; flex-direction:column">
                                                    <span class="fs-12-b">${feedback.customer}</span>
                                                    <div>
                                                        <span class="fs-12-i">Dịch vụ:</span>
                                                        <span class="fs-12-b">${feedback.service}</span>
                                                    </div>
                                                </div>
                                                <time class="fs-12">${feedback.feedbackTime}</time>
                                            </div>
                                            <div class="item__content">
                                                ${feedback.feedbackContent}
                                            </div>
                                        </div>
                                    </div>
                                    <div hidden>
                                        <input type="text"value="${feedback.serviceId}" name="serviceId">
                                    </div>
                                    <div hidden>
                                        <input type="text"value="${feedback.examinationId}" name="examinationId">
                                    </div>
                                </form>
                            </li>

                        </c:forEach>
                    </ul>
                </div>
                <div class="col-lg-4">
                    <form action="ViewFeedBackListController" method="Get">
                        <div class="service">
                            <h6 style="margin:10px">Dịch vụ</h6>
                            <div style="margin-top:10px; margin-left:40px;">
                                <c:forEach items="${services.data}" var="service"  varStatus="counter" >
                                    <input type="radio" value="${service.serviceId}" name="serviceId">
                                    <label for="1">${service.serviceName}</label><br>
                                </c:forEach>
                            </div>
                            <div style="text-align: center; margin-top:10px; margin-bottom:15px">
                                <button type="submit" class="btn btn-primary" style="width: 100px">Lọc</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

        </div>
        <div class="pagi-wrapper">
            <c:if test="${feedbacks.totalPage > 1}">
                <div class="row">
                    <div class="col-12 text-center">
                        <ul>
                            <c:if test="${feedbacks.currentPage > 1}">
                                <a class="btn btn-light" href="ViewFeedBackListController?page=${feedbacks.currentPage-1}">Trang trước</a>
                            </c:if>
                            <c:forEach var="pageNumber" begin="1" end="${feedbacks.totalPage}" step="1">
                                <c:if test="${feedbacks.currentPage == pageNumber}">
                                    <a class="btn btn-success" href="#">${pageNumber}</a>
                                </c:if>
                                <c:if test="${feedbacks.currentPage != pageNumber}">
                                    <a class="btn btn-light" href="ViewFeedBackListController?page=${pageNumber}">${pageNumber}</a>
                                </c:if>
                            </c:forEach>
                            <c:if test="${feedbacks.currentPage < feedbacks.totalPage}">
                                <a class="btn btn-light" href="ViewFeedBackListController?page=${services.currentPage+1}">Trang sau</a>
                            </c:if>
                        </ul>
                    </div>
                </div>
            </c:if>
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