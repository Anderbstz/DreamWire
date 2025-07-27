package com.informationconfig.spring.app.springboot_applications.controllers;

import com.informationconfig.spring.app.springboot_applications.models.Modulo;
import com.informationconfig.spring.app.springboot_applications.services.ModuloService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {
    private final ModuloService moduloService;
    public ModuloController(ModuloService moduloService) {
        this.moduloService = moduloService;
    }
    @GetMapping
    public List<Modulo> getAll() {
        return moduloService.findAll();
    }
    @GetMapping("/{id}")
    public Modulo getById(@PathVariable Long id) {
        return moduloService.findById(id).orElse(null);
    }
    @PostMapping
    public Modulo create(@RequestBody Modulo modulo) {
        return moduloService.save(modulo);
    }
    @PutMapping("/{id}")
    public Modulo update(@PathVariable Long id, @RequestBody Modulo modulo) {
        modulo.setId(id);
        return moduloService.save(modulo);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        moduloService.deleteById(id);
    }
} 