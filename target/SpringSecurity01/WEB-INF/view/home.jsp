<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: yilma
  Date: 20.07.2020
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>This is home page</title>
</head>
<body>
<h3>Home page</h3>
<hr>
<p><a href="${pageContext.request.contextPath}/showMyLoginPage">Go to Login Page</a></p>
<hr>

<p>
    User: <security:authentication property="principal.username" />
    <br><br>
    Role(s): <security:authentication property="principal.authorities" />
</p>

<security:authorize access="hasRole('MANAGER')">
    <hr>
    <p>
        <a href="${pageContext.request.contextPath}/showMyLeadersPage">Leaders (Only for Managers)</a>
    </p>
</security:authorize>
<security:authorize access="hasRole('ADMIN')">
    <hr>
    <p>
        <a href="${pageContext.request.contextPath}/systems">Systems Page (Only for Admins)</a>
    </p>
</security:authorize>

<form:form action="/logout" method="post">
    <input type="submit" value="Logout" />
</form:form>

</body>
</html>
