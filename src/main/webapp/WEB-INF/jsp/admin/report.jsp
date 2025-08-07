<%--
  Created by IntelliJ IDEA.
  User: Ca Ngao
  Date: 8/5/2025
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Báo cáo - Thống kê</title>
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
    <div class="admin-title">Administration Tool</div>
    <div class="admin-links">
      <a href="${pageContext.request.contextPath}/admin/userManagement">User Management</a>
      <a href="${pageContext.request.contextPath}/admin/videoManagement">Video Management</a>
      <a href="${pageContext.request.contextPath}/admin/report">Report</a>

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
          <li><a class="dropdown-item" href="#">Logoff</a></li>
          <li><a class="dropdown-item" href="${pageContext.request.contextPath}/changePassword">Change Password</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>

<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item" role="presentation">
    <button class="nav-link active" id="favorites-tab" data-bs-toggle="tab" data-bs-target="#favorites" type="button" role="tab">Favorites</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="favorite-users-tab" data-bs-toggle="tab" data-bs-target="#favorite-users" type="button" role="tab">Favorite Users</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="shared-friends-tab" data-bs-toggle="tab" data-bs-target="#shared-friends" type="button" role="tab">Shared Friends</button>
  </li>
</ul>

<div class="tab-content" id="myTabContent">

  <!-- TAB 1: Favorites -->
  <div class="tab-pane fade show active" id="favorites" role="tabpanel">
    <table class="table table-bordered mt-3">
      <thead class="table-light">
      <tr>
        <th>Video Title</th>
        <th>Favorite Count</th>
        <th>Latest Date</th>
        <th>Oldest Date</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>Lâu ghê mới gặp</td>
        <td>100</td>
        <td>31/12/2020</td>
        <td>01/01/2020</td>
      </tr>
      </tbody>
    </table>
  </div>

  <!-- TAB 2: Favorite Users -->
  <div class="tab-pane fade" id="favorite-users" role="tabpanel">
    <div class="mt-3">
      <label for="videoTitle" class="form-label">Video Title:</label>
      <select class="form-select" id="videoTitle">
        <option selected>Lâu ghê mới gặp</option>
        <option>Video khác 1</option>
        <option>Video khác 2</option>
      </select>
    </div>
    <table class="table table-bordered mt-3">
      <thead class="table-light">
      <tr>
        <th>Username</th>
        <th>Fullname</th>
        <th>Email</th>
        <th>Favorite Date</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>TeoNV</td>
        <td>Nguyễn Văn Tèo</td>
        <td>teonv@gmail.com</td>
        <td>01/01/2020</td>
      </tr>
      </tbody>
    </table>
  </div>

  <!-- TAB 3: Shared Friends -->
  <div class="tab-pane fade" id="shared-friends" role="tabpanel">
    <div class="mt-3">
      <label for="videoTitle2" class="form-label">Video Title:</label>
      <select class="form-select" id="videoTitle2">
        <option selected>Lâu ghê mới gặp</option>
        <option>Video khác 1</option>
        <option>Video khác 2</option>
      </select>
    </div>
    <table class="table table-bordered mt-3">
      <thead class="table-light">
      <tr>
        <th>Sender Name</th>
        <th>Sender Email</th>
        <th>Receiver Email</th>
        <th>Sent Date</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>Nguyễn Văn Tèo</td>
        <td>teonv@gmail.com</td>
        <td>poly@gmail.com</td>
        <td>01/01/2020</td>
      </tr>
      </tbody>
    </table>
  </div>

</div>
</body>
</html>
