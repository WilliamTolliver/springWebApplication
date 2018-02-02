<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is the home page</title>
</head>
<body>

	<sec:authorize access="hasAuthority('ROLE_ADMIN')">
		<a href="${pageContext.request.contextPath}/admin"> Admin Page </a>
	</sec:authorize>

	<c:forEach var="offer" items="${offers}">
    Id: ${offer.id}<br />
    Name: ${offer.user.name}<br />
    Email: ${offer.user.email}<br />
    Desc: ${offer.text}<br />
		<hr />
	</c:forEach>

	<c:choose>
		<c:when test="${hasOffer}">
			<a href="${pageContext.request.contextPath}/createoffer">Edit or
				delete your Offer</a>
		</c:when>
		<c:otherwise>
			<a href="${pageContext.request.contextPath}/createoffer">Create
				Offer</a>
		</c:otherwise>
	</c:choose>
</body>
</html>