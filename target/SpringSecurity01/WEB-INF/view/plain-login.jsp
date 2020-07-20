<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Plain Login Page</title>
</head>
<body>
<h3> My Custom Login Page</h3>
<style>
    .failed{
        color: darkred;
    }
</style>
<hr>
    <form:form action="/authenticateTheUser" method="post">
        <c:if test="${param.error != null}">
            <i class="failed"> Sorry! You entered wrong username/password pair.</i>
        </c:if>
        <p>Username: <input type="text" name="username"></p>

        <p>Password: <input type="password" name="password"></p>

        <input type="submit" value="Login">
    </form:form>

</body>
</html>
