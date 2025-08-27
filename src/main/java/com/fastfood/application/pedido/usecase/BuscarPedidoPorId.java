package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BuscarPedidoPorId {

    private final PedidoRepository pedidoRepository;

    public Optional<PedidoModel> buscarPedidoPorId(int id) {
        return pedidoRepository.buscarPorId(id);
    }
}
