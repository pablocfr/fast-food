package com.fastfood.presentation.pedido.mapper;

import com.fastfood.domain.cliente.model.ClienteModel;
import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.domain.seguridad.model.UsuarioModel;
import com.fastfood.infrastructure.persistence.cliente.entity.ClienteEntity;
import com.fastfood.infrastructure.persistence.producto.mapper.ProductoMapper;
import com.fastfood.infrastructure.persistence.seguridad.entity.UsuarioEntity;
import com.fastfood.presentation.pedido.dto.PedidoCreateRequestDTO;
import com.fastfood.presentation.pedido.dto.PedidoResponseDTO;
import com.fastfood.presentation.pedido.dto.PedidoUpdateRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface PedidoDTOMapper {
    // --------------------------
    // CreateRequestDTO -> Model
    // --------------------------
    @Mapping(target = "idPedido", ignore = true)
    @Mapping(target = "activo", constant = "true")
    @Mapping(target = "fechaHora", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "numeroTicket", expression = "java(generateTicketNumber())") // Generar número de ticket
    @Mapping(target = "cliente", source = "clienteId", qualifiedByName = "mapIdToCliente")
    @Mapping(target = "usuario", source = "usuarioId", qualifiedByName = "mapIdToUsuarioEntity")
    @Mapping(target = "detalles", source = "detalles")
    PedidoModel map(PedidoCreateRequestDTO dto);

    // --------------------------
    // UpdateRequestDTO -> Model
    // --------------------------
    @Mapping(target = "idPedido", ignore = true)
    @Mapping(target = "numeroTicket", ignore = true) // No cambiar en updates
    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "usuario", ignore = true)
    @Mapping(target = "fechaHora", ignore = true)
    @Mapping(target = "detalles", source = "detalles")
    PedidoModel mapUpdate(PedidoUpdateRequestDTO dto);

    // --------------------------
    // Model -> ResponseDTO
    // --------------------------
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detalles", source = "detalles")
    PedidoResponseDTO map(PedidoModel model);

    // --------------------------
    // Métodos auxiliares
    // --------------------------
    @Named("mapIdToCliente")
    default ClienteEntity mapIdToCliente(Integer clienteId) {
        if (clienteId == null) return null;
        ClienteEntity cliente = new ClienteEntity();
        cliente.setIdCliente(clienteId);
        return cliente;
    }

    @Named("mapIdToUsuarioEntity")
    default UsuarioModel mapIdToUsuarioEntity(Integer usuarioId) {
        if (usuarioId == null) return null;
        // Usar builder o método estático si están disponibles
        return UsuarioModel.builder()
                .id(usuarioId.longValue()) // Convertir Integer a Long si es necesario
                .build();

        // ALTERNATIVA 1: Si no tienes builder, usa método estático
        // return UsuarioModel.of(usuarioId.longValue());

        // ALTERNATIVA 2: Si solo necesitas el ID, crear objeto mínimo
        // UsuarioModel usuario = new UsuarioModel();
        // usuario.setId(usuarioId.longValue());
        // return usuario;
    }

    // Método para generar número de ticket
    default String generateTicketNumber() {
        return "TK" + System.currentTimeMillis(); // Formato simple, puedes mejorarlo
    }
}
