package com.informationconfig.spring.app.springboot_applications.repositories;

import com.informationconfig.spring.app.springboot_applications.models.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;
 
public interface ModuloRepository extends JpaRepository<Modulo, Long> {
} 