package com.informationconfig.spring.app.springboot_applications.controllers.admin;

import com.informationconfig.spring.app.springboot_applications.models.Usuario;
import com.informationconfig.spring.app.springboot_applications.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Admin dashboard";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.findById(id).orElse(null);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/usuarios/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.save(usuario);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
} 