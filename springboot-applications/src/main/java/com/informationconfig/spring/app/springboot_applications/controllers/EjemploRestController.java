package com.informationconfig.spring.app.springboot_applications.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.informationconfig.spring.app.springboot_applications.models.Empleados;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.informationconfig.spring.app.springboot_applications.models.dto.ClaseDTO;

@RestController

@RequestMapping("/api")

public class EjemploRestController {

    @GetMapping(path = "/detalles")
    
    public ClaseDTO detalles() {
        ClaseDTO usuario = new ClaseDTO();
        usuario.setTitulo("Desarrollador Backend");
        usuario.setUsuario("Ander González");
        return usuario;

    }
        
}
    //public Map<String, Object> detalles() {
        //Empleados empleado = new Empleados("Ander", "González", "Av. Siempre Viva 742", "Desarrollador", 30, 60000, 123456789, 1);

        //Map<String, Object> respuesta = new HashMap<>();
        //respuesta.put("nombre", empleado.getNombre());
        //respuesta.put("apellido", empleado.getApellido());
        //respuesta.put("email", empleado.getEmail());
        //respuesta.put("puesto", empleado.getPuesto());
        //respuesta.put("edad", empleado.getEdad());
        //respuesta.put("salario", empleado.getSalario());
        //respuesta.put("telefono", empleado.getTelefono());
        //respuesta.put("id", empleado.getId());
    //    return respuesta;
    


