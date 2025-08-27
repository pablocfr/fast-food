package com.fastfood.infrastructure.persistence.producto.mapper;

import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.infrastructure.persistence.combo.mapper.ComboProductoMapper;
import com.fastfood.infrastructure.persistence.pedido.mapper.DetallePedidoMapper;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CategoriaProdMapper.class, ProveedorMapper.class, ComboProductoMapper.class, DetallePedidoMapper.class})
public interface ProductoMapper {

    @Mapping(target = "comboProductos", ignore = true) // rompe posible recursión Combo → Producto → Combo
    @Mapping(target = "detalles", source = "detalles")
    ProductoModel map(ProductoEntity entity);

    @Mapping(target = "comboProductos", ignore = true)
    @Mapping(target = "detalles", source = "detalles")
    ProductoEntity mapEntity(ProductoModel model);
}
