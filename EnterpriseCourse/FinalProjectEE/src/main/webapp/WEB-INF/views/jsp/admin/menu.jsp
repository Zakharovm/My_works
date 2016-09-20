<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Menu tab</title>

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

        <h2>Menu List</h2>

        <table class="table-data">

            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Dishes</th>
                <th class="action-row">Action</th>
            </tr>

            <c:forEach items="${menuList}" var="menu">
                <tr>
                    <td>${menu.id}</td>
                    <td>${menu.name}</td>
                    <td style="text-align: justify"><c:forEach items="${menu.dishes}" var="dish" varStatus="loop">
                        <c:if test="${loop.last}">${dish.name}</c:if>
                        <c:if test="${not loop.last}">${dish.name},</c:if>
                    </c:forEach>
                    </td>

                    <td class="action-row">
                        <spring:url value="/admin/menus/${menu.id}" var="menuUrl"/>
                        <spring:url value="/admin/menus/${menu.id}/update" var="updateUrl"/>
                        <spring:url value="/admin/menus/${menu.id}/delete" var="deleteUrl"/>


                        <button class="btn btn-info" onclick="location.href='${menuUrl}'">Show</button>
                        <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button>
                        <button class="btn btn-danger" onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <spring:url value="/admin/menus/add" var="urlAddMenu"/>
        <button class="btn btn-primary" onclick="location.href='${urlAddMenu}'">Add Menu</button>


    </div>


</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
