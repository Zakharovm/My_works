<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

        <h2>List Of Dishes</h2>

        <table class="table-data">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Weight</th>
                <th>Category</th>
                <th>Ingredients</th>
                <th class="action-row">Action</th>
            </tr>

            <c:forEach items="${dishList}" var="dish">
                <tr>
                    <td>${dish.id}</td>
                    <td>${dish.name}</td>
                    <td>${dish.price}</td>
                    <td>${dish.weight}</td>
                    <td>${dish.category}</td>

                    <td><c:forEach items="${dish.composition}" var="entry" varStatus="loop">
                        <c:if test="${loop.last}">${entry.key.name}</c:if>
                        <c:if test="${not loop.last}">${entry.key.name},</c:if>
                    </c:forEach>
                    </td>

                    <td class="action-row">
                        <spring:url value="/admin/dishes/${dish.id}" var="dishUrl"/>
                        <spring:url value="/admin/dishes/${dish.id}/delete" var="deleteUrl"/>
                        <spring:url value="/admin/dishes/${dish.id}/update" var="updateUrl"/>

                        <button class="btn btn-info" onclick="location.href='${dishUrl}'">Show</button>
                        <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                        <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <spring:url value="/admin/dishes/add" var="urlAddDish"/>
        <button class="btn btn-primary" onclick="location.href='${urlAddDish}'">Add Dish</button>
    </div>


</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
