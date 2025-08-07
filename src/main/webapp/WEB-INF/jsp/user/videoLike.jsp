<%--
  Created by IntelliJ IDEA.
  User: Ca Ngao
  Date: 8/5/2025
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Video yêu thích</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h2 style="text-align: center">Danh sách Video yêu thích</h2>
    <c:if test="${!empty videos}">
        <table class="table table-bordered table-hover table-striped text-center align-middle">
            <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Poster</th>
                <th>Views</th>
                <th>Active</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="v" items="${videos}">
                <tr>
                    <td>${v.id}</td>
                    <td>${v.title}</td>
                    <td>${v.poster}</td>
                    <td>${v.views}</td>
                    <td><c:out value="${v.active ? 'Còn' : 'Hết'}" /></td>
                    <td>
                        <button type="button" class="btn btn-warning btn-sm">Unlike</button>
                        <button type="button" class="btn btn-info btn-sm">Share</button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty videos}">
        <div class="alert alert-warning text-center">Không có video nào được tìm thấy.</div>
    </c:if>
</div>
</body>
</html>
