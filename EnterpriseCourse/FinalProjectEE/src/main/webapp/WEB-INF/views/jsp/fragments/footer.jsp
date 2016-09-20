<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/style/js/hello.js" var="coreJs" />
<spring:url value="/resources/style/js/bootstrap.min.js"
            var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<!-- jQuery -->
<spring:url value="/resources/js/jquery-2.1.4.min.js" var="jqueryjs"/>
<script src="${jqueryjs}"></script>
