
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
        <script src="https://kit.fontawesome.com/069a201b18.js" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>Account Status</title>

    </head>
    <header>
        <jsp:include page="./components/adminHeader.jsp"/>
    </header>
    <body>
        <div class="container-fluid">
            <div class="row">
                <h2 class="col-lg-10 mx-auto justify-content-end" >Account Status</h2>
            </div>

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <nav class="navbar navbar-light bg-light justify-content-between">
                        <div style="color: green">
                            ${message}
                        </div>
                        <form class="form-inline" action="ViewStatusAccountController" method="post">
                            <input class="form-control mr-sm-2"name="search" type="search" placeholder="Search" aria-label="Search" value="${search}">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </nav>
                    <table id="datatable" class="table table-striped table-bordered mx-auto" cellspacing="0" width="70%">
                        <tr>
                            <th>ID</th>
                            <th>Tài Khoản</th>
                            <th>Họ tên</th>
                            <th>Chức vụ</th>
                            <th>Status</th>
                            <th>View Detail</th>
                            <th>Change Status</th>
                        </tr>
                        <c:forEach var="user" items="${users.data}">
                            <tr>
                                <td>${user.userId}</td>
                                <td>${user.username}</td>
                                <td>${user.fullName}</td>
                                <td>${user.role}</td>
                                <td>${user.isActive==true?"Active":"Disabled"}</td>
                                <td>
                                    <button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#view${user.userId}" >
                                        <i class="fa-solid fa-eye"></i>
                                    </button>
                                </td>
                                <td>
                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#edit${user.userId}" >
                                        <i class="fa-solid fa-pen"></i>
                                    </button>

                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                    <nav aria-label="Page navigation example">
                        <c:if test="${users.totalItem == 0}">
                            <div class="col-12">
                                <p class="text-center">Không có dữ liệu</p>
                            </div>
                        </c:if>
                        <c:if test="${isSearch==false}">
                            <c:if test="${users.totalPage > 1}">
                            <div class="row">
                                <div class="col-12 text-center">
                                    <ul>
                                        <c:if test="${users.currentPage > 1}">
                                            <a class="btn btn-light" href="ViewStatusAccountController?page=${users.currentPage-1}">Trang trước</a>
                                        </c:if>
                                        <c:forEach var="pageNumber" begin="1" end="${users.totalPage}" step="1">
                                            <c:if test="${users.currentPage == pageNumber}">
                                                <a class="btn btn-success" href="#">${pageNumber}</a>
                                            </c:if>
                                            <c:if test="${users.currentPage != pageNumber}">
                                                <a class="btn btn-light" href="ViewStatusAccountController?page=${pageNumber}">${pageNumber}</a>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${users.currentPage < users.totalPage}">
                                            <a class="btn btn-light" href="ViewStatusAccountController?page=${users.currentPage+1}">Trang sau</a>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </c:if>
                        </c:if>
                        <c:if test="${isSearch}">
                            <c:if test="${users.totalPage > 1}">
                            <div class="row">
                                <div class="col-12 text-center">
                                    <ul>
                                        <c:if test="${users.currentPage > 1}">
                                            <a class="btn btn-light" href="ViewStatusAccountController?search=${search}&&page=${users.currentPage-1}">Trang trước</a>
                                        </c:if>
                                        <c:forEach var="pageNumber" begin="1" end="${users.totalPage}" step="1">
                                            <c:if test="${users.currentPage == pageNumber}">
                                                <a class="btn btn-success" href="#">${pageNumber}</a>
                                            </c:if>
                                            <c:if test="${users.currentPage != pageNumber}">
                                                <a class="btn btn-light" href="ViewStatusAccountController?search=${search}&&page=${pageNumber}">${pageNumber}</a>
                                            </c:if>
                                        </c:forEach>
                                        <c:if test="${users.currentPage < users.totalPage}">
                                            <a class="btn btn-light" href="ViewStatusAccountController?search=${search}&&page=${users.currentPage+1}">Trang sau</a>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </c:if>
                        </c:if>
                    </nav>
                </div>

            </div>
        </div>

        <c:forEach var="user" items="${users.data}">
            <div class="modal fade" tabindex="-1" role="dialog" aria-labelledby="view" aria-hidden="true" id="view${user.userId}">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">                   
                            <h4 class="modal-title custom_align" id="Heading">Chi tiết tài khoản</h4>

                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>

                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputRole">Chức vụ</label>
                                        <input type="text" class="form-control" name="inputRole" value="${user.role}" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputAccount">Tài khoản</label>
                                        <input type="text" class="form-control" name="inputAccount" value="${user.username}" disabled>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Họ và tên</label>
                                    <input type="text" class="form-control" name="inputName" value="${user.fullName}" disabled>
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" class="form-control" name="inputEmail" value="${user.email}" disabled>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Địa chỉ</label>
                                        <input type="text" class="form-control" name="inputAddress" value="${user.address}" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Số điện thoại</label>
                                        <input type="text" class="form-control" name="inputPhone" value="${user.phone}" disabled>

                                    </div>

                                    <div class="form-group col-md-6">
                                        <label>Giới tính</label>
                                        <input type="text" class="form-control" id="inputGender" value="${user.gender == "true" ? "Nam" : "Nữ"}" disabled>
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                    <!-- /.modal-content --> 
                </div>
                <!-- /.modal-dialog --> 
            </div>



            <div class="modal fade" id="edit${user.userId}">
                <div class="modal-dialog">
                    <form action="UpdateStatusAccountController" method="GET">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title custom_align" id="Heading">Chỉnh sửa trạng thái</h4>

                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Username</label>
                                        <input type="text" class="form-control" name="" value="${user.username}" disabled>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Trạng thái</label>
                                        <select id="inputGender" class="form-control" name="status">
                                            <option ${user.isActive==true?"Selected":""} value="true">Active</option>
                                            <option ${user.isActive==false?"Selected":""} value="false">Disabled</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-6" hidden>
                                <input type="text" class="form-control" name="userId" id="inputBirthDate" value="${user.userId}">
                            </div>
                            <div class="modal-footer ">
                                <button type="submit" class="btn btn-primary btn-xs btn-lg col-md-6" style="width: 100%;">Lưu</button>
                                <button type="button" data-dismiss="modal" aria-label="Close" class="btn btn-danger btn-lg col-md-6" style="width: 100%;">Hủy</button>
                            </div>
                        </div>
                    </form>

                    <!-- /.modal-content --> 
                </div>
                <!-- /.modal-dialog --> 
            </div>


        </c:forEach>
        <!--<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>-->
        <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
        <!--                <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
                        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>-->
    </body>
</html>

