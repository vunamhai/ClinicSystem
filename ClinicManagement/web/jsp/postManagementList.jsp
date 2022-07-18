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
        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">


    </head>

    <body>
        <!-- Header -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="p-2">
                <a href="#">
                    <img src="./assets/images/logo.png" alt="" width="30" height="30">
                </a>
            </div>
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarClinicHeader" aria-controls="navbarClinicHeader" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarClinicHeader">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                      <li class="nav-item">
                                <a class="nav-link" href="#">Xem tất cả danh sách đặt chỗ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="../ClinicManagement/ServiceManagementController">Quản lý dịch vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Gói dịch vụ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="../ClinicManagement/ViewFeedbackManagedListController">Quản lý phản hồi</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Duyệt lịch đặt chỗ</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">Quản lý bài viết</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="../ClinicManagement/DoctorManagementController">Quản lý bác sĩ</a>
                            </li>
                    </ul>
                    <div class="avatar">
                        <img src="https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png" alt="avatar">
                    </div>
                    <form action="PostManagementController"  value="${searchList}">
                        <input type="text" placeholder="Search.." name="search">
                        <button type="submit">Tìm kiếm</button>

                    </form>
                </div>
            </div>
        </div>
    </nav>

    <h1 id="title">
        Dach sách bài viết
    </h1>

    <div class="wrapper">

        <a id="add-btn" data-title="Add" class="btn btn-light mb-3" name="idPost=" data-toggle="modal" data-target="#add" >
            <i class="bi bi-plus-circle-fill"></i>
            Thêm bài viết
        </a>
    </form
    <div class="container-fluid">


        <div class="row">
            <div >

                <!-- Table -->

                <table  class="table table-bordered align-middle"  cellspacing="0" width="70%">
                    <thead>
                        <tr>
                            <th >#</th>
                            <th>Mã ID</th>
                            <th>Tiêu đề</th>
                            <th>Tóm tắt bài viết</th>
                            <th>Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${post.data}" var="post"  varStatus="counter" >
                            <tr>
                                <th>${counter.count}</th>
                                <td>${post.id}</td>
                                <td >${post.title}</td>
                                <td >${post.summary}</td>
                                <td>
                                    <div class="action">

                                        <button class="btn-only-ic" data-bs-toggle="modal" data-bs-target="#view${post.id}" data-bs-whatever="@mdo">
                                            <i class="bi bi-eye-fill"></i>
                                        </button>
                                        <button class="btn-only-ic" data-bs-toggle="modal" data-bs-target="#edit${post.id}" data-bs-whatever="@mdo">
                                            <i class="bi bi-pencil-fill"></i>
                                        </button>
                                        <button class="btn-only-ic" value="delete" data-bs-toggle="modal" data-bs-target="#staticBackdrop${post.id}">
                                            <i class="bi bi-trash-fill"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <!-- Pagination -->
            <div class="pagi-wrapper">
                <c:if test="${post.totalPage > 1}">
                    <div class="row">
                        <div class="col-12 text-center">
                            <ul>
                                <c:if test="${post.currentPage > 1}">
                                    <a class="btn btn-light" href="PostManagementController?page=${restaurants.currentPage-1}">Trang trước</a>
                                </c:if>
                                <c:forEach var="pageNumber" begin="1" end="${post.totalPage}" step="1">
                                    <c:if test="${post.currentPage == pageNumber}">
                                        <a class="btn btn-success" href="#">${pageNumber}</a>
                                    </c:if>
                                    <c:if test="${post.currentPage != pageNumber}">
                                        <a class="btn btn-light" href="PostManagementController?page=${pageNumber}">${pageNumber}</a>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${post.currentPage < post.totalPage}">
                                    <a class="btn btn-light" href="PostManagementController?page=${post.currentPage+1}">Trang sau</a>
                                </c:if>
                            </ul>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <!-- Add Post Modal -->

    <div class="modal fade" id="add">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title custom_align" id="Heading">Thêm bài viết</h4>


                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form action="../ClinicManagement/AddPostController" method="GET">

                        <input name="roleId" type="hidden" value="3" readonly>

                        <div class="form-group">
                            <label for="inputAccount">Chủ đề</label>
                            <textarea class="form-control" name="postTitle" required maxlength="100000"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="inputAccount">Tóm tắt</label>
                            <textarea class="form-control" name="postSummary" required maxlength="10000000"></textarea>
                        </div>

                        <div class="form-group">
                            <label>Nội dung</label>
                            <textarea type="text" class="form-control" name="postContent" required maxlength="1000000"></textarea>
                        </div>
                        <div class="form-group">
                            <label>Hình ảnh</label>
                            <input type="text" class="form-control" name="postImage">
                        </div>
                </div>
                <div class="modal-footer" >
                    <button type="submit" id="submitPost" class="btn btn-primary btn-xs btn-lg col-md-6" style="width: 100%; margin-right: 120px;">Thêm bài viết</button>
                </div>
                </form>
            </div>
        </div>
        <!-- /.modal-content --> 
    </div>
    <!-- /.modal-dialog -->     


    <c:forEach items="${post.data}" var="post">

        <!-- /View Post Modal--> 
        <div class="modal fade" id="view${post.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"> Xem chi tiết bài viết</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body ">
                        <div class="row"> 

                            <div class="col-xs-3 col-md-6">
                                <label for="message-text" name="id"></label><b>Mã ID: ${post.id}</b>                             
                            </div>
                            <div class="col-xs-3 col-md-6">
                                <label for="message-text" name="userId"></label><b>User ID: ${post.userId}</b>                         
                            </div>
                        </div>
                        <div class="row"> 
                            <div class="col-xs-3 col-md-6"><b>Ngày tạo:</b>
                                ${post.createDate}
                            </div>
                            <div class="col-xs-3 col-md-6"><b>Thời gian tạo:</b>
                               ${post.createTime}
                            </div>
                        </div>     
                        <div class="row"> 
                            <div class="col-xs-3 col-md-6">
                                <label for="message-text" ><b>Tiêu đề:</b></label>
                                <textarea class="form-control" id="message-text" readonly required maxlength="100000" name="title" value="${post.title}">${post.title}</textarea>
                            </div>
                            <div class="col-xs-3 col-md-6">
                                <label for="message-text"><b>Tóm tắt:</b></label>
                                <textarea class="form-control" id="message-text" readonly required maxlength="100000" name="summary" value="${post.summary}">${post.summary}</textarea>
                            </div>
                        </div>                             
                        <div class="mb-3">
                            <label for="message-text" class="col-form-label"><b>Nội dung:</b></label>
                            <textarea class="form-control" id="message-text" readonly required maxlength="1000000" name="content" value="${post.content}">${post.content}</textarea>
                        </div>
                        <div class="row"> 
                            <div class="col-md-6"><b>Hình ảnh:</b>
                                <td><img src="${post.postImage}" height="300px" width="600px"></td>
                            </div>
                        </div>
                    </div>
                    </form>
                </div>
            </div>
        </div>


        <!-- /Edit Post Modal--> 
        <div class="modal fade" id="edit${post.id}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Chỉnh sửa bài viết</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="../ClinicManagement/UpdatePostController" method="GET">

                        <div class="modal-body ">
                            <div class="row"> 
                                <div class="col-xs-3 col-md-6"><b>Mã ID:</b>
                                    <input type="text" id="recipient-name" readonly name="id" required maxlength="100" value="${post.id}"> 
                                </div>
                                <div class="col-xs-3 col-md-6"><b>User ID:</b>
                                    <input id="message-text" readonly name="userId" required maxlength="100" value="${post.userId}">
                                </div>
                            </div>                       
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Tiêu đề:</label>
                                <textarea class="form-control" id="message-text" required maxlength="100000" name="title" value="${post.title}">${post.title}</textarea>
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Tóm tắt:</label>
                                <textarea class="form-control" id="message-text" required maxlength="100000" name="summary" value="${post.summary}">${post.summary}</textarea>
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Nội dung:</label>
                                <textarea class="form-control" id="message-text" required maxlength="1000000" name="content" value="${post.content}">${post.content}</textarea>
                            </div>
                            <div class="mb-3">
                                <label for="message-text" class="col-form-label">Hình ảnh:</label>
                                <input class="form-control" id="message-text" required maxlength="100000" name="image" value="${post.postImage}">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                            <button type="submit" class="btn btn-primary">Lưu thay đổi</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Delete Post Modal--> 

        <div class="modal fade" id="staticBackdrop${post.id}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">  
            <div class="modal-dialog modal-dialog-centered modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="staticBackdropLabel">Thông báo</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <form action="../ClinicManagement/DeletePostController" method="GET"> 
                        <div class="modal-body">                   
                            <input type="hidden" name="Id" value="${post.id}">                    
                            <div class="alert alert-danger">Bạn có muốn xóa bài viết có &nbsp &nbsp id = "${post.id}" này không?</div>                    
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Không</button>
                            <button type="submit" class="btn btn-primary">Có</button>

                        </div>
                    </form>         
                </div>
            </div>
        </div>
    </c:forEach>
</div>


<!--<script language="JavaScript" src="https://code.jquery.com/jquery-1.11.1.min.js" type="text/javascript"></script>-->
<script language="JavaScript" src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script language="JavaScript" src="https://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
</script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>


</body>
</html>
