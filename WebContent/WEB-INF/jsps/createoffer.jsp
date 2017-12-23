<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/bootstrap-lumen.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container body-content">
		Under Construction - Create Offer

		<form:form method="post"
			action="${pageContext.request.contextPath }/docreate" commandName="offer">
			<table>
				<tr>
					<td>Name: <form:input path="name" class="form-control" type="text" name="name" /><form:errors path="name" cssClass="alert alert-dismissible alert-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Email: <form:input path="email" class="form-control" type="text" name="email" /><form:errors path="email" cssClass="alert alert-dismissible alert-danger"></form:errors></td>
				</tr>
				<tr>
					<td>The Offer: <form:textarea path="text" class="form-control" rows="10" cols="10" name="text"></form:textarea><form:errors path="text" cssClass="alert alert-dismissible alert-danger"></form:errors></td>
				</tr>
				<tr>
					<td><input class="btn btn-primary" type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>