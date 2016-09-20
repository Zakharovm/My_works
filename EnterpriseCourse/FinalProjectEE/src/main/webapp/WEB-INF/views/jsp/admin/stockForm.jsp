<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock form</title>

    <jsp:include page="../fragments/styles.jsp"/>
</head>

<jsp:include page="../fragments/headerAdmin.jsp"/>
<div id="content">
    <c:choose>
        <c:when test="${stockForm['new']}">
            <h2>Add Stock</h2>
        </c:when>
        <c:otherwise>
            <h2>Update Stock</h2>
        </c:otherwise>
    </c:choose>
    <br/>
    <div class="container">

        <spring:url value="/admin/stock" var="stockActionUrl"/>

        <form:form class="form-horizontal" method="post" modelAttribute="stockForm" action="${stockActionUrl}">
            <form:hidden path="id"/>


            <c:choose>
                <c:when test="${stockForm['new']}">
                    <spring:bind path="ingredient">
                        <div class="form-group ${status.error ? 'has-error' : ''}">
                            <label class="col-sm-2 control-label">Ingredient name</label>
                            <div class="col-sm-5">
                                <form:input path="ingredient" type="text" class="form-control " id="ingredient"
                                            placeholder="Ingredient name"/>
                                <form:errors path="ingredient" class="control-label"/>
                            </div>
                        </div>
                    </spring:bind>
                </c:when>
                <c:otherwise>
                    <spring:bind path="ingredient">

                    <div class="form-group">
                        <label class="col-sm-2 control-label">Ingredient name</label>
                        <div class="col-sm-5">
                            <div class="col-sm-4">${stockForm.ingredient.name}</div>
                        </div>
                    </div>
                    <input type="hidden" name="ingredient" value="${stockForm.ingredient.name}"/>
                        <form:errors path="ingredient" class="control-label"/>
                    </spring:bind>
                </c:otherwise>
            </c:choose>


            <spring:bind path="quantity">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Quantity</label>
                    <div class="col-sm-5">
                        <form:input path="quantity" type="text" class="form-control " id="quantity"
                                    placeholder="Quantity"/>
                        <form:errors path="quantity" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <c:choose>
                        <c:when test="${stockForm['new']}">
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
