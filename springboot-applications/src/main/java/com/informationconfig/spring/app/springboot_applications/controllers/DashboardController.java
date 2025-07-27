package com.informationconfig.spring.app.springboot_applications.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private boolean isValidToken(String token) {
        // TODO: Implementar validación real del token usando JWT
        if (token == null || token.isEmpty()) {
            return false;
        }
        
        // Validación básica del formato Bearer token
        if (!token.startsWith("Bearer ")) {
            return false;
        }
        
        String tokenValue = token.substring(7); // Remover "Bearer "
        return tokenValue.startsWith("mock-jwt-") && tokenValue.length() >= 20;
    }

    private Map<String, Object> getUserFromToken(String token) {
        // TODO: Implementar obtención real del usuario desde el token usando JWT
        String tokenValue = token.substring(7); // Remover "Bearer "
        Map<String, Object> user = new HashMap<>();
        
        // Simulamos diferentes roles basados en el token para pruebas
        if (tokenValue.contains("admin")) {
            user.put("role", "ADMIN");
            user.put("name", "Admin Demo");
            user.put("email", "admin@dreamwire.com");
        } else if (tokenValue.contains("superadmin")) {
            user.put("role", "SUPERADMIN");
            user.put("name", "Super Admin Demo");
            user.put("email", "superadmin@dreamwire.com");
        } else {
            user.put("role", "USER");
            user.put("name", "Usuario Demo");
            user.put("email", "user@dreamwire.com");
        }
        
        user.put("id", System.currentTimeMillis() % 1000); // ID único simulado
        return user;
    }

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getDashboardInfo(@RequestHeader("Authorization") String token) {
        if (!isValidToken(token)) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Token inválido");
            return ResponseEntity.status(401).body(errorResponse);
        }

        Map<String, Object> user = getUserFromToken(token);
        Map<String, Object> response = new HashMap<>();
        response.put("title", "DreamWire Dashboard");
        response.put("message", "Bienvenido, " + user.get("name"));
        response.put("user", user);
        response.put("status", "active");
        response.put("projects", new Object[]{
            new HashMap<String, Object>() {{
                put("id", 1);
                put("name", "Mi Primer Proyecto");
                put("description", "Una aplicación web con Spring Boot y React");
                put("progress", 75);
                put("status", "En Progreso");
            }},
            new HashMap<String, Object>() {{
                put("id", 2);
                put("name", "E-commerce DreamWire");
                put("description", "Tienda en línea con carrito de compras");
                put("progress", 30);
                put("status", "Iniciado");
            }}
        });
        return ResponseEntity.ok(response);
    }

    @GetMapping("/admin")
    public ResponseEntity<Map<String, Object>> getAdminDashboard(@RequestHeader("Authorization") String token) {
        if (!isValidToken(token)) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Token inválido");
            return ResponseEntity.status(401).body(errorResponse);
        }

        Map<String, Object> user = getUserFromToken(token);
        if (!"ADMIN".equals(user.get("role"))) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Acceso denegado");
            return ResponseEntity.status(403).body(errorResponse);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("title", "Panel de Administración");
        response.put("role", "ADMIN");
        response.put("features", new String[]{"Gestión de Usuarios", "Gestión de Proyectos", "Reportes"});
        return ResponseEntity.ok(response);
    }

    @GetMapping("/superadmin")
    public ResponseEntity<Map<String, Object>> getSuperAdminDashboard(@RequestHeader("Authorization") String token) {
        if (!isValidToken(token)) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Token inválido");
            return ResponseEntity.status(401).body(errorResponse);
        }

        Map<String, Object> user = getUserFromToken(token);
        if (!"SUPERADMIN".equals(user.get("role"))) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Acceso denegado");
            return ResponseEntity.status(403).body(errorResponse);
        }

        Map<String, Object> response = new HashMap<>();
        response.put("title", "Panel de Super Administración");
        response.put("role", "SUPERADMIN");
        response.put("features", new String[]{"Gestión Global", "Configuración del Sistema", "Auditoría"});
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user")
    public ResponseEntity<Map<String, Object>> getUserDashboard(@RequestHeader("Authorization") String token) {
        if (!isValidToken(token)) {
            Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Token inválido");
        return ResponseEntity.status(401).body(errorResponse);
        }

        Map<String, Object> user = getUserFromToken(token);
        Map<String, Object> response = new HashMap<>();
        response.put("title", "Mi Panel de Usuario");
        response.put("role", user.get("role"));
        response.put("features", new String[]{"Mis Proyectos", "Nuevo Proyecto", "Perfil"});
        return ResponseEntity.ok(response);
    }
}