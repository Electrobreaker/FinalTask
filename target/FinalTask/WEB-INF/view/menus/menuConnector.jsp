<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "role" scope = "session" value = "${userRole}"/>

<c:choose>
    <c:when test = "${role == 'CASHIER'}">  </c:when>
    <c:when test = "${role == 'SENIOR_CASHIER'}"></c:when>
    <c:when test = "${role == 'COMMODITY_EXPERT'}"></c:when>
    <c:when test = "${role == 'ADMIN'}"> <jsp:include page="adminMenu.jsp"></jsp:include> </c:when>
    <c:otherwise> <jsp:include page="defaultMenu.jsp"></jsp:include>  </c:otherwise>
</c:choose>


