package com.fastfood.infrastructure.persistence.pedido.jpa;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.infrastructure.persistence.pedido.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, Integer> {

}
