package com.fastfood.domain.producto.repository;

import com.fastfood.domain.producto.model.CategoriaProdModel;

import java.util.List;
import java.util.Optional;

public interface CategoriaProdRepository {

    Optional<CategoriaProdModel> buscarCategoriaPorId(Integer id);
    List<CategoriaProdModel> listarCategorias();
    CategoriaProdModel guardarCategoria(CategoriaProdModel categoria);

}
