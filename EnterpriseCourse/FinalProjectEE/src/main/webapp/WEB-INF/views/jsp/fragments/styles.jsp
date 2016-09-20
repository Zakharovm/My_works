<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/style/css/hello.css" var="coreCss"/>
<spring:url value="/resources/style/css/bootstrap.css"
            var="bootstrapCss"/>

<link href="${bootstrapCss}" rel="stylesheet"/>
<link href="${coreCss}" rel="stylesheet"/>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/main.css"
      media="screen"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/style.css"
      media="screen"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/table.css"
      media="screen"/>


