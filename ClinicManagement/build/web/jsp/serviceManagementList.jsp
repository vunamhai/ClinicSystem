<!--
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-05-26      1.0                 UyenNP         Controller Service Management List
-->

<!doctype html>
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <link rel="stylesheet" href="./assets/service/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <script src="new.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <title>Clinic Management</title>
    </head>

    <body>
        <div class="container" id="service-container">
            <!-- Header -->
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarClinicHeader" aria-controls="navbarClinicHeader" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarClinicHeader">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                            <li class="nav-item">
                                <a class="nav-link active" href="#">Quản lý dịch vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../ClinicManagement/ViewFeedbackManagedListController">Quản lý phản hồi</a>
                            </li>

                        </ul>
                        <div class="avatar">
                            <img src="https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png" alt="avatar">
                        </div>
                        <form action="SearchServiceController" method="POST">
                            <input type="text" placeholder="Search.." name="search">
                            <button type="submit">Tìm kiếm</button>
                        </form>
                    </div>
                </div>
            </nav>

            <h1 id="title">
                Dach sách dịch vụ
            </h1>

            <div class="wrapper">
                <button id="add-btn" type="button" class="btn btn-light mb-3" onclick="showAddServiceModal()">
                    <i class="bi bi-plus-circle-fill"></i>
                    Thêm dịch vụ
                </button>

                <!-- Table -->
                <table class="table table-bordered align-middle" id="table-services">
                    <thead>
                        <tr>
                            <th scope="col">STT</th>
                            <th scope="col">Mã ID</th>
                            <th scope="col">Tên dịch vụ</th>
                            <th scope="col">Tóm tắt dịch vụ</th>
                            <th scope="col">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${services}" var="service" >
                            <tr>
                                <th scope="row">${counter.count}</th>
                                <td>${service.serviceId}</td>
                                <td>${service.serviceName}</td>
                                <td class="service-desc">${service.serviceDescription}</td>
                                <td>
                                    <div class="action">
                                        <a class="bi bi-eye" href="ServiceManagementDetailController?id=${service.serviceId}"></a> 
                                        <button class="btn-only-ic" data-bs-target="#editServiceModal">
                                            <a href="ServiceManagementDetailController?Id=${service.serviceId}&page=${page}" class="bi bi-pencil-fill"></a>
                                        </button>
                                        <a class="bi bi-trash-fill" href="DeleteService?id=${service.serviceId}"></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div id="modal-update" class="modal-update">

                    <script>
                        function openModalUpdateService(idService) {
                            $.ajax({
                                type: "get",
                                url: "/ClinicManagement/UpdateService",
                                data: {
                                    idService: idService
                                }, // serializes the form's elements.
                                success: function (data)
                                {
                                    var formUpdate = document.getElementById("modal-update");
                                    formUpdate.innerHTML += data;
                                }
                            });
                            document.getElementById("modal-update").style.display = "flex";
                        }
                    </script>

                    <script>
                        function openModalDeleteService(idService) {
                            $.ajax({
                                type: "get",
                                url: "/ClinicManagement/DeleteService",
                                data: {
                                    idService: idService
                                }, // serializes the form's elements.
                                success: function (data)
                                {
                                    var formUpdate = document.getElementById("modal-update");
                                    formUpdate.innerHTML += data;
                                }
                            });
                            document.getElementById("modal-update").style.display = "flex";
                        }
                    </script>

                    <!-- Pagination -->

                    <!-- Detail Service Modal -->
                    <div class="modal fade" id="detailServiceModal" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog modal-lg">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <div class="non-block"></div>
                                    <h5 class="modal-title" id="staticBackdropLabel">Chi tiết dịch vụ</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <form class="row g-3">
                                            <div class="pe-5 col-6">
                                                <div class="row mb-3">
                                                    <label for="serviceCode" class="col-4 col-form-label">Mã dịch vụ</label>
                                                    <div class="col-8">
                                                        <span class="form-control-plaintext service_id"></span>
                                                    </div>
                                                </div>
                                                <div class="row mb-3">
                                                    <label for="serviceName" class="col-4 col-form-label">Tên dịch vụ</label>
                                                    <div class="col-8">
                                                        <span class="desc-text form-control-plaintext service_name"></span>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label for="serviceDesc" class="col-4 col-form-label">Mô tả</label>
                                                    <div class="col-8">
                                                        <span class="form-control-plaintext service_desc"></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="ps-5 col-6">
                                                <div class="row">
                                                    <div class="col-7 col-form-label">
                                                        Bác sĩ
                                                    </div>
                                                </div>
                                                <div class="row list-doctors">
                                                    <div class="list-doctors-scroll">

                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Add Service Modal -->



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

                <!-- Delete Service Modal -->



            </div>


            <!-- Bootstrap Bundle -->
            <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                    integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.0/jquery.min.js" integrity="sha256-xNzN2a4ltkB44Mc/Jz3pT4iU1cmeR0FkXs4pru/JxaQ=" crossorigin="anonymous"></script>

            <script> function renderDoctorListView (doctors, from) {
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
                                                                    console.log('123')

                                                                    let doctors = [];
            <c:forEach items="${doctors}" var="doctor"  varStatus="counter" >
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
                                                            
                                                            const setError = (element, message) => {
                                                                const inputControl = element.parentElement;
                                                                const errorDisplay = inputControl.querySelector('.error');

                                                                errorDisplay.innerText = message;
                                                                inputControl.classList.add('error');
                                                                inputControl.classList.remove('success')
                                                            }
                                                                         function editServiceSubmit () {
                                                            const idModal = '#editServiceModal'
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
                                                                    window.location.href = 'UpdateServiceController?service_name=' + service_name +
                                                                    '&service_id=' + service_id +
                                                                    '&service_desc=' + service_desc +
                                                                    '&list_doctors=' + stringListId
                                                                    const modal = new bootstrap.Modal(document.getElementById('editServiceModal'), {})
                                                                    modal.hide()
                                                            }
                                                          function selectDoctor(username) {
                                                            const selectingDoctor = $('#selectDoctorModal .list-doctors-scroll > .doctor-card#' + username)
                                                                    if (selectingDoctor.length <= 0) return;
                                                            console.log('abcxz')
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