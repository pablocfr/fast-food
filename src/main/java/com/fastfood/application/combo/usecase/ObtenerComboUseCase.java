package com.fastfood.application.combo.usecase;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.repository.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ObtenerComboUseCase {

    private final ComboRepository comboRepository;

    public Optional<ComboModel> obtenerCombo(Integer id) {
        return comboRepository.buscarPorId(id);
    }
}
