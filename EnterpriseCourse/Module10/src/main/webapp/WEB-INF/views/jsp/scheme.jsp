<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Restaurant Scheme</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/main.css"
          media="screen"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/style.css"
          media="screen"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/table.css"
          media="screen"/>

</head>
<body>
<div id="wrapper">
    <div id="header"></div>

    <ul class="head-nav">
        <li class="nav-main"><a href="${pageContext.request.contextPath}/index" title="Main Page">Main
            Page</a></li>
        <li class="nav-scheme"><a href="${pageContext.request.contextPath}/scheme" title="Restaurant scheme">Restaurant
            scheme</a></li>
        <li class="nav-staff"><a href="${pageContext.request.contextPath}/staff" title="Staff">Staff</a></li>
        <li class="nav-contacts"><a href="${pageContext.request.contextPath}/contacts" title="Contacts">Contacts</a>
        </li>
    </ul>

    <div id="content">
        <h1>Restaurant Scheme</h1>
        <img src='resources/style/images/scheme.jpg'
             alt="logo">

    </div>


</div>
</body>
</html>
