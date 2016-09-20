<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dish List</title>
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


        <h2>Orders</h2>

        <spring:url value="/admin/orders/filter/" var="filterActionUrl"/>
        <button class="btn btn-primary" onclick="location.href='${filterActionUrl}'">Filters</button>
        <br/>
        <br/>

        <c:choose>
            <c:when test="${not empty filter}">
                <div class="container">
                    <div class="row">
                        <label class="col-sm-2">${filterName}</label>
                        <div class="col-sm-4">${filterValue}</div>
                    </div>
                </div>

                <table class="table-data">

                    <tr>
                        <th>ID</th>
                        <th>Waiter Name</th>
                        <th>Dishes</th>
                        <th>Table Number</th>
                        <th>Date Of Order</th>
                        <th>Order status</th>
                    </tr>

                    <c:forEach items="${filter}" var="order">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.waiter.name}</td>
                            <td>
                                <c:forEach items="${order.dishes}" var="dishList" varStatus="loop">
                                    <c:if test="${loop.last}">${dishList.name}</c:if>
                                    <c:if test="${not loop.last}">${dishList.name},</c:if>
                                </c:forEach>
                            </td>
                            <td>${order.tableNumber}</td>
                            <td>${order.dateOfOrder}</td>
                            <td>${order.currentStatus}</td>

                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <table class="table-data">

                    <tr>
                        <th>ID</th>
                        <th>Waiter Name</th>
                        <th>Dishes</th>
                        <th>Table Number</th>
                        <th>Date Of Order</th>
                        <th>Order status</th>
                    </tr>

                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.id}</td>
                            <td>${order.waiter.name}</td>
                            <td>
                                <c:forEach items="${order.dishes}" var="dishList" varStatus="loop">
                                    <c:if test="${loop.last}">${dishList.name}</c:if>
                                    <c:if test="${not loop.last}">${dishList.name},</c:if>
                                </c:forEach>
                            </td>
                            <td>${order.tableNumber}</td>
                            <td>${order.dateOfOrder}</td>
                            <td>${order.currentStatus}</td>

                        </tr>
                    </c:forEach>
                </table>
            </c:otherwise>
        </c:choose>

    </div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>