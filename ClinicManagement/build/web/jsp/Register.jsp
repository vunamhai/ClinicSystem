<%-- 
    Document   : Register
    Created on : Mar 8, 2022, 8:49:23 AM
    Author     : nguye
--%>

<!DOCTYPE html>
<html>
    <head>
        <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <section class="h-100 h-custom" style="background-color: #8fc4b7;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-lg-8 col-xl-6">
                        <div class="card rounded-3">
                            <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp" class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;" alt="Sample photo">
                            <div class="card-body p-4 p-md-5">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Đăng kí</h3>

                                <form class="px-md-2" action="../RegisterForCustomerController" method="get">

                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Họ<span class="text-danger"> *</span></label>
                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" required name="firstname" value="${firstname}" />
                                    </div>
                                     <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Tên<span class="text-danger"> *</span></label>
                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" required name="lastname" value="${lastname}" />
                                    </div>
                                     <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Ngày sinh<span class="text-danger" > *</span></label>

                                        <input type="date" id="form3Example1q" class="form-control" value="${dob}" required name="dob"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Giới tính<span class="text-danger"> *</span></label>
                                        <br>
                                        <div class="form-check form-check-inline">
                                            <input
                                                class="form-check-input"
                                                type="radio"
                                                name="gender"
                                                value="-1"
                                                checked
                                                />
                                            <label class="form-check-label" for="femaleGender">Nam</label>
                                        </div>
                                        <div class="form-check form-check-inline">
                                            <input
                                                class="form-check-input"
                                                type="radio"
                                                name="gender"
                                                value="1"

                                                />
                                            <label class="form-check-label" for="femaleGender">Nữ</label>
                                        </div>
                                    </div>
                                     <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Điện thoại<span class="text-danger"> *</span></label>

                                        <input type="tel" id="form3Example1q" class="form-control" maxlength="10" value="${phone}"  required name="phone" pattern="[0][0-9]{9}"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Tài Khoản<span class="text-danger"> *</span></label>
                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" required name="username" value="${username}" />
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Email<span class="text-danger"> *</span></label>

                                        <input type="email" id="form3Example1q" class="form-control" value="${email}" required maxlength="30" name="email"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Mật khẩu<span class="text-danger"> *</span></label>

                                        <input type="password" id="form3Example1q" class="form-control" maxlength="20" value="${password}" required name="password"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Nhập lại mật khẩu<span class="text-danger"> *</span></label>

                                        <input type="password" id="form3Example1q" class="form-control" maxlength="20" value="${rePassword}" required name="re-password"/>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Đường<span class="text-danger"> *</span></label>

                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" value="${street}" required name="street"/>
                                    </div>

                                     <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q">Thành Phố<span class="text-danger"> *</span></label>

                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" value="${city}" required name="city"/>
                                    </div>
                                     <div class="form-outline mb-4">
                                        <label class="form-label" for="form3Example1q"> Quên Quán<span class="text-danger"> *</span></label>

                                        <input type="text" id="form3Example1q" class="form-control"  maxlength="30" value="${country}" required name="country"/>
                                    </div>
                                    <button type="submit" class="btn btn-success btn-lg mb-1">Đăng kí</button>
                                </form>
                                <div style="color: red"> ${message}</div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
