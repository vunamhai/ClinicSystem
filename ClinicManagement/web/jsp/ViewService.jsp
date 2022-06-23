<%-- 
    Document   : ViewService
    Created on : 14-06-2022, 15:19:52
    Author     : uyenc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                <th>Id</th>
                <th>Tên dịch vụ</th>
                <th>Mô tả</th>
                <th>Họ bác sĩ</th>
                <th>Tên bác sĩ</th>
            </tr>
            <c:forEach items="${viewService}" var="i" >
                <tr>
                   <td style="text-align: center; border: 1px solid" >
                        <input type="text" name="id" value="${i.service_id}">
                    </td>                  
                    <td style="text-align: center; border: 1px solid">
                        <input type="text" disabled="true" value="${i.service_name}">
                    </td>
                    <td style="text-align: center; border: 1px solid" >
                         <input type="text" disabled="true" value="${i.desc}">
                    </td>                  
                    <td style="text-align: center; border: 1px solid">
                         <input type="text" disabled="true" value="${i.lname}">
                    </td>
                    <td style="text-align: center; border: 1px solid" >
                         <input type="text" disabled="true" value="${i.fname}">
                    </td>                  

                </tr>
            </c:forEach>
        </table>
    </body>
</html>
