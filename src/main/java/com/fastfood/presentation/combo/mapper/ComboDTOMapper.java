package com.fastfood.presentation.combo.mapper;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.combo.model.ComboProductoModel;
import com.fastfood.presentation.combo.dto.request.ComboCreateRequestDTO;
import com.fastfood.presentation.combo.dto.request.ComboUpdateRequestDTO;
import com.fastfood.presentation.combo.dto.response.ComboResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ComboDTOMapper {

    // Crear -> Model
    @Mapping(target = "idCombo", ignore = true) // el id no viene en create
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "activo", ignore = true)
    ComboModel map(ComboCreateRequestDTO dto);

    @Mapping(target = "idCombo", ignore = true) // el id no viene en create
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "comboProductos", source = "comboProductos")
    @Mapping(target = "activo", ignore = true)
    ComboModel mapUpdate(ComboUpdateRequestDTO dto);

    // Model -> Response
    @Mapping(target = "idCombo", source = "idCombo")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")
    @Mapping(target = "activo", source = "activo")
    @Mapping(target = "comboProductos", source = "comboProductos")
    ComboResponseDTO mapDto(ComboModel model);

}
