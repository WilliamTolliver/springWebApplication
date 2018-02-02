<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarColor01" aria-controls="navbarColor01"
		aria-expanded="false" aria-label="Toggle navigation" style="">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarColor01">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="http://localhost:8080/spring/">Home <span class="sr-only">(current)</span>
			</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/createoffer">Create
					Offer</a></li>

			<li class="nav-item"><a class="nav-link"
				href="${pageContext.request.contextPath}/offers">Show Offers</a></li>

			<sec:authorize access="!isAuthenticated()">
				<a class="nav-link" href="http://localhost:8080/spring/login-page">Login</a>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<c:url var="logoutUrl" value="/logout" />
				<form action="${pageContext.request.contextPath}/logout" id="logout"
					method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
				<a class="nav-link" href="#" onclick="document.getElementById('logout').submit();">Logout</a>
			</sec:authorize>

			<p />
		</ul>

	</div>
</nav>