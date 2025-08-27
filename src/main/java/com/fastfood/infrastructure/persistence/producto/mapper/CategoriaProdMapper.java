package com.fastfood.infrastructure.persistence.producto.mapper;

import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.infrastructure.persistence.producto.entity.CategoriaProdEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CategoriaProdMapper {

    @Mapping(target = "idCategoria", source = "idCategoria")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "activo", source = "activo")
    CategoriaProdModel map(CategoriaProdEntity entity);

    @Mapping(target = "idCategoria", source = "idCategoria")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "activo", source = "activo")
    CategoriaProdEntity mapEntity(CategoriaProdModel model);
}
