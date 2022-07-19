
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/plug-ins/3cfcc339e89/integration/bootstrap/3/dataTables.bootstrap.css">
        <script src="https://kit.fontawesome.com/069a201b18.js" crossorigin="anonymous"></script>        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <title>Đăng ký dịch vụ</title>
    </head>

    <body>
        <div class="container-fluid">
            <div class="row-fluid mb-5">
                <img class="col-lg-12 p-0" src="./assets/images/banner.jpg" alt="Banner"/>
            </div>
            <div class="row mx-auto">
                <h2 class="col-lg-6 mx-auto justify-content-end" >Đăng ký dịch vụ</h2>
                </br>
            </div>
            <div class="row">
                <div class="col-md-6 mx-auto">
                    <form class="row g-3" action="BookReservationController" method="POST">
                        <div class="col-md-6">
                            <label for="date" class="form-label">Chọn ngày khám</label>
                            <input type="date" class="form-control" name="date" required>
                        </div>
                        <div class="col-md-6">
                            <label for="time" class="form-label">Chọn giờ khám</label>
                            <input type="time" class="form-control" name="time" required>
                        </div>
                        <div class="col-12">
                            <label for="note" class="form-label">Yêu cầu của bệnh nhân</label>
                            <input type="text-area" class="form-control" name="note" required>
                        </div>
                        <div class="col-md-6" hidden>
                            <input type="text" class="form-control" name="running" value="running">
                        </div>

                        <div class="col-12 mx-auto">
                            <label class="form-label"></label> </br>
                            <button type="submit" class="btn btn-primary">Đăng ký</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>