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

<title>Uusi kysely</title>
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
		<div class="row">
			<div class="col">
				<h1 class="otsikko">
				Lisää uusi kysely
				</h1>
			</div>
		</div>
		<div class="row">
		<div class="col">
	<form:form modelAttribute="kysely" method="post">
		<div class="form-group">
			<label for="nimi">Nimi:</label>
			<input type="text" class="form-control" name="nimi" value=""/>
		</div>
		<div class="form-group">
			<label for="nimi">Kuvaus:</label>
			<input type="text" class="form-control" name="kuvaus" value=""/>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Lisää" />
			<input type="reset" class="btn btn-danger" value="Tyhjennä" />
		</div>
	</form:form>
	</div></div>
	
	<a href="/backend/hallinta/kyselyt" class="btn btn-secondary">Takaisin</a>

	</div>
</body>
</html>