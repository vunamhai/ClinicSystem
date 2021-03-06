
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
                                <a class="nav-link active" href="#">Qu???n l?? d???ch v???</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../ClinicManagement/ViewFeedbackManagedListController">Qu???n l?? ph???n h???i</a>
                            </li>

                        </ul>
                        <div class="avatar">
                            <img src="https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png" alt="avatar">
                        </div>
                        <form action="SearchServiceController" method="POST">
                            <input type="text" placeholder="Search.." name="search">
                            <button type="submit">T??m ki???m</button>
                        </form>
                    </div>
                </div>
            </nav>

            <h1 id="title">
                Dach s??ch d???ch v???
            </h1>

            <div class="wrapper">
                <button id="add-btn" type="button" class="btn btn-light mb-3" onclick="showAddServiceModal()">
                    <i class="bi bi-plus-circle-fill"></i>
                    Th??m d???ch v???
                </button>

                <!-- Table -->
                <table class="table table-bordered align-middle" id="table-services">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">M?? ID</th>
                            <th scope="col">T??n d???ch v???</th>
                            <th scope="col">T??m t???t d???ch v???</th>
                            <th scope="col">Thao t??c</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${searchList}" var="service" >
                            <tr>
                                <th scope="row">${counter.count}</th>
                                <td>${service.serviceId}</td>
                                <td>${service.serviceName}</td>
                                <td class="service-desc">${service.serviceDescription}</td>
                                <td>
                                    <div class="action">
                                        <a class="bi bi-pencil-fill" href="UpdateService?id=${service.serviceId}"></a> 
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
                                    <h5 class="modal-title" id="staticBackdropLabel">Chi ti???t d???ch v???</h5>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body">
                                    <div class="container-fluid">
                                        <form class="row g-3">
                                            <div class="pe-5 col-6">
                                                <div class="row mb-3">
                                                    <label for="serviceCode" class="col-4 col-form-label">M?? d???ch v???</label>
                                                    <div class="col-8">
                                                        <span class="form-control-plaintext service_id"></span>
                                                    </div>
                                                </div>
                                                <div class="row mb-3">
                                                    <label for="serviceName" class="col-4 col-form-label">T??n d???ch v???</label>
                                                    <div class="col-8">
                                                        <span class="desc-text form-control-plaintext service_name"></span>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <label for="serviceDesc" class="col-4 col-form-label">M?? t???</label>
                                                    <div class="col-8">
                                                        <span class="form-control-plaintext service_desc"></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="ps-5 col-6">
                                                <div class="row">
                                                    <div class="col-7 col-form-label">
                                                        B??c s??
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

            <script src="./index.js"></script>


    </body>

</html>