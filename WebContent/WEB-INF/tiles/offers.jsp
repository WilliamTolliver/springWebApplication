<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="offer" items="${offers}">
    Id: ${offer.id}<br />
    Name: ${offer.name}<br />
    Email: ${offer.email}<br />
    Desc: ${offer.text}<br />
	<hr />
</c:forEach>