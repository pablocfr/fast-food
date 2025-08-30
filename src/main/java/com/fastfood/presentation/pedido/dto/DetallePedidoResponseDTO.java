package com.fastfood.presentation.pedido.dto;

public record DetallePedidoResponseDTO(
        Integer cantidad,
        String estado,
        ProductoDTO producto,
        ComboDTO combo
) { }
