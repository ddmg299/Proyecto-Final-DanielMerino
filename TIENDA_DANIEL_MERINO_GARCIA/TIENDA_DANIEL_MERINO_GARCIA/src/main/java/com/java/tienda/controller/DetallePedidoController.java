package com.java.tienda.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.tienda.model.Detalle_Pedido;
import com.java.tienda.model.Producto;
import com.java.tienda.service.PedidoService;
import com.java.tienda.service.ProductoService;

/**
 * Servlet implementation class DetallePedidoController
 */
@WebServlet("/DetallePedidoController")
public class DetallePedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallePedidoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int pedido_id= Integer.parseInt(request.getParameter("id"));
		
		
		//Busco el detalle del pedido elegido
		PedidoService pService = new PedidoService();
		ArrayList<Detalle_Pedido> d_pedidos = pService.buscaPorId(pedido_id);
		
		
		
		
		
		request.setAttribute("d_pedidos",d_pedidos);
		
//		//Busco los productos de este pedido para mostrar sus nombres
		ArrayList<Producto> productos = new ArrayList<Producto>();
		ProductoService prodService = new ProductoService();
		Producto p = null;
		for(Detalle_Pedido d_pedido:d_pedidos) {
			
			p=prodService.buscaPorId(d_pedido.getProducto_id());
			productos.add(p);
		}
		request.setAttribute("productos",productos);
		request.getRequestDispatcher("views/detallePedido.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
