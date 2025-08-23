package com.fastfood.infrastructure.persistence.producto.jpa;

import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepositoryJpa extends JpaRepository<ProductoEntity, Integer> {

    /**
     * Top 3 productos más vendidos del día (por cantidad en detalles de pedido)
     */
    @Query("""
            SELECT p FROM ProductoEntity p
            JOIN DetallePedidoEntity d ON d.producto = p
            JOIN PedidoEntity pe ON d.pedido = pe
            WHERE pe.estado != 'Pendiente'
              AND pe.activo = true
              AND FUNCTION('DATE', pe.fechaHora) = CURRENT_DATE
              AND p.activo = true
            GROUP BY p.idProducto, p.nombre
            ORDER BY SUM(d.cantidad) DESC
            """)
    List<Object[]> findTopProductosVendidosHoy(@Param("limit") int limit);
}