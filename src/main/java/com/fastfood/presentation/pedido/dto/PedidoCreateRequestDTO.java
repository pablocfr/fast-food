package com.fastfood.presentation.pedido.dto;

import java.util.List;

public record PedidoCreateRequestDTO(
        String estado,
        String numeroTicket,
        Integer clienteId,
        Integer usuarioId,
        List<DetallePedidoCreateDTO> detalles
) { }
