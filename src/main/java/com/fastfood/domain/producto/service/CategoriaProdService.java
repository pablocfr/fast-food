package com.fastfood.domain.producto.service;

import com.fastfood.domain.producto.model.CategoriaProdModel;

import java.util.List;
import java.util.Optional;

public interface CategoriaProdService {

    Optional<CategoriaProdModel> buscarCategoriaPorId(Integer id);
    List<CategoriaProdModel> listarCategorias();
    CategoriaProdModel guardarCategoria(CategoriaProdModel categoria);

}
