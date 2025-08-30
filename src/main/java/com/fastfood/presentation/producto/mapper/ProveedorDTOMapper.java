package com.fastfood.presentation.producto.mapper;

import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.presentation.producto.dto.ProveedorCreateRequestDTO;
import com.fastfood.presentation.producto.dto.ProveedorResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProveedorDTOMapper {

    // --------------------------
    // CreateRequestDTO -> Model
    //
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "contacto", source = "contacto")
    ProveedorModel map(ProveedorCreateRequestDTO dto);

    // --------------------------
    // Model -> ResponseDTO
    // --------------------------

    @Mapping(target = "idProveedor", source = "idProveedor")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "contacto", source = "contacto")
    ProveedorResponseDTO map(ProveedorModel model);


}
