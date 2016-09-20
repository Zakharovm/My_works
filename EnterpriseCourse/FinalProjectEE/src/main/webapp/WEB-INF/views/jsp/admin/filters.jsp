<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter order</title>
    <jsp:include page="../fragments/styles.jsp"/>

</head>
<body>
<div id="wrapper">
    <jsp:include page="../fragments/headerAdmin.jsp"/>

    <div id="content">
        <div class="container">

            <c:if test="${not empty msg}">
                <div class="alert alert-${css} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <strong>${msg}</strong>
                </div>
            </c:if>


            <h2>Order Filter</h2>

            <spring:url value="/admin/orders/filter/date" var="dateFilterUrl"/>
            <form:form class="form-horizontal" method="post" modelAttribute="dateForm"
                       action="${dateFilterUrl}">
                <spring:bind path="date">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Date Filter</label>
                        <div class="col-sm-5">
                            <form:input path="date" type="text" class="form-control " id="date"
                                        placeholder="Date (yyyy-mm-dd hh:mm:ss)"/>
                            <form:errors path="date" class="control-label"/>
                        </div>
                    </div>
                </spring:bind>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">
                        <button type="submit" class="btn-lg btn-primary pull-right">Find</button>
                    </div>
                </div>

            </form:form>


            <spring:url value="/admin/orders/filter/waiterName" var="waiterFilterUrl"/>
            <form:form class="form-horizontal" method="post" modelAttribute="waiterForm"
                       action="${waiterFilterUrl}">
                <spring:bind path="inputField">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Waiter Filter</label>
                        <div class="col-sm-5">
                            <form:input path="inputField" type="text" class="form-control " id="inputField"
                                        placeholder="Waiter name"/>
                            <form:errors path="inputField" class="control-label"/>
                        </div>
                    </div>
                </spring:bind>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">
                        <button type="submit" class="btn-lg btn-primary pull-right">Find</button>
                    </div>
                </div>

            </form:form>

            <spring:url value="/admin/orders/filter/tableNumber" var="tableFilterUrl"/>
            <form:form class="form-horizontal" method="post" modelAttribute="tableNumberForm"
                       action="${tableFilterUrl}">
                <spring:bind path="tableNumber">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <label class="col-sm-2 control-label">Table Number Filter</label>
                        <div class="col-sm-5">
                            <form:input path="tableNumber" type="text" class="form-control " id="tableNumber"
                                        placeholder="Table Number"/>
                            <form:errors path="tableNumber" class="control-label"/>
                        </div>
                    </div>
                </spring:bind>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-5">
                        <button type="submit" class="btn-lg btn-primary pull-right">Find</button>
                    </div>
                </div>

            </form:form>

        </div>

</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>
