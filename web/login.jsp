<%--
  Created by IntelliJ IDEA.
  User: abhishekbhandari
  Date: 13/06/18
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Welcome, please login:</h1>
    <form action="/login" method="post">
        login-name = <input type="text" name="loginname" width="30"/>
        password= <input type="password" name="password" width="30"/>
        <input type="submit" name="Login"/>
    </form>
    <p style="color: red "> ${errorMessage}</p>
</body>
</html>
