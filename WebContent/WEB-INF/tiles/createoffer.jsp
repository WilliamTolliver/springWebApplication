<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container body-content">

	<form:form method="post"
		action="${pageContext.request.contextPath }/docreate"
		commandName="offer">
		<table>
			<tr>
				<td>Name: <form:input path="name" class="form-control"
						type="text" name="name" />
					<form:errors path="name"
						cssClass="alert alert-dismissible alert-danger"></form:errors></td>
			</tr>
			<tr>
				<td>Email: <form:input path="email" class="form-control"
						type="text" name="email" />
					<form:errors path="email"
						cssClass="alert alert-dismissible alert-danger"></form:errors></td>
			</tr>
			<tr>
				<td>The Offer: <form:textarea path="text" class="form-control"
						rows="10" cols="10" name="text"></form:textarea>
					<form:errors path="text"
						cssClass="alert alert-dismissible alert-danger"></form:errors></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</div>