<%-- 
    Document   : updateService
    Created on : 09-06-2022, 12:29:54
    Author     : uyenc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Service</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="../assets/styles/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.structure.min.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/styles/jquery-ui.theme.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <table style="margin-left: auto; margin-right: auto; border: 1px solid">
            <tr>
                <th>Tên dịch vụ</th>
                <th>Mô tả</th>
                <th>Update</th>
            </tr>
            <form action="UpdateService" method="POST">
                <tr>
                <input type="hidden" name="id" value="${serviceX.serviceId}">
                    <td style="text-align: center; border: 1px solid" >
                        <input name="serviceName" value="${serviceX.serviceName}">
                    </td>                  
                    <td style="text-align: center; border: 1px solid">
                        <input name="serviceDescription" value="${serviceX.serviceDescription}">
                    </td>
                    <td style="text-align: center; border: 1px solid" class="btn-success">
                        <a href="">
                            <button type="submit" class="btn btn-primary">Update</button>
                        </a>
                    </td>
                </tr>
            </form>
        </table>
    </body>
</html>
