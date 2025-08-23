package com.fastfood.infrastructure.persistence.pedido.jpa;

import com.fastfood.infrastructure.persistence.pedido.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Integer> {

    /**
     * Listar pedidos con estado "Listo" o "Completado" del día actual
     */
    @Query("""
            SELECT p FROM PedidoEntity p
            WHERE p.estado IN ('Listo', 'Completado')
              AND p.activo = true
              AND DATE(p.fechaHora) = CURRENT_DATE
            ORDER BY p.fechaHora ASC
            """)
    List<PedidoEntity> findListosParaEntregarHoy();

    /**
     * Listar pedidos ya entregados del día actual
     */
    @Query("""
            SELECT p FROM PedidoEntity p
            WHERE p.estado = 'Entregado'
              AND p.activo = true
              AND DATE(p.fechaHora) = CURRENT_DATE
            ORDER BY p.fechaHora ASC
            """)
    List<PedidoEntity> findEntregadosHoy();

    /**
     * Buscar pedido por ID con sus relaciones cargadas (cliente, detalles, productos, combos)
     */
    @Query("""
            SELECT DISTINCT p FROM PedidoEntity p
            LEFT JOIN FETCH p.cliente
            LEFT JOIN FETCH p.detalles d
            LEFT JOIN FETCH d.producto
            LEFT JOIN FETCH d.comboProducto
            WHERE p.idPedido = :id AND p.activo = true
            """)
    Optional<PedidoEntity> findByIdWithDetails(@Param("id") Integer id);
}