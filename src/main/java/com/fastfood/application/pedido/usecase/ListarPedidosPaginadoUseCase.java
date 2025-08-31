package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.pedido.repository.PedidoRepository;
import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.valueobject.PaginaResult;
import com.fastfood.domain.producto.valueobject.PaginacionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListarPedidosPaginadoUseCase {

    private final PedidoRepository pedidoRepository;

    public PaginaResult<PedidoModel> ejecutar(PaginacionRequest paginacion) {
        return pedidoRepository.listarPedidosPaginado(paginacion);
    }

}
