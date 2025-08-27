package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditarProductoUseCase {
    private final ProductoRepository productoRepository;

    public ProductoModel actualizar(int id, ProductoModel producto) {
        return productoRepository.actualizar(id, producto);
    }
}
