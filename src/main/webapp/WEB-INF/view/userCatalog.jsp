<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 21.06.2022
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>product</title>
</head>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<h1>Product List</h1>
<form method="get" action="Servlet">
    <table style="width: 70%">
        <tr><th>Название</th><th>Тип тары</th><th>Обьем тары</th><th>Тип пива</th><th>Процент алкоголя</th><th>Горечь</th><th>Количество</th><th></th></tr>
        <c:forEach var="product" items="${products}">
            <tr><td style="width: 20%">${product.nameBeer}</td>
                <td style="width: 20%">${product.containerType}</td>
                <td style="width: 10%">${product.volumeContainerBeer}</td>
                <td style="width: 20%">${product.typeBeer}</td>
                <td style="width: 10%">${product.percentageOfAlcoholBeer}</td>
                <td style="width: 10%">${product.bitternessOfBeer}</td>
                <td style="width: 10%">${product.quantityOfBeer}</td>
                <td>
                    <form method="get" action="Servlet">
                        <input type="hidden" name="productId" value="${product.id}">
                        <input type="submit" name="command" value="add_Beer_To_Buy_Page"class="btn btn-success">
                    </form>
                </td></tr>
        </c:forEach>

    </table>
    <input type="submit" name="command" value="buy_product" class="btn btn-success">
    <input type="submit" name="command" value="user_menu_page" class="btn btn-success">
</form>
</body>
</html>
