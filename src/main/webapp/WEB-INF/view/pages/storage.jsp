<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
  </head>
  <body>

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
                                     href="storagePage?currentPage=${currentPage-1}">Previous</a>
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
                                         href="storagePage?currentPage=${i}">${i}</a>
                </li>
              </c:otherwise>
            </c:choose>
          </c:forEach>

          <c:if test="${currentPage lt noOfPages}">
            <li class="page-item"><a class="page-link"
                                     href="storagePage?currentPage=${currentPage+1}">Next</a>
            </li>
          </c:if>
        </ul>
      </nav>
    </main>
    </div>
  </body>
</html>
