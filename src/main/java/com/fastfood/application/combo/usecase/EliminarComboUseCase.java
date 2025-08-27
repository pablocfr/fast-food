package com.fastfood.application.combo.usecase;

import com.fastfood.domain.combo.repository.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EliminarComboUseCase {

    private final ComboRepository comboRepository;

    public void eliminar(Integer id) {
        comboRepository.eliminar(id);
    }

}
