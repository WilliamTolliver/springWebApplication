<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="https://bootswatch.com/4/lumen/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container body-content">
		Under Construction - Create Offer

		<form method="get"
			action="${pageContext.request.contextPath }/docreate">
			<table>
				<tr>
					<td>Name: <input class="form-control" type="text" name="name" /></td>
				</tr>
				<tr>
					<td>Email: <input class="form-control" type="text" name="email" /></td>
				</tr>
				<tr>
					<td>The Offer: <textarea class="form-control" rows="10" cols="10"></textarea></td>
				</tr>
				<tr>
					<td><input class="btn btn-primary" type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>