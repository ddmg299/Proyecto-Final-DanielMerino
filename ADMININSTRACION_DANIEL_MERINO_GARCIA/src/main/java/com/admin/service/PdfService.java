package com.admin.service;


import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.ServletContext;

@Service
public class PdfService {
	
	
	

	
	public Document creafactura() {
		String rutaCompleta = "src/main/resources/static/facturas/pFactura.pdf";


		
		PdfWriter writer = null;
		Document d = new Document(PageSize.A4 , 20 , 20 , 70 , 50);
		try {
			
			writer= PdfWriter.getInstance(d,new FileOutputStream(rutaCompleta));
			
			
			d.open();
			
			//Parrafo
			Paragraph p = new Paragraph();
			p.add("Prueba pdf");
			d.add(p);
			PdfPTable tabla= new PdfPTable(4);
			
			Phrase texto= new Phrase("PRODUCTOS");
			PdfPCell c = new PdfPCell(texto);
			
			Phrase texto1= new Phrase("PRECIO");
			PdfPCell c1 = new PdfPCell(texto);
			
			Phrase texto2= new Phrase("Cantidad");
			PdfPCell c2 = new PdfPCell(texto);
			
			Phrase texto3= new Phrase("Total");
			PdfPCell c3 = new PdfPCell(texto);
			
			
			tabla.addCell("PRODUCTOS");			
			tabla.addCell("PRECIO");
			tabla.addCell("CANTIDAD");
			tabla.addCell("TOTAL");
			tabla.addCell("p1");
			tabla.addCell("p2");
			tabla.addCell("p3");
			tabla.addCell("p4");
			d.add(tabla);
			d.close();
			
			writer.close();
			return d;
		}catch(IOException e) {
			
			e.printStackTrace();
			return null;
		}catch(DocumentException e ) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	
	
}


