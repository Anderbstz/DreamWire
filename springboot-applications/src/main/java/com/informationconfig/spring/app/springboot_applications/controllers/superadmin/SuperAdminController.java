package com.informationconfig.spring.app.springboot_applications.controllers.superadmin;

import com.informationconfig.spring.app.springboot_applications.models.Usuario;
import com.informationconfig.spring.app.springboot_applications.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/superadmin")
public class SuperAdminController {
    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "SuperAdmin dashboard";
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.findAll();
    }
} 