<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 14.06.2022
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <meta charset="utf-8" />
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<body>
<div class="form">
  <h1>input</h1><br>
  <form method="post" action="Servlet">
    <input type="text" required placeholder="login" name="login"><br>
    <input type="email" required placeholder="email" name="email"><br>
    <input type="password" required placeholder="password" name="password"><br><br>
    <input class="button" type="submit" name="command" value="registration_user_command"class="btn btn-success">
  </form>

</div>

</body>
</html>
