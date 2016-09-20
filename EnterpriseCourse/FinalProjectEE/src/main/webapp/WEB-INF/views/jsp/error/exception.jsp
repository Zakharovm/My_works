<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage = "true"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exception error</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>

<body>
<!-- Page Content -->
<div class="container">

    <c:if test="${not empty exception.errCode}">
        <h1>${exception.errCode} : System Errors</h1>
    </c:if>

    <div class="row">
        <div class="jumbotron">

            <div class="col-lg-12">
                <h1>Error!!!</h1>
                <p>This is the message from ExceptionHandler:</p>
                <b>${exception.errMsg}</b>
                <br/>

                <spring:url value="/homepage" var="urlHome"/>
                <spring:url value="/admin" var="urlAdmin"/>
                <button class="btn btn-success" onclick="location.href='${urlHome}'">Home</button>
                <button class="btn btn-success" onclick="location.href='${urlAdmin}'">Admin page</button>
            </div>
        </div>
    </div>

</div>
</body>

</html>