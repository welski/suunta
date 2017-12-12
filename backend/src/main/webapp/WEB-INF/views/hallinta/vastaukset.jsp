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
	
	<link rel="stylesheet" type="text/css" href="../../../resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../../../resources/css/backend.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet">
	
	<title>Vastaukset</title>
	</head>
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
	<body>
		<div class="container">
				<h1 class="otsikko">Vastaukset</h1>
			
				<table class="table table-striped">
					<thead>
						<tr class="col">
							<th class="col-xs-auto">
								Vastaus
							</th>
							<th class="col-xs-auto">
								Lkm
							</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${vastaukset}" var="vastaus">
							<tr>
								<td scope="row"><c:out value="${vastaus.key}"/></td>
								<td><c:out value="${vastaus.value}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<a href="/backend/hallinta/kysymykset/${id}" class="btn btn-secondary">Takaisin</a>
			</div>
	</body>
</html>