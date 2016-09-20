<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${stock.ingredient.name}</title>

    <jsp:include page="../fragments/styles.jsp"/>

</head>
<body>
<jsp:include page="../fragments/headerAdmin.jsp"/>


<div id="content">
    <c:if test="${not empty msg}">
        <div class="alert alert-${css} alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
            <strong>${msg}</strong>
        </div>
    </c:if>
    <div class="container">

        <h2>Ingredient Availability Detail</h2>
        <br/>

        <div class="row">
            <label class="col-sm-2">ID</label>
            <div class="col-sm-4">${stock.id}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Ingredient name</label>
            <div class="col-sm-4">${stock.ingredient.name}</div>
        </div>

        <div class="row">
            <label class="col-sm-2">Quantity</label>
            <div class="col-sm-4">${stock.quantity} grams.</div>
        </div>

    </div>
</div>

<jsp:include page="../fragments/footer.jsp"/>

</body>
</html>
