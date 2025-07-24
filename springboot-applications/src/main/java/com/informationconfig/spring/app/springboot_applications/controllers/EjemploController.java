package com.informationconfig.spring.app.springboot_applications.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.informationconfig.spring.app.springboot_applications.models.Empleados;


@Controller

public class EjemploController {

    @GetMapping("/ejemplo")
    
    public String info(Model model) {
        Empleados empleado = new Empleados("Ander", "González", "Av. Siempre Viva 742", "Desarrollador", 30, 60000, 123456789, 1);

        model.addAttribute("Empleado", empleado);
        return "ejemplo";
    }
    
}
