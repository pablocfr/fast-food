package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListarProductoUseCase {
    private final ProductoRepository productoRepository;

    public List<ProductoModel> listarTodos() {
        return productoRepository.listarTodos();
    }
}
