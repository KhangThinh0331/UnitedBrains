<%--
  Created by IntelliJ IDEA.
  User: Ca Ngao
  Date: 8/5/2025
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Đăng nhập</title>
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
      color: white;
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
      <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
      <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
    </div>
  </div>
</div>
<c:url var="url" value="/login"></c:url>
<div class="container my-4" style="max-width: 400px;">
  <form action="${url}" method="post">
    <div class="border border-warning rounded">
      <!-- Header -->
      <div class="bg-success-subtle px-3 py-2 border-bottom border-warning">
        <strong class="text-uppercase">Login</strong>
      </div>

      <!-- Form content -->
      <div class="p-3">
        <div class="mb-3">
          <label for="username" class="form-label fw-semibold text-capitalize">Username:</label>
          <input type="text" class="form-control border-warning" id="username" name="username" />
        </div>

        <div class="mb-3">
          <label for="password" class="form-label fw-semibold text-capitalize">Password:</label>
          <input type="password" class="form-control border-warning" id="password" name="password" />
        </div>

      <!-- Footer -->
      <div class="bg-light d-flex justify-content-end px-3 py-2 border-top border-warning">
        <button type="submit" class="btn btn-warning text-white shadow-sm px-4">Login</button>
      </div>
    </div>
    </div>
  </form>
</div>
<i>${message}</i>
</body>
</html>
