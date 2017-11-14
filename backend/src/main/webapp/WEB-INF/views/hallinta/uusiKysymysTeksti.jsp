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

<title>Uusi tekstikysymys</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>
				Lisää uusi tekstikysymys
			</h1>
		</div>

	<form:form modelAttribute="kysymys" method="post">
		<div class="form-group">
			<label for="teksti">Kysymys</label>
			<input type="text" class="form-control" name="teksti" value=""/>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Lisää" />
			<input type="reset" class="btn btn-danger" value="Tyhjennä" />
		</div>

	</form:form>

	</div>
</body>
</html>