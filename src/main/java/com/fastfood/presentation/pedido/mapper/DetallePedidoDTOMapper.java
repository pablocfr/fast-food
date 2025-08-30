package com.fastfood.presentation.pedido.mapper;

import com.fastfood.domain.pedido.model.DetallePedidoModel;
import com.fastfood.presentation.pedido.dto.DetallePedidoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetallePedidoDTOMapper {
    @Mapping(target = "producto", source = "producto")
    @Mapping(target = "combo", source = "combo")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "estado", source = "estado")
        // otros mappings necesarios...
    DetallePedidoResponseDTO map(DetallePedidoModel model);

    List<DetallePedidoResponseDTO> mapList(List<DetallePedidoModel> models);
}
