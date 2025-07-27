package com.informationconfig.spring.app.springboot_applications.controllers;

import com.informationconfig.spring.app.springboot_applications.models.Usuario;
import com.informationconfig.spring.app.springboot_applications.models.Rol;
import com.informationconfig.spring.app.springboot_applications.repositories.UsuarioRepository;
import com.informationconfig.spring.app.springboot_applications.dto.LoginRequest;
import com.informationconfig.spring.app.springboot_applications.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Check if username already exists
        if (usuarioRepository.findByUsername(request.getName()).isPresent()) {
            return ResponseEntity.badRequest().body(Map.of("error", "User already exists"));
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(request.getName());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword()); // TODO: Hash password in production
        usuario.setRoles(Set.of(Rol.USER));

        Usuario saved = usuarioRepository.save(usuario);

        Map<String, Object> response = new HashMap<>();
        response.put("id", saved.getId());
        response.put("username", saved.getUsername());
        response.put("email", saved.getEmail());
        response.put("roles", saved.getRoles());
        response.put("token", "dummy-jwt-token-" + saved.getId());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(request.getEmail());
        if (usuarioOpt.isEmpty() || !usuarioOpt.get().getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }

        Usuario usuario = usuarioOpt.get();
        Map<String, Object> response = new HashMap<>();
        response.put("id", usuario.getId());
        response.put("username", usuario.getUsername());
        response.put("email", usuario.getEmail());
        response.put("roles", usuario.getRoles());
        response.put("token", "dummy-jwt-token-" + usuario.getId());

        return ResponseEntity.ok(response);
    }
}
