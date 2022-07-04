<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 19.06.2022
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<body>
<h1>Hello user, ${userName}</h1>
<form method="post" action="Servlet">
    <input type="submit" name="command" value="user_catalog_beer" class="btn btn-success">
    <input type="submit" name="command" value="buy_product" class="btn btn-success">
    <input type="submit" name="command" value="shop_history" class="btn btn-success">
    <input type="submit" name="command" value="logout" class="btn btn-success">

</form>
</body>
</html>
