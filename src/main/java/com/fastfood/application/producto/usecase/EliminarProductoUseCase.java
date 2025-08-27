package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EliminarProductoUseCase {
    private final ProductoRepository productoRepository;

    public void eliminar(int id) {
        productoRepository.eliminar(id);
    }
}
