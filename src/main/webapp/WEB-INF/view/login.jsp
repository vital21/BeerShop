<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 13.06.2022
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <meta charset="utf-8" />
</head>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <div class="form">
            <h1>Вход</h1><br>
            <form method="post" action="Servlet">
                <input type="text"  placeholder="login" name="login"><br>
                <input type="password"  placeholder="password" name="password"><br><br>
                <input  type="submit" name="command" value="login_command" class="btn btn-success">
                <input  type="submit" name="command" value="registration_command" class="btn btn-success"><br>

            </form>
        </div>
</body>
</html>
