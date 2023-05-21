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
@Table(name = "producto")
public class Producto {
    @Id
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private double precio;

    @Column(name = "impuesto")
    private double impuesto;

    @Column(name = "stock")
    private int stock;

    @Column(name = "baja")
    private boolean baja;

    @Column(name = "foto")
    private String foto;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    // Constructor, getters, and setters
    
    
    public String getPrecioFormateado() {
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String valorFormateado = decimalFormat.format(this.precio);
        return valorFormateado;

    }
    
//    public Double precioFormateadoDouble() {
//    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
//        String valorFormateado = decimalFormat.format(this.precio);
//        return valorFormateado;
//
//    }
    
    public String getImpuestoFormateado() {
    	DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        String valorFormateado = decimalFormat.format(this.impuesto);
        return valorFormateado;

    }
    
    
}
