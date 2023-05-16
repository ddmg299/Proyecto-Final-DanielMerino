<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<title>Inicio de sesión</title>
</head>
<body>

<%@include file="/fragments/Header.jsp" %>
<div class="container">
  <h1>Iniciar Sesión</h1>
  
  
  <div class="container">
  
  <form action="UserController" method="post">
    <div class="mb-3">
      <label for="email" class="form-label">Correo Electrónico</label>
      <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Contraseña</label>
      <input type="password" class="form-control" id="password" name="password" required>
    </div>
    <button type="submit" name="login" value="login" class="btn btn-primary">Iniciar Sesión</button>
  </form>
</div>


<%if(request.getAttribute("loged")!=null) {%>
	<%if(request.getAttribute("loged").equals(false)){ %>
		<p class="aviso">Usuario no encontrado en la base de datos, compruebe usuario y contraseña</p>
	<%} %>
<%} %>
  
  
  </div>
  

<%@include file="/fragments/Footer.jsp" %>


</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</html>