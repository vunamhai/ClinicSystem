<!--

-->
<html lang="en">
    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Bootstrap Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <title>Clinic Management</title>
    </head>

    <body>
        <style>
            #service-container {
                margin: 0 0;
                max-width: 100%;
                padding: 0;
            }

            #add-btn {
                background-color: #fff;
                border: none;
                box-shadow: none !important;
            }

            .btn-only-ic {
                background-color: #fff !important;
                border-color: transparent;
                padding: 0 0;
                max-height: 20px;
            }

            /* Header */
            .navbar {
                border: 1px solid #adb5bd;
                background-color: #fff !important;
            }

            .nav-link {
                border-radius: 5px;
                border: 1px solid #ebebeb;
                margin-right: 10px;
                transition: all 0.3s ease-in-out;
                font-weight: bold;
                padding: .75rem 1rem;
                max-width: 150px;
                text-align: center;
            }

            .nav-link:hover,
            .nav-link.active {
                background-color: #8AB9FF;
            }

            .avatar {
                width: 45px;
                height: 45px;
                line-height: 45px;
                border-radius: 50%;
            }

            .avatar > img {
                display: block;
                width: 100%;
                height: 100%;
                object-fit: cover;
            }

            /* Title */
            #title {
                text-align: center;
                margin-top: 20px;
                margin-bottom: 90px;
            }

            /* Wrapper */
            .wrapper {
                width: 100vh;
                margin: auto;
            }

            #table-services > * > * > th{
                text-align: center;
            }

            tr > td.service-desc {
                white-space: nowrap;
                overflow: hidden;
                text-overflow: ellipsis;
                max-width: 508px;
            }

            td > .action {
                text-align: center;
            }

            td > .action > i {
                cursor: pointer;
            }

            /* Pagination */
            .pagi-wrapper {
                margin-top: 30px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 0 20px;
            }

            .non-block {
                width: 20px;
                height: 20px;
            }

            /* Modal */
            .modal-service {
                max-width: 850px;
            }

        </style>
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
                                <a class="nav-link" href="../ClinicManagerment/ServiceManagementController?page=${pageIndex}">Quản lý dịch vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Quản lý phản hồi</a>
                            </li>
                            
                        </ul>
                        <div class="avatar">
                            <img src="https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png" alt="avatar">
                        </div>
                    </div>
                </div>
            </nav>

            <h1 id="title">
                Dach sách phản hồi
            </h1>

            <div class="wrapper mt-5">
                <!-- Table -->
                <table class="table table-bordered align-middle" id="table-services">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Mã ID</th>
                            <th scope="col">Tên dịch vụ</th>
                            <th scope="col">Tên khách hàng</th>
                            <th scope="col">Username</th>
                            <th scope="col">Thời gian đánh giá</th>
                            <th scope="col">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${feedbacks.data}" var="feedback"  varStatus="counter" >
                            <tr>
                                <th scope="row">${counter.count}</th>
                                <td>${feedback.feedbackId}</td>
                                <td>${feedback.service}</td>
                                <td>${feedback.customer}</td>
                                <td>${feedback.username}</td>
                                <td>${feedback.feedbackTime}</td>
                                <td>
                                    <div class="action">
                                        <button class="btn btn-light border border-secondary" onclick="viewFeedbackModal({
                                            id: '${feedback.feedbackId}',
                                                    service_name: '${feedback.service}',
                                                    customer_name: '${feedback.customer}',
                                                    username: '${feedback.username}',
                                                    date_time: '${feedback.feedbackTime}',
                                                    feedback: '${feedback.feedbackContent}',
                                                    feedbackDoc: '${feedback.feedbackReply}'
                                            })">
                                            Chi tiết
                                        </button>
                                        <button class="btn btn-light border border-secondary" onclick="showFeedbackModal({
                                            id: '${feedback.feedbackId}',
                                                    service_name: '${feedback.service}',
                                                    customer_name: '${feedback.customer}',
                                                    username: '${feedback.username}',
                                                    date_time: '${feedback.feedbackTime}',
                                                    feedback: '${feedback.feedbackContent}',
                                                    feedbackDoc: '${feedback.feedbackReply}',
                                                    serviceId: '${feedback.serviceId}',
                                                    examinationId: '${feedback.examinationId}'
                                            })">
                                            Trả lời
                                        </button>
                                    </div>
                                </td>
                            </tr>

                        </c:forEach>
                    </tbody>
                </table>

                <!-- Pagination -->
                <div class="pagi-wrapper">
                    <c:if test="${feedbacks.totalPage > 1}">
                        <div class="row">
                            <div class="col-12 text-center">
                                <ul>
                                    <c:if test="${feedbacks.currentPage > 1}">
                                        <a class="btn btn-light" href="ViewFeedbackManagedListController?page=${feedbacks.currentPage-1}">Trang trước</a>
                                    </c:if>
                                    <c:forEach var="pageNumber" begin="1" end="${feedbacks.totalPage}" step="1">
                                        <c:if test="${feedbacks.currentPage == pageNumber}">
                                            <a class="btn btn-success" href="#">${pageNumber}</a>
                                        </c:if>
                                        <c:if test="${feedbacks.currentPage != pageNumber}">
                                            <a class="btn btn-light" href="ViewFeedbackManagedListController?page=${pageNumber}">${pageNumber}</a>
                                        </c:if>
                                    </c:forEach>
                                    <c:if test="${feedbacks.currentPage < feedbacks.totalPage}">
                                        <a class="btn btn-light" href="ViewFeedbackManagedListController?page=${services.currentPage+1}">Trang sau</a>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </c:if>
                </div>

                <!-- Feedback Modal -->
                <div class="modal fade" id="feedbackModal" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body my-3">
                                <div class="container-fluid">
                                    <div class="row g-3 border border-secondary px-3">
                                        <div class="pe-5 col-8">
                                            <div class="row mb-3">
                                                <label class="col-12 col-form-label">Username: <span id="username"></span></label>
                                            </div>
                                            <div class="row mb-3">
                                                <label class="col-12 col-form-label">Họ và tên: <span id="customer_name"></span></label>
                                            </div>
                                            <div class="row mb-3">
                                                <label class="col-12 col-form-label">
                                                    Thời gian phản hồi: <span id="date_time"></span>
                                                </label>
                                            </div>
                                            <div class="row">
                                                <label class="col-12 col-form-label">
                                                    Dịch vụ: <span id="service_name"></span>
                                                </label>
                                            </div>

                                        </div>
                                        
                                        <div class="col-12 mb-3">
                                            <textarea class="form-control" readonly rows="5" id="feedback">
                                            </textarea>
                                        </div>
                                    </div>
                                    <div class="row my-3 fw-bold">
                                        Nội dung trả lời
                                    </div>
                                    <form class="row" action="/ClinicManagerment/ReplyFeedbackController">
                                        <input name='serviceId' id='serviceId' style='display: none'/>
                                        <div class="form-group col-12 mb-3">
                                            <textarea name="content" id="reply" class="form-control" rows="5" required onchange="onChange(event)"></textarea>
                                            <span id='error' class='text-danger d-none'></span>
                                        </div>
                                        <div class="form-group col-12 text-end">
                                            <button 
                                                id='btn-reply'
                                                type="submit"
                                                class="btn btn-primary" 
                                                >
                                                Trả lời
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal fade" id="viewfeedbackModal" data-bs-keyboard="false" tabindex="-1" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body my-3">
                                <div class="container-fluid">
                                    <div class="row g-3 border border-secondary px-3">
                                        <div class="pe-5 col-8">
                                            <div class="row mb-3">
                                                <label class="col-12 col-form-label">Username: <span id="username"></span></label>
                                            </div>
                                            <div class="row mb-3">
                                                <label class="col-12 col-form-label">Họ và tên: <span id="customer_name"></span></label>
                                            </div>
                                            <div class="row mb-3">
                                                <label class="col-12 col-form-label">
                                                    Thời gian phản hồi: <span id="date_time"></span>
                                                </label>
                                            </div>
                                            <div class="row">
                                                <label class="col-12 col-form-label">
                                                    Dịch vụ: <span id="service_name"></span>
                                                </label>
                                            </div>

                                        </div>
                                        
                                        <div class="col-12 mb-3">
                                            <div id='feedback'>
                                               
                                            </div>
<!--                                            <textarea class="form-control" readonly rows="5" id="feedback">
                                            </textarea>-->
                                        </div>
                                    </div>
                                </div>
                            </div>
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

            <script>
                                                    function showFeedbackModal(data) {
                                                    $('#feedbackModal #username').html(data?.username)
                                                            $('#feedbackModal #customer_name').html(data?.customer_name)
                                                            $('#feedbackModal #service_name').html(data?.service_name)
                                                            $('#feedbackModal #date_time').html(data?.date_time)
                                                            $('#feedbackModal #feedback').html(data?.feedback)
                                                            
                                                            $('#feedbackModal #serviceId').val(data?.serviceId)
                                                            $('#feedbackModal #examinationId').val(data?.serviceId)

                                                            const fbModal = new bootstrap.Modal(document.getElementById('feedbackModal'), {})
                                                            fbModal.show()
                                                    }

                                                    function viewFeedbackModal(data) {
                                                        
                                                        
                                                        
                                                    $('#viewfeedbackModal #username').html(data?.username)
                                                            $('#viewfeedbackModal #customer_name').html(data?.customer_name)
                                                            $('#viewfeedbackModal #service_name').html(data?.service_name)
                                                            $('#viewfeedbackModal #date_time').html(data?.date_time)
//                                                            $('#viewfeedbackModal #feedback').html(data?.feedback)

                                                            const customerReply = document.createElement('p')
                                                        customerReply.innerHTML = 'Customer: ' + data?.feedback
                                                        $('#viewfeedbackModal #feedback').html('')
                                                        $('#viewfeedbackModal #feedback').append(customerReply)
                                                        
                                                        const listDocReplyStr = data?.feedbackDoc
                                                        if (listDocReplyStr) {
                                                            let listDocReplyArr = listDocReplyStr.replaceAll('[', '').replaceAll(']', '').split(', ')
                                                            if (listDocReplyArr.length > 0) 
                                                                for(let i = 0; i < listDocReplyArr.length; i++) {
                                                                    const p = document.createElement('p')
                                                                    p.innerHTML = 'Doctor: ' + listDocReplyArr[i]
                                                                    $('#viewfeedbackModal #feedback').append(p)
                                                                }
                                                        }
                                                        
                                                        

                                                            const fbModal = new bootstrap.Modal(document.getElementById('viewfeedbackModal'), {})
                                                            fbModal.show()
                                                    }
                                                    function onChange(e) {
                                                        const value = e.target.value
                                                        const spanError = document.getElementById('error')
                                                        const textLimit = 'Ban da nhap qua 300 ky tu'
                                                        const textInvalid = 'Khong duoc de trong truong nay'
                                                       
                                                        if (value.length > 0 && value.trim().length === 0) {
                                                            spanError.classList.remove('d-none')
                                                            spanError.classList.add('d-block')
                                                            spanError.innerHTML = textInvalid
                                                            $('#feedbackModal #btn-reply').attr('disabled', true)
                                                        } else if (value.length > 0 && value.trim().length > 0){
                                                             if (spanError.innerHTML === textInvalid) {
                                                                spanError.classList.add('d-none')
                                                                spanError.classList.remove('d-block')
                                                                $('#feedbackModal #btn-reply').removeAttr('disabled')
                                                            }
                                                        }
                                                        
                                                         if (value.length > 300) {
                                                            spanError.classList.remove('d-none')
                                                            spanError.classList.add('d-block')
                                                            spanError.innerHTML = textLimit
                                                            $('#feedbackModal #btn-reply').attr('disabled', true)
                                                        } else {
                                                            if (spanError.innerHTML === textLimit) {
                                                                spanError.classList.add('d-none')
                                                                spanError.classList.remove('d-block')
                                                                $('#feedbackModal #btn-reply').removeAttr('disabled')
                                                            }
                                                        }
                                                        
                                                    }
                                                    
            </script>
    </body>
</html>