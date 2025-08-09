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
  <style> .video-box { border: 1px solid #f0ad4e; padding: 1rem; } .video-thumbnail { background-color: #f8f9fa; border: 1px solid #f0ad4e; height: 300px; display: flex; align-items: center; justify-content: center; color: #333; } .video-title { background-color: #e8f5e9; font-weight: bold; padding: 0.5rem; } .video-description { padding: 0.5rem; } .sidebar-video { border: 1px solid #c8e6c9; padding: 0.5rem; margin-bottom: 0.5rem; display: flex; align-items: center; } .sidebar-video img { width: 60px; height: 45px; object-fit: cover; margin-right: 0.5rem; } .video-actions { background-color: #f8f9fa; padding: 0.5rem; display: flex; justify-content: end; gap: 0.5rem; } .extra-links { padding: 0.5rem 0 0.5rem 0; border-top: 1px solid #ddd; } .extra-links a { margin-right: 1rem; }
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
<body class="bg-black">

<div class="container py-3">
  <div class="admin-navbar shadow">
    <div class="admin-title">Online Entertainment</div>
    <div class="admin-links">
      <a href="${pageContext.request.contextPath}/">Video List</a>
      <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
      <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
    </div>
  </div>
</div>
<div class="container-fluid mt-4"> <div class="row"> <!-- Main Video Section -->
  <div class="col-lg-8">
    <div class="video-box">

      <!-- Khu vực nhúng video lấy từ DB -->
      <div class="mt-3">
        <h5 class="text-warning">${video.title}</h5>
        <div class="ratio ratio-16x9 position-relative">
          <iframe
                  src="${video.link}"
                  title="${video.title}"
                  frameborder="0"
                  allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
                  allowfullscreen
                  style="width: 100%; height: 100%; display: block;"
          ></iframe>
          <!-- overlay link phủ toàn bộ iframe -->
          <a href="${pageContext.request.contextPath}/user/videoWatch?id=${video.id}"
             class="stretched-link"></a>
        </div>
      </div>

      <div class="video-actions">
        <form method="post" action="${pageContext.request.contextPath}/user/videoLike"> <input type="hidden" name="videoId" value="${video.id}" /> <button type="submit" class="btn btn-success btn-sm">Like</button> </form>
        <a href="${pageContext.request.contextPath}/user/videoShare?id=${video.id}" class="btn btn-info text-white btn-sm">Share</a>
      </div>
    </div>
  </div>
  <!-- Sidebar Video List -->
  <div class="col-lg-4">
    <c:forEach var="v" items="${videos}">
      <c:if test="${v.id ne video.id}">
        <div class="sidebar-video">
          <a href="${pageContext.request.contextPath}/user/videoDt?id=${v.id}">
            <c:set var="videoId" value="${fn:substringAfter(v.link, '/embed/')}" />
            <img src="https://img.youtube.com/vi/${videoId}/hqdefault.jpg" alt="${video.title}" style="max-height: 300px;" />
          </a>
          <span>${v.title}</span>
        </div>
      </c:if>
    </c:forEach>
  </div>
</div> </div>
</body>
</html>
