package com.fastfood.infrastructure.persistence.producto.jpa;

import com.fastfood.infrastructure.persistence.producto.entity.CategoriaProdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaProRepositoryJPA extends JpaRepository<CategoriaProdEntity, Integer> {
}
