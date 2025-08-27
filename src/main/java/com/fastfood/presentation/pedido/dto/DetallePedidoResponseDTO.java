package com.fastfood.presentation.pedido.dto;

public record DetallePedidoResponseDTO(
        Integer idDetalle,
        ProductoDTO producto,
        Integer cantidad
) { }
