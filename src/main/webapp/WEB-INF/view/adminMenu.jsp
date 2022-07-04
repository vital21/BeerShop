<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 13.06.2022
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Title</title>
    <meta charset="utf-8" />
</head>
<body>
<h1>Hello admin</h1>
<form method="post" action="Servlet">
    <input type="submit" name="command" value="insert_page_beer" class="btn btn-success">
    <input type="submit" name="command" value="view_products_command" class="btn btn-success">
    <input type="submit" name="command" value="shop_history_all" class="btn btn-success">
    <input type="submit" name="command" value="logout" class="btn btn-success">
</form>

</body>
</html>
