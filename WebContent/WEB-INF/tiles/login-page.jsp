<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-lumen.css">
<link rel="stylesheet" type="text/css" href="resources/css/errors.css">
</head>
<body>
	<h3>Login using Username and Password</h3>
	<c:if test="${param.error != null }">
		<p class="login-error-w">Login failed, please check your username
			and password</p>
	</c:if>
	<form name='f' action='${pageContext.request.contextPath}/login'
		method='POST'>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td>Remember me:</td>
				<td><input type='checkbox' name='remember-me' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</tr>
		</table>
	</form>

	<p>
		<a href="<c:url value="/newaccount"/>">Create new account </a>
	</p>
</body>
</html>