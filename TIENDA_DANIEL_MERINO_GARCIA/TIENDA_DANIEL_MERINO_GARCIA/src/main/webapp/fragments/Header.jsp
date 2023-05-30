


<%@ page import="com.java.tienda.model.Usuario" %>
<header class="p-3 bg-dark text-white mb-5">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">


        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><a href="<%=request.getContextPath() %>" class="nav-link px-2 text-light">Inicio</a></li>

        </ul>


        <%if(request.getSession(false).getAttribute("usuario")!=null){
        	
        	%>
        	
        <div class="text-end " id="cabecera">
        	
        	<div class="dropdown" id="usuario">
				<button class="link-button dropdown-toggle " type="button"
					id="dropdownMenuButton1" data-bs-toggle="dropdown"
					aria-expanded="false"><%=((Usuario)request.getSession(false).getAttribute("usuario")).getNombre() %></button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
					
					<li>
						<div class="form-check ps-4">
							 <a class="text-decoration-none " href="UserController?dir=EditarDatos" >Editar tus datos</a>
								
						</div>
					</li>
					<li>
						<div class="form-check ps-4">
							 <a class="text-decoration-none " href="UserController?dir=Historial" >Historial de pedidos</a>
								
						</div>
					</li>
					<li>
						<div class="form-check ps-4">
							<a class="text-decoration-none " href="UserController?dir=CSesion" >Cerrar Sesión</a>
						</div>
					</li>
					
				</ul>
			</div>
        	

	         <a href="CarritoController" class="link-button ">Carrito<span class="badge bg-dark text-white ms-1 rounded-pill"><%= request.getSession(false).getAttribute("contadorC") %></span></a>
	        

        	
		</div>
        	<%
        }else{ %>
        <div class="text-end">
	        <a href="UserController?dir=login" class="link-button me-2">Iniciar Sesión</a>
	        <a href="UserController?dir=register" class="link-button">Registrarse</a>
	        <a href="CarritoController" class="link-button mt-2 mb-2">Carrito<span class="badge bg-dark text-white ms-1 rounded-pill"><%= request.getSession(false).getAttribute("contadorC") %></span></a>
	        
        
        </div>
        
        
        
        
          <%} %>
        
      </div>
    </div>
  </header>
<!--   <hr class="hr" /> -->