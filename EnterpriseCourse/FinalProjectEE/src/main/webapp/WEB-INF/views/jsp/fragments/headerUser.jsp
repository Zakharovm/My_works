<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div id="header">
    <jsp:include page="../fragments/authorization.jsp"/>
    <ul class="head-nav">
        <li class="nav-main"><a href="${pageContext.request.contextPath}/homepage" title="Main Page">Main
            Page</a></li>
        <li class="nav-scheme"><a href="${pageContext.request.contextPath}/scheme" title="Restaurant scheme">Restaurant
            scheme</a></li>
        <li class="nav-staff"><a href="${pageContext.request.contextPath}/staff" title="Staff">Staff</a></li>
        <li class="nav-contacts"><a href="${pageContext.request.contextPath}/contacts" title="Contacts">Contacts</a>
        </li>
    </ul>

</div>
<br/>
