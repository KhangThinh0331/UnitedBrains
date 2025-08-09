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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách Video yêu thích</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        .admin-navbar {
            background: linear-gradient(to bottom, #333 0%, #000 100%);
            border-radius: 10px;
            padding: 0.5rem 1rem;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .admin-title {
            font-weight: bold;
            color: yellow;
            text-transform: uppercase;
            letter-spacing: 0.5px;
        }

        .admin-links {
            display: flex;
            align-items: center;
            gap: 1rem;
        }

        .admin-links a {
            color: #a5ff75;
            text-decoration: none;
            font-weight: 500;
            text-transform: uppercase;
        }

        .admin-links a:hover {
            text-decoration: underline;
        }

        /* Custom dropdown override */
        .dropdown-menu {
            background-color: #222;
            border-radius: 8px;
            border: 1px solid #555;
        }

        .dropdown-menu a {
            color: #a5ff75;
        }

        .dropdown-menu a:hover {
            background-color: #333;
            color: #fff;
        }
    </style>
</head>
<body class="bg-black text-white">

<div class="container py-3">
    <div class="admin-navbar shadow">
        <div class="admin-title">User Tool</div>
        <div class="admin-links">
            <a href="${pageContext.request.contextPath}/user/videoList">Video List</a>
            <a href="${pageContext.request.contextPath}/user/videoLike">Video Favorite</a>
            <div class="dropdown">
                <a
                        class="nav-link dropdown-toggle"
                        href="#"
                        role="button"
                        data-bs-toggle="dropdown"
                        aria-expanded="false"
                >
                    My Account
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logoff</a></li>
                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/changePassword">Change Password</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <h2 style="text-align: center">Danh sách Video yêu thích</h2>
    <c:if test="${!empty favorites}">
        <table class="table table-bordered table-hover table-striped text-center align-middle">
            <thead class="table-light">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Poster</th>
                <th>Views</th>
                <th>Like Date</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="f" items="${favorites}">
                <tr>
                    <td>${f.video.id}</td>
                    <td>${f.video.title}</td>
                    <td><a href="${pageContext.request.contextPath}/user/videoDetail?id=${f.video.id}"><c:set var="videoId" value="${fn:substringAfter(f.video.link, '/embed/')}" />
                        <img src="https://img.youtube.com/vi/${videoId}/hqdefault.jpg" alt="${f.video.title}" style="max-height: 300px;" /></a></td>
                    <td>${f.video.views}</td>
                    <td><fmt:formatDate value="${f.likeDate}" pattern="dd/MM/yyyy"/></td>
                    <td>
                        <form method="post" action="${pageContext.request.contextPath}/user/videoUnlike" style="display:inline;"> <input type="hidden" name="favoriteId" value="${f.id}" /> <button type="submit" class="btn btn-warning btn-sm">Unlike</button> </form>
                        <a href="${pageContext.request.contextPath}/user/videoShare?id=${f.video.id}" class="btn btn-info text-white btn-sm">Share</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
    <c:if test="${empty favorites}">
        <div class="alert alert-warning text-center">Không có video nào được tìm thấy.</div>
    </c:if>
</div>
</body>
</html>
