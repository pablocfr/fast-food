package com.fastfood.presentation.despacho.dto;

import java.time.LocalDateTime;

public record PedidoDespachoDto(
        Integer idPedido,
        String numeroTicket,
        String clienteNombre,
        LocalDateTime fechaHora,
        Double montoTotal
) {
}