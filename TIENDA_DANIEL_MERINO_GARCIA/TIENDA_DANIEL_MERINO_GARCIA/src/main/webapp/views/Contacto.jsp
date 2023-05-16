<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Contacta con Nosotros</title>
</head>
<body>
	<%@include file="/fragments/Header.jsp" %>
	
	<main>
		<div class="container">
		
		<form>
			<div class="row">
				<div class="col-md-6 col-sm-12 col-12">
					
					<div class="mb-3">
			    		<label for="nombre" class="form-label">Nombre:</label>
			    		<input type="text" class="form-control" id="nombre" aria-describedby="emailHelp">
			  		</div>
		
				</div>
				
				<div class="col-md-6 col-sm-12 col-12">
						
					<div class="mb-3">
		    			<label for="apellido" class="form-label">Apellido</label>
		    			<input type="text" class="form-control" id="apellido" aria-describedby="emailHelp">
	
			  		</div>
				</div>
			
			</div>
			  
			  <div class="mb-3">
			    	<label for="email" class="form-label">Email</label>
			    	<input type="email" class="form-control" id="email">
			  </div>
			<div class="mb-3">

					<label for="consulta" class="form-label">Cuentanos tus dudas:</label>
			    	<textarea name="textarea"  class="form-control" id="consulta" rows="10" cols="50"></textarea>

			</div>
			  <button type="submit" class="btn btn-primary">Enviar</button>
		</form>
		
			
		</div>
	</main>
	
	
	
	
	<%@include file="/fragments/Footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</html>