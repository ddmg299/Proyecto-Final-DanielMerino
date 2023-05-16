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
@Table(name = "categoria")
public class Categoria {
    @Id
    private int id;

    @Column(name = "nombre")
    private String nombre;

    // Constructor, getters, and setters
}
