package com.fastfood.presentation.producto.mapper;

import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.presentation.producto.dto.CategoriaCreateRequestDTO;
import com.fastfood.presentation.producto.dto.CategoriaProdDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaDTOMapper {

    // --------------------------
    // CreateRequestDTO -> Model
    //
    @Mapping(target = "nombre", source = "nombre")
    CategoriaProdModel map (CategoriaCreateRequestDTO dto);

    // --------------------------
    // Model -> ResponseDTO
    // --------------------------

    @Mapping(target = "idCategoria", source = "idCategoria")
    @Mapping(target = "nombre", source = "nombre")
    CategoriaProdDTO map (CategoriaProdModel model);
}
