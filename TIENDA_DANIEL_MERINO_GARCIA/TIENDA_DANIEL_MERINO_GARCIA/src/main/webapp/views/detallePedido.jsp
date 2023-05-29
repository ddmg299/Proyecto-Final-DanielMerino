<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.java.tienda.model.Pedido" %>
    <%@ page import="com.java.tienda.model.Producto" %>
    <%@ page import="com.java.tienda.model.Detalle_Pedido" %>
	<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Detalle del Pedido</title>
</head>
<body>

<%@include file="/fragments/Header.jsp"%>

	<main>
	<div class="container justify-content-end mb-3" id="filtros">
			<a class=" link-button text-decoration-none " href="UserController?dir=Historial" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-bar-left" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M12.5 15a.5.5 0 0 1-.5-.5v-13a.5.5 0 0 1 1 0v13a.5.5 0 0 1-.5.5ZM10 8a.5.5 0 0 1-.5.5H3.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L3.707 7.5H9.5a.5.5 0 0 1 .5.5Z"/>
</svg></a>
<!-- 			<form action="HistorialController" method="post"> -->
<!-- 					<label for="fecha">Fecha:</label> -->
<!-- 					<input type="date" name="fecha"> -->
<!-- 					<button class="link-button" type="submit" name="Filtrar" value="Filtrar">Filtrar</button> -->
				
<!-- 			</form> -->
					
		</div>
		<div class="container">
			<table class="table table-responsive">
				<thead>
					<tr>
						<td>Producto:</td>
						<td>Unidades</td>
						<td>Impuesto aplicado</td>
						<td>Total</td>
						
					</tr>
				</thead>
				<tbody>
				
				<%
				ArrayList<Detalle_Pedido> d_pedidos = new ArrayList<Detalle_Pedido>();
				 d_pedidos.addAll((ArrayList<Detalle_Pedido>)request.getAttribute("d_pedidos"));
				 
				 ArrayList<Producto> productos = new ArrayList<Producto>();
				 productos.addAll((ArrayList<Producto>)request.getAttribute("productos"));
				
				 
				 
				for (int i = 0; i<d_pedidos.size(); i++) {
				%>
				<tr>
					<td><%=productos.get(i).getNombre() %></td>
					<td><%= d_pedidos.get(i).getUnidades()%></td>
					<td><%= d_pedidos.get(i).formatImpuesto()%></td>
					
					<td><%= d_pedidos.get(i).formatTotal()%></td>
					
				</tr>
					
				
				<%} %>
				
				</tbody>
			</table>
		</div>
	</main>
<%@include file="/fragments/Footer.jsp"%>
</body>
</html>