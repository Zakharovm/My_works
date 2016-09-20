<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${employee.name} ${employee.surname}</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>
<body>
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
    <div class="container">

        <h2>Employee Detail</h2>
        <br/>

        <div class="row">
            <label class="col-sm-2">ID</label>
            <div class="col-sm-4">${employeeForm.id}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Name</label>
            <div class="col-sm-4">${employeeForm.name}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Surname</label>
            <div class="col-sm-4">${employeeForm.surname}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Date Of birth</label>
            <div class="col-sm-4">${employeeForm.dateOfBirth}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Phone Number</label>
            <div class="col-sm-4">${employeeForm.phoneNumber}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Position</label>
            <div class="col-sm-4">${employeeForm.position}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Salary</label>
            <div class="col-sm-4">${employeeForm.salary}</div>
        </div>

        <spring:eval expression="employeeForm.position == T(restaurant.model.Position).Waiter" var="isWaiter" />
        <spring:eval expression="employeeForm.position == T(restaurant.model.Position).Cook" var="isCook" />

        <c:choose>
            <c:when test="${isWaiter}">
                <div class="row">
                    <label class="col-sm-2">Orders</label>
                    <div class="col-sm-4">${employeeForm.orders}</div>
                </div>
            </c:when>
            <c:when test="${isCook}">
                <div class="row">
                    <label class="col-sm-2">Cooked dishes</label>
                    <div class="col-sm-4">${employeeForm.cookedDishes}</div>
                </div>
            </c:when>
        </c:choose>

    </div>
</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
