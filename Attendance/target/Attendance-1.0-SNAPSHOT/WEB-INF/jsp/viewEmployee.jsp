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
        <title>Employees</title>
        <%@include file="bootstrap-links.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Employee details</h1>
            </div>
            <div class="row">
                <div class="col-md-3">
                    <a class="btn btn-success"
                       href="/Attendance/addEmployee">
                        Add Employee
                    </a>
                </div>
                <div class="col-md-6">
                    <input type="text" id="employeeName"
                           class="form-control"
                           placeholder="Search employee by name...">
                </div>
                <div class="col-md-3">
                    <button class="btn btn-info"
                            onclick="searchEmployee()">
                        Search
                    </button>
                </div>
            </div><br>
            <div class="row">
                <table class="table table-striped table-hover table-responsive">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Department ID</th>
                            <th>Attendance</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${employees}" var="employee">
                            <tr>
                                <td>${employee.id}</td>
                                <td>${employee.name}</td>
                                <td>${employee.department_id}</td>
                                <td>
                                    <a class="btn btn-info" 
                                       href="/Attendance/viewAttendance?id=<c:out value="${employee.id}"/>">View attendance</a>
                                </td>
                                <td>
                                    <a class="btn btn-warning" 
                                       href="/Attendance/editEmployee?id=<c:out value="${employee.id}"/>">Edit</a>
                                </td>
                                <td>
                                    <a class="btn btn-danger" 
                                       href="/Attendance/deleteEmployee?id=<c:out value="${employee.id}"/>">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script>
            function searchEmployee() {
                var employeeName = document.getElementById('employeeName').value;
                window.location = "viewEmployee?ename=" + employeeName;
            }
        </script>
    </body>
</html>
