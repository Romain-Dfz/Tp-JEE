<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add produit</title>
    <jsp:include page="../includes/head.jsp" />

</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div class="container mt-4">
    <center>
        <h2>Ajouter un produit </h2>
    </center>
<div>
    <form action="insert" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Marque</label>
                <input type="text" class="form-control" id="inputEmail4" name="marque">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPassword4">Reference</label>
                <input type="text" class="form-control" id="inputPassword4" name="reference">
            </div>
        </div>
        <div class="form-row">
        <div class="form-group col-md-4">
            <label for="inputAddress">Prix</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="12" name="prix">
        </div>
        <div class="form-group col-md-4">
            <label for="inputAddress2">Stock</label>
            <input type="text" class="form-control" id="inputAddress2" placeholder="50" name="stock">
        </div>
            <div class="form-group col-md-4">
                <label for="inputAddress3">Stock</label>
                <input type="date" class="form-control" id="inputAddress3" placeholder="50" name="dateAchat">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Validation</button>
    </form>
</div>
</div>
</body>
</html>
