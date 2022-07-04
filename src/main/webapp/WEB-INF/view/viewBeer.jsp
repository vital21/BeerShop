

<%--
  Created by IntelliJ IDEA.
  User: vital
  Date: 13.06.2022
  Time: 21:30
  To change this template use File | Settings | File Templates.
  private String nameBeer;
    public enum ContainerType{
       BOTTLE,CAN,DRAFT;
    }
    private ContainerType containerType;
    private double volumeContainerBeer;
    private String typeBeer;
    private double percentageOfAlcoholBeer;
    private int bitternessOfBeer;
    private int  quantityOfBeer;
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>product</title>
</head>
<body>
<h1>Список товаров</h1>
<form method="get" action="Servlet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<table style="width: 70%">

    <tr><th>Название</th><th>Тип тары</th><th>Обьем тары</th><th>Тип пива</th><th>Процент алкоголя</th><th>Горечь</th><th>Количество</th><th></th></tr>
<c:forEach var="product" items="${products}">
    <tr><td>${product.nameBeer}</td>
         <td>${product.containerType}</td>
         <td>${product.volumeContainerBeer}</td>
        <td>${product.typeBeer}</td>
        <td>${product.percentageOfAlcoholBeer}</td>
        <td>${product.bitternessOfBeer}</td>
        <td>${product.quantityOfBeer}</td>
        <td>
            <form method="post" action="Servlet">
            <input type="hidden" name="productId" value="${product.id}">
            <input type="submit" name="command" value="edit_page_beer" class="btn btn-success">
            </form>
        </td></tr>
</c:forEach>
</table>
</form>
<form action="Servlet" method="post">
    <input type="submit" name="command" value="admin_menu_page" class="btn btn-success">
</form>
</body>
</html>
