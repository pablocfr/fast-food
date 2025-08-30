package com.fastfood.infrastructure.persistence.producto.jpa;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.infrastructure.persistence.combo.entity.ComboProductoEntity;
import com.fastfood.infrastructure.persistence.producto.entity.CategoriaProdEntity;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.infrastructure.persistence.producto.entity.ProveedorEntity;
import com.fastfood.infrastructure.persistence.producto.projection.ProductoProjection;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepositoryJPA extends JpaRepository<ProductoEntity, Integer> {

    @Query("SELECT p FROM ProductoEntity p WHERE p.categoria.nombre = :nombreCategoria")
    List<ProductoEntity> listarPorNombreCategoria(@Param("nombreCategoria") String nombreCategoria);

    List<ProductoEntity> findByNombre(String nombre);

    @Query("""
       SELECT p 
       FROM ProductoEntity p
       JOIN FETCH p.categoria
       JOIN FETCH p.proveedor
       WHERE p.activo = true
       """)
    Page<ProductoEntity> findAllProductosActivos(Pageable pageable);

}

