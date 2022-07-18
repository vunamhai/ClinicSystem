
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="/WEB-INF/functions.tld" prefix="f" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div class="col-md-6 border-right">
            <h4>Thông tin cá nhân</h4>
            <label for="fullName">Họ và tên</label>
            <input type="text" class="form-control" id="fullName" value="${reservation.customer.fullName}" disabled="disabled"/>
            <label for="dateBirth">Ngày sinh</label>
            <input type="text" class="form-control" id="dateBirth" value="${reservation.customer.birthDate}" disabled="disabled"/>
            <br/>
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" value="${reservation.customer.email}" disabled="disabled"/>
            <br/>
            <label class="mr-5">Giới tính</label>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="male" ${(reservation.customer.gender == true) ? "checked=\"checked\"":""} disabled="disabled">
                <label class="form-check-label" for="male"  >Nam</label>
            </div>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gender" id="female" ${(reservation.customer.gender == false) ? "checked=\"checked\"":""} disabled="disabled">
                <label class="form-check-label" for="female">Nữ</label>
            </div>
            <br/>
            <label for="phone">Điện thoại</label>
            <input type="number" class="form-control" id="phone" value="${reservation.customer.phone}" disabled="disabled"/>
            <br/>
            <label for="address">Địa chỉ</label>
            <input type="text" class="form-control" id="address" value="${reservation.customer.address}" disabled="disabled"/>
        </div>
        <div class="col-md-6">
            <dl class="row ml-auto mb-2">
                <dt class="col-sm-7">Dịch vụ:</dt>
                <dd class="col-sm-5">${reservation.service.serviceName}</dd>
                <dt class="col-sm-7">Gói:</dt>
                <dd class="col-sm-5">${reservation.servicePackage.packageTitle}</dd>
                <dt class="col-sm-7">Thời gian khám bệnh:</dt>
                <dd class="col-sm-5">${reservation.servicePackage.examinationDuration}</dd>
                <dt class="col-sm-7">Ngày khám bệnh: </dt>
                <dd class="col-sm-5">${reservation.confirmedExaminationDate} ${reservation.confirmedExaminationTime}</dd>
                <dt class="col-sm-7">Yêu cầu y tế:</dt>
                <dd class="col-sm-5">${(reservation.medicalRequest ne null) ? reservation.medicalRequest : "Không có"}</dd>
            </dl>
            <div class="row ml-auto mt-5">
                <button type="button" class="btn btn-info btn-block" id="${reservation.customer.userId}" onClick="openViewExaminationHistoryPopup(this)" value="1" data-toggle="modal" data-target="#viewExaminationHistoryPopup" data-dismiss="modal">Xem lịch sử khám bệnh</button>
                <button type="button" class="btn btn-success btn-block" id="${reservation.reservationId}" onclick="openAddNewExaminationPopup(this)" data-toggle="modal" data-target="#addNewExaminationPopup" data-dismiss="modal">Thêm mới lịch sử khám bệnh</button>
                <button type="button" class="btn btn-warning btn-block" id="${reservation.reservationId}" onclick="openChangeReservationDate(this)" data-toggle="modal" data-target="#changeReservationDatePopup" data-dismiss="modal">Đổi lịch đặt chỗ</button>
                <button type="button" class="btn btn-danger btn-block" id="${reservation.reservationId}" onclick="openCancelReceiveReservationConfirmDialog(this)" data-toggle="modal" data-target="#cancelReceiveReservationPopup" data-dismiss="modal">Hủy nhận lịch đặt chỗ này</button>
                <button type="button" class="btn btn-danger btn-block" id="${reservation.reservationId}" onclick="openCancelReservationConfirmDialog(this)" data-toggle="modal" data-target="#cancelReservationPopup" data-dismiss="modal">Hủy lịch đặt chỗ</button>
            </div>
        </div>                          
    </body>
</html>