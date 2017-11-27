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
					<th class="col">
						muokkaa
					</th>
					<th class="col">
						näytä
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
							<a href="kysymykset/<c:out value="${kysely.id}" />">
							Näytä kysymykset</a>
						</td>
						<td>
							<a href="/backend/hallinta/vastaukset">
							Näytä vastaukset</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>

	<form:form modelAttribute="kysely" method="post">
		<div class="form-group">
			<label for="nimi">Nimi</label>
			<input type="text" class="form-control" name="nimi" value=""/>
		</div>
		<div class="form-group">
			<label for="nimi">Kuvaus</label>
			<input type="text" class="form-control" name="kuvaus" value=""/>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Lisää" />
			<input type="reset" class="btn btn-danger" value="Tyhjennä" />
		</div>

	</form:form>

	</div>
</body>
</html>