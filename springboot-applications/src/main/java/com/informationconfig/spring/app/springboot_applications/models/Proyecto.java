package com.informationconfig.spring.app.springboot_applications.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String tipo; // API, Web, App
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Modulo> modulos;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    // otros getters y setters
} 