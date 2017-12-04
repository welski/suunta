<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="resources/css/backend.css">
<link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet">

<title>Backend</title>
</head>
<body>
<header>
<nav>
		<div class="row">
			<ul class="main-nav">
				<li><a href="/backend">Etusivu</a></li>
				<li><a href="/backend/hallinta/kyselyt">Kyselyt</a></li>
				<li><a href="#">Kirjautuminen</a></li>
			</ul>
		</div>
    </nav>
</header>
<div class="container">
		<div class="col-12">
			<h4>Backend</h4>
		</div>
		
		<div class="row">
		<h2>Rest API</h2>
	</div>
	<div class="row">
		<a href="http://github.com/welski/suunta">Rest API @ GitHub</a>
	</div>

	<div class="row" style="margin-top: 40px;">
	
		<div class="col-6">
			<h2>JSON</h2>
			<ul>
				<li><a href="kyselyt">Kaikki kyselyt</a></li>
				<li><a href="kyselyt/1">Esimerkki: Yksi kysely</a></li>
				<li><a href="kyselyt/1/kysymykset">Esimerkki: Yhden kyselyn kaikki kysymykset</a></li>
				<li><a href="kyselyt/1/kysymykset/1">Esimerkki: Yhden kyselyn yksi kysymys</a></li>
			</ul>
		</div>
		<div class="col-6">
			<a href="hallinta/kyselyt">Kyselyiden hallinta</a>
		</div>
	</div>
	</div>
</body>
</html>