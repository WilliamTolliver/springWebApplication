	<p />

	<a href="${pageContext.request.contextPath}/offers"> Show all
		offers </a>
	<p />

	<a href="${pageContext.request.contextPath}/createoffer"> Add a new
		Offer </a>

	<p />
	
		<sec:authorize access="!isAuthenticated()">
		<a href="http://localhost:8080/spring/login-page" >Login</a>
	</sec:authorize>
	
	
		<sec:authorize access="isAuthenticated()">
		<c:url var="logoutUrl" value="/logout" />
		<form action="${logoutUrl}" id="logout" method="post">
			<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
		</form>
		<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>
	</sec:authorize>
	
	<p />
	
	
	<sec:authorize access="hasAuthority('ROLE_ADMIN')">
		<a href="${pageContext.request.contextPath}/admin"> Admin Page </a>
	</sec:authorize>
