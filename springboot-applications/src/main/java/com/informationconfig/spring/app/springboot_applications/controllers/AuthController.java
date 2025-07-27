package com.informationconfig.spring.app.springboot_applications.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import com.informationconfig.spring.app.springboot_applications.models.User;
import com.informationconfig.spring.app.springboot_applications.dto.LoginRequest;
import com.informationconfig.spring.app.springboot_applications.dto.RegisterRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final Map<String, User> users = new HashMap<>();
    private Long nextUserId = 1L;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Validar si el email ya existe
        if (users.values().stream().anyMatch(u -> u.getEmail().equals(request.getEmail()))) {
            return ResponseEntity.badRequest().body(Map.of("error", "El email ya está registrado"));
        }

        // Crear nuevo usuario
        User newUser = new User();
        newUser.setId(nextUserId++);
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword()); // En producción, hashear la contraseña
        newUser.setRole("USER");

        users.put(request.getEmail(), newUser);

        // Devolver usuario sin contraseña
        Map<String, Object> response = new HashMap<>();
        response.put("id", newUser.getId());
        response.put("name", newUser.getName());
        response.put("email", newUser.getEmail());
        response.put("role", newUser.getRole());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        User user = users.get(request.getEmail());

        if (user == null || !user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }

        // Devolver usuario sin contraseña
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("role", user.getRole());

        return ResponseEntity.ok(response);
    }
}