package com.informationconfig.spring.app.springboot_applications.models;

import jakarta.persistence.*;

@Entity
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;
    // getters y setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
} 