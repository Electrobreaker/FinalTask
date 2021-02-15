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
                <a class="navbar-brand" href="${pageContext.request.contextPath}/storage"> Storage </a>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/logout"> Logout </a>
            </div>
        </div>
      </div>
    </nav>
  </body>
</html>

<div class="row mb-3">
    <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
    <div class="col-sm-3">
        <input type="email" class="form-control" id="inputEmail" placeholder="name@example.com">
    </div>
</div>
<div class="row mb-3">
    <label for="inputAddress" class="col-sm-2 col-form-label" >Address</label>
    <div class="col-sm-3">
        <input type="text" class="form-control" id="inputAddress" placeholder="Enter address">
    </div>
</div>
<div class="row mb-3">
    <label for="inputPhoneNumber" class="col-sm-2 col-form-label" >Phone Number</label>
    <div class="col-sm-3">
        <input type="text" class="form-control" id="inputPhoneNumber" placeholder="Enter phone number">
    </div>
</div>

<div class="row mb-3">
    <label for="chooseRole" class="col-sm-2 col-form-label">Role</label>
    <div class="col-auto">
        <select id="chooseRole" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
            <option selected>Pick role</option>
            <option value="1">Cashier</option>
            <option value="2">Senior cashier</option>
            <option value="3">Commodity expert</option>
        </select>
    </div>
</div>