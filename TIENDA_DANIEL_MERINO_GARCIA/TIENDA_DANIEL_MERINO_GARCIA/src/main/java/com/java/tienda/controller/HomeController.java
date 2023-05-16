package com.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tienda.dao.ProductoDao;
import com.java.tienda.model.Producto;
import com.java.tienda.service.FiltroService;
import com.java.tienda.dao.CategoriaDao;
import com.java.tienda.model.Categoria;



/**
 * Servlet implementation class HomeController
 */
@WebServlet("")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//Cojo los productos de la BBDD
		ProductoDao pdao = new ProductoDao();
		ArrayList<Producto> productos = pdao.getAll();

		//Cojo las categorias de la BBDD
		CategoriaDao cdao= new CategoriaDao();
		ArrayList<Categoria> categorias = cdao.getAll();
		
		

		
		if(request.getSession().getAttribute("carrito")==null) {
			//CREO LA SESION
			request.getSession();
			//CREO EL CARRITO
			HashMap<Integer, Producto>  carrito = new HashMap<Integer, Producto> ();
			//CREO EL CONTADOR
			request.getSession(false).setAttribute("contadorC",0);
			//GUARDO EL CARRITO EN LA SESION
			request.getSession(false).setAttribute("carrito", carrito);
			
		}
		
		
		request.setAttribute("categorias",categorias);
		request.setAttribute("productos",productos);
		
		//request.setAttribute("productos", productos);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("filtrar")!=null) {
			boolean p1=false;
			boolean p2=false;
			boolean p3=false;
			boolean populares=false;
			int idCategoria= 0;
			String precioo[] = null;
			
			
			//Compruebo si filtra por precios y por cual de las 3 opciones

			
			if(request.getParameter("p")!=null) {
				System.out.println("COMPRUEBOo");
				String precio=request.getParameter("p");
				precioo= precio.split("-");
				System.out.println("precioooo"+precioo[0]);
				
			}
			
//			
			if(request.getParameter("populares")!=null) {
				populares = true;
			}
			
			if(request.getParameter("idC")!=null) {
				idCategoria=Integer.parseInt(request.getParameter("idC"));
				System.out.println("categoria"+idCategoria);
			}
			
			
			FiltroService  fService= new FiltroService();
			
			ArrayList<Producto> productos= fService.filtroHome(precioo, populares, idCategoria);
			//Cojo las categorias de la BBDD
			CategoriaDao cdao= new CategoriaDao();
			ArrayList<Categoria> categorias = cdao.getAll();
			request.setAttribute("categorias",categorias);
			request.setAttribute("productos",productos);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			doGet(request, response);
			
		}
		
		
		
		
		
	}

}
