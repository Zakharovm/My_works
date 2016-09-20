<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu form</title>

    <jsp:include page="../fragments/styles.jsp"/>
</head>

<jsp:include page="../fragments/headerAdmin.jsp"/>
<div id="content">
    <c:choose>
        <c:when test="${menuForm['new']}">
            <h2>Add Menu</h2>
        </c:when>
        <c:otherwise>
            <h2>Update Menu</h2>
        </c:otherwise>
    </c:choose>
    <br/>
    <div class="container">

        <spring:url value="/admin/menus" var="menuActionUrl"/>

        <form:form class="form-horizontal" method="post" modelAttribute="menuForm" action="${menuActionUrl}">
            <form:hidden path="id"/>

            <spring:bind path="name">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Name</label>
                    <div class="col-sm-5">
                        <form:input path="name" type="text" class="form-control " id="name" placeholder="Name"/>
                        <form:errors path="name" class="control-label"/>
                    </div>
                </div>
            </spring:bind>

            <spring:bind path="dishes">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="col-sm-2 control-label">Dishes</label>
                    <div class="col-sm-7">
                        <form:checkboxes items="${dishList}" path="dishes" itemLabel="name" itemValue="name"
                                         delimiter=" | " cssClass="checkbox-inline"/>

                        <form:errors path="dishes" class="control-label"/>

                    </div>
                </div>
            </spring:bind>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <c:choose>
                        <c:when test="${menuForm['new']}">
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
