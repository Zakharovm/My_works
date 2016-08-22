<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>My Tasks</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/main.css" media="screen"/>

</head>
<body>
<h1>My ToDO List</h1>
<form name="form1" action="ToDoList">
    <table width="100%" border="1" align="center">
        <tr>
            <th>Name</th>
            <th>Category</th>
            <th>Complete</th>

        </tr>
        <c:forEach items="${allTasks}" var="taskValue">
            <tr>
                <td class="name"><c:out value="${taskValue.key}"/></td>
                <td><c:out value="${taskValue.value.category}"/></td>
                <td><input type="checkbox" name="task" value="${taskValue.key}"/></td>

            </tr>
        </c:forEach>

    </table>
    <br/>
    <input class="submit" type="submit" value="Update Tasks"/>
</form>
<br>


<form name="addingForm" action="ToDoList" method="POST">
    <div class="main">
        <div class="field">
            <label for="task_name">Task Name: </label>
            <input class="text" type="text" name="task_name" placeholder="Input task name">
        </div>
        <div class="field">
            <label for="task_category">Task Category:</label>
            <input class="text" type="text" name="task_category" placeholder="Input task category">
        </div>
            <input class="submit" type="submit" value="Add Task"/>
    </div>


</form>

</body>
</html>