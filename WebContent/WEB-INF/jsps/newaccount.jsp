<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js "></script>
<script type="text/javascript">
	function onload() {
		$("#password").keyup(checkPasswordsMatch);
		$("#confirm").keyup(checkPasswordsMatch);
		$("#signupForm").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirm = $("#confirm").val();

		if (password != confirm) {
			alert("Passwords do not match!");
			return false;
		} else {
			return true;
		}
	}

	function checkPasswordsMatch() {
		var password = $("#password").val();
		var confirm = $("#confirm").val();
		if (password.length > 7 || confirm.length > 7) {
			if (password == confirm) {
				$("#passwordMatch").text("Passwords match");
				$("#passwordMatch").addClass("valid-w");
				$("#passwordMatch").removeClass("invalid-w");

			} else {
				$("#passwordMatch").text("Passwords DO NOT match");
				$("#passwordMatch").addClass("invalid-w");
				$("#passwordMatch").removeClass("valid-w");

			}
		}
	}
	$(document).ready(onload);
</script>
<link rel="stylesheet" type="text/css"
	href="resources/css/bootstrap-lumen.css">
<link rel="stylesheet" type="text/css" href="resources/css/errors.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create an account</title>
</head>
<body>
	<div class="container body-content">


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
					<td>Email: <form:input path="email" class="form-control"
							type="text" name="email" />
					<td><form:errors path="email" cssClass="invalid-feedback-w"></form:errors></td>
					</td>
				</tr>
				<tr>
					<td>Password: <form:input path="password" class="form-control"
							type="text" name="password" id="password" /></td>
					<td><form:errors path="password" cssClass="invalid-feedback-w"></form:errors></td>
				</tr>
				<tr>
					<td>Confirm Password: <input path="confirmpass" id="confirm"
						class="form-control" type="text" name="confirmpass" /></td>
					<td id="passwordMatch"></td>
				</tr>
				<tr>
					<td><input class="btn btn-primary" type="submit"
						value="Create Account" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>