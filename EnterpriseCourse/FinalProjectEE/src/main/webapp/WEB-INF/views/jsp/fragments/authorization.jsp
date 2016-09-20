<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_SUPER_USER', 'ROLE_USER')" var="isAnyUser"/>
<security:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin"/>


<div class="aut-block">
    <c:if test="${not isAnyUser}">


        <c:if test="${empty param.error}">
            <spring:url value="/login" var="urlHome"/>
            <div class="aut-right"><h3>You are not authorized. </h3></div>
            <div class="aut-left">
                <button class="btn btn-success" onclick="location.href='${urlHome}'">Login</button>
            </div>

        </c:if>
    </c:if>

    <c:if test="${isAnyUser}">


        <div class="aut-left"><h3>Hello, <span class="username"><security:authentication property="principal.username"/> </span>!
        </h3></div>
        <div class="aut-right"><spring:url value="/logout" var="urlLogout"/>
            <button class="btn btn-danger" onclick="location.href='${urlLogout}'">Logout</button>
        </div>
    </c:if>
</div>

<c:if test="${isAdmin}">
    <div class="nav-homepage"><a href="${pageContext.request.contextPath}/homepage"
                                 title="Homepage">Homepage</a></div>
    <div class="nav-adminpage"><a href="${pageContext.request.contextPath}/admin"
                                 title="Admin page">Admin page</a></div>
</c:if>