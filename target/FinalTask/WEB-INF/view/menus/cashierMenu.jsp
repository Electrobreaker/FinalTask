<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Title</title>
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="navbar-brand" aria-current="page" href="${pageContext.request.contextPath}/profile"> Profile </a>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/cashier"> Cashier Page </a>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/logout"> Logout </a>
            </div>
        </div>
      </div>
    </nav>
  </body>
</html>