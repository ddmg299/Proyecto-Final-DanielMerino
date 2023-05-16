package com.java.tienda.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tienda.dao.ProductoDao;
import com.java.tienda.model.Producto;
import com.java.tienda.service.ProductoService;

/**
 * Servlet implementation class CarritoController
 */
@WebServlet("/CarritoController")
public class CarritoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HashMap<Integer, Producto> carrito = (HashMap<Integer, Producto>) request.getSession().getAttribute("carrito");
		
		if(request.getParameter("cambio")!=null) {
			
			carrito.get(Integer.parseInt(request.getParameter("productoId"))).setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		}else if(request.getParameter("eliminar")!=null) {
			carrito.remove(Integer.parseInt(request.getParameter("productoId")));
			int contadorC=(Integer)request.getSession(false).getAttribute("contadorC");
			request.getSession(false).setAttribute("contadorC", contadorC-1);
		}
		
		
		ProductoService pService = new ProductoService();	
		float pTotal=pService.precioTotal(carrito);
		
		
		request.setAttribute("pTotal",pTotal);
		
		request.getRequestDispatcher("views/CarritoView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		ProductoService pService = new ProductoService();

		HashMap<Integer, Producto> carrito = (HashMap<Integer, Producto>) request.getSession().getAttribute("carrito");
		int id= Integer.parseInt(request.getParameter("id"));
		
		
		pService.actualizaCarrito(id, carrito);

		
		//System.out.println("CANTIDAD: "+cantidad );
		int contadorC= (int) request.getSession(false).getAttribute("contadorC");
		//System.out.println("CONTADORC: "+contadorC);
		contadorC++;	
		request.getSession().setAttribute("contadorC",contadorC);
		request.getSession(false).setAttribute("carrito",carrito);
		
		//request.getRequestDispatcher("").forward(request, response);
		response.sendRedirect(request.getContextPath());
		
		
		
	}

}
