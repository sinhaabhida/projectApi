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
        <title>Attendance</title>
        <%@include file="bootstrap-links.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Attendance details</h1>
            </div>
            <div class="row">
                <div class="col-md-2">
                    <input type="date" id="a_date"
                           class="form-control">
                </div>
                <div class="col-md-3">
                    <button class="btn btn-success"
                            onclick="addAttendance()">
                        Add Attendance
                    </button>
                </div>
                <div class="col-md-3">
                    <input type="number" id="monthNumber"
                           class="form-control"
                           placeholder="Search by month...">
                </div>
                <div class="col-md-3">
                    <button class="btn btn-info"
                            onclick="searchAttendance()">
                        Search
                    </button>
                </div>
            </div>
            <div class="row">
                <table class="table table-striped table-hover table-responsive">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Date</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${attendances}" var="attendance">
                            <tr>
                                <td>${attendance.id}</td>
                                <td>${attendance.date}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script>
            function searchAttendance() {
                var monthNumber = document.getElementById('monthNumber').value;
                window.location = "viewAttendance?id=<%=request.getParameter("id")%>&month=" + monthNumber;
            }
            
            function addAttendance() {
                var date = document.getElementById('a_date').value;
                window.location = "addAttendance?id=<%=request.getParameter("id")%>&date=" + date;
            }
        </script>
    </body>
</html>
