package com.fastfood.application.producto;

import com.fastfood.application.producto.usecase.*;
import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.service.ProductoService;
import com.fastfood.domain.producto.valueobject.PaginaResult;
import com.fastfood.domain.producto.valueobject.PaginacionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final CrearProductoUseCase crearProductoUseCase;
    private final EditarProductoUseCase editarProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;
    private final ObtenerProductoUseCase obtenerProductoUseCase;
    private final ListarProductoUseCase listarProductoUseCase;
    private final ListarProductosPaginadoUseCase listarProductosPaginadoUseCase;

    @Override
    public Optional<ProductoModel> buscarPorId(int id) {
        return obtenerProductoUseCase.buscarPorId(id);
    }

    @Override
    public List<ProductoModel> listarTodos() {
        return listarProductoUseCase.listarTodos();
    }

    @Override
    public ProductoModel guardar(ProductoModel producto) {
        return crearProductoUseCase.guardar(producto);
    }

    @Override
    public ProductoModel actualizar(int id, ProductoModel producto) {
        return editarProductoUseCase.actualizar(id, producto);
    }

    @Override
    public void eliminar(int id) {
        eliminarProductoUseCase.eliminar(id);
    }

    @Override
    public PaginaResult<ProductoModel> listarProductosPaginado(PaginacionRequest paginacion) {
        return listarProductosPaginadoUseCase.ejecutar(paginacion);
    }
}
