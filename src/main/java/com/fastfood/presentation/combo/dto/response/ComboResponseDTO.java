package com.fastfood.presentation.combo.dto.response;

import com.fastfood.domain.combo.model.ComboProductoModel;
import com.fastfood.presentation.combo.dto.request.ComboProductoDTO;

import java.util.List;

public record ComboResponseDTO(
        Integer idCombo,
        String nombre,
        Double precio,
        Boolean activo,
        List<ComboProductoDTO> comboProductos
) { }
