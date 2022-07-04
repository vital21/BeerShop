<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 26.06.2022
  Time: 13:47
  To change this template use File | Settings | File Templates.
  request.setAttribute("beerList",beers);
        request.setAttribute("userBuys",userBuys);
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

        <tr><th>Название</th><th>Тип тары</th><th>Обьем тары</th><th>Тип пива</th><th>Процент алкоголя</th><th>Горечь</th><th>Количество на заказ</th><th>Дата покупки</th><th></th></tr>
        <tr><c:forEach var="beer" items="${beerList}"  varStatus="stepForEach">
            <td STYLE="width: 15%">${beer.nameBeer}</td>
            <td STYLE="width: 10%">${beer.containerType}</td>
            <td STYLE="width: 10%">${beer.volumeContainerBeer}</td>
            <td STYLE="width: 10%">${beer.typeBeer}</td>
            <td STYLE="width: 10%">${beer.percentageOfAlcoholBeer}</td>
            <td STYLE="width: 10%">${beer.bitternessOfBeer}</td>
            <c:forEach var="userBuy" items="${userBuys}" begin="${stepForEach.index}" end="${stepForEach.index}">
                <td STYLE="width: 12%">${userBuy.quantityBuyBeer}</td>
                <td STYLE="width: 25%">${userBuy.date}</td>
            </c:forEach>
        </tr>
        </c:forEach>



    </table>
    <table>
        <form method="post" action="Servlet">
            <td><input type="submit" name="command" value="user_menu_page" class="btn btn-success"></td>
        </form>
    </table>
</form>
</body>
</html>

