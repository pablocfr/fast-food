package com.fastfood.infrastructure.persistence.proveedor.jpa;

import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.infrastructure.persistence.proveedor.entity.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepositoryJpa extends JpaRepository<ProveedorEntity, Integer> {

    @Query("SELECT p FROM ProveedorEntity p WHERE p.activo = true ORDER BY p.nombre")
    List<ProveedorEntity> findAllActivos();

    @Query("SELECT p FROM ProveedorEntity p WHERE p.idProveedor = :id AND p.activo = true")
    Optional<ProveedorEntity> findByIdActivo(@Param("id") Integer id);

    boolean existsByNombreAndActivoTrue(String nombre);
}