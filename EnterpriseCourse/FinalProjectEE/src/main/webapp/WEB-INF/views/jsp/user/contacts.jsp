<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contacts</title>

    <jsp:include page="../fragments/styles.jsp" />

</head>
<body>
<div id="wrapper">
    <jsp:include page="../fragments/headerUser.jsp"/>

    <div id="content">
        <h1>Contact information</h1>
        <div class="contacts"><img src="resources/style/images/handset.png" alt="handset"/>
            <p>+38 063 321 55 23</p></div>
        <div class="contacts"><img src="resources/style/images/email.png" alt="email"/>
            <p>colosseum@gmail.com</p></div>
        <div class="contacts"><img src="resources/style/images/location.png" alt="location"/>
            <p>25 Zhilyanskaya street, Kyiv</p></div>

        <div class="clear"></div>

        <div class="cont-map-title">location</div>
        <div class="cont-map">
            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2541.4049200742716!2d30.509199415870448!3d50.43355799646283!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cee337435373%3A0xcc1a5d5d55e47d10!2z0LLRg9C70LjRhtGPINCW0LjQu9GP0L3RgdGM0LrQsCwgMjUsINCa0LjRl9Cy!5e0!3m2!1sru!2sua!4v1472481175032"
                    width="600" height="450" frameborder="0" style="border:solid 1px #9d9d9d; border-radius: 10px;" allowfullscreen></iframe>
        </div>

    </div>
</div>
</body>
</html>
