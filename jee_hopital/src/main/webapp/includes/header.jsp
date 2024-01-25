
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="head.jsp" />
  <title></title>
</head>
<body>

  <nav class="navbar navbar-expand-lg navbar-light bg-light shadow-lg">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="list">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="new">Add</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="https://www.amazon.fr/" >Amazon</a>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled">About</a>
        </li>
      </ul>
      <div class="form-inline  gx-4 my-lg-0 text-center ">
        <c:if test="${not empty sessionScope.name}">
          <div class="mx-4">
          <i class="bi bi-person-circle"></i><br>
          <span>${sessionScope.name}</span>
          </div>
        </c:if>
        <a class="btn btn-outline-danger my-2 my-sm-0" href="user">Logout</a>
      </div>
    </div>
  </nav>
</body>
</html>
