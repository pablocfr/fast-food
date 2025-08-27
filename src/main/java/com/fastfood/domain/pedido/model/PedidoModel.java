package com.fastfood.domain.pedido.model;

import com.fastfood.domain.seguridad.model.UsuarioModel;
import com.fastfood.infrastructure.persistence.cliente.entity.ClienteEntity;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class PedidoModel {

    private Integer idPedido;
    private LocalDateTime fechaHora;
    private String estado;
    private String numeroTicket;
    private Boolean activo;
    private ClienteEntity cliente;
    private UsuarioModel usuario;
    private List<DetallePedidoModel> detalles;

}
