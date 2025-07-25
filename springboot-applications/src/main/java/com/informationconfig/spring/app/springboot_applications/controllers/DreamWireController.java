package com.informationconfig.spring.app.springboot_applications.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.informationconfig.spring.app.springboot_applications.models.dto.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/dreamwire")
public class DreamWireController {
    
    @PostMapping("/analyze-idea")
    public ResponseEntity<ProjectAnalysis> analyzeIdea(@RequestBody IdeaRequest request) {
        // Ejemplo de análisis básico
        ProjectAnalysis analysis = new ProjectAnalysis();
        analysis.setAnalyzedIdea(request.getIdea());
        analysis.setSuggestedEntities(Arrays.asList("Usuario", "Clase", "Reserva", "Instructor"));
        analysis.setSuggestedEndpoints(Arrays.asList("/api/usuarios", "/api/clases", "/api/reservas"));
        analysis.setSuggestedFeatures(Arrays.asList("CRUD", "Autenticación", "Reservas"));
        
        return ResponseEntity.ok(analysis);
    }
    
    @PostMapping("/generate-project")
    public ResponseEntity<byte[]> generateProject(@RequestBody ProjectConfig config) {
        // Aquí irá la lógica para generar el ZIP
        // Por ahora retorna un placeholder
        return ResponseEntity.ok("Proyecto generado".getBytes());
    }
}