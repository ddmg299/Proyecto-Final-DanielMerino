package com.admin.service;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.admin.model.Detalle;
import com.admin.model.Pedido;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;




@Service
public class PdfService {
	private Image headerImage=null;
	
	@Autowired
	private ConfiguracionService cSer;
	
	@Autowired
	private DetalleService dSer;
	

	
	public Document creafactura(Pedido pedido ) {

		
			String nombreArchivo=pedido.getNumFactura().replace("/", "-");
		 	String rutaCompleta = "src/main/resources/static/facturas/"+nombreArchivo+".pdf";
		 	System.out.println("RUTA DEL ARCHIVO"+rutaCompleta);
	        String rutaFoto = "src/main/resources/static/img/logo_sinFondo.png";

	        Document document = new Document(PageSize.A4, 30, 30, 60, 50);

	        try {
	            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaCompleta));
	            document.open();

	            // Cabecera
	            Image headerImage = Image.getInstance(rutaFoto);
	            headerImage.scaleToFit(60,60);

	            PdfPTable headerTable = new PdfPTable(2);
	            headerTable.setWidthPercentage(100);

	            PdfPCell imageCell = new PdfPCell(headerImage, true);
	            imageCell.setBorder(Rectangle.NO_BORDER);
	            imageCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            imageCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	            headerTable.addCell(imageCell);

	            PdfPCell textCell = new PdfPCell();
	            textCell.setBorder(Rectangle.NO_BORDER);
	            textCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	            
	            
	            
	            
	            String nombreU= cSer.getConfiguracion("Nombre").getValor();
	            String direccion= cSer.getConfiguracion("Dirección").getValor();
	            String cPostal = cSer.getConfiguracion("Código Postal").getValor();
	            String localidad= cSer.getConfiguracion("Localidad").getValor();
	            
	            
	            textCell.addElement(new Paragraph(nombreU));
	            textCell.addElement(new Paragraph(direccion));
	            textCell.addElement(new Paragraph(localidad));
	            textCell.addElement(new Paragraph(cPostal));

	            headerTable.addCell(textCell);

	            //headerTable.setTotalWidth(document.right() - document.left());
	           // headerTable.writeSelectedRows(0, -1, document.left(), document.top(), writer.getDirectContent());
	            
	            document.add(headerTable);
	            
	            
	           Paragraph p1 = new Paragraph("Nombre:"+pedido.getUsuario().getNombre()+"\t Apellidos:"+pedido.getUsuario().getApellidos());
	           Paragraph p2 = new Paragraph("Fecha del pedido "+ pedido.getFecha());
	           Paragraph p3 = new Paragraph("Total del pedido:"+pedido.getTotalFormateado()+"€");
	            p1.setIndentationLeft(40);
	            p2.setIndentationLeft(40);
	            p3.setIndentationLeft(40);
	            
	            
	            document.add(p1);
	            document.add(p2);
	            document.add(p3);
	            
	            
	            
	            //Tabla del detalle del pedido
	            
	           List<Detalle> detalles = dSer.getDetalleByPedidoId(pedido.getId());
	           
	           PdfPTable tablaDetalle = new PdfPTable(4);
	           
	           	Phrase texto1= new Phrase("PRODUCTOS");
	           	Phrase texto2= new Phrase("PRECIO");
	           	Phrase texto3= new Phrase("CANTIDAD");
	           	Phrase texto4= new Phrase("TOTAL");
	           	
				PdfPCell c1 = new PdfPCell(texto1);
				PdfPCell c2 = new PdfPCell(texto2);
				PdfPCell c3 = new PdfPCell(texto3);
				PdfPCell c4 = new PdfPCell(texto4);
				
				
				tablaDetalle.addCell(c1);
				tablaDetalle.addCell(c2);
				tablaDetalle.addCell(c3);
				tablaDetalle.addCell(c4);
				
				for(Detalle detalle: detalles) {
					
					
					System.out.println(detalle.getUnidades());
					
					tablaDetalle.addCell(new PdfPCell(new Phrase(detalle.getProducto().getNombre())));
					tablaDetalle.addCell(new PdfPCell(new Phrase(detalle.getPrecioFormateado()+"€")));
					tablaDetalle.addCell(new PdfPCell(new Phrase(Integer.toString(detalle.getUnidades()))));
					tablaDetalle.addCell(new PdfPCell(new Phrase(detalle.getTotalFormateado()+"€")));
					
				}
				
				tablaDetalle.setSpacingBefore(20);
				document.add(tablaDetalle);
	            
	            
	            
	            
	            
	            
	            document.close();
	            writer.close();

	            System.out.println("El archivo PDF se ha generado correctamente.");
	        } catch (DocumentException | IOException e) {
	            System.out.println("Error al generar el archivo PDF: " + e.getMessage());
	        }
		return document;
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
}


