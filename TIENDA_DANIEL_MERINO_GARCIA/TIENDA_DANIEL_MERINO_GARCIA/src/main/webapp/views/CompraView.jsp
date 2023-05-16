<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.java.tienda.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<title>Confirmación de Compra</title>
</head>
<body>
	<%@include file="/fragments/Header.jsp" %>
	
	<main>
			<%Usuario  user = (Usuario) request.getSession(false).getAttribute("usuario");%>
		<div class="container">
			<form action="CompraController" method="post">
				
					 <div class="mb-3">
						<label for="nombre" class="form-label">Nombre:</label>
						<input type="text" class="form-control" name="nombre" value="<%=user.getNombre()%>" required>
					</div>
					 
					 <div class="mb-3">
						<label for="apellidos" class="form-label">Apellidos:</label>
						<input type="text" class="form-control" name="apellidos" value="<%=user.getApellidos()%>" required>
					 </div>
					 
					 <div class="mb-3">
						<label for="email" class="form-label">Email:</label>
						<input type="text" class="form-control" name="email" value="<%=user.getEmail()%>" required>
					</div>
					
					<div class="mb-3">
						<label for="direccion" class="form-label">Dirección:</label>
						<input type="text" class="form-control" name="direccion" value="" required>
					</div>
					 
					 <div class="mb-3">
						
						<label for="pago" class="form-label">Método de pago:</label>
						<select name="pago">
						  <option value="defecto" selected>Elija un método de pago</option>
						  <option value="paypal">PayPal</option>
						  <option value="tarjeta">Tarjeta de credito</option>
						</select>
						<%if(request.getAttribute("pago")!=null){ %>
							<% if(request.getAttribute("pago").equals(false)){%>
								<span class="aviso"> No se ha elegido método de pago</span>
							<%} %>
						<%} %>
						
						
								
					</div>
						<input type="submit" name="pagar" value="Pagar" class="btn btn-outline-dark">
						
			</form>
			
		</div>
	</main>



	
<%@include file="/fragments/Footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</html>