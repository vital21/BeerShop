<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 24.06.2022
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="get" action="Servlet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <table style="width: 70%">

        <tr><th>Название</th><th>Тип тары</th><th>Обьем тары</th><th>Тип пива</th><th>Процент алкоголя</th><th>Горечь</th><th>Количество</th><th>Количество на заказ</th><th></th></tr>
        <tr><c:forEach var="product" items="${products}"  varStatus="stepForEach">
           <td STYLE="width: 15%">${product.nameBeer}</td>
                <td STYLE="width: 15%">${product.containerType}</td>
                <td STYLE="width: 10%">${product.volumeContainerBeer}</td>
                <td STYLE="width: 15%">${product.typeBeer}</td>
                <td STYLE="width: 10%">${product.percentageOfAlcoholBeer}</td>
                <td STYLE="width: 10%">${product.bitternessOfBeer}</td>
                <td STYLE="width: 10%">${product.quantityOfBeer}</td>
            <c:forEach var="buyProduct" items="${buyProduct}" begin="${stepForEach.index}" end="${stepForEach.index}">
        <td STYLE="width: 20%">${buyProduct.quantity}</td>
        </c:forEach>
        </tr>
        </c:forEach>



    </table>
    <table>
        <form method="post" action="Servlet">
            <td><input type="submit" name="command" value="buy_product_cart" class="btn btn-success"></td>
            <td><input type="submit" name="command" value="clear_cart" class="btn btn-success"></td>
            <td><input type="submit" name="command" value="user_catalog_beer" class="btn btn-success"></td>
        </form>
    </table>
</form>
</body>
</html>
