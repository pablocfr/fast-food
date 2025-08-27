package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarPedidosUseCase {

    private final PedidoRepository pedidoRepository;

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.listarPedidos();
    }
}
