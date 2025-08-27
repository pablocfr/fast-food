package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearProductoUseCase {

    private final ProductoRepository productoRepository;

    public ProductoModel guardar(ProductoModel producto) {
        return productoRepository.guardar(producto);
    }

}
