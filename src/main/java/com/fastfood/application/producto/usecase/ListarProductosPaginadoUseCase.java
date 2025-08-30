package com.fastfood.application.producto.usecase;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.repository.ProductoRepository;
import com.fastfood.domain.producto.valueobject.PaginaResult;
import com.fastfood.domain.producto.valueobject.PaginacionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ListarProductosPaginadoUseCase {

    private final ProductoRepository productoRepository;

    public PaginaResult<ProductoModel> ejecutar(PaginacionRequest paginacion) {
        return productoRepository.listarProductosPaginado(paginacion);
    }

}
