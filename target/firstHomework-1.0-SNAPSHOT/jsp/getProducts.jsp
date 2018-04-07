<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.ivmiit.alfia.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="Cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
    <link href="/css/formStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-style-6">
        <form method="post" action="data-product">
            <input  type="text" placeholder="name" name="name"><br>
            <input  type="submit" value="Add product">
        </form>
    </div>
    <div class="form-style-6">
        <h1>Список продуктов</h1>
        <table>
            <tr>
                <th>Product name</th>
            </tr>
            <jsp:useBean id="productsFromServer" scope="request" type="java.util.ArrayList"/>
            <c:forEach items="${productsFromServer}" var="product">
                <tr>
                    <td>${product.name}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>

</html>
