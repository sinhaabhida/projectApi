<%-- 
    Document   : index
    Created on : Feb 13, 2018, 2:35:09 PM
    Author     : mohil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <h1>Dashboard</h1>
            </div>
            <div class="row">
                <table class="table table-hover table-responsive">
                    <tbody>
                        <tr>
                            <td style="font-size: 25px">
                                Department operations
                            </td>
                            <td>
                                <a class="btn btn-success"
                                   href="/Attendance/addDepartment">
                                    Add department
                                </a>
                            </td>
                            <td>
                                <a class="btn btn-success"
                                   href="/Attendance/viewDepartment">
                                    View department
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size: 25px">
                                Employee operations
                            </td>
                            <td>
                                <a class="btn btn-success"
                                   href="/Attendance/addEmployee">
                                    Add employee
                                </a>
                            </td>
                            <td>
                                <a class="btn btn-success"
                                   href="/Attendance/viewEmployee">
                                    View employees
                                </a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
