<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 21.06.2022
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <title>Edit beer</title>
</head>
<body>
<form method="post" action="Servlet">
    <input type="hidden" value="${product.id}" name="productId">
    <label>Новый обьем емкости</label><br>
    <input type="number" step="any" name="volumeContainerBeer"><br>
    <label>Количество</label><br>
    <input type="number" name="quantityOfBeer"><br>
    <input type="submit" name="command" value="edit_beer" class="btn btn-success">
    <input type="submit" name="command" value="view_products_command" class="btn btn-success">
</form>
</body>
</html>
