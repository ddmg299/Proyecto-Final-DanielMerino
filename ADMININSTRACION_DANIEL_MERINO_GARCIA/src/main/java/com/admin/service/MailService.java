package com.admin.service;


import java.util.Properties;


import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.admin.model.Pedido;

import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.activation.*;
import java.util.Properties;
import java.io.File;


@Service
public class MailService {
	
	public boolean enviarEmail(String emailDestinatario, String asunto, String cuerpoMensaje, Pedido p) {

		String nombreArchivo=p.getNumFactura().replace("/", "-");
	 	String rutaCompleta = "src/main/resources/static/facturas/"+nombreArchivo+".pdf";
	 	
		String destinatario = emailDestinatario;
		
		try {
			

			Properties prop = new Properties();

			prop.setProperty("mail.smtp.host", "smtp.office365.com");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.user", "pruebacorreoserbatic@outlook.com");
			prop.setProperty("mail.smtp.auth", "true");

			Session sesion = Session.getDefaultInstance(prop);
			
			sesion.setDebug(true);

			MimeMessage mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress("pruebacorreoserbatic@outlook.com"));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

			mensaje.setSubject(asunto);

			// Crea la parte del mensaje de texto
            MimeBodyPart textoPart = new MimeBodyPart();
            textoPart.setText(cuerpoMensaje, "utf-8", "html");

            // Crea la parte del mensaje que contendrá el archivo adjunto
            MimeBodyPart adjuntoPart = new MimeBodyPart();

            // Establece la ubicación del archivo adjunto
            DataSource fuenteDatos = new FileDataSource(rutaCompleta);
            adjuntoPart.setDataHandler(new DataHandler(fuenteDatos));
            adjuntoPart.setFileName(fuenteDatos.getName());

            // Crea el multipart para combinar el contenido del mensaje y el archivo adjunto
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textoPart);
            multipart.addBodyPart(adjuntoPart);

            // Establece el contenido del mensaje
            mensaje.setContent(multipart);

			Transport t = sesion.getTransport("smtp");
			t.connect("pruebacorreoserbatic@outlook.com", "pruebaCb157");
			t.sendMessage(mensaje, mensaje.getAllRecipients());

			t.close();
			return true;
		} catch (AddressException ex) {
			System.out.println(ex);
			return false;
		} catch (MessagingException ex) {
			System.out.println(ex);
			return false;
		}
	}

}
