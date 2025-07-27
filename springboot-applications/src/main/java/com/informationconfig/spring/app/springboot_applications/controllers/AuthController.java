package com.informationconfig.spring.app.springboot_applications.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.informationconfig.spring.app.springboot_applications.models.User;
import com.informationconfig.spring.app.springboot_applications.dto.LoginRequest;
import com.informationconfig.spring.app.springboot_applications.dto.RegisterRequest;
import com.informationconfig.spring.app.springboot_applications.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        // Verificar si el usuario ya existe
        if (userRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body(Map.of("error", "El usuario ya existe"));
        }

        // Crear nuevo usuario
        User newUser = new User();
        newUser.setName(request.getName());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(request.getPassword());
        newUser.setRole("USER");
        
        // Guardar en base de datos
        User savedUser = userRepository.save(newUser);

        // Devolver usuario sin contraseña
        Map<String, Object> response = new HashMap<>();
        response.put("id", savedUser.getId());
        response.put("name", savedUser.getName());
        response.put("email", savedUser.getEmail());
        response.put("role", savedUser.getRole());
        response.put("token", "dummy-jwt-token-" + savedUser.getId());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty() || !userOptional.get().getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales inválidas"));
        }

        User user = userOptional.get();
        
        // Devolver usuario sin contraseña
        Map<String, Object> response = new HashMap<>();
        response.put("id", user.getId());
        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("role", user.getRole());
        response.put("token", "dummy-jwt-token-" + user.getId());

        return ResponseEntity.ok(response);
    }
}