
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/functions.tld" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="col-lg-12">
            <table class="table table-striped border table-sm col-lg-12">
                <thead>
                    <tr>
                        <th scope="col">Ngày khám</th>
                        <th class="col-lg-3" scope="col">Dịch vụ</th>
                        <th class="col-lg-2" scope="col">Gói</th>
                        <th class="col-lg-2" scope="col">Bác sĩ</th>
                        <th class="col-lg-2" scope="col">Trạng Thái</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="i" items="${examination}">
                        <tr>
                            <td>${i.examinationDate}</td>
                            <td>${i.reservation.service.serviceName}</td>
                            <td>${i.reservation.servicePackage.packageTitle}</td>
                            <td>${i.doctor.fullName}</td>
                            <td class="text-success">${i.reservation.reservationStatus}</td>
                            <td><a id="${i.examinationId}" onClick="openViewExaminationDetailPopup(this)" data-toggle="modal" href="#viewExaminationDetailPopup" data-dismiss="modal">Xem Chi Tiết</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="row ml-auto justify-content-center" >
                <input type="hidden" name="customerId" value="${customerId}"/>
                <button ${currentPage>1?'class="btn btn-primary"':'class="btn btn-secondary" disabled'} value="${currentPage-1}" id="${customerId}" onClick="openViewExaminationHistoryPopup(this)">Trang trước</button>
                <c:choose>
                    <c:when test="${numberOfPage > 5}">
                        <c:choose>
                            <c:when test="${currentPage<=2}">
                                <c:forEach var="i" begin="1" end="5">
                                    <button class="${i eq currentPage?'btn btn-dark':'btn btn-light'}" value="${i}" id="${customerId}" onClick="openViewExaminationHistoryPopup(this)">${i}</button>  
                                </c:forEach>
                            </c:when>
                            <c:when test="${currentPage>=numberOfPage-1}">
                                <c:forEach var="i" begin="${currentPage-2}" end="${numberOfPage}">
                                    <button class="${i eq currentPage?'btn btn-dark':'btn btn-light'}" value="${i}" id="${customerId}" onClick="openViewExaminationHistoryPopup(this)">${i}</button>  
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="i" begin="${currentPage-2}" end="${currentPage+2}">
                                    <button class="${i eq currentPage?'btn btn-dark':'btn btn-light'}" value="${i}" id="${customerId}" onClick="openViewExaminationHistoryPopup(this)">${i}</button>  
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="i" begin="1" end="${numberOfPage}">
                            <button class="${i eq currentPage?'btn btn-dark':'btn btn-light'}" value="${i}" id="${customerId}" onClick="openViewExaminationHistoryPopup(this)">${i}</button>  
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
                <button ${currentPage<numberOfPage?'class="btn btn-primary"':'class="btn btn-secondary" disabled'} value="${currentPage+1}" id="${customerId}" onClick="openViewExaminationHistoryPopup(this)">Trang sau</button>
                <!--End paging -->
            </div>
        </div>                          
    </body>
</html>