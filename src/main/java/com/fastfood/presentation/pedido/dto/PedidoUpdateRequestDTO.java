package com.fastfood.presentation.pedido.dto;

import java.util.List;

public record PedidoUpdateRequestDTO(
        String estado,
        Boolean activo,
        List<DetallePedidoCreateDTO> detalles
) { }
