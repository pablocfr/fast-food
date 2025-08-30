package com.fastfood.infrastructure.persistence.pedido.jpa;

import com.fastfood.infrastructure.persistence.pedido.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, Integer> {

    List<PedidoEntity> findByEstado(String estado);

    @Query("SELECT DISTINCT p FROM PedidoEntity p " +
            "LEFT JOIN FETCH p.detalles d " +
            "LEFT JOIN FETCH d.producto " +
            "LEFT JOIN FETCH d.comboProducto " +
            "LEFT JOIN FETCH p.cliente " +
            "LEFT JOIN FETCH p.usuario")
    List<PedidoEntity> listarTodosLosPedidos();

}
