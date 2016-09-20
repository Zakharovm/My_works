<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee tab</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>
<body>
<div id="wrapper">
    <jsp:include page="../fragments/headerAdmin.jsp"/>

    <div id="content">

        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>

        <h2>Employee List</h2>

        <table class="table-data">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Phone Number</th>
                <th>Position</th>
                <th class="action-row">Action</th>
            </tr>

            <c:forEach items="${employeeList}" var="employee">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.surname}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.position}</td>

                    <td class="action-row">
                        <spring:url value="/admin/employees/${employee.id}" var="employeeUrl"/>
                        <spring:url value="/admin/employees/${employee.id}/update" var="updateUrl"/>
                        <spring:url value="/admin/employees/${employee.id}/delete" var="deleteUrl"/>

                        <button class="btn btn-info" onclick="location.href='${employeeUrl}'">Show</button>
                        <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                        <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <spring:url value="/admin/employees/add" var="urlAddEmployee"/>
        <button class="btn btn-primary" onclick="location.href='${urlAddEmployee}'">Add Employee</button>

    </div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
