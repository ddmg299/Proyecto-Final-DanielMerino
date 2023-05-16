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
		<div class="container-fluid">
			<table class="table">
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
					<td><%= d_pedidos.get(i).getImpuesto()%></td>
					
					<td><%= d_pedidos.get(i).getTotal()%></td>
					
				</tr>
					
				
				<%} %>
				
				</tbody>
			</table>
		</div>
	</main>
<%@include file="/fragments/Footer.jsp"%>
</body>
</html>