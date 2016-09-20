<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dish form</title>

    <jsp:include page="../fragments/styles.jsp"/>
</head>

<jsp:include page="../fragments/headerAdmin.jsp"/>
<div id="content">
    <c:choose>
        <c:when test="${dishForm['new']}">
            <h1>Add Dish</h1>
        </c:when>
        <c:otherwise>
            <h1>Update Dish</h1>
        </c:otherwise>
    </c:choose>
    <br/>
    <div class="container">

        <spring:url value="/admin/dishes" var="dishActionUrl"/>

        <form:form class="form-horizontal" method="post" modelAttribute="dishForm" action="${dishActionUrl}">
            <form:hidden path="id"/>

            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-6">
                        <form:input path="name" type="text" class="form-control " id="name" placeholder="Name"/>
                        <form:errors path="name" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="price">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Price</label>
                    <div class="col-sm-6">
                        <form:input path="price" type="text" class="form-control " id="price" placeholder="Price"/>
                        <form:errors path="price" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="weight">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Weight</label>
                    <div class="col-sm-6">
                        <form:input path="weight" type="text" class="form-control" id="weight" placeholder="Weight"/>
                        <form:errors path="weight" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="category">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Category</label>
                    <div class="col-sm-6">
                        <c:forEach items="${categoryList}" var="category">
                            <label class="radio-inline"> <form:radiobutton path="category"
                                                                           value="${category}"/> ${category}</label>
                        </c:forEach>
                        <form:errors path="category" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="ingredientAmount">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Composition</label>
                    <div class="col-sm-8">

                        <c:forEach items="${dishForm.ingredientAmount}" var="element" varStatus="loop">
                            <div class="col-sm-4">
                                <label class="col-sm-8"
                                       for="ingredientAmount">${ingredientList[loop.index].name}</label>
                                <input id="ingredientAmount" name="ingredientAmount[${loop.index}]" value="${element}"
                                       class="form-control"/>
                            </div>
                        </c:forEach>
                        <form:errors path="ingredientAmount" class="control-label"/>


                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <c:choose>
                        <c:when test="${dishForm['new']}">
                            <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
                        </c:when>
                        <c:otherwise>
                            <button type="submit" class="btn-lg btn-primary pull-right">Update</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>

        </form:form>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
