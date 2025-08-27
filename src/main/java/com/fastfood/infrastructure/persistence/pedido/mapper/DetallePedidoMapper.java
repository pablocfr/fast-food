package com.fastfood.infrastructure.persistence.pedido.mapper;

import com.fastfood.domain.pedido.model.DetallePedidoModel;
import com.fastfood.infrastructure.persistence.combo.mapper.ComboProductoMapper;
import com.fastfood.infrastructure.persistence.pedido.entity.DetallePedidoEntity;
import com.fastfood.infrastructure.persistence.producto.mapper.ProductoMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class, ComboProductoMapper.class})
public interface DetallePedidoMapper {

    @Mapping(target = "idDetallePedido", source = "idDetallePedido")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "comboProducto", ignore = true)
    DetallePedidoModel map(DetallePedidoEntity entity);

    @Mapping(target = "idDetallePedido", source = "idDetallePedido")
    @Mapping(target = "cantidad", source = "cantidad")
    @Mapping(target = "estado", source = "estado")
    @Mapping(target = "pedido", source = "pedido")
    @Mapping(target = "producto", ignore = true)
    @Mapping(target = "comboProducto", ignore = true)
    DetallePedidoEntity mapEntity(DetallePedidoModel model);

}
