<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<head><title><fmt:message key="title" /></title></head>
<body>
	<h1><fmt:message key="heading" /></h1>
	<p><fmt:message key="greeting" /> <c:out value="${model.now}" /></p>
	<h3>Products:</h3>
	<c:forEach items="${model.products}" var="product">
		<c:out value="${product.description}" /> <li> <c:out value="${product.price}" /></li><br><br>
	</c:forEach>
	
	<br>
<a href="<c:url value="priceincrease.htm"/>">Increase Prices</a>
<br>
</body>
</html>