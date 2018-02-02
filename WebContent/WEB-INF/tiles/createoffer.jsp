<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	function onDeleteClick(event) {

		var doDelete = confirm("Are you sure you would like to delete this offer?");
		
		if(doDelete == false){
			event.preventDefault();			
		}
	}

	function onReady() {
		$("#delete").click(onDeleteClick);
	}
	
	$(document).ready(onReady);
</script>

<div class="container body-content">

	<form:form method="post"
		action="${pageContext.request.contextPath }/docreate"
		commandName="offer">
		<form:input type="hidden" name="id" path="id" />
		<table>
			<tr>
				<td>The Offer: <form:textarea path="text" class="form-control"
						rows="10" cols="10" name="text"></form:textarea> <form:errors
						path="text" cssClass="alert alert-dismissible alert-danger"></form:errors></td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" type="submit" value="Save" /></td>
			</tr>
			<c:if test="${offer.id!=0}">
				<tr>
					<td><input class="btn btn-danger" id="delete" name="delete"
						type="submit" value="Delete" /></td>
				</tr>
			</c:if>
		</table>
	</form:form>
</div>