package com.fastfood.presentation.combo.dto.request;

import com.fastfood.domain.combo.model.ComboProductoModel;

import java.util.List;

public record ComboCreateRequestDTO(
        String nombre,
        Double precio,
        List<ProductoEnComboDTO> productos
) { }
