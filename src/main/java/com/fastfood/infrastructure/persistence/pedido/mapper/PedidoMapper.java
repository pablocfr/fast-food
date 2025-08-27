package com.fastfood.infrastructure.persistence.pedido.mapper;

import com.fastfood.domain.pedido.model.PedidoModel;
import com.fastfood.infrastructure.persistence.pedido.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Mapping(target = "idPedido", source = "idPedido")
    @Mapping(target = "fechaHora", source = "fechaHora")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "numeroTicket", source = "numeroTicket")
    @Mapping(target = "activo", source = "activo")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detalles", source = "detalles")
    PedidoModel map(PedidoEntity entity);

    @Mapping(target = "idPedido", source = "idPedido")
    @Mapping(target = "fechaHora", source = "fechaHora")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "numeroTicket", source = "numeroTicket")
    @Mapping(target = "activo", source = "activo")
    @Mapping(target = "cliente", source = "cliente")
    @Mapping(target = "usuario", source = "usuario")
    @Mapping(target = "detalles", source = "detalles")
    PedidoEntity mapEntity(PedidoModel model);

}
