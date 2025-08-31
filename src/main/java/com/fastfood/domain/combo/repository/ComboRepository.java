package com.fastfood.domain.combo.repository;

import com.fastfood.domain.combo.model.ComboModel;

import java.util.List;
import java.util.Optional;

public interface ComboRepository {

    Optional<ComboModel> buscarPorId(Integer id);
    List<ComboModel> buscarTodos();
    ComboModel guardar(ComboModel combo);
    ComboModel actualizar(Integer id, ComboModel combo);
    void eliminar(Integer id);

    List<ComboModel> listarCombos();
}
