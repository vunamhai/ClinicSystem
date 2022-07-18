
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/functions.tld" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="col-lg-12">
            <c:choose>
                <c:when test="${isAddNew == 0}">
                    <label for="examinationDisgosis"><h6>Chuẩn đoán</h6></label>
                    <textarea class="form-control" id="examinationDisgosis" rows="8" disabled>${examination.examinationDisgnosis}</textarea>
                    <label for="examinationPrescription"><h6>Đơn thuốc</h6></label>
                    <textarea class="form-control" id="examinationPrescription" rows="8" disabled>${examination.examinationPrescription}</textarea>
                </c:when>
                <c:when test="${isAddNew == 1}">
                    <form id="reservationId" action="${pageContext.request.contextPath}/addNewExamination" method="POST" data-toggle="validator" role="form">
                        <div class="form-row">
                            <label for="examinationDisgosis"><h6>Chuẩn đoán</h6></label>
                            <textarea class="form-control" id="examinationDisgosis" rows="8" name="examinationDisgosis" required maxlength="1000"></textarea>
                        </div>
                        <div class="form-row">
                            <label for="examinationPrescription"><h6>Đơn thuốc</h6></label>
                            <textarea class="form-control" id="examinationPrescription" rows="8" name="examinationPrescription" required maxlength="1000"></textarea>
                        </div>
                        <input type="hidden" name="reservationId" value="${reservationId}">
                        <button type="submit" class="mt-2 btn btn-primary btn-block">Đã khám xong</button>
                    </form>
                </c:when>
            </c:choose>
        </div>
    </body>
</html>