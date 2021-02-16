<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  </head>
  <body>
  <jsp:include page="../menus/menuConnector.jsp"></jsp:include>
  <h2 style="margin-left: 42%">Admin page</h2>
  <h3>Create new user</h3>


  <form method="POST" action="${pageContext.request.contextPath}/adminPage" style="margin-left: 5px" >
    <input type="hidden" name="redirectId" value="${param.redirectId}" />
    <div class="row mb-3">
      <label for="inputName" class="col-sm-2 col-form-label" >Name</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" id="inputName" placeholder="Enter name" name="userName" value = "${user.userName}">
      </div>
    </div>

    <div class="row mb-3">
      <label for="inputPassword" class="col-sm-2 col-form-label" >Password</label>
      <div class="col-sm-3">
        <input type="password" class="form-control" id="inputPassword" placeholder="Enter password" name="userPassword" value = "${user.userPassword}">
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputEmail" class="col-sm-2 col-form-label">Email</label>
      <div class="col-sm-3">
        <input type="email" class="form-control" id="inputEmail" placeholder="name@example.com" name="userEmail" value= "${user.userEmail}">
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputAddress" class="col-sm-2 col-form-label" >Address</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" id="inputAddress" placeholder="Enter address" name="userAddress" value= "${user.userAddress}">
      </div>
    </div>
    <div class="row mb-3">
      <label for="inputPhoneNumber" class="col-sm-2 col-form-label" >Phone Number</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" id="inputPhoneNumber" placeholder="Enter phone number" name="userPhoneNumber" value= "${user.userPhoneNumber}">
      </div>
    </div>

    <div class="row mb-3">
      <label for="chooseRole" class="col-sm-2 col-form-label">Role</label>
      <div class="col-auto">
        <select id="chooseRole" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example" name="roleId">
          <option value="1">Cashier</option>
          <option value="2">Senior cashier</option>
          <option value="3">Commodity expert</option>
        </select>
      </div>
    </div>

    <button style="margin-left: 481px" type="submit" class="btn btn-primary btn-lg" >Submit</button>
  </form>







  </body>
</html>
