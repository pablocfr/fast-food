package com.fastfood.presentation.combo.dto.request;

import com.fastfood.domain.combo.model.ComboProductoModel;

import java.util.List;

public record ComboUpdateRequestDTO(
        Integer idCombo,
        String nombre,
        Double precio,
        List<ComboProductoDTO> comboProductos
) { }
