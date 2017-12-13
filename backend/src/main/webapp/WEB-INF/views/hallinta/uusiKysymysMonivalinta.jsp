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
<link href="https://fonts.googleapis.com/css?family=Lato:300" rel="stylesheet">

<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>

<title>Uusi monivalintakysymys</title>
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
				Lisää uusi monivalintakysymys
			</h1>

	<form:form modelAttribute="kysymysMv" method="post">
		<div class="form-group">
			<label for="teksti">Kysymys:</label>
			<input type="text" class="form-control" name="teksti" value=""/>
		</div>

		<div class="btn-group" data-toggle="buttons">
		  <label class="btn btn-primary active">
		    <input type="radio" name="monivalinta" value="false" autocomplete="off" checked>Vain yksi vastausvaihtoehto sallittu (radio)
		  </label>
		  <label class="btn btn-primary">
		    <input type="radio" name="monivalinta" value="true" autocomplete="off">Yksi tai useampi vastausvaihtoehto sallittu (checkbox)
		  </label>
		</div>

		<div id="vaihtoehdot">
		
		<div class="form-group">
			<label for="vaihtoehto">Vaihtoehto:</label>
			<input type="text" class="form-control" name="vaihtoehto" value=""/>
		</div>
		<div class="form-group">
			<label for="vaihtoehto">Vaihtoehto:</label>
			<input type="text" class="form-control" name="vaihtoehto" value=""/>
		</div>
		<div class="form-group">
			<label for="vaihtoehto">Vaihtoehto:</label>
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
	
	<a href="/backend/hallinta/kyselyt/${kyselyId}/kysymykset" class="btn btn-secondary">Takaisin</a>

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