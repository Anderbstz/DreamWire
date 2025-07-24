package com.informationconfig.spring.app.springboot_applications.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // NO @RestController
public class WebController {
    
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login"; // busca templates/login.html
    }
    
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard"; // busca templates/dashboard.html
    }
}
