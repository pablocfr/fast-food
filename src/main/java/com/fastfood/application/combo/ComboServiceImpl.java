package com.fastfood.application.combo;

import com.fastfood.application.combo.usecase.*;
import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.service.ComboService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComboServiceImpl implements ComboService {

    private final CrearComboUseCase crearComboUseCase;
    private final EditarComboUseCase editarComboUseCase;
    private final EliminarComboUseCase eliminarComboUseCase;
    private final ObtenerComboUseCase obtenerComboUseCase;
    private final ListarCombosUseCase listarCombosUseCase;
    private final ObtenerCombosUseCase obtenerCombosUseCase;

    @Override
    public Optional<ComboModel> buscarPorId(Integer id) {
        return obtenerComboUseCase.obtenerCombo(id);
    }

    @Override
    public List<ComboModel> buscarTodos() {
        return listarCombosUseCase.listarCombos();
    }

    @Override
    public ComboModel guardar(ComboModel combo) {
        return crearComboUseCase.guardar(combo);
    }

    @Override
    public ComboModel actualizar(Integer id, ComboModel combo) {
        return editarComboUseCase.editar(id, combo);
    }

    @Override
    public void eliminar(Integer id) {
        eliminarComboUseCase.eliminar(id);
    }

    @Override
    public List<ComboModel> listarCombos() {
        return obtenerCombosUseCase.listarCombos();
    }
}
