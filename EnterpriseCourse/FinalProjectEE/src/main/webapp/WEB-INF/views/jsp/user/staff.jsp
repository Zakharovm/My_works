<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Our Staff</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>
<body>
<div id="wrapper">
    <jsp:include page="../fragments/headerUser.jsp"/>

    <div id="content">
        <h1>The List Of Waiters</h1>

        <c:forEach items="${employees}" var="employee">
            <div class="employee">
                <img src='resources/style/images/staff/${employee.surname}.png'
                     alt="logo">
                <div class="text-container">
                    <p>${employee.name}</p>
                </div>
            </div>
        </c:forEach>
        <div class="clear"></div>
        <br/>
        <h3> You can write comments about our staff here <span class="username">colosseum@gmail.com</span>. Or just appeal to
            Administrator.</h3>


    </div>


</div>
</body>
</html>
