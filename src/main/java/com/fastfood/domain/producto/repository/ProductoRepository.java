package com.fastfood.domain.producto.repository;

import com.fastfood.domain.producto.model.ProductoModel;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {

    Optional<ProductoModel> buscarPorId(int id);
    List<ProductoModel> listarTodos();
    ProductoModel guardar(ProductoModel producto);
    ProductoModel actualizar(int id, ProductoModel producto);
    void eliminar(int id);

}
