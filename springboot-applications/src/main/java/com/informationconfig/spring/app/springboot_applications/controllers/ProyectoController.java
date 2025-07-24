package com.informationconfig.spring.app.springboot_applications.controllers;

import com.informationconfig.spring.app.springboot_applications.models.Proyecto;
import com.informationconfig.spring.app.springboot_applications.services.ProyectoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    private final ProyectoService proyectoService;
    public ProyectoController(ProyectoService proyectoService) {
        this.proyectoService = proyectoService;
    }
    @GetMapping
    public List<Proyecto> getAll() {
        return proyectoService.findAll();
    }
    @GetMapping("/{id}")
    public Proyecto getById(@PathVariable Long id) {
        return proyectoService.findById(id).orElse(null);
    }
    @PostMapping
    public Proyecto create(@RequestBody Proyecto proyecto) {
        return proyectoService.save(proyecto);
    }
    @PutMapping("/{id}")
    public Proyecto update(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        proyecto.setId(id);
        return proyectoService.save(proyecto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        proyectoService.deleteById(id);
    }
} 