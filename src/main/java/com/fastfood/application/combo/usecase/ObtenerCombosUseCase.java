package com.fastfood.application.combo.usecase;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.repository.ComboRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ObtenerCombosUseCase {

    private final ComboRepository comboRepository;

    public List<ComboModel> listarCombos() {
        return  comboRepository.listarCombos();
    }
}
