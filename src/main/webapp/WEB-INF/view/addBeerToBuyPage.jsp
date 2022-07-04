<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 21.06.2022
  Time: 22:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<h1>Hello you ready for by</h1>
<form method="get" action="Servlet">

    <table STYLE="width: 70%">

        <tr><th>Название</th><th>Тип тары</th><th>Обьем тары</th><th>Тип пива</th><th>Процент алкоголя</th><th>Горечь</th><th>Количество</th><th></th></tr>

           <td style="width: 20%"><c:out
                   value="${products.nameBeer}"
           ></c:out></td>
        <td style="width: 20%"><c:out
                value="${products.containerType}"
        ></c:out></td>
        <td style="width: 10%"><c:out
                value="${products.volumeContainerBeer}"
        ></c:out></td>
        <td style="width: 20%"><c:out
                value="${products.typeBeer}"
        ></c:out></td>
        <td style="width: 10%"><c:out
                value="${products.percentageOfAlcoholBeer}"
        ></c:out></td>
        <td style="width: 10%"><c:out
                value="${products.bitternessOfBeer}"
        ></c:out></td>
        <td style="width: 10%"><c:out
                value="${products.quantityOfBeer}"
        ></c:out></td>


    </table>
    <label>Quantity</label>
    <input type="number" value="quantity" name="quantity">
    <br><input type="submit" name="command" value="add_beer_to_buy" class="btn btn-success">
    <input type="submit" name="command" value="user_catalog_beer" class="btn btn-success">
</form>
</body>
</html>
