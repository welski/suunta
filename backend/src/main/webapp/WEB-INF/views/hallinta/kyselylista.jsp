<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../resources/css/backend.css">

<title>Kyselyt</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>
				Kyselyt
			</h1>
		</div>
		<div class="col-md-12">
		<table class="table table-striped">
			<thead>
				<tr class="col">
					<th class="col-xs-auto">
						id
					</th>
					<th class="col-xs-auto">
						nimi
					</th>
					<th class="col">
						kuvaus
					</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${kyselyt}" var="kysely">
					<tr>
						<th scope="row"><c:out value="${kysely.id}" /></th>
						<td><c:out value="${kysely.nimi}" /></td>
						<td><c:out value="${kysely.kuvaus}" /></td>						
						<td>
							<a href="kysely/<c:out value="${kysely.id}" />">
							muokkaa</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>

	</div>
</body>
</html>