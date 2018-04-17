<%-- 
    Document   : editEmployee
    Created on : Feb 13, 2018, 6:05:05 PM
    Author     : mohil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit department</title>
        <%@include file="bootstrap-links.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Department data</h1>
            </div>
            <div class="row">
                <form:form method = "POST" action = "/Attendance/editDepartmentDB">
                    <form:hidden path="id" />
                    <table>
                        <tr>
                            <td><form:label path = "name">Department name</form:label></td>
                            <td><form:input path = "name" /></td>
                        </tr>
                        <tr>
                            <td colspan = "2">
                                <input type = "submit" value = "Submit"/>
                            </td>
                        </tr>
                    </table>  
                </form:form>
            </div>
        </div>
    </body>
</html>
