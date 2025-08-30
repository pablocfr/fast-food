package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CambiarEstadoPedidoUseCase {

    private final PedidoRepository pedidoRepository;

    public void cambiarEstadoPedido(Integer idPedido) {
        pedidoRepository.cambiarEstadoPedido(idPedido);
    }

}
