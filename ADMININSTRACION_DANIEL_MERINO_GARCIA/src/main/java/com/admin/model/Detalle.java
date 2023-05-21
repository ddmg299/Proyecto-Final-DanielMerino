package com.admin.model;

import java.text.DecimalFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "detalle")
public class Detalle {
    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(name = "unidades")
    private int unidades;

    @Column(name = "preciounidad")
    private double precioUnitario;

    @Column(name = "impuesto")
    private double impuesto;

    @Column(name = "total")
    private double total;

    // Constructor, getters, and setters
    
    public String getPrecioFormateado() {
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String valorFormateado = decimalFormat.format(this.precioUnitario);
        return valorFormateado;
    
    }
    
    public String getTotalFormateado() {
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String valorFormateado = decimalFormat.format(this.total);
        return valorFormateado;

    }
}
