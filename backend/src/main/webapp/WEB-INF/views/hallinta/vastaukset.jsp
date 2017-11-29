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
	<link rel="stylesheet" type="text/css" href="../../resources/css/backend.css">
	
	<title>Vastaukset</title>
	</head>
	<body>
		<div class="container">
		
			<div class="row">
				<h1>Vastaukset</h1>
			</div>
			
			<div class="col-md-12">
				<table class="table table-striped">
					<thead>
						<tr class="col">
							<th class="col-xs-auto">
								vastaus
							</th>
							<th class="col-xs-auto">
								lkm
							</th>
							
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${vastaukset}" var="vastaus">
							<tr>
								<th scope="row"><c:out value="${vastaus.key}"/></th>
								<td><c:out value="${vastaus.value}"/></td>
							</tr>
							
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>