package com.informationconfig.spring.app.springboot_applications.controllers.user;

import com.informationconfig.spring.app.springboot_applications.models.Usuario;
import com.informationconfig.spring.app.springboot_applications.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "User dashboard";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/profile")
    public Usuario getProfile(@AuthenticationPrincipal UserDetails userDetails) {
        return usuarioService.findByUsername(userDetails.getUsername()).orElse(null);
    }
} 