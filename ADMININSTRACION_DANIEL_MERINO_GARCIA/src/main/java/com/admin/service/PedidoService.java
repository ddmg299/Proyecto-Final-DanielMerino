package com.admin.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Pedido;
import com.admin.model.Usuario;
import com.admin.repository.PedidoRepository;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository pRep;
	
	
	//AÑADIR
	public void addPedido(Pedido p) {
		pRep.save(p);
	}
	
	//ELIMINAR
	public void delUsuario(int id) {
		Pedido p = getPedido(id);
		pRep.delete(p);
	}
	
	//ACTUALIZAR PEDIDO
	public void updtPedido(int id,Usuario user,Date fecha,String metodopago,String numfactura,String estado,double total) {
		Pedido p = getPedido(id);
		p.setId(id);
		p.setUsuario(user);
		p.setFecha(fecha);
		p.setMetodoPago(metodopago);
		p.setNumFactura(numfactura);
		p.setEstado(estado);
		p.setTotal(total);
		pRep.save(p);
	}
	
	
	
	//ENVIAR PEDIDO
	public void enviarPedido(int id) {
		Pedido p = getPedido(id);
		p.setId(id);
		p.setEstado("E");
		pRep.save(p);
		
	}
	
	
	//ENVIAR PEDIDO
	public void cancelarPedido(int id) {
		Pedido p = getPedido(id);
		p.setId(id);
		p.setEstado("C");
		pRep.save(p);
		
	}

	//BUSCAR POR ID
	public Pedido getPedido(int id) {
		return pRep.findById(id);
	}
	
	//LISTAR
	public List<Pedido> getPedidos(){
		return pRep.findAll();
	}
	
	
	//Cambiar estado de pedidos
	
	//BUSCAR LOS PEDIDOS PENDIENTES DE ENVIAR
	public List<Pedido> getPendientesPE(){
		return pRep.getPedidosPE();
	}
	
	
	//BUSCAR LOS PEDIDOS PENDIENTES DE CANCELAR
		public List<Pedido> getPendientesPC(){
			return pRep.getPedidosPC();
		}
	
	
	
}
