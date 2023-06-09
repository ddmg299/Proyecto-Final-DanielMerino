package com.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.model.Rol;
import com.admin.model.Usuario;
import com.admin.model.Categoria;
import com.admin.model.Producto;
import com.admin.service.CategoriaService;
import com.admin.service.ProductoService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/Producto")
public class ProductoController {
	
	
	@Autowired
	private ProductoService pServ;
	@Autowired
	private CategoriaService cServ;
	
	
	@GetMapping("NuevoProducto")
	public String newProducto(Model model,HttpSession sesion) {
		
		List<Categoria> categorias= cServ.getCategorias();
		model.addAttribute("categorias", categorias);
		return "/views/productos/nuevoProducto";
	}
	
	@GetMapping("EditarProducto")
	public String editarProducto(Model model, @RequestParam String id,HttpSession sesion) {
		Producto producto = pServ.getProducto(Integer.parseInt(id));
		String precio= producto.getPrecioFormateado().replace(",",".");
		Double precioF= Double.parseDouble(precio);
		model.addAttribute("precio", precioF );
		model.addAttribute("producto",producto);
		
		List<Categoria> categorias= cServ.getCategorias();
		model.addAttribute("categorias", categorias);
		return "/views/productos/editProducto";
	}
	
	
	//Dar de baja a un usuario
		@GetMapping("BajaProducto")
		public String bajaUser(Model model,@RequestParam String id) {
			pServ.bajaUser(Integer.parseInt(id));
			
			 return "redirect:/Home/Productos";
		}
		
		//Dar de alta a un usuario
		@GetMapping("AltaProducto")
		public String altaUser(Model model,@RequestParam String id) {
			pServ.altaUser(Integer.parseInt(id));
			
			 return "redirect:/Home/Productos";
		}
	
	
	
	
	
	
	
	
	
	
	
	//AÑADIR PRODUCTO
	@PostMapping("AddProducto")
	public String addProducto(Model model, @RequestParam String nombre, String descripcion, String precio,String stock,String categoria) {
		List<Categoria> categorias= cServ.getCategorias();
		
		if(nombre.isEmpty()==false) {				
			if(descripcion.isEmpty()==false) {					
				if(precio.isEmpty()==false) {						
					if(stock.isEmpty()==false) {
						if(categoria.equals("0")) {
							
							model.addAttribute("categorias", categorias);
							model.addAttribute("valores", "categorias");
							return "/views/productos/nuevoProducto";
							
						}else {
							Producto p = new Producto();
							p.setNombre(nombre);
							p.setDescripcion(descripcion);
							p.setPrecio(Double.parseDouble(precio));
							p.setImpuesto(0.21);
							p.setStock(Integer.parseInt(stock));
							p.setBaja(false);
							Categoria c = cServ.getCategoria(Integer.parseInt(categoria));
							p.setCategoria(c);
							pServ.addProducto(p);
							
						}
					}else {
						model.addAttribute("categorias", categorias);
						model.addAttribute("valores", "cantidad");
						return "/views/productos/nuevoProducto";
					}		
				}else {
					model.addAttribute("categorias", categorias);
					model.addAttribute("valores", "precio");
					return "/views/productos/nuevoProducto";		
				}						
			}else {
				model.addAttribute("categorias", categorias);
				model.addAttribute("valores", "descripcion");
				return "/views/productos/nuevoProducto";	
			}
		}else {
			model.addAttribute("categorias", categorias);
			model.addAttribute("valores", "nombre");
			return "/views/productos/nuevoProducto";
		}
		return "redirect:/Home/Productos"; 
	}
	
	
	//EDITAR PRODUCTO
		@PostMapping("EditProducto")
		public String editProducto(Model model, @RequestParam String id, String nombre, String descripcion, String precio,String stock,String categoria) {
			
			if(nombre.isEmpty()==false) {				
				if(descripcion.isEmpty()==false) {					
					if(precio.isEmpty()==false) {						
						if(stock.isEmpty()==false) {
							if(categoria.equals("0")){
								
								
								
								
								
								Producto producto = pServ.getProducto(Integer.parseInt(id));
								String precio2= producto.getPrecioFormateado().replace(",",".");
								Double precioF= Double.parseDouble(precio2);
								model.addAttribute("precio", precioF );
								model.addAttribute("producto",producto);
								
								List<Categoria> categorias= cServ.getCategorias();
								model.addAttribute("categorias", categorias);
								model.addAttribute("valores", "categorias");
								return "/views/productos/editProducto";
								
								
								
								
								
							}else {
								Categoria c = cServ.getCategoria(Integer.parseInt(categoria));
								
								pServ.updtProducto(Integer.parseInt(id), nombre, descripcion, Double.parseDouble(precio), 0.21, Integer.parseInt(stock), false, null,c );
							}
						}else {
							Producto producto = pServ.getProducto(Integer.parseInt(id));
							String precio2= producto.getPrecioFormateado().replace(",",".");
							Double precioF= Double.parseDouble(precio2);
							model.addAttribute("precio", precioF );
							model.addAttribute("producto",producto);
							
							List<Categoria> categorias= cServ.getCategorias();
							
							model.addAttribute("valores", "cantidad");
							model.addAttribute("categorias", categorias);
							
							return "/views/productos/editProducto";
						}		
					}else {
						Producto producto = pServ.getProducto(Integer.parseInt(id));
						String precio2= producto.getPrecioFormateado().replace(",",".");
						Double precioF= Double.parseDouble(precio2);
						model.addAttribute("precio", precioF );
						model.addAttribute("producto",producto);
						
						List<Categoria> categorias= cServ.getCategorias();
						model.addAttribute("categorias", categorias);
						model.addAttribute("valores", "precio");
						
						return "/views/productos/editProducto";	
					}						
				}else {
					Producto producto = pServ.getProducto(Integer.parseInt(id));
					String precio2= producto.getPrecioFormateado().replace(",",".");
					Double precioF= Double.parseDouble(precio2);
					model.addAttribute("precio", precioF );
					model.addAttribute("producto",producto);
					
					List<Categoria> categorias= cServ.getCategorias();
					model.addAttribute("categorias", categorias);
					model.addAttribute("valores", "descripcion");
					
					return "/views/productos/editProducto";
				}
			}else {
				Producto producto = pServ.getProducto(Integer.parseInt(id));
				String precio2= producto.getPrecioFormateado().replace(",",".");
				Double precioF= Double.parseDouble(precio2);
				model.addAttribute("precio", precioF );
				model.addAttribute("producto",producto);
				
				List<Categoria> categorias= cServ.getCategorias();
				model.addAttribute("categorias", categorias);
				
				model.addAttribute("valores", "nombre");
				return "/views/productos/editProducto";
			}
			return "redirect:/Home/Productos"; 
		}
	
	
	
	
	
	
	
	
	
	

}
