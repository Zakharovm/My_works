<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stock tab</title>

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

        <h2>Stock</h2>

        <div class="search-ingredient">
            <spring:url value="/admin/stock/filter" var="searchUrl"/>
            <form:form method="post" modelAttribute="homePageForm"
                       action="${searchUrl}">
                <form:input path="inputField" type="text" id="inputField"
                            placeholder="Filter ingredient..."/>
                <form:errors path="inputField"/>

                <button type="submit" class="btn btn-info">Filter</button>

            </form:form>
        </div>

        <c:choose>
            <c:when test="${not empty filter}">
                <div class="container">
                    <div class="row">
                        <label class="col-sm-2">${filter}</label>
                    </div>
                </div>

                <table class="table-data">

                    <tr>
                        <th>ID</th>
                        <th>Ingredient</th>
                        <th>Quantity</th>
                        <th class="action-row">Action</th>
                    </tr>

                    <tr>
                        <td>${stockIngredient.id}</td>
                        <td>${stockIngredient.ingredient.name}</td>
                        <td>${stockIngredient.quantity} grams.</td>

                        <td class="action-row">
                            <spring:url value="/admin/stock/${stockIngredient.id}" var="stockUrl"/>
                            <spring:url value="/admin/stock/${stockIngredient.id}/update" var="updateUrl"/>
                            <spring:url value="/admin/stock/${stockIngredient.id}/delete" var="deleteUrl"/>


                            <button class="btn btn-info" onclick="location.href='${stockUrl}'">Show</button>
                            <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                            <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete
                            </button>
                        </td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <table class="table-data">

                    <tr>
                        <th>ID</th>
                        <th>Ingredient</th>
                        <th>Quantity</th>
                        <th class="action-row">Action</th>
                    </tr>

                    <c:forEach items="${ingredientList}" var="ingredient">
                        <tr>
                            <td>${ingredient.id}</td>
                            <td>${ingredient.ingredient.name}</td>
                            <td>${ingredient.quantity} grams.</td>

                            <td class="action-row">
                                <spring:url value="/admin/stock/${ingredient.id}" var="stockUrl"/>
                                <spring:url value="/admin/stock/${ingredient.id}/update" var="updateUrl"/>
                                <spring:url value="/admin/stock/${ingredient.id}/delete" var="deleteUrl"/>


                                <button class="btn btn-info" onclick="location.href='${stockUrl}'">Show</button>
                                <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                                <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">
                                    Delete
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <spring:url value="/admin/stock/add" var="urlAddStock"/>
                <button class="btn btn-primary" onclick="location.href='${urlAddStock}'">Add Ingredient</button>
            </c:otherwise>
        </c:choose>

    </div>


</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
