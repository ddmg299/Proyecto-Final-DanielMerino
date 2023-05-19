package com.java.tienda.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tienda.dao.UsuarioDao;
import com.java.tienda.model.Producto;
import com.java.tienda.model.Usuario;

import com.java.tienda.service.PedidoService;
import com.java.tienda.service.ProductoService;

/**
 * Servlet implementation class CompraController
 */
@WebServlet("/CompraController")
public class CompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompraController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("views/CompraView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String email= request.getParameter("email");
		String metodo= request.getParameter("pago");
		
		UsuarioDao uDao= new UsuarioDao();
		PedidoService pService= new PedidoService();
		
		
		//Si no se ha elegido un metodo de pago
		if(metodo.equals("defecto")) {
			System.out.println("DEFECTO");
			request.setAttribute("pago",false);
			request.getRequestDispatcher("views/CarritoView.jsp").forward(request, response);
		}else {
			Usuario usuario=uDao.getByEmail(email); 
			//String fecha= pService.generaNumFactura();
			//System.out.println("Fecha:"+fecha);
			
			
			HashMap<Integer, Producto> carrito = (HashMap<Integer, Producto>) request.getSession().getAttribute("carrito");
			
			ProductoService prodService = new ProductoService();	
			double pTotal=prodService.precioTotal(carrito);
			
			String numF= pService.generaNumFactura();
			System.out.println("NUMF EN EL CONTROLLER"+numF);
			//CREACIÓN DEL PEDIDO
			pService.creaPedido(usuario.getId(), metodo, numF, pTotal);
			pService.creaDetalle(carrito);
			
			//Restar los productos comprados del stock de la tienda
			prodService.restaStock(carrito);
			
			//VACIAR EL CARRITO
			carrito = new HashMap<Integer, Producto>();
			request.getSession().setAttribute("carrito", carrito);
			request.getSession().setAttribute("contadorC", 0);
			//request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect(request.getContextPath());
			
		
		}
		
		
		
		
		
	}

}
