package com.admin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "configuracion")
public class Configuracion {
    @Id
    private String clave;

    @Column(name = "valor")
    private String valor;

    // Constructor, getters, and setters
}
