<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Create new Account</h2>
<form:form method="post" id="signupForm"
	action="${pageContext.request.contextPath }/createaccount"
	commandName="user">
	<table>
		<tr>
			<td>Username: <form:input path="username" class="form-control"
					type="text" name="username" /></td>
			<td><form:errors path="username" cssClass="invalid-feedback-w"></form:errors></td>
		</tr>
		<tr>
			<td>Name: <form:input path="name" class="form-control"
					type="text" name="name" /></td>
			<td><form:errors path="name" cssClass="invalid-feedback-w"></form:errors></td>
		</tr>
		<tr>
			<td>Email: <form:input path="email" class="form-control"
					type="text" name="email" />
			<td><form:errors path="email" cssClass="invalid-feedback-w"></form:errors></td>
			</td>
		</tr>
		<tr>
			<td>Password: <form:input path="password" class="form-control"
					type="password" name="password" id="password" /></td>
			<td><form:errors path="password" cssClass="invalid-feedback-w"></form:errors></td>
		</tr>
		<tr>
			<td>Confirm Password: <input path="confirmpass" id="confirm"
				class="form-control" type="password" name="confirmpass" /></td>
			<td id="passwordMatch"></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit"
				value="Create Account" /></td>
		</tr>
	</table>
</form:form>