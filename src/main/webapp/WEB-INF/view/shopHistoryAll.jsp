<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 27.06.2022
  Time: 17:00
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

        <tr><th>Имя пользователя</th><th>email пользователя</th><th>Название пива</th><th>Количество</th><th>Дата</th><th></th></tr>
        <tr><c:forEach var="user" items="${users}"  varStatus="stepForEach">
            <td STYLE="width: 15%">${user.login}</td>
            <td STYLE="width: 20%">${user.email}</td>
            <c:forEach var="beer" items="${beers}" begin="${stepForEach.index}" end="${stepForEach.index}">
                <td STYLE="width: 12%">${beer.nameBeer}</td>
            </c:forEach>
            <c:forEach var="userBuy" items="${userBuys}" begin="${stepForEach.index}" end="${stepForEach.index}">
                <td STYLE="width: 12%">${userBuy.quantityBuyBeer}</td>
                <td STYLE="width: 12%">${userBuy.date}</td>
            </c:forEach>
        </tr>
        </c:forEach>



    </table>
    <table>
        <form method="post" action="Servlet">
            <td><input type="submit" name="command" value="admin_menu_page" class="btn btn-success"></td>
        </form>
    </table>
</form>
</body>
</html>
