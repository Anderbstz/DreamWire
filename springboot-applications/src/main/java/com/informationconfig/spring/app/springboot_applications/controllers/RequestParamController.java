package com.informationconfig.spring.app.springboot_applications.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.informationconfig.spring.app.springboot_applications.controllers.ParametroDTO;

@RestController
@RequestMapping("/api/parametros")

public class RequestParamController {
    @GetMapping("/detalles")
    public ParametroDTO getParametro(@RequestParam String nombre, @RequestParam String valor) {
        return new ParametroDTO(nombre, valor);
    }
    
    

}
