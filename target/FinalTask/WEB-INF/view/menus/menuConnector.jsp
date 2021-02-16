<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "role" scope = "session" value = "${userRole}"/>

<c:choose>
    <c:when test = "${role == 'CASHIER'}"><jsp:include page="cashierMenu.jsp"></jsp:include>  </c:when>
    <c:when test = "${role == 'SENIOR_CASHIER'}"><jsp:include page="seniorCashierMenu.jsp"></jsp:include></c:when>
    <c:when test = "${role == 'COMMODITY_EXPERT'}"><jsp:include page="commodityExpertMenu.jsp"></jsp:include></c:when>
    <c:when test = "${role == 'ADMIN'}"> <jsp:include page="adminMenu.jsp"></jsp:include> </c:when>
</c:choose>


