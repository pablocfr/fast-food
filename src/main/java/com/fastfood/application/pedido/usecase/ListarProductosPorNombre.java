package com.fastfood.application.pedido.usecase;

import com.fastfood.domain.pedido.repository.PedidoRepository;
import com.fastfood.domain.producto.model.ProductoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarProductosPorNombre {

    private final PedidoRepository pedidoRepository;

    public List<ProductoModel> listarProductosPorNombre(String nombre) {
        return pedidoRepository.listarPorTipoProducto(nombre);
    }
}
