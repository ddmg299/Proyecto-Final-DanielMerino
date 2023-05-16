package com.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tienda.model.Pedido;
import com.java.tienda.model.Usuario;
import com.java.tienda.service.PedidoService;

/**
 * Servlet implementation class HistorialController
 */
@WebServlet("/HistorialController")
public class HistorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistorialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println("ID "+id);
		PedidoService pService= new PedidoService();
		pService.cancelaPedido(id);
		
		ArrayList<Pedido> pedidos = pService.getPedidos(((Usuario) request.getSession().getAttribute("usuario")).getId()); 
		
		System.out.println("PEDIDOS"+pedidos);
		
		request.setAttribute("pedidos", pedidos);
		request.getRequestDispatcher("views/historial.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getParameter("fecha")!="") {
			PedidoService pService = new PedidoService();
			String fecha = request.getParameter("fecha");
			System.out.println("FECHA "+fecha);
			ArrayList<Pedido> pedidos = pService.filtroPorFecha(fecha, ((Usuario) request.getSession().getAttribute("usuario")).getId());
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("views/historial.jsp").forward(request, response);
		}else {
			
			
			PedidoService pService = new  PedidoService();
			ArrayList<Pedido> pedidos = pService.getPedidos(((Usuario) request.getSession().getAttribute("usuario")).getId()); 
			
			System.out.println("PEDIDOS"+pedidos);
			
			request.setAttribute("pedidos", pedidos);
			request.getRequestDispatcher("views/historial.jsp").forward(request, response);
			
			
		}
	}

}
