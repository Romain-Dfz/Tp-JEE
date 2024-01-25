<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produits</title>
    <jsp:include page="../includes/head.jsp" />

</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container mt-4">
<center>
    <h2>Liste des produits </h2>
</center>
<div class="m-4">
        <a href="new" class="btn btn-success text-start">Add Product </a>
</div>


    <center>
    <table border="1" cellpadding="5" class="table table-dark text-center" >
        <caption><h2>List of Product</h2></caption>
        <tr>
            <th>Marque</th>
            <th>Reference</th>
            <th>Prix</th>
            <th>Stock</th>
            <th>Date achat</th>
            <th >Actions</th>
        </tr>
<c:if test="${produits != null}">
        <c:forEach items="${produits}" var="produit">
            <tr>
                <td>${produit.getMarque()}</td>
                <td>${produit.getReference()}</td>
                <td>${produit.getPrix()} €</td>
                <td>${produit.getStock()}</td>
                <td>${produit.getDateAchat()}</td>
                <td>
                    <a href="edit?id=${produit.getId()}" class="btn btn-info">Edit</a>
                    <a href="delete?id=${produit.getId()}" class="btn btn-danger">Delete</a>
                    <a href="details?id=${produit.getId()}" class="btn btn-primary">Detail</a>
                </td>
            </tr>
        </c:forEach>
</c:if>
    </table>
    </center>
</div>


</body>
</html>
