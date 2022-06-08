<%-- 
    Document   : login.jsp
    Created on : Feb 11, 2022, 9:03:56 PM
    Author     : nguye
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body style="background-color: #A9DFFD;">
        <section class="ftco-section">
            <div class="container">

                <div class="row justify-content-center">
                    <div class="col-md-7 col-lg-5">
                        <div class="wrap">
                            <div class="img" style="background-image: url(./assets/images/bg-1.jpg);"></div>
                            <div class="login-wrap p-4 p-md-5">
                                <div class="d-flex">
                                    <div class="w-100">
                                        <h3 class="mb-4">Đăng nhập</h3>
                                    </div>
                                </div>
                                <form action="HomeController" method="POST" class="signin-form">
                                    <div class="form-group mt-3">
                                        <input type="text" class="form-control" required name="username" maxlength="15">
                                        <label class="form-control-placeholder" for="username">Tên đăng nhập...</label>
                                    </div>
                                    <div class="form-group">
                                        <input id="password-field" type="password" class="form-control" required name="password" maxlength="15">
                                        <label class="form-control-placeholder" for="password">Mật khẩu...</label>
                                        <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="form-control btn btn-primary rounded submit px-3">Đăng nhập</button>
                                    </div>

                                </form>
                                <p class="text-center">không phải thành viên? <a  href="./jsp/Register.jsp">Đăng kí</a></p>
                                <c:if test="${messageLogin != null}">
                                    <p class="text-center">Quên mật khẩu? <a  href="./jsp/forgotPass.jsp">Quên mật khẩu</a></p>
                                </c:if>
                                <p style="color: red"> ${messageLogin}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="./assets/js/jquery.min.js"></script>
        <script src="./assets/js/popper.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
        <script src="./assets/js/main.js"></script>
    </body>
</html>
