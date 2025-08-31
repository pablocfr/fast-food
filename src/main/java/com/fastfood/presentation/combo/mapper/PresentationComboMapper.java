package com.fastfood.presentation.combo.mapper;

import com.fastfood.infrastructure.persistence.combo.entity.ComboEntity;
import com.fastfood.infrastructure.persistence.combo.entity.ComboProductoEntity;
import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.presentation.combo.dto.request.ComboDTO;
import com.fastfood.presentation.combo.dto.request.ComboProductoDTO;
import com.fastfood.presentation.combo.dto.request.ProductoDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", implementationName = "PresentationComboMapperImpl")
public interface PresentationComboMapper {

    ComboDTO toDTO(ComboEntity entity);

    List<ComboDTO> toDTOList(List<ComboEntity> entities);

    ComboProductoDTO toDTO(ComboProductoEntity entity);

    ProductoDTO toDTO(ProductoEntity entity);
}
