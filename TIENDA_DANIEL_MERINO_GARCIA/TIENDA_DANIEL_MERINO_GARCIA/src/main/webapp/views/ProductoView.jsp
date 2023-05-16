<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.java.tienda.model.Producto" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>Insert title here</title>
</head>
<body>

<%@include file="/fragments/Header.jsp" %>
	<main>
		
			<%Producto p = (Producto)request.getAttribute("producto"); %>
			
		
		<section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://dummyimage.com/600x700/dee2e6/6c757d.jpg" alt="..."></div>
                    <div class="col-md-6">
                        <div class="small mb-1"></div>
                        <h1 class="display-5 fw-bolder"><%=p.getNombre() %></h1>
                        <div class="fs-5 mb-5">
<%--                             <span class="text-decoration-line-through"></span> --%>
                             <span><%=p.getPrecio()%>$</span>
                        </div>
                        <p class="lead"><%=p.getDescripcion() %></p>
                        <div class="d-flex">
<!--                             

<input class="form-control text-center me-3" id="inputQuantity" type="num" value="1" style="max-width: 3rem"> -->
							
							
							<form action="CarritoController" method="post">
	                			<!--  <button type="button" class="btn btn-sm btn-outline-secondary">Comprar</button>-->
	
	                   				<input type="hidden" name="id" value="<%= p.getId() %>">
	                   			<%if(p.getStock()<=0){ %>
	                   				<input class="btn btn-outline-dark mt-2 mb-2" type="submit" value="Añadir Al Carrito" disabled>
	                   			<%}else{ %>
	                   				<input class="btn btn-outline-dark mt-2 mb-2" type="submit" value="Añadir Al Carrito">
	                   			<%} %>
	               			</form>

							
                            
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
<!--         			<form class="d-flex"> -->
<!--                         <button class="btn btn-outline-dark" type="submit"> -->
<!--                             <i class="bi-cart-fill me-1"></i> -->
<!--                             Cart -->
<!--                             <span class="badge bg-dark text-white ms-1 rounded-pill">0</span> -->
<!--                         </button> -->
<!--                     </form> -->

	</main>	
	
	
	
<%@include file="/fragments/Footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>
</html>