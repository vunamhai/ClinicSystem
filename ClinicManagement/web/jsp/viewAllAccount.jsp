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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script><title>Account Management</title>

    </head>
    <header>
        
    </header>
    <body>
        <div class="container-fluid">
            <div class="row">
                <h2 class="col-lg-10 mx-auto justify-content-end" >Account Management</h2>
            </div>

            <div class="row">
                <div class="col-md-10 mx-auto">
                    <nav class="navbar navbar-light bg-light justify-content-between">
                        <button class="btn btn-primary btn-xs" data-title="Add" data-toggle="modal" data-target="#add" >Thêm tài khoản
                        </button>
                        <div style="color: red">
                            ${message}
                        </div>
                        <form class="form-inline" action="GetAllAccountController" method="GET">
                            <input class="form-control mr-sm-2"name="search" type="search" placeholder="Search" aria-label="Search" value="${search}">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </nav>
                    <table id="datatable" class="table table-striped table-bordered mx-auto" cellspacing="0" width="70%">
                        <tr>
                            <th>ID</th>
                            <th>Tài Khoản</th>
                            <th>Email</th>
                            <th>Họ tên</th>
                            <th>Sinh nhật</th>
                            <th>Address</th>
                            <th>Giới tính</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                        <c:forEach var="a" items="${listAcc}">
                            <tr>
                                <td>${a.id}</td>
                                <td>${a.username}</td>
                                <td>${a.email}</td>
                                <td>${a.firstname} ${a.lastname}</td>
                                <td>${a.dob}</td>
                                <td>${a.street} ${a.city} ${a.country}</td>
                                <td>${a.gender == "true" ? "Nam" : "Nữ"}</td>
                                <td>
                                    <button class="btn btn-primary btn-xs" data-toggle="modal" data-target="#edit${a.id}" >
                                        <i class="fa-solid fa-pen"></i>
                                    </button>

                                </td>
                                <td>
                                    <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#delete${a.id}" >
                                        <i class="fa-solid fa-trash-can"></i>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                    
                </div>

            </div>
        </div>


        <div class="modal fade" id="add">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title custom_align" id="Heading">Thêm tài khoản</h4>


                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="AddAccountController" method="POST">
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label for="inputAccount">Tài khoản</label>
                                    <input type="text" class="form-control" name="username" required maxlength="20">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="inputAccount">password</label>
                                <input type="text" class="form-control" name="password" required maxlength="20">
                            </div>

                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" name="email" required maxlength="20">
                            </div>
                            <div class="form-row">
                                <div class="form-group col-md-6">
                                    <label>Họ</label>
                                    <input type="text" class="form-control" name="firstname" required maxlength="20">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Tên</label>
                                    <input type="text" class="form-control" name="lastname" required maxlength="20">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Đường/Phố</label>
                                    <input type="text" class="form-control" name="street" required maxlength="20">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Thành Phố</label>
                                    <input type="text" class="form-control" name="city" required maxlength="20">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Quốc gia</label>
                                    <input type="text" class="form-control" name="country" required maxlength="20">
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Số điện thoại</label>
                                    <input type="text" class="form-control" name="phone" required maxlength="20">

                                </div>
                                <div class="form-group col-md-6">
                                    <label>Ngày sinh</label>
                                    <input type="date" class="form-control" id="inputBirthDate" name="dob" required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label>Giới tính</label>
                                    <select id="inputGender" class="form-control" name="gender">
                                        <option selected>Chọn giới tính</option>
                                        <option value="1">Nam</option>
                                        <option value="2">Nữ</option>
                                    </select>
                                </div>
                            </div>
                            <div class="modal-footer ">
                                <button type="submit" class="btn btn-primary btn-xs btn-lg col-md-6" style="width: 100%;">Lưu</button>
                                <button type="reset" class="btn btn-danger btn-lg col-md-6" style="width: 100%;">Làm mới</button>
                            </div>
                        </form>
                    </div>
                </div>
                <!-- /.modal-content --> 
            </div>
            <!-- /.modal-dialog --> 
        </div>
        <c:forEach var="a" items="${listAcc}">
            <form action="DeleteAccountController">
                <div hidden>
                    <input name="id" value="${a.id}">
                </div>
                <div class="modal fade" id="delete${a.id}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title custom_align" id="Heading">Xóa tài khoản</h4>

                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="alert alert-danger"><span class="glyphicon glyphicon-warning-sign"></span>Bạn chắc chắn muốn xóa tài khoản ${user.username} này chứ?</div>
                            </div>
                            <div class="modal-footer ">
                                <button type="submit" class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Có</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Không</button>
                            </div>
                        </div>
                        <!-- /.modal-content --> 
                    </div>
                    <!-- /.modal-dialog --> 
                </div>
            </form>



            <div class="modal fade" id="edit${a.id}">
                <div class="modal-dialog">
                    <form action="UpdateAccountController" method="POST">
                        <div hidden>
                            <input name="id" value="${a.id}">
                        </div>
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title custom_align" id="Heading">Chỉnh sửa tài khoản</h4>

                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputAccount">Tài khoản</label>
                                        <input type="text" class="form-control" required maxlength="20" name="username" value="${a.username}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label>Họ</label>
                                    <input type="text" class="form-control"required maxlength="20" name="firstname" value="${a.firstname}">
                                </div>
                                <div class="form-group">
                                    <label>Tên</label>
                                    <input type="text" class="form-control"required maxlength="20" name="lastname" value="${a.lastname}">
                                </div>
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" class="form-control"required maxlength="30" name="email" value="${a.email}">
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label>Đường/Phố</label>
                                        <input type="text" class="form-control"required maxlength="30" name="street" value="${a.street}">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Thành phố</label>
                                        <input type="text" class="form-control"required maxlength="30" name="city" value="${a.city}">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Quốc gia</label>
                                        <input type="text" class="form-control"required maxlength="30" name="country" value="${a.country}">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Số điện thoại</label>
                                        <input type="text" class="form-control"required maxlength="15" name="phone" value="${a.phone}">

                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Ngày sinh</label>
                                        <input type="date" class="form-control" name="dob" required id="inputBirthDate" value="${a.dob}">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label>Giới tính</label>
                                        <select id="inputGender" class="form-control" name="gender">
                                            <option value="1" ${a.gender == "true" ? "selected" : ""}>Nam</option>
                                            <option value="2" ${a.gender == "false" ? "selected" : ""}>Nữ</option>
                                        </select>
                                    </div>
                                </div>
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
<!--        <script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>-->
        <script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
<!--                        <script src="./assets/js/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
                        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>-->
    </body>
</html>
