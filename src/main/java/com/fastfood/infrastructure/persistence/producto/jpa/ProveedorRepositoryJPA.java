package com.fastfood.infrastructure.persistence.producto.jpa;

import com.fastfood.infrastructure.persistence.producto.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProveedorRepositoryJPA extends JpaRepository<ProveedorEntity, Integer> {
}
