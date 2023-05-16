<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.java.tienda.model.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Datos del usuario</title>
</head>
<body>
<%@include file="/fragments/Header.jsp" %>

<main>

<%Usuario  user = (Usuario) request.getSession(false).getAttribute("usuario");%>

	<div class="container">
	  <h1>Cambiar Datos</h1>
	  <form action="UserController" method="post">
	    <div class="mb-3">
	      <label for="nombre" class="form-label">Nombre</label>
	      <input type="text" class="form-control" id="nombre" name="nombre" required value="<%=user.getNombre()%>">
	    </div>
	    <div class="mb-3">
	      <label for="apellidos" class="form-label">Apellidos</label>
	      <input type="text" class="form-control" id="apellidos" name="apellidos" required value="<%=user.getApellidos()%>">
	    </div>
	    <div class="mb-3">
	      <label for="email" class="form-label">Correo Electrónico</label>
	      <input type="email" class="form-control" id="email" name="email" required value="<%=user.getEmail()%>">
	    </div>
	    <div class="mb-3">
	      <label for="password" class="form-label">Contraseña</label>
	      <input type="password" class="form-control" id="password" name="password" required>
	    </div>
	    <div class="mb-3">
	      <label for="password" class="form-label">Confirma Contraseña</label>
	      <input type="password" class="form-control" id="passwordC" name="passwordC" required>
	    </div>
	    <button type="submit" name="CDatos" value="Cambiar Datos" class="btn btn-primary">Cambiar Datos</button>
	  </form>
	  
		<%if(request.getAttribute("registered")!=null) {%>
			<%if(request.getAttribute("registered").equals(false)){ %>
				<p class="aviso">Usuario Repetido en la base de datos</p>
			<%}%>
		<%}%>
		
		<%if(request.getAttribute("passwords")!=null) {%>
			<%if(request.getAttribute("passwords").equals(false)){ %>
				<p class="aviso">Las contraseñas no coinciden</p>
			<%} %>
		<%} %>
	  
	</div>

</main>

<%@include file="/fragments/Footer.jsp" %>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</html>