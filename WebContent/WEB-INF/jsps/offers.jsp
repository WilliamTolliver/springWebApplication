
<c:forEach var="offer" items="${offers}">
    Id: ${offer.id}<br />
    Name: ${offer.name}<br />
    Email: ${offer.email}<br />
    Desc: ${offer.text}<br />
	<hr />
</c:forEach>