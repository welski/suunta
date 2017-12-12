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
	
	<link rel="stylesheet" type="text/css" href="../../resources/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="../../resources/css/backend.css">
	<link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet">
	
	<title>Kysymykset</title>
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
		
				<h1 class="otsikko">Kysymykset</h1>
			
				<table class="table table-striped">
					<thead>
						<tr class="col">
							<th class="col-xs-auto">
								id
							</th>
							<th class="col-xs-auto">
								kysymys
							</th>
							
							<th class="col-xs-auto">
								näytä
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${kysymykset}" var="kysymys">
							<tr>
								<th scope="row"><c:out value="${kysymys.id}"/></th>
								<td><c:out value="${kysymys.teksti}"/></td>
								<td><a href="<c:out value="${kysymys.id}"/>/vastaukset" >Vastaukset</a></td>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>
				
			<div class="form-group">
			<a href="/backend/hallinta/kyselyt/<c:out value="${kyselyId}" />/lisaaMonivalinta" class="btn btn-primary">Lisää monivalintakysymys</a>
			<a href="/backend/hallinta/kyselyt/<c:out value="${kyselyId}" />/lisaaTeksti" class="btn btn-danger">Lisää tekstikysymys</a>
			</div>
		</div>
	</body>
</html>