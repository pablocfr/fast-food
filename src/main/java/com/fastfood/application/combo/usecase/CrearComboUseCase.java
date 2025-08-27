package com.fastfood.application.combo.usecase;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.repository.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CrearComboUseCase {

    private final ComboRepository comboRepository;

    public ComboModel guardar(ComboModel combo) {
        return comboRepository.guardar(combo);
    }

}
