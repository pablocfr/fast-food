package com.fastfood.infrastructure.persistence.combo.mapper;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.model.ComboProductoModel;
import com.fastfood.infrastructure.persistence.combo.entity.ComboEntity;
import com.fastfood.infrastructure.persistence.combo.entity.ComboProductoEntity;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.infrastructure.persistence.producto.mapper.ProductoMapper;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface ComboProductoMapper {

    @Mapping(target = "producto.comboProductos", ignore = true) // rompe recursión Producto → ComboProductos → Producto
    ComboProductoModel map(ComboProductoEntity entity);

    List<ComboProductoModel> mapList(List<ComboProductoEntity> entities);
}
