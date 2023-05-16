<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.java.tienda.model.Producto"%>
<%@ page import="com.java.tienda.model.Categoria"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet" type="text/css" href="css/estilos1.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
	crossorigin="anonymous">
<title>Inicio</title>

</head>
<body>
	<%@include file="/fragments/Header.jsp"%>



	<main>

		<div class="container" id="filtros">
			<div >
				<form action="" method="post" class="row ">

					<div class="col-md-3 col-sm-12 d-flex justify-content-center pb-2" >

						<div id="precio" class="" >
							<div class="form-check form-switch ">
								<input class="form-check-input" name="p" value="0-20" type="radio" id="flexSwitchCheckDefault">
								<label class="form-check-label" for="flexSwitchCheckDefault">0-20</label>
							</div>	
							<div class="form-check form-switch ">
								<input class="form-check-input" name="p" value="21-50"  type="radio" id="flexSwitchCheckDefault">
								<label class="form-check-label" for="flexSwitchCheckDefault">20-50</label>
							</div>
								
							<div class="form-check form-switch ">
								<input class="form-check-input" name="p" value="51" type="radio" id="flexSwitchCheckDefault">
								<label class="form-check-label" for="flexSwitchCheckDefault">50 o más</label>
							
							</div>
							
						</div>

					</div>
									
					<div class="col-md-3 col-sm-12 d-flex justify-content-center pt-1 pb-2">
				
							<div class="form-check form-switch ">
								<input class="form-check-input" name="populares" type="checkbox" id="flexSwitchCheckDefault">
									<label class="form-check-label" for="flexSwitchCheckDefault">Más Comprados</label>
							</div>
						
					</div>

					<div class="col-md-3 col-sm-12 d-flex justify-content-center text-center pb-2">

							<div class="dropdown">
								<button class="btn btn-secondary dropdown-toggle" type="button"
									id="dropdownMenuButton1" data-bs-toggle="dropdown"
									aria-expanded="false">Categorias</button>
								<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
									<%
									ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();
									listaCategorias.addAll((ArrayList<Categoria>) request.getAttribute("categorias"));
									for (Categoria categoria : listaCategorias) {
									%>
									<li>
										<div class="form-check ps-5">
											<input class="form-check-input" type="radio"
												name="idC" id="idC"
												value="<%=categoria.getId()%>"> <label
												class="form-check-label" for="flexRadioDefault1"> <%=categoria.getCategoria()%>
											</label>
										</div>
									</li>
									<%
									}
									%>
								</ul>
							</div>

					</div>

					
					<div class="col-md-3 col-sm-12  justify-content-center text-center">
							<input class="btn btn-outline-dark" name="filtrar" type="submit" value="Filtrar">
					</div>

				</form>


			</div>

		</div>

		<div class="album py-5 ">
			<div class="container">

				<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">


					<%
					ArrayList<Producto> listaProductos = new ArrayList<Producto>();
					listaProductos.addAll((ArrayList<Producto>) request.getAttribute("productos"));

					for (Producto producto : listaProductos) {
					%>
					<div class="col">
						<a class="text-decoration-none "
							href="ProductoController?id=<%=producto.getId()%>">
							<div class="card shadow-sm">
								<svg class="bd-placeholder-img card-img-top" width="100%"
									height="225" xmlns="http://www.w3.org/2000/svg" role="img"
									aria-label="Placeholder: Thumbnail"
									preserveAspectRatio="xMidYMid slice" focusable="false">
									
									<title>Placeholder</title><rect width="100%" height="100%"
										fill="#55595c"></rect>
									<text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

								<div class="card-body">
									<p class="card-text"><%=producto.getNombre()%>
									</p>
									<div class="d-flex justify-content-between align-items-center">


										<div class="btn-group">

											<form action="CarritoController" method="post">
												<!--  <button type="button" class="btn btn-sm btn-outline-secondary">Comprar</button>-->

												<input type="hidden" name="id"
													value="<%=producto.getId()%>">
												<%
												if (producto.getStock() <= 0) {
												%>
												<input class="btn btn-outline-dark mt-2 mb-2" type="submit"
													value="Añadir Al Carrito" disabled>
												<%
												} else {
												%>
												<input class="btn btn-outline-dark mt-2 mb-2" type="submit"
													value="Añadir Al Carrito">
												<%
												}
												%>
											</form>

										</div>
									</div>
								</div>
							</div>
						</a>
					</div>
					<%
					}
					%>


				</div>
			</div>
		</div>

	</main>
	<%@include file="/fragments/Footer.jsp"%>

</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
	crossorigin="anonymous"></script>
</html>