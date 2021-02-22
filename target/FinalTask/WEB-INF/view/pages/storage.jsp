<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Title</title>
    <style><%@include file="/resources/split.css"%></style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  </head>
  <body>

    <jsp:include page="../menus/menuConnector.jsp"></jsp:include>
    <h2 style="color: blue; margin-left: 40%" >Storage</h2>
    <h3>Create goods</h3>


    <form method="POST" action="${pageContext.request.contextPath}/storage" style="margin-left: 5px" >
      <input type="hidden" name="redirectId" value="${param.redirectId}" />

      <div class="row mb-3">
        <label for="inputGoodsName" class="col-sm-2 col-form-label" >Goods name</label>
        <div class="col-sm-3">
          <input type="text" class="form-control" id="inputGoodsName" placeholder="Enter goods name" name="goodsName" value="${goods.goodsName}" required>
        </div>
      </div>

      <div class="row mb-3">
        <label for="inputQuantity" class="col-sm-2 col-form-label" >Quantity (max 999)</label>
        <div class="col-sm-3">
          <input type="number" min="1" max="999" class="form-control" id="inputQuantity" placeholder="Enter quantity" name="goodsQuantity" value="${goods.goodsQuantity}" required>
        </div>
      </div>

      <div class="row mb-3">
        <label for="inputPrice" class="col-sm-2 col-form-label">Price</label>
        <div class="col-sm-3">
          <input type="text" class="form-control" id="inputPrice" placeholder="Enter price" name="goodsPrice" value="${goods.goodsPrice}" required>
        </div>
      </div>

      <button style="margin-left: 481px" type="submit" class="btn btn-primary btn-lg"> Add </button>
    </form>

  <br>
    <div class="split right">
      <br>
    <main class="m-3">
      <div class="row col-md-6">
        <table class="table table-striped table-bordered table-sm">
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Price</th>
          </tr>

          <c:forEach items="${goodsList}" var="goods">
            <tr>
              <td>${goods.getGoodsId()}</td>
              <td>${goods.getGoodsName()}</td>
              <td>${goods.getGoodsQuantity()}</td>
              <td>${goods.getGoodsPrice()}</td>
            </tr>
          </c:forEach>
        </table>
      </div>

      <nav aria-label="Navigation for countries">
        <ul class="pagination">
          <c:if test="${currentPage != 1}">
            <li class="page-item"><a class="page-link"
                                     href="storage?recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}">Previous</a>
            </li>
          </c:if>

          <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
              <c:when test="${currentPage eq i}">
                <li class="page-item active"><a class="page-link">
                    ${i} <span class="sr-only">(current)</span></a>
                </li>
              </c:when>
              <c:otherwise>
                <li class="page-item"><a class="page-link"
                                         href="storage?recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                </li>
              </c:otherwise>
            </c:choose>
          </c:forEach>

          <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="storage?recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}">Next</a>
            </li>
          </c:if>
        </ul>
      </nav>
    </main>
    </div>
  </body>
</html>
