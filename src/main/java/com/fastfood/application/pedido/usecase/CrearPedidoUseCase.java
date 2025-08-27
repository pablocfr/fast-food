package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public PedidoModel crearPedido(PedidoModel pedidoModel) {
        return pedidoRepository.guardar(pedidoModel);
    }
}
