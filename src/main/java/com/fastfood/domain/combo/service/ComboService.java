package com.fastfood.domain.combo.service;

import com.fastfood.domain.combo.model.ComboModel;

import java.util.List;
import java.util.Optional;

public interface ComboService {
    Optional<ComboModel> buscarPorId(Integer id);
    List<ComboModel> buscarTodos();
    ComboModel guardar(ComboModel combo);
    ComboModel actualizar(Integer id, ComboModel combo);
    void eliminar(Integer id);
}
