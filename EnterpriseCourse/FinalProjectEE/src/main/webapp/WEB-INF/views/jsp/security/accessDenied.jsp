<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Access denied</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>

<body>
<!-- Page Content -->
<div class="container">


    <div class="row">

        <div class="col-lg-12">
            <div class="jumbotron">
                <h1><span class="error-404">Access denied</span>
                </h1>

                <p>Sorry, you are not allowed to visit this page. You can return to:</p>
                <spring:url value="/homepage" var="urlHome"/>
                <spring:url value="/admin" var="urlAdmin"/>
                <button class="btn btn-success" onclick="location.href='${urlHome}'">Home</button>
                <c:if test="${isAdmin}">
                    <button class="btn btn-success" onclick="location.href='${urlAdmin}'">Admin page</button>
                </c:if>
            </div>
        </div>

    </div>
</div>
</body>
</html>
