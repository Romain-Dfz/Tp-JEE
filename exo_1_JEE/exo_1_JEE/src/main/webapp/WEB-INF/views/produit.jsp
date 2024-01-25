
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Produit ${produit.getId()}</title>
    <jsp:include page="../includes/head.jsp" />
</head>
<body>
<jsp:include page="../includes/header.jsp" />
<div class="container">
    <center>
<div class="card" style="width: 18rem;">
    <img src="" class="card-img-top" alt="...">
    <div class="card-body">
        <h5 class="card-title">Marque : ${produit.getMarque()}</h5>
        <p class="card-text">${produit.getReference()}</p>
    </div>
    <ul class="list-group list-group-flush">
        <li class="list-group-item">${produit.getPrix()} €</li>
        <li class="list-group-item">${produit.getStock()}</li>
        <li class="list-group-item">${produit.getDateAchat()}</li>
    </ul>
    <div class="card-body">
        <a href="list" class="btn btn-primary">Retour</a>
        <a href="delete?id=${produit.getId()}" class="btn btn-danger">Delete</a>
    </div>

</div>
    </center>
</div>
</body>
</html>
