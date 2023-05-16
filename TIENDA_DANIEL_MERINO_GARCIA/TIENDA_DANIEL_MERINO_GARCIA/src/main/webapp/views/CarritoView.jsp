<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.HashMap" %>
<%@ page import="com.java.tienda.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<meta charset="ISO-8859-1">
<title>Carrito</title>
</head>
<body>
	<%@include file="/fragments/Header.jsp" %>
	
	<main>
	
	<div class="container-fluid">
	
			<div class="row">
		  		<div class="col-8">
			    	    		    
				    <div class="container-fluid d-flex justify-content-center">
						<table class="table">
						<thead>
							<tr>
								<th>Nombre del producto</th>
								<th>Precio por unidad</th>
								<th>Cantidad Comprada </th>
								<th>Precio total del montón</th>
							</tr>
						</thead>			
						<tbody>
							<%HashMap<Integer,Producto>carrito = (HashMap<Integer,Producto>) request.getSession(false).getAttribute("carrito"); 
			 				for (HashMap.Entry<Integer,Producto> entry:carrito.entrySet()) {
			 					Integer id = entry.getKey();
								Producto p = entry.getValue();
							%>
							<tr>
								<td><%=p.getNombre() %></td>
								<td><%=p.getPrecio() %></td>
								<td>
									<form action="CarritoController" method="get">
										<input type="hidden" name="productoId" value="<%=id%>">
										<input  type="number" name="cantidad" min="1" max="<%=p.getStock() %>" value="<%=p.getCantidad() %>">
										<input class="btn btn-outline-dark mt-2 mb-2" type="submit" name="cambio" value="Confirmar Cambio" >
										<input class="btn btn-outline-dark mt-2 mb-2" type="submit" name="eliminar" value="Eliminar Producto" >
									</form>
								</td>
								<td><%= p.getCantidad()*p.getPrecio()%></td>
							</tr>					
			 				<%} %> 
						</tbody>
						</table>
					</div>
			  </div>
			  
			  <div class="col-4">
			    <h4>TOTAL:</h4>
			    
			   		
			   		<%=request.getAttribute("pTotal") %>&nbsp; Euros 
			   		<%if(request.getSession(false).getAttribute("usuario")==null){ %>
		                <form action="UserController" method="get">
		                <%if(carrito.size()==0){ %>
		                	<input type="hidden" name="dir" value="i">
		                	<input class="btn btn-outline-dark" type="submit" name="comprar" value="Comprar" disabled>
		                <%}else{ %>
		                	<input type="hidden" name="dir" value="i">
		                	<input class="btn btn-outline-dark" type="submit" name="comprar" value="Comprar">
		                <%} %>
		                </form>
	                <%}else{ %>
				   		<form action="CompraController" method="get">
				   		<%if(carrito.size()==0){ %>
				   			<input class="btn btn-outline-dark" type="submit" name="comprar" value="Comprar" disabled>
				   			<%}else{ %>
				   			<input class="btn btn-outline-dark" type="submit" name="comprar" value="Comprar">
				   			<%} %>
				   		</form>
	                <%} %>
			   		
			      
			  </div>	
			</div>
	</div>
	</main>
	
<!-- 	<div class="container-fluid"> -->
<!-- 	</div> -->
	
	
	<%@include file="/fragments/Footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</html>