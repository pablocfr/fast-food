package com.fastfood.infrastructure.persistence.producto.jpa;

import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositoryJPA extends JpaRepository<ProductoEntity, Integer> {
}
