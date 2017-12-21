<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css"></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Under Construction - Create Offer

	<form method="get"
		action="${pageContext.request.contextPath }/docreate">
		<table>
			<tr><td>Name: <input type="text" name="name" /></td></tr>
			<tr><td>Email: <input type="text" name="email" /></td></tr>
			<tr><td>The Offer: <textarea rows="10" cols="10"></textarea></td></tr>
			<tr><td><input type="submit" value="Create advert" /></td></tr>
		</table>
	</form>

</body>
</html>