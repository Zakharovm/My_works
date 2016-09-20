<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>"Coliseum" restaurant</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>
<body>
<div id="wrapper">

    <jsp:include page="../fragments/headerUser.jsp"/>
    <div id="title">
        <div class="search">
            <spring:url value="/homepage/search/dish" var="searchUrl"/>
            <form:form method="post" modelAttribute="homePageForm"
                       action="${searchUrl}">
                <form:input path="inputField" type="text" id="inputField"
                            placeholder="Search dish..."/>
                <form:errors path="inputField"/>

                <button type="submit" class="btn btn-info">Find</button>

            </form:form>
        </div>

        <div>
            <div class="contacts_index_phone"><img src="resources/style/images/handset.png" alt="handset"/>
                <p>+38 063 321 55 23</p></div>
            <a href="${pageContext.request.contextPath}/homepage" title="Main Page"><img
                    src="resources/style/images/logo.png"
                    alt="logo"></a>
            <div class="contacts_index_location"><img src="resources/style/images/location.png" alt="location"/>
                <p>25 Zhilyanskaya street, Kyiv</p></div>
        </div>
    </div>


    <div class="clear"></div>
    <div id="content">

        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>

        <h2>We are always happy to meet you here!</h2>
        <c:forEach items="${menuList}" var="menuName">
            <div class="menu-div">
                <h1>${menuName.name}</h1>
                <c:forEach items="${categories}" var="category">
                    <h2 id="category">${category}</h2>
                    <table id="menu">
                        <tr>
                            <th class="bold">Name</th>
                            <th class="bold">Weight</th>
                            <th class="bold">Price</th>
                        </tr>
                        <c:forEach items="${menuName.dishes}" var="dish">

                            <c:if test="${category.equals(dish.category)}">
                                <tr>
                                    <td class="dish_name"><a
                                            href="${pageContext.request.contextPath}/homepage/${dish.name}">${dish.name}</a>
                                    </td>
                                    <td class="dish_weight">${dish.weight} gr.</td>
                                    <td class="dish_price">${dish.price} uah.</td>
                                </tr>

                            </c:if>

                        </c:forEach>

                    </table>
                </c:forEach>
            </div>
        </c:forEach>
    </div>


</div>
</body>
</html>
