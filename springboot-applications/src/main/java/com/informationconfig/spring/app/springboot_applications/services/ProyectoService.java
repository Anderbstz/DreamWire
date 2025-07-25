package com.informationconfig.spring.app.springboot_applications.services;

import com.informationconfig.spring.app.springboot_applications.models.Proyecto;
import com.informationconfig.spring.app.springboot_applications.repositories.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> findAll() {
        return proyectoRepository.findAll();
    }

    public Optional<Proyecto> findById(Long id) {
        return proyectoRepository.findById(id);
    }

    public Proyecto save(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public void deleteById(Long id) {
        proyectoRepository.deleteById(id);
    }
} 