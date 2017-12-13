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
<link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet">

<title>Kyselyt</title>
</head>
<body>
<header>

 	<nav>
		<div class="row">
			<ul class="main-nav">
				<li><a href="/backend">Etusivu</a></li>
				<li><a href="/backend/hallinta/kyselyt">Kyselyt</a></li>
				<li><a href="https://github.com/welski/suunta">REST Api</a></li>
			</ul>
		</div>
    </nav>
    
</header>
	<div class="container">
			<h1 class="otsikko">
				Kyselyt
			</h1>
		<table class="table table-striped">
			<thead>
				<tr class="col">
					<th class="col-1">
						Id
					</th>
					<th class="col-3">
						Nimi
					</th>
					<th class="col-4">
						Kuvaus
					</th>
					<th class="col-3">
						Näytä kysymykset
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
							<a href="kyselyt/<c:out value="${kysely.id}/kysymykset" />">
							Näytä kysymykset</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="row">
			<div class="col">
				<a href="/backend/hallinta/kyselyt/uusiKysely" class="btn btn-primary">Lisää uusi kysely</a>
			</div>
		</div>
	<div class="row">
		<div class="col">
		<br><br>
		<a href="/backend/" class="btn btn-secondary">Palaa etusivulle</a>
		</div>
	</div>
	</div>
</body>
</html>