<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="header">
    <jsp:include page="../fragments/authorization.jsp"/>

    <ul class="head-nav">
        <li class="nav-menus"><a href="${pageContext.request.contextPath}/admin/menus" title="Menus">Menus</a></li>
        <li class="nav-dishes"><a href="${pageContext.request.contextPath}/admin/dishes" title="Dishes">Dishes</a></li>
        <li class="nav-employees"><a href="${pageContext.request.contextPath}/admin/employees"
                                     title="Employees">Employees</a></li>
        <li class="nav-stock"><a href="${pageContext.request.contextPath}/admin/stock" title="Stock">Stock</a></li>
        <li class="nav-order-history"><a href="${pageContext.request.contextPath}/admin/orders"
                                         title="Order history">Order history</a></li>
    </ul>
    <div class="clear"></div>
</div>
<br/>

