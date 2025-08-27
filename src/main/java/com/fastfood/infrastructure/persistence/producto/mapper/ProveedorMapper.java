package com.fastfood.infrastructure.persistence.producto.mapper;
import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.infrastructure.persistence.producto.entity.ProveedorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductoMapper.class})
public interface ProveedorMapper {

    @Mapping(target = "idProveedor", source = "idProveedor")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "contacto", source = "contacto")
    @Mapping(target = "activo", source = "activo")
    @Mapping(target = "productos", ignore = true)
    ProveedorModel map(ProveedorEntity entity);

    @Mapping(target = "idProveedor", source = "idProveedor")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "contacto", source = "contacto")
    @Mapping(target = "activo", source = "activo")
    @Mapping(target = "productos", ignore = true)
    ProveedorEntity mapEntity(ProveedorModel model);
}
