package com.fastfood.presentation.combo.dto.request;

public record ComboProductoDTO(
        Integer idComboProducto,
        Integer cantidad,
        Integer idProducto,   // solo referencia
        String nombreProducto // opcional
) {}
