package com.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Detalle;
import com.admin.model.Pedido;
import com.admin.model.Producto;
import com.admin.repository.DetalleRepository;
@Service
public class DetalleService {
	
	
	@Autowired
	private DetalleRepository dRep;

	
	//AÑADIR
	public void addDetalle(Detalle d) {
		dRep.save(d);
		
	}
	
	//ELIMINAR
	public void delDetalle(int id) {
		Detalle d = getDetalle(id);
		dRep.delete(d);
	}
	
	
	
	//ACTUALIZAR DETALLE
	public void updtPedido(int id,Pedido ped,Producto prod,int unidades,double preciounitario,double impuesto,double total) {
		Detalle d = getDetalle(id);
		d.setId(id);
		d.setPedido(ped);
		d.setProducto(prod);
		d.setUnidades(unidades);
		d.setPrecioUnitario(preciounitario);
		d.setImpuesto(impuesto);
		d.setTotal(total);
		dRep.save(d);
	}
	
	//BUSCAR POR ID
	public Detalle getDetalle(int id) {
		return dRep.findById(id);
		
	}
	
	//LISTAR
	public List<Detalle> getDetalle(){
		return dRep.findAll();
	}
	
	
	//LISTAR POR ID DE PEDIDO
	public List<Detalle> getDetalleByPedidoId(int pedido_id){
		return dRep.listByPedidoId(pedido_id);
	}
}
