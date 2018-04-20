<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.ivmiit.projectFixCourse.model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="Cp1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Products</title>
    <link href="/css/formStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div class="form-style-6">
        <h1>Products list</h1>
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
        <a href="/save-product">Go to adding products</a>
        <a href="/signIn">Exit</a>
    </div>

</body>

</html>
