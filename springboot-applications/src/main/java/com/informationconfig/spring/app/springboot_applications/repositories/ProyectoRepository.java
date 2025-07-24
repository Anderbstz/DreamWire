package com.informationconfig.spring.app.springboot_applications.repositories;

import com.informationconfig.spring.app.springboot_applications.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
} 