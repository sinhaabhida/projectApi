<%-- 
    Document   : viewEmployee
    Created on : Feb 13, 2018, 5:11:49 PM
    Author     : mohil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Departments</title>
        <%@include file="bootstrap-links.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Department details</h1>
            </div>
            <div class="row">
                <a class="btn btn-success" href="/Attendance/addDepartment">
                    Add Department
                </a>
            </div>
            <div class="row">
                <table class="table table-striped table-hover table-responsive">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${departments}" var="department">
                            <tr>
                                <td>${department.id}</td>
                                <td>${department.name}</td>
                                <td>
                                    <a class="btn btn-info" 
                                       href="/Attendance/editDepartment?id=<c:out value="${department.id}"/>">Edit</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" 
                                       href="/Attendance/deleteDepartment?id=<c:out value="${department.id}"/>">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
