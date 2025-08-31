package com.fastfood.infrastructure.persistence.combo.mapper;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.infrastructure.persistence.combo.entity.ComboEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ComboProductoMapper.class})
public interface ComboMapper {

    // --------------------------
    // ComboEntity -> ComboModel
    // --------------------------
    @Mapping(target = "idCombo", source = "idCombo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "activo", source = "activo")
    @Mapping(target = "comboProductos", source = "comboProductos")
    ComboModel map(ComboEntity entity);

    List<ComboModel> mapList(List<ComboEntity> entities);

    @Mapping(target = "idCombo", source = "idCombo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "activo", source = "activo")
    @Mapping(target = "comboProductos", source = "comboProductos")
    ComboEntity mapEntity(ComboModel entity);

    List<ComboEntity> mapEntityList(List<ComboModel> models);
}
