<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-lumen.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an account</title>
</head>
<body>
	<div class="container body-content">

		<form:form method="post"
			action="${pageContext.request.contextPath }/createaccount"
			commandName="user">
			<table>
				<tr>
					<td>Username: <form:input path="username" class="form-control"
							type="text" name="username" /> <form:errors path="username"
							cssClass="alert alert-dismissible alert-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Email: <form:input path="email" class="form-control"
							type="text" name="email" /> <form:errors path="email"
							cssClass="alert alert-dismissible alert-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Password: <form:input path="password" class="form-control"
							type="text" name="password" /> <form:errors path="password"
							cssClass="alert alert-dismissible alert-danger"></form:errors></td>
				</tr>
				<tr>
					<td>Confirm Password: <input path="confirmpass"
						class="form-control" type="text" name="confirmpass" /></td>
				</tr>
				<tr>
					<td><input class="btn btn-primary" type="submit"
						value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>