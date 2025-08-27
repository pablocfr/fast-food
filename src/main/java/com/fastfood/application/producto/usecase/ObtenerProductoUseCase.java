package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ObtenerProductoUseCase {
    private final ProductoRepository productoRepository;

    public Optional<ProductoModel> buscarPorId(int id) {
        return productoRepository.buscarPorId(id);
    }
}
