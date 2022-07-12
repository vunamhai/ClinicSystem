<!--
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-06-8      1.0                 TuDA         Edit Service
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Bootstrap Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <link rel="stylesheet" href="./assets/service/style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="modal-dialog modal-lg" id="editServiceModal">
            <div class="modal-content">
                <div class="modal-header">
                    <div class="non-block"></div>
                    <h5 class="modal-title" id="staticBackdropLabel">Chỉnh sửa dịch vụ</h5>

                    <a href="../ClinicManagement/ServiceManagementController?page=${page}">
                      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                        </button>
                    </a>
                </div>
                <div class="modal-body">
                    <div class="container-fluid">
                        <form class="row g-3" >
                            <div class="pe-5 col-6">
                                <div class="row mb-3">
                                    <label for="serviceCode" class="col-4 col-form-label">Mã dịch vụ</label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" name="service_code" readonly
                                               id="serviceCode" value="${service.serviceId}" required maxlength="50"> 
                                    </div>
                                </div>
                                <div class="row mb-3">
                                    <label for="serviceName" class="col-4 col-form-label">Tên dịch vụ</label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" name="service_name" required maxlength="50"
                                               id="serviceName" value="${service.serviceName}">
                                        <span id='error_name' class="text-danger d-none"></span>
                                    </div>
                                </div>
                                <div class="row">
                                    <label for="serviceDesc" class="col-4 col-form-label">Mô tả</label>
                                    <div class="col-8">
                                        <textarea class="form-control" name="service_desc" id="serviceDesc"  required maxlength="50"
                                                  rows="3">${service.serviceDescription}</textarea>
                                                  <span id='error_desc' class="text-danger d-none"></span>
                                    </div>
                                </div>
                                                   <div class="row mb-3">
                                    <label for="serviceBrief" class="col-4 col-form-label">Tóm tắt dịch vụ</label>
                                    <div class="col-8">
                                        <textarea class="form-control" name="service_brief" id="serviceBrief"  required maxlength="250"
                                                  rows="3">${service.serviceBrief}</textarea>
                                        <span id='error_brief' class="text-danger d-none"></span>
                                    </div>
                                </div>
                            </div>
                            <div class="ps-5 col-6">
                                <div class="row">
                                    <div class="col-7 col-form-label">
                                        Bác sĩ
                                    </div>
                                    <button id="add-btn" type="button" class="btn btn-light col-5"
                                            onclick="showSelectDoctorModal('#editServiceModal')">
                                        Thêm bác sĩ
                                        <i class="bi bi-plus-circle-fill ms-1"></i>
                                    </button>
                                </div>
                                <div class="row list-doctors">
                                    <div class="list-doctors-scroll">
                                    </div>
                                </div>
                            </div>
                            <div class="col-auto mx-auto text-center">
                                <button 
                                    type='button'
                                    class="btn btn-primary" 
                                    data-bs-dismiss="modal"
                                    onclick="editServiceSubmit()"
                                    >Lưu thay đổi </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Select Doctor Modal -->
        <div class="modal fade" id="selectDoctorModal" data-bs-keyboard="false" tabindex="-1"
             aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-doctor">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="non-block"></div>
                        <h5 class="modal-title" id="staticBackdropLabel">Chọn bác sĩ</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="list-doctors">
                            <div class="list-doctors-scroll">
                            </div>
                        </div>
                        <div class="col-auto mx-auto text-center">
                            <button id="addDoc" type="button" class="btn btn-primary">Thêm</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Delete Doctor Modal -->
        <div class="modal fade" id="deleteDoctorModal" data-bs-keyboard="false" tabindex="-1"
             aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered modal-delete">
                <div class="modal-content">
                    <div class="modal-header justify-content-center">
                        <h5 class="modal-title" id="staticBackdropLabel">Thông báo</h5>
                    </div>
                    <div class="modal-body text-center">
                        Bạn có muốn xóa "<span class="doctor-name"></span>" không?
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-light" data-bs-dismiss="modal">
                            Không</button>
                        <button class="btn btn-primary btn-confirm" data-bs-dismiss="modal">
                            Có</button>
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

        <script>
                                        $(document).ready(function(){
                                        let doctors = [];
            <c:forEach items="${doctors}" var="doctor"  varStatus="counter" >
                                        doctors.push({
                                        name: '${doctor.name}',
                                                username: '${doctor.id}',
                                                image: '${doctor.image}'
                                        });
            </c:forEach>
                                        renderDoctorListView(doctors, '#editServiceModal')

                                        });
                                        function showDetailServiceModal(data = {}) {
                                        $('#detailServiceModal .list-doctors-scroll').html('')
                                                if (!data) return;
                                        $("#detailServiceModal .service_id").html(data?.id)
                                                $("#detailServiceModal .service_name").html(data?.name)
                                                $("#detailServiceModal .service_desc").html(data?.description)
                                                data?.doctors?.length > 0 && data?.doctors.forEach(doctor => {
                                                let html =
                                                        '<div class="doctor-card px-0">' +
                                                        '<div class="img-cover">' +
                                                        '<img src=' + doctor?.image + ' alt="">' +
                                                        '</div>' +
                                                        '<div class="d-flex flex-column my-2 mx-4">' +
                                                        doctor?.name +
                                                        `Id ${doctor.username}` +
                                                        '</div>' +
                                                        '</div>'

                                                        $('#detailServiceModal .list-doctors-scroll').append(html)
                                                })
                                                const detailModal = new bootstrap.Modal(document.getElementById('detailServiceModal'), {})
                                                detailModal.show()
                                        }

                                        function showAddServiceModal() {
                                        const addModal = new bootstrap.Modal(document.getElementById('addServiceModal'), {})
                                                addModal.show()
                                        }

                                        function showEditServiceModal(data = {}) {
                                        $('#editServiceModal .list-doctors-scroll').html('')
                                                if (!data) return;
                                        $('#editServiceModal #serviceCode').val(data?.id)
                                                $('#editServiceModal #serviceName').val(data?.name)
                                                $('#editServiceModal #serviceDesc').val(data?.description)
                                                // hiển thị danh sách bác sĩ
                                                renderDoctorListView(data?.doctors, '#editServiceModal')

                                                const editModal = new bootstrap.Modal(document.getElementById('editServiceModal'), {})
                                                editModal.show()
                                        }

                                        function renderDoctorListView (doctors, from) {
                                        $(from + ' .list-doctors-scroll').html('')
                                                doctors?.length > 0 && doctors.forEach(doctor => {
                                                let doctorCard = document.createElement('div')
                                                        doctorCard.setAttribute('class', 'doctor-card px0')
                                                        doctorCard.setAttribute('id', doctor?.username)

                                                        let imgCover = document.createElement('div')
                                                        imgCover.setAttribute('class', 'img-cover')
                                                        let img = document.createElement('img')
                                                        img.src = doctor?.image
                                                        img.alt = ''
                                                        imgCover.appendChild(img)

                                                        let divName = document.createElement('div')
                                                        divName.setAttribute('class', 'd-flex flex-column my-2 mx-3')
                                                        divName.innerHTML = doctor.name + '<br/>' + ' Id ' + doctor.username
                                                        let button = document.createElement('button')
                                                        button.setAttribute('type', 'button')
                                                        button.setAttribute('class', 'btn-only-ic')
                                                        button.onclick = function() {
                                                        showDeleteDoctorModal({doctor, from})
                                                        }
                                                let icon = document.createElement('i')
                                                        icon.setAttribute('class', 'bi bi-dash-circle-fill')
                                                        button.appendChild(icon)

                                                        doctorCard.appendChild(imgCover)
                                                        doctorCard.appendChild(divName)
                                                        doctorCard.appendChild(button)

                                                        $(from + ' .list-doctors-scroll').append(doctorCard)
                                                })
                                        }

                                        function showSelectDoctorModal(from) {
                                        const selectDoc = new bootstrap.Modal(document.getElementById('selectDoctorModal'), {})
                                                let doctors = [];
            <c:forEach items="${allDoctors}" var="doctor"  varStatus="counter" >
                                        doctors.push({
                                        name: '${doctor.name}',
                                                username: '${doctor.id}',
                                                image: '${doctor.image}'
                                        });
            </c:forEach>


                                        let doctorCards = $(from + ' .list-doctors-scroll > .doctor-card')
                                                let listId = []
                                                if (doctorCards?.length > 0) {
                                        for (let i = 0; i < doctorCards?.length; i++) {
                                        listId.push(doctorCards[i].id)
                                        }
                                        }
                                        renderDoctorListSelect(doctors, from, listId)
                                                const buttonAddDoc = $('#selectDoctorModal #addDoc')
                                                buttonAddDoc[0].onclick = function() {
                                        console.log(doctors);
                                        addDoctorBackToList(doctors, from)
                                                selectDoc.hide()
                                        }
                                        selectDoc.show()
                                        }

                                        function renderDoctorListSelect (doctors, from, listActive) {
                                        console.log(listActive)
                                                $('#selectDoctorModal .list-doctors-scroll').html('')
                                                setTimeout(() => {
                                                doctors?.length > 0 && doctors.forEach(doctor => {
                                                let doctorCard = document.createElement('div')
                                                        console.log(doctor.username)
                                                        doctorCard.setAttribute('class', 'doctor-card px0')
                                                        if (listActive.includes(doctor.username)) doctorCard.classList.add('active')
                                                        doctorCard.setAttribute('id', doctor?.username)
                                                        doctorCard.onclick = function () {
                                                        selectDoctor(doctor?.username)
                                                        }

                                                let imgCover = document.createElement('div')
                                                        imgCover.setAttribute('class', 'img-cover')
                                                        let img = document.createElement('img')
                                                        img.src = doctor?.image
                                                        img.alt = ''
                                                        imgCover.appendChild(img)

                                                        let divName = document.createElement('div')
                                                        let doctornameSpan = document.createElement('span')
                                                        let usernameSpan = document.createElement('span')
                                                        divName.setAttribute('class', 'd-flex flex-column my-2 mx-3')
                                                        doctornameSpan.innerHTML = doctor?.name
                                                        usernameSpan.innerHTML = 'Id ' + doctor.username
                                                        divName.appendChild(doctornameSpan)
                                                        divName.appendChild(usernameSpan)

                                                        let button = document.createElement('button')
                                                        button.setAttribute('type', 'button')
                                                        button.setAttribute('class', 'btn-checked')

                                                        let icon = document.createElement('i')
                                                        icon.setAttribute('class', 'bi bi-check-circle-fill')
                                                        button.appendChild(icon)

                                                        doctorCard.appendChild(imgCover)
                                                        doctorCard.appendChild(divName)
                                                        doctorCard.appendChild(button)

                                                        $('#selectDoctorModal .list-doctors-scroll').append(doctorCard)
                                                })
                                                }, 100)
                                        }

                                        function showDeleteServiceModal(id, serviceName) {
                                        $('#deleteServiceModal #service_name').html(serviceName)
                                                const deleteModal = new bootstrap.Modal(document.getElementById('deleteServiceModal'), {})
                                                deleteModal.show()
                                                const button = $('#deleteServiceModal #delete-btn')[0].onclick = function () {
                                        deleteServiceSubmit(id)
                                        }
                                        }

                                        function showDeleteDoctorModal({doctor, from}) {
                                        $('#deleteDoctorModal .doctor-name').html(doctor?.name)
                                                $('#deleteDoctorModal .btn-confirm')[0].onclick = function() {
                                        deleteDoctor(doctor?.username, from)
                                        }
                                        const deleteDocModal = new bootstrap.Modal(document.getElementById('deleteDoctorModal'), {})
                                                deleteDocModal.show()
                                        }

                                        function addServiceSubmit () {
                                        const idModal = '#addServiceModal'
                                                const service_id = $(idModal + ' #serviceCode').val()
                                                const service_name = $(idModal + ' #serviceName').val()
                                                const service_desc = $(idModal + ' #serviceDesc').val()

                                                let doctorCards = $(idModal + ' .list-doctors-scroll > .doctor-card')
                                                let listId = []
                                                if (doctorCards?.length > 0) {
                                        for (let i = 0; i < doctorCards?.length; i++) {
                                        listId.push(doctorCards[i].id)
                                        }
                                        }
                                        const body = {
                                        service_id,
                                                service_name,
                                                service_desc,
                                                doctors: listId
                                        }
                                        const stringListId = listId.join('-')
                                                window.location.href = 'AddServiceController?service_name=' + service_name +
                                                '&service_desc=' + service_desc +
                                                '&list_doctors=' + stringListId
                                        }




                                        function editServiceSubmit () {
                                        const idModal = '#editServiceModal'
                                                const service_id = $(idModal + ' #serviceCode').val()
                                                const service_name = $(idModal + ' #serviceName').val().trim()
                                                const service_desc = $(idModal + ' #serviceDesc').val().trim()
                                                const nameError = document.getElementById('error_name')
                                                const descError = document.getElementById('error_desc')
                                                const textError = 'Khong duoc de trong truong nay'
                                                                    
                                                if (service_name.length === 0) {
                                                    nameError.classList.remove('d-none')
                                                    nameError.classList.add('d-block')
                                                    nameError.innerHTML = textError
                                                    return;
                                                } else {
                                                    if (nameError.innerHTML === textError) {
                                                        nameError.classList.add('d-none')
                                                        nameError.classList.remove('d-block')
                                                        nameError.innerHTML = ''
                                                    }
                                                }
                                                               
                                                if (service_desc.length === 0) {
                                                    descError.classList.remove('d-none')
                                                    descError.classList.add('d-block')
                                                    descError.innerHTML = textError
                                                    return
                                                } else {
                                                    if (descError.innerHTML === textError) {
                                                        descError.classList.add('d-none')
                                                        descError.classList.remove('d-block')
                                                        descError.innerHTML = ''
                                                    }
                                                }

                                                let doctorCards = $(idModal + ' .list-doctors-scroll > .doctor-card')
                                                let listId = []
                                                if (doctorCards?.length > 0) {
                                        for (let i = 0; i < doctorCards?.length; i++) {
                                        listId.push(doctorCards[i].id)
                                        }
                                        }
                                        const body = {
                                        service_id,
                                                service_name,
                                                service_desc,
                                                doctors: listId
                                        }
                                        const stringListId = listId.join('-');
                                        console.log(window.location)
                                                const host = window.location.origin + '/ClinicManagement'
                                                window.location.href =
                                                host + '/UpdateServiceController?service_name=' + service_name +
                                                '&service_id=' + service_id +
                                                '&service_desc=' + service_desc +
                                                '&list_doctors=' + stringListId
//                                                        const modal = new bootstrap.Modal(document.getElementById('editServiceModal'), {})
//                                                        modal.hide()
                                        }

                                        function deleteServiceSubmit(id) {
                                        window.location.href = 'DeleteServiceController?service_id=' + id
                                        }

                                        function selectDoctor(username) {
                                        const selectingDoctor = $('#selectDoctorModal .list-doctors-scroll > .doctor-card#' + username)
                                                if (selectingDoctor.length <= 0) return;
                                        if (selectingDoctor[0].classList.contains('active')) {
                                        selectingDoctor[0].classList.remove('active')
                                        } else {
                                        selectingDoctor[0].classList.add('active')
                                        }

                                        const activeDoctors = $('#selectDoctorModal .active')
                                                const buttonAddDoc = $('#selectDoctorModal #addDoc')
                                                if (activeDoctors.length === 0) {
                                        buttonAddDoc[0].setAttribute('disabled', true)
                                        } else {
                                        buttonAddDoc[0].removeAttribute('disabled')
                                        }
                                        }

                                        function deleteDoctor(username, from) {
                                        $(from + ' .list-doctors-scroll > .doctor-card#' + username).remove()
                                        }

                                        function addDoctorBackToList(doctors, from) {
                                        const activeDoctors = $('#selectDoctorModal .active')
                                                let listId = []
                                                if (activeDoctors?.length > 0) {
                                        for (let i = 0; i < activeDoctors?.length; i++) {
                                        listId.push(activeDoctors[i].id)
                                        }
                                        }
                                        let tempList = doctors.filter(item => {
                                        return listId.includes(item.username)
                                        })
                                                console.log()
                                                renderDoctorListView(tempList, from)
                                        }

        </script>
    </body>
</html>
