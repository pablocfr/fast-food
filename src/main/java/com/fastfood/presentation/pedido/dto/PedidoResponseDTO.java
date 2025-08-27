package com.fastfood.presentation.pedido.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PedidoResponseDTO(
        Integer idPedido,
        LocalDateTime fechaHora,
        String estado,
        String numeroTicket,
        Boolean activo,
        ClienteDTO cliente,
        UsuarioDTO usuario,
        List<DetallePedidoResponseDTO> detalles
) { }
