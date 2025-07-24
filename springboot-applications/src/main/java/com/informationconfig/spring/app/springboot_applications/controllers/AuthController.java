package com.informationconfig.spring.app.springboot_applications.controllers;

import com.informationconfig.spring.app.springboot_applications.models.Usuario;
import com.informationconfig.spring.app.springboot_applications.models.Rol;
import com.informationconfig.spring.app.springboot_applications.repositories.UsuarioRepository;
import com.informationconfig.spring.app.springboot_applications.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = passwordEncoder.encode(body.get("password"));
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setRoles(Collections.singleton(Rol.USER));
        usuarioRepository.save(usuario);
        String token = jwtUtil.generateToken(username);
        return Collections.singletonMap("token", token);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(username);
        return Collections.singletonMap("token", token);
    }
} 