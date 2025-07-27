package com.informationconfig.spring.app.springboot_applications.config;

import com.informationconfig.spring.app.springboot_applications.models.Rol;
import com.informationconfig.spring.app.springboot_applications.models.Usuario;
import com.informationconfig.spring.app.springboot_applications.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (usuarioRepository.findByUsername("admin").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123456"));
            admin.setRoles(Set.of(Rol.ADMIN));
            usuarioRepository.save(admin);
        }
        if (usuarioRepository.findByUsername("user").isEmpty()) {
            Usuario user = new Usuario();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("123456"));
            user.setRoles(Set.of(Rol.USER));
            usuarioRepository.save(user);
        }
        if (usuarioRepository.findByUsername("superadmin").isEmpty()) {
            Usuario superadmin = new Usuario();
            superadmin.setUsername("superadmin");
            superadmin.setPassword(passwordEncoder.encode("123456"));
            superadmin.setRoles(Set.of(Rol.SUPERADMIN));
            usuarioRepository.save(superadmin);
        }
    }
}