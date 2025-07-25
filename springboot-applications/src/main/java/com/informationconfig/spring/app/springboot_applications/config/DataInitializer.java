package com.informationconfig.spring.app.springboot_applications.config;

import com.informationconfig.spring.app.springboot_applications.models.Usuario;
import com.informationconfig.spring.app.springboot_applications.models.Rol;
import com.informationconfig.spring.app.springboot_applications.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.Set;

@Component
public class DataInitializer {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostConstruct
    public void initData() {
        System.out.println("🚀 Inicializando datos...");
        
        // Solo crea si no existen usuarios
        if (usuarioRepository.count() == 0) {
            
            // Crear usuario admin
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRoles(Set.of(Rol.ADMIN)); // Usar Set.of() para crear el conjunto
            usuarioRepository.save(admin);
            
            // Crear usuario normal
            Usuario user = new Usuario();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(Rol.USER));
            usuarioRepository.save(user);
            
            // Crear usuario con múltiples roles
            Usuario superUser = new Usuario();
            superUser.setUsername("superuser");
            superUser.setPassword(passwordEncoder.encode("123456"));
            superUser.setRoles(Set.of(Rol.ADMIN, Rol.USER)); // Múltiples roles
            usuarioRepository.save(superUser);
            
            System.out.println("✅ Datos iniciales creados:");
            System.out.println("👤 Admin: admin/123456 (ADMIN)");
            System.out.println("👤 User: user/123456 (USER)");
            System.out.println("👤 SuperUser: superuser/123456 (ADMIN, USER)");
            
        } else {
            System.out.println("ℹ️ Los datos ya existen, saltando inicialización...");
        }
    }
}