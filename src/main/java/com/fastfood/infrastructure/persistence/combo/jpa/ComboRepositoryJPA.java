package com.fastfood.infrastructure.persistence.combo.jpa;

import com.fastfood.infrastructure.persistence.combo.entity.ComboEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComboRepositoryJPA extends JpaRepository<ComboEntity, Integer> {
}
