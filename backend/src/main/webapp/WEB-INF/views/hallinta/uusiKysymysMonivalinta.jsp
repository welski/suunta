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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../../resources/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../../../resources/css/backend.css">

<title>Uusi monivalintakysymys</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1>
				Lisää uusi monivalintakysymys
			</h1>
		</div>

	<form:form modelAttribute="kysymysMv" method="post">
		<div class="form-group">
			<label for="teksti">Kysymys</label>
			<input type="text" class="form-control" name="teksti" value=""/>
		</div>
		<div id="vaihtoehdot">
		
		<div class="form-group">
			<label for="vaihtoehto">Vaihtoehto</label>
			<input type="text" class="form-control" name="vaihtoehto" value=""/>
		</div>
		<div class="form-group">
			<label for="vaihtoehto">Vaihtoehto</label>
			<input type="text" class="form-control" name="vaihtoehto" value=""/>
		</div>
		<div class="form-group">
			<label for="vaihtoehto">Vaihtoehto</label>
			<input type="text" class="form-control" name="vaihtoehto" value=""/>
		</div>
		
		</div>
		
		<div class="form-group">
			<button type="button" class="btn btn-secondary" id="lisaaNappi">+ Lisää vaihtoehto</button>
			<button type="button" class="btn btn-secondary" id="poistaNappi">- Poista vaihtoehto</button>
		</div>
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Lisää" />
			<input type="reset" class="btn btn-danger" value="Tyhjennä" />
		</div>

	</form:form>

	</div>
</body>
<script>
	$(document).ready(function () {
		$("#lisaaNappi").on("click", function () {
			var vaihtoehto = "<div class='form-group'><label for='vaihtoehto'>Vaihtoehto</label> <input type='text' class='form-control' name='vaihtoehto' value=''/></div>";
			$("#vaihtoehdot").append(vaihtoehto);
		});
		$("#poistaNappi").on("click", function () {
			$("#vaihtoehdot div").last().remove();
		});
	});

</script>
</html>