package com.fastfood.infrastructure.persistence.producto.jpa;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepositoryJPA extends JpaRepository<ProductoEntity, Integer> {

    @Query("SELECT p FROM ProductoEntity p WHERE p.categoria.nombre = :nombreCategoria")
    List<ProductoEntity> listarPorNombreCategoria(@Param("nombreCategoria") String nombreCategoria);

    List<ProductoEntity> findByNombre(String nombre);
}
