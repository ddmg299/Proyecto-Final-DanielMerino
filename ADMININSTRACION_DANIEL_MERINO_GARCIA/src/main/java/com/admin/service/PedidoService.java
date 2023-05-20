package com.admin.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.model.Configuracion;
import com.admin.model.Pedido;
import com.admin.model.Usuario;
import com.admin.repository.PedidoRepository;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository pRep;
	
	@Autowired
	private ConfiguracionService cSer;
	
	@Autowired 
	private MailService mSer;
	
	@Autowired 
	private PdfService pdfSer;
	
	
	
	
	
	//NÚMEROS DE FACTURA
	public String getNumFactura() {
		
		
		
		//Consigo la fecha de hoy
		Date fecha= new Date();
		SimpleDateFormat formatoFecha= new SimpleDateFormat("dd/MM/yy");
		String num=formatoFecha.format(fecha);
		//Consigo el ultimo numero de la factura
		Configuracion c= cSer.getConfiguracion("Número Factura");
		
		
		String numF=num.concat("/00"+c.getValor());
		
		
		
		
		
		int numFactura= Integer.parseInt(c.getValor());
		numFactura+=1;
		c.setValor(Integer.toString(numFactura));
		
		cSer.updtConfiguracion(c.getClave(),c.getValor());
		
		
		return numF;
		
		
	}
	
	
	
	
	
	
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
		p.setNumFactura(getNumFactura());
		pRep.save(p);
		String asunto= "Pedido:"+p.getNumFactura();
		String cuerpo= "Le enviamos adjunta la factura de su pedido. \n\n Gracias por comprar en nuestra tienda";
		
		pdfSer.creafactura(p);
		mSer.enviarEmail("danielmeringar@gmail.com",asunto ,cuerpo,p);
		
		
	}
	
	
	//CANCELAR PEDIDO
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
