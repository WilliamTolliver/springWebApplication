
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
			<td colspan='2'><input name="submit" type="submit" value="Login" /></td>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</tr>
	</table>
</form>

<p>
	<a href="<c:url value="/newaccount"/>">Create new account </a>
</p>