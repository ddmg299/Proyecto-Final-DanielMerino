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



@Service
public class MailService {
	
	public boolean enviarEmail(String emailDestinatario, String asunto, String cuerpoMensaje) {

		//TODO
		String destinatario = emailDestinatario;
		
		try {
			

			Properties prop = new Properties();

			prop.setProperty("mail.smtp.host", "smtp.office365.com");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.user", "tienda-online-curso@outlook.com");
			prop.setProperty("mail.smtp.auth", "true");

			Session sesion = Session.getDefaultInstance(prop);
			
			sesion.setDebug(true);

			MimeMessage mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress("tienda-online-curso@outlook.com"));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));

			mensaje.setSubject(asunto);

			mensaje.setText(
					cuerpoMensaje,
					"utf-8",
					"html");

			Transport t = sesion.getTransport("smtp");
			t.connect("tienda-online-curso@outlook.com", "cursojava2022");
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
