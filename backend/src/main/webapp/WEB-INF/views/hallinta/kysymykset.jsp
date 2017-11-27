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
	
	<title>Kysymykset</title>
	</head>
	<body>
		<div class="container">
		
			<div class="row">
				<h1>Kysymykset</h1>
			</div>
			
			<div class="col-md-12">
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
								muokkaa
							</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${kysymykset}" var="kysymys">
							<tr>
								<th scope="row"><c:out value="${kysymys.id}"/></th>
								<td><c:out value="${kysymys.teksti}"/></td>
								<td><a href="<c:out value="${kysymys.id}"/>/poista" >Poista</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="form-group">
			<a href="/backend/hallinta/kyselyt/<c:out value="${kyselyId}" />/lisaaMonivalinta" class="btn btn-primary">Lisää monivalintakysymys</a>
			<a href="/backend/hallinta/kyselyt/<c:out value="${kyselyId}" />/lisaaTeksti" class="btn btn-danger">Lisää tekstikysymys</a>
			</div>
		</div>
	</body>
</html>