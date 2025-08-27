package com.fastfood.application.combo.usecase;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.repository.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditarComboUseCase {

    private final ComboRepository comboRepository;

    public ComboModel editar(Integer id, ComboModel combo) {
        return comboRepository.actualizar(id,combo);
    }

}
