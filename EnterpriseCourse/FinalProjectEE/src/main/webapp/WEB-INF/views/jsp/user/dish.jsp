<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dish composition</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>
<body>
<div id="wrapper">
    <jsp:include page="../fragments/headerUser.jsp"/>

    <div id="content">

        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>

        <h1>${dish.name}</h1>
        <img class="dish_img" src="../resources/style/images/dishes/${dish.name}.png" alt="dish"/>
        <table id="dish" style="width: 600px">
            <tr>
                <th>Name</th>
                <th>Weight</th>
                <th>Price</th>
                <th>Ingredients</th>
            </tr>

            <tr>
                <td>${dish.name}</td>
                <td>${dish.weight} gr.</td>
                <td>${dish.price} uah.</td>
                <td>
                    <c:forEach items="${dish.composition}" var="entry" varStatus="loop">
                        <c:if test="${loop.last}">${entry.key.name}</c:if>
                        <c:if test="${not loop.last}">${entry.key.name},</c:if>
                    </c:forEach>
                </td>

            </tr>

        </table>

    </div>


</div>
</body>
</html>
