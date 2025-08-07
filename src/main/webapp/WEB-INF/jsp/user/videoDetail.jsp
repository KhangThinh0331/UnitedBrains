<%--
  Created by IntelliJ IDEA.
  User: Ca Ngao
  Date: 8/5/2025
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết video</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style> .video-box { border: 1px solid #f0ad4e; padding: 1rem; } .video-thumbnail { background-color: #f8f9fa; border: 1px solid #f0ad4e; height: 300px; display: flex; align-items: center; justify-content: center; color: #333; } .video-title { background-color: #e8f5e9; font-weight: bold; padding: 0.5rem; } .video-description { padding: 0.5rem; } .sidebar-video { border: 1px solid #c8e6c9; padding: 0.5rem; margin-bottom: 0.5rem; display: flex; align-items: center; } .sidebar-video img { width: 60px; height: 45px; object-fit: cover; margin-right: 0.5rem; } .video-actions { background-color: #f8f9fa; padding: 0.5rem; display: flex; justify-content: end; gap: 0.5rem; } .extra-links { padding: 0.5rem 0 0.5rem 0; border-top: 1px solid #ddd; } .extra-links a { margin-right: 1rem; } </style>
</head>

<body>
<div class="container-fluid mt-4"> <div class="row"> <!-- Main Video Section -->
    <div class="col-lg-8">
        <div class="video-box">
            <div class="video-thumbnail">
                <img src="${video.poster}" style="max-height: 300px;" />
            </div>
            <div class="video-title">${video.title}</div>
            <div class="video-description"> <p class="mb-1">${video.description}</p>
                <div class="extra-links"> <a href="${video.link}" target="_blank">${video.link}</a></div>
            </div>
            <div class="video-actions">
            <button class="btn btn-primary">Like</button> <button class="btn btn-warning text-white">Share</button>
        </div>
</div>
</div>
    <!-- Sidebar Video List -->
    <div class="col-lg-4">
        <c:forEach var="v" items="${videos}">
            <c:if test="${v.id ne video.id}">
                <div class="sidebar-video">
                    <a href="${pageContext.request.contextPath}/user/videoDetail?id=${v.id}">
                        <img src="${v.poster}" />
                    </a>
                    <span>${v.title}</span>
                </div>
            </c:if>
        </c:forEach>
    </div>
</div> </div>
</body>
</html>
