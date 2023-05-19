package com.java.tienda.service;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import com.java.tienda.dao.ConfiguracionDao;
import com.java.tienda.dao.Detalle_PedidoDao;
import com.java.tienda.dao.PedidoDao;
import com.java.tienda.model.Pedido;
import com.java.tienda.model.Producto;
import com.java.tienda.model.Configuracion;
import com.java.tienda.model.Detalle_Pedido;

public class PedidoService{
	
	
	public PedidoService() {
		
	}
	
	
	public void cancelaPedido(int pedido_id) {
		PedidoDao pdao= new PedidoDao();
		pdao.cancelaPedido(pedido_id);
		
	}
	
	public String generaNumFactura() {
		
		//Consigo la fecha de hoy
//		Date fecha= new Date();
//		SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/MM/yy");
//		String num=formatoFecha.format(fecha);
//		//Consigo el ultimo numero de la factura
//		ConfiguracionDao cDao = new ConfiguracionDao();
//		Configuracion c = cDao.getNumFactura();
//		
//		String numF=num.concat("/00"+c.getValor());
//		
//		
//		int numFactura= Integer.parseInt(c.getValor());
//		numFactura+=1;
//		c.setValor(Integer.toString(numFactura));
//		
//		cDao.updateNumFactura(c);
		
		
		return "-";
	}
	
	public void creaPedido(int uId,String metodo,String numF,double total) {
		
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		PedidoDao pDao= new PedidoDao();
		
		
		
		Pedido ped= new Pedido(0,uId,ts,metodo,numF,"PE",total);
		
		pDao.insert(ped);
		
	}
	
	
	public void creaDetalle(HashMap<Integer,Producto> carrito) {
		PedidoDao pDao= new PedidoDao();
		Detalle_PedidoDao pDetalleDao= new Detalle_PedidoDao();
		Detalle_Pedido dPedido=null;
		
		int maxId=pDao.getMaxId();
		int pId=0;
		int unidades=0;
		double pUnidad=0;
		double impuesto=0;
		double total=0;
		
		
		for (HashMap.Entry<Integer,Producto> entry:carrito.entrySet()) {
			Producto p = entry.getValue();
			pId= p.getId();
			unidades=p.getCantidad();
			pUnidad=p.getPrecio();
			impuesto=p.getImpuesto();
			total=(pUnidad*unidades);
			
			dPedido= new Detalle_Pedido(0,maxId,pId,unidades,pUnidad,impuesto,total);
		
			pDetalleDao.insert(dPedido);	
			} 
	}

	
	public ArrayList<Pedido> getPedidos(int usuario_id){
		ArrayList<Pedido> pedidos = null;
		PedidoDao pDao= new PedidoDao();
		pedidos= pDao.getById(usuario_id);
		
		
		return pedidos;
	}
	
	
	
	public ArrayList<Pedido> filtroPorFecha(String fecha, int usuario_id){
		ArrayList<Pedido> pedidos = null;
		PedidoDao pDao= new PedidoDao();
		pedidos= pDao.getByDateAndId(fecha, usuario_id);
		return pedidos;
	}
	
	
	public ArrayList<Detalle_Pedido> buscaPorId(int pedido_id){
		ArrayList<Detalle_Pedido> dPedidos=null;
		Detalle_PedidoDao dpDao = new Detalle_PedidoDao();
		dPedidos= dpDao.getAllById(pedido_id);
		
		
		return dPedidos;
	}
	
	

}
