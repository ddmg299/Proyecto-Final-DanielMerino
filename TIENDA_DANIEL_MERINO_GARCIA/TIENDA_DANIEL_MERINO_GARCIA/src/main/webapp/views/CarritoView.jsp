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
										<input type="hidden" name="Cproducto" value="<%=p.getCantidad()%>">
										<input  type="number" name="cantidad" min="1" max="<%=p.getStock() %>" value="<%=p.getCantidad() %>">
										<button class="link-button mt-2 mb-2" type="submit" name="cambio" value="Confirmar Cambio" >Confirmar Cambio</button>
										<button class="link-button mt-2 mb-2" type="submit" name="eliminar" value="Eliminar Producto" >Eliminar Producto</button>
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
		                	<input  type="hidden" name="dir" value="login">
		                	<button  class="btn btn-outline-dark" type="submit" name="comprar" value="Comprar" disabled>Comprar</button>
		                <%}else{ %>
		                	<input  type="hidden" name="dir" value="login">
		                	<button  class="btn btn-outline-dark" type="submit" name="comprar" value="Comprar">Comprar</button>
		                <%} %>
		                </form>
	                <%}else{ %>
				   		<%if(carrito.size()==0){ %>
				   		<form action="CompraController" method="get">
				   			<button class="link-button" type="submit" name="comprar" value="Comprar" disabled>Comprar</button>
				   		</form>
				   			<%}else{ %>
				   			
				   			
				   			
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
										<button type="submit" name="pagar" value="Pagar" class="link-button">Pagar</button>
									</form>
								</div>
				   			
<!-- 				   			<button class="link-button" type="submit" name="comprar" value="Comprar">Comprar</button> -->
				   			<%} %>
<!-- 				   		</form> -->
	                <%} %>
	                
	                
	                
	                
             
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
	                
			   		
			      
			  </div>	
			</div>
	</div>
	</main>
	

	
	
	<%@include file="/fragments/Footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</html>