<%--
  Created by IntelliJ IDEA.
  User: Ca Ngao
  Date: 7/24/2025
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý Video</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body class="p-4">
    <h5 class="mb-3">QUẢN LÝ VIDEO</h5>

    <!-- Nav Tabs -->
    <ul class="nav nav-tabs" id="videoTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active" id="edition-tab" data-bs-toggle="tab" data-bs-target="#edition" type="button" role="tab">
                VIDEO EDITION
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="list-tab" data-bs-toggle="tab" data-bs-target="#list" type="button" role="tab">
                VIDEO LIST
            </button>
        </li>
    </ul>

    <!-- Tab Content -->
    <div class="tab-content" id="videoTabContent">
        <!-- Video Edition -->
        <div class="tab-pane fade show active" id="edition" role="tabpanel">
            <div class="row mt-3">
                <div class="col-md-4">
                    <div class="poster-box">POSTER</div>
                </div>

                <div class="col-md-8">
                    <form>
                        <div class="mb-2">
                            <label class="form-label">TD:</label>
                            <input type="text" class="form-control">
                        </div>

                        <div class="mb-2">
                            <label class="form-label">Video Title:</label>
                            <input type="text" class="form-control">
                        </div>

                        <div class="mb-2">
                            <label class="form-label">View Count:</label>
                            <input type="number" class="form-control" value="0">
                        </div>

                        <div class="mb-2">
                            <label class="form-label">Link:</label>
                            <input type="text" class="form-control" value="0">
                        </div>

                        <div class="mb-2">
                            <label class="form-label d-block">Trạng thái:</label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="activeCheck" name="active">
                                <label class="form-check-label" for="activeCheck">Active</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" id="inactiveCheck" name="active">
                                <label class="form-check-label" for="inactiveCheck">Inactive</label>
                            </div>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Description:</label>
                            <textarea class="form-control" rows="3"></textarea>
                        </div>

                        <div class="btn-group-bottom">
                            <button type="button" class="btn btn-success">Create</button>
                            <button type="button" class="btn btn-secondary">Update</button>
                            <button type="button" class="btn btn-danger">Delete</button>
                            <button type="reset" class="btn btn-warning">Reset</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!-- Video List (empty placeholder) -->
        <div class="tab-pane fade" id="list" role="tabpanel">
            <div class="mt-3">
                <c:if test="${!empty videos}">
                    <table class="table table-bordered table-hover table-striped text-center align-middle">
                        <thead class="table-light">
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                                <th>Poster</th>
                                <th>Views</th>
                                <th>Description</th>
                                <th>Active</th>
                                <th>Link</th>
                                <th>Edit</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="v" items="${videos}">
                            <tr>
                                <td>${v.id}</td>
                                <td>${v.title}</td>
                                <td>${v.poster}</td>
                                <td>${v.views}</td>
                                <td>${v.description}</td>
                                <td><c:out value="${v.active ? 'Còn' : 'Hết'}" /></td>
                                <td><a href="${v.link}" target="_blank">${v.link}</a></td>
                                <td><a href="">Edit</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty videos}">
                    <div class="alert alert-warning text-center">Không có video nào được tìm thấy.</div>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
