<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.java.tienda.model.Pedido" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<title>Historial de Pedidos</title>
</head>
<body>
<%@include file="/fragments/Header.jsp"%>

	
	
	<main>
	
	
		<div class="container justify-content-end mb-3" id="filtros">
			
			<form action="HistorialController" method="post">
					<label for="fecha">Fecha:</label>
					<input type="date" name="fecha">
					<button class="link-button" type="submit" name="Filtrar" value="Filtrar">Filtrar</button>
				
			</form>
					
		</div>


		<div class="container">
			<table class="table table-responsive">
				<thead>
					<tr>
						<td>Num Pedido:</td>
						<td>Fecha</td>
						<td>Método de pago</td>
						<td>Número de factura</td>
						<td>Estados</td>
						<td>Total</td>
						<td></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
				
				<%
				ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
				 pedidos.addAll((ArrayList<Pedido>)request.getAttribute("pedidos"));
				int i=1;
				for (Pedido pedido : pedidos) {
				%>
				<tr>
					<td><%=i++ %></td>
					<td><%=pedido.getFecha() %></td>
					<td><%=pedido.getMetodo_pago() %></td>
					<td><%=pedido.getNum_factura() %></td>
					<td><%=pedido.getEstado() %></td>
					<td><%=pedido.formatTotal() %></td>
					<td><a class="link-button" href="DetallePedidoController?id=<%=pedido.getId()%>">Ver Productos pedidos</a></td>
					<td><a class="link-button" href="HistorialController?id=<%=pedido.getId()%>">Cancelar Pedido</a></td>
				</tr>
					
				
				<%} %>
				
				</tbody>
			</table>
		</div>
		
	</main>
<%@include file="/fragments/Footer.jsp"%>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
	crossorigin="anonymous"></script>
</html>