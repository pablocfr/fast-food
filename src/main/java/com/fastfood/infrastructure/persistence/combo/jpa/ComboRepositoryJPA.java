package com.fastfood.infrastructure.persistence.combo.jpa;

import com.fastfood.infrastructure.persistence.combo.entity.ComboEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComboRepositoryJPA extends JpaRepository<ComboEntity, Integer> {

    @Query("""
           SELECT DISTINCT c FROM ComboEntity c
           LEFT JOIN FETCH c.comboProductos cp
           LEFT JOIN FETCH cp.producto
           """)
    List<ComboEntity> findAllWithProductos();

}
