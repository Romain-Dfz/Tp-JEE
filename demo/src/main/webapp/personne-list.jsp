<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Personne</title>
</head>
<body>

<h1>La liste des personnes </h1>

<c:forEach items="${personnes}" var="personne">
    <div>
        Nom: ${personne.getNom()}
        Prenom: ${personne.getPrenom()}
    </div>
</c:forEach>

</body>
</html>
