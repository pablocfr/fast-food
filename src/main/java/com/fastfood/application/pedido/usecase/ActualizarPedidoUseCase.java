package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ActualizarPedidoUseCase {

    private final PedidoRepository pedidoRepository;

}
