<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee form</title>

    <jsp:include page="../fragments/styles.jsp"/>
</head>

<jsp:include page="../fragments/headerAdmin.jsp"/>
<div id="content">
    <c:choose>
        <c:when test="${employeeForm['new']}">
            <h2>Add Employee</h2>
        </c:when>
        <c:otherwise>
            <h2>Update Employee</h2>
        </c:otherwise>
    </c:choose>
    <br/>
    <div class="container">

        <spring:url value="/admin/employees" var="employeeActionUrl"/>

        <form:form class="form-horizontal" method="post" modelAttribute="employeeForm" action="${employeeActionUrl}">
            <form:hidden path="id"/>

            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-6">
                        <form:input path="name" type="text" class="form-control " id="name" placeholder="Name"/>
                        <form:errors path="name" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="surname">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Surname</label>
                    <div class="col-sm-6">
                        <form:input path="surname" type="text" class="form-control " id="surname"
                                    placeholder="Surname"/>
                        <form:errors path="surname" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="dateOfBirth">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Date of birth</label>
                    <div class="col-sm-6">
                        <form:input path="dateOfBirth" type="text" class="form-control " id="dateOfBirth"
                                    placeholder="Date of birth"/>
                        <form:errors path="dateOfBirth" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="phoneNumber">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Phone tableNumber</label>
                    <div class="col-sm-6">
                        <form:input path="phoneNumber" type="text" class="form-control " id="phoneNumber"
                                    placeholder="Phone tableNumber"/>
                        <form:errors path="phoneNumber" class="control-label"/>
                    </div>
                </div>
            </spring:bind>


            <c:choose>
                <c:when test="${employeeForm['new']}">
                    <spring:bind path="position">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Position</label>
                            <div class="col-sm-6">
                                <c:forEach items="${positionList}" var="position">
                                    <label class="radio-inline"> <form:radiobutton path="position"
                                                                                   value="${position}"/> ${position}</label>

                                </c:forEach>
                                <form:errors path="position" class="control-label"/>
                            </div>
                        </div>
                    </spring:bind>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Position</label>
                        <div class="col-sm-5">
                            <div class="col-sm-4">${employeeForm.position}</div>
                            <form:hidden path="position"/>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>


            <spring:bind path="salary">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Salary</label>
                    <div class="col-sm-6">
                        <form:input path="salary" type="text" class="form-control " id="salary" placeholder="Salary"/>
                        <form:errors path="salary" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:eval expression="employeeForm.position == T(restaurant.model.Position).Waiter" var="isWaiter"/>
            <spring:eval expression="employeeForm.position == T(restaurant.model.Position).Cook" var="isCook"/>

            <c:choose>
                <c:when test="${isWaiter}">
                    <spring:bind path="orders">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Orders (id)</label>
                            <div class="col-sm-6">
                                <form:input path="orders" type="text" class="form-control " id="orders"
                                            placeholder="Orders' IDs"/>
                                <form:errors path="orders" class="control-label"/>
                            </div>
                        </div>
                    </spring:bind>
                </c:when>
                <c:when test="${isCook}">
                    <spring:bind path="cookedDishes">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Cooked dishes(id)</label>
                            <div class="col-sm-6">
                                <form:input path="cookedDishes" type="text" class="form-control " id="cookedDishes"
                                            placeholder="CookedDishes' IDs"/>
                                <form:errors path="cookedDishes" class="control-label"/>
                            </div>
                        </div>
                    </spring:bind>
                </c:when>
            </c:choose>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <c:choose>
                        <c:when test="${employeeForm['new']}">
                            <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

        </form:form>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
