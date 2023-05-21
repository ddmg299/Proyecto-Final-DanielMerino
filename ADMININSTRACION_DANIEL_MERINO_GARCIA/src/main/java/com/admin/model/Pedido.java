package com.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;

import java.util.Calendar;
import java.util.TimeZone;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    //private Date fecha;
    private Timestamp fecha;

    @Column(name = "metodopago")
    private String metodoPago;

    @Column(name = "numfactura")
    private String numFactura;

    @Column(name = "estado")
    private String estado;

    @Column(name = "total")
    private double total;

    // Constructor, getters, and setters
    
    
    
    public String getTotalFormateado() {
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String valorFormateado = decimalFormat.format(this.total);
        return valorFormateado;

    }
//    public Timestamp getFechaFormateado() {
//    	
//    	
//    	TimeZone defaultTimeZone = TimeZone.getDefault();
//    	System.out.println("Zona horaria predeterminada: " + defaultTimeZone.getID());
//    	Timestamp timestampFromDB = this.fecha;
//    	// Crear un objeto Calendar y establecer la zona horaria deseada
//		Calendar calendar = Calendar.getInstance();
//		TimeZone timeZone = TimeZone.getTimeZone("Europe/Madrid"); // Zona horaria deseada
//		calendar.setTimeZone(timeZone);
//
//		// Establecer la marca de tiempo del objeto Calendar usando el valor del Timestamp de la base de datos
//		calendar.setTimeInMillis(timestampFromDB.getTime());
//
//		// Obtener el nuevo Timestamp con la zona horaria ajustada
//		Timestamp fechaFormateada = new Timestamp(calendar.getTimeInMillis());
//		System.out.println(fechaFormateada.toString());
//		return fechaFormateada;
//
//    			
//
//    }
}
