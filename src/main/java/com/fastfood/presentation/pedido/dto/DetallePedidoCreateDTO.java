package com.fastfood.presentation.pedido.dto;

public record DetallePedidoCreateDTO(
        Integer productoId,
        Integer cantidad
) { }
