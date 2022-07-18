
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Clinic Management</title>
        <link href="./assets/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css" />
        <link href="./assets/themes/krajee-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="./assets/css/select2.min.css" />
        <link rel="stylesheet" href="./assets/css/select2-bootstrap-5-theme.min.css" />
        <link rel="stylesheet" href="./assets/css/custom.css" />
        <link href="./assets/css/header.css" rel="stylesheet" type="text/css"/>

    </head>

    <style>
        .list{
            background-color:#F0F0F0;

            padding: 20px;
            border-radius: 10px;
            width: 75%;
            margin: 0 auto;
            margin-top: 30px;

        }
        .infor{
            margin-left: 30px;
        }
        .feedback{
            padding:10px;
            background-color: red;
            border-radius: 10px;
            color: white;
            text-align: center;
            font-weight: bold;
        }
        .status{
            padding:10px;
            background-color: red;
            border-radius: 10px;
            color: white;
            text-align: center;
            font-weight: bold;
        }
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* 15% from the top and centered */
            padding: 20px;
            border: 1px solid #888;
            width: 80%; /* Could be more or less, depending on screen size */
        }

        /* The Close Button */
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        .item_header {
            display: flex;
            width: 100%;
            justify-content: space-between;
        }

        .item__content {
            border: 1px solid #e6e6e6;
            margin-top: 10px;
            border-radius: 5px;
            padding: 10px;
        }
        .h3{
            color: #1c2f55;
            font-size: 28px;
            font-weight: 900;
        }
        .col{
            width: 200px;
            height: 300px;
        }
        .m{
            color: #db9d06;
            font-family: -apple-system, BlinkMacSystemFont, "Open Sans", "Segoe UI", Roboto, "Helvetica Neue", Arial, "Noto Sans", sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
        }
        
    </style>

    <body >
                 
        <%@include file="components/customerHeader.jsp" %>
        <div class=" p-3 list"style="height: 1000px">
            <h5 class="p-3" style="margin-bottom: 50px;">Chúng tôi</h5>
          
            <h2 class="p-3">    Welcome to  ISOFTCARE Hospital</h2>
          
        <div class="container">
  <div class="row">
    <div class="col">
              <div id="carouselExampleControlsNoTouching" class="carousel slide" style="width: 470px" data-bs-touch="false" data-bs-interval="false">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://benhvienk.vn/data/media/1601/images/q2.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://benhvienk.vn/data/media/1601/images/q1.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="https://benhvienk.vn/data/media/1601/images/lh.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <button class="carousel-control-prev" type="button"  style="width: 1px" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden"></span>
  </button>
            <button class="carousel-control-next" type="button" style="width: 1px" data-bs-target="#carouselExampleControlsNoTouching" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden"></span>
  </button>
                 
</div>
        <h3>Chúng tôi có một khoa chăm sóc đặc biệt với sức chứa <b> 14 giường tất cả được trang bị đầy đủ</b></h3>
        
    </div>
    <div class="col">
        <h3 class=" m ">Nhiệm vụ</h3>
        <p>Nhiệm vụ của bệnh viện là cung cấp chẩn đoán, điều trị và giám sát bệnh nhân, vết thương và phụ nữ mong đợi có tính đến các khía cạnh tâm lý xã hội của bệnh nhân.</p>
          <h3 class=" m "> Tầm nhìn</h3>
          <p>Tầm nhìn của chúng tôi là cung cấp các dịch vụ với tiêu chuẩn cao nhất theo dữ liệu thu được của khoa học y tế; cung cấp đào tạo liên tục và đóng góp vào nghiên cứu.</p>
          <h3 class=" m ">Giá Trị</h3>
                  <ul>
            <li>Sự hài lòng của con người phù hợp với đạo đức.</li>
            <li>Trung thực</li>
            <li>Hợp tác với các Đại lý Y tế Quốc gia</li>
            <li>Hoàn thiện sự hài lòng của bệnh nhân và nhân viên</li>
        </ul>
          <h3 class=" m ">Chính sách chất lượng</h3>
          <p>Lấy cảm hứng từ các tiêu chuẩn quốc gia và quốc tế:</p>
               <ul>
            <li>Một dịch vụ dành riêng cho sự hài lòng của bệnh nhân và bác sĩ</li>
            <li>Trong một nền văn hóa không ngừng cải tiến, luôn học hỏi nhiều hơn, cải thiện và nâng cao trình độ giữa các nhân viên y tế với sự hỗ trợ của chất lượng dịch vụ;</li>
            <li>Hợp tác với các Đại lý Y tế Quốc gia</li>
        </ul>
    </div>
  </div>
=       
        </div>
            
        </div>
        <div class="container">
            <div class="row p-3">
    <div class="col">
     <div class="text-center">
  
  <div class="card" style="width: 18rem;">
  <img src="https://glahospital.com/media/public/images/about-5-1.2e16d0ba.fill-350x185.jpg" class="rounded" alt="...">
  <div class="card-body">
      <h4 class="card-text m ">Chúng tôi quan tâm đến bạn</h4>
    <p class="card-text ">Chúng tôi quan tâm đến bạn</p>
  </div>
</div>
</div>
    </div>
    <div class="col order-5">
      
    <div class="card" style="width: 18rem;">
  <img src="https://glahospital.com/media/public/images/examen-echantillon-au-microscope_1.2e16d0ba.fill-350x185.jpg" class="rounded" alt="...">
  <div class="card-body">
      <h4 class="card-text m ">Chúng tôi tiên tiến và được trang bị đầy đủ</h4>
    <p class="card-text">Chúng tôi tiên tiến và được trang bị đầy đủ</p>
  </div>
</div>
    </div>
                       
    <div class="col order-1">
      
    <div class="card" style="width: 18rem;">
 <img src="https://glahospital.com/media/public/images/726.2e16d0ba.fill-350x185.jpg" class="rounded" alt="...">
  <div class="card-body">
       <h4 class="card-text m ">Thiết bị điện tử công nghệ cao</h4>
    <p class="card-text">Thiết bị điện tử công nghệ cao</p>
  </div>
</div>
    </div>
  </div>
</div>
     <%@include file="components/footer.jsp" %>
     
  </div>
         
       
        <script src="./assets/js/jquery-3.6.0.min.js" type="text/javascript"></script>
        <script src="./assets/js/popper.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="./assets/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="./assets/js/star-rating.js" type="text/javascript"></script>
        <script src="./assets/themes/krajee-fas/theme.js" type="text/javascript"></script>
        <script src="./assets/js/select2.full.min.js"></script>
        <script src="./assets/js/custom.js"></script>
    </body>
    <script>
        $("p:contains('Chờ duyệt')").css("background-color", "orange");
        $("p:contains('Đã khám')").css("background-color", "blue");
        $("p:contains('Đặt thành công')").css("background-color", "green");
    </script>
</html>
