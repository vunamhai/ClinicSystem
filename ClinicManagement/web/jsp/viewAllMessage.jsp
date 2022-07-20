
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Post Management</title>
       
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <!-- Bootstrap Icon -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

        <link rel="stylesheet" href="./assets/service/style.css">

    </head>

    <body>
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
                            <a class="nav-link" href="../ClinicManagement/ServiceManagementController">Quản lý dịch vụ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="../ClinicManagement/ViewFeedbackManagedListController">Quản lý phản hồi</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">Quản lý bài viết</a>
                        </li>
                        <li class="nav-item">
                                <a class="nav-link" href="./ListMessageController">Quản lý tin nhắn</a>
                            </li>
                    </ul>
                </div>
            </div>
        </nav>

        <h1 id="title">
            Dach sách tin nhắn
        </h1>
        <form  >
            <div class="container-fluid">
            <div class="row">
                <div >
                    <table  class="table table-bordered align-middle"  cellspacing="0" width="70%">
                       
                            <tr>
                                <th>Tên</th>
                                <th>Email</th>
                                <th>SĐT</th>
                                <th>Ghi Chú</th>
                            </tr>
                     
                        <tbody>
                            <c:forEach items="${ms.data}" var="ms"   >
                                <tr>
                                    <th>${ms.name}</th>
                                    <td>${ms.email}</td>
                                    <td >${ms.phone}</td>
                                    <td >${ms.note}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
               
            </div>
        </div>
            
        </form>
</body>
</html>
