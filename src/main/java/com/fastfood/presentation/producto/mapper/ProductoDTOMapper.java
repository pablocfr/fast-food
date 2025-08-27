package com.fastfood.presentation.producto.mapper;


import com.fastfood.domain.producto.model.CategoriaProdModel;
import com.fastfood.domain.producto.model.ProductoModel;
import com.fastfood.domain.producto.model.ProveedorModel;
import com.fastfood.infrastructure.persistence.producto.mapper.CategoriaProdMapper;
import com.fastfood.infrastructure.persistence.producto.mapper.ProveedorMapper;
import com.fastfood.presentation.producto.dto.ProductoCreateRequestDTO;
import com.fastfood.presentation.producto.dto.ProductoResponseDTO;
import com.fastfood.presentation.producto.dto.ProductoUpdateRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = {CategoriaProdMapper.class, ProveedorMapper.class})
public interface ProductoDTOMapper {
    // --------------------------
    // CreateRequestDTO -> Model
    // --------------------------
    @Mapping(target = "idProducto", ignore = true) // se genera automáticamente
    @Mapping(target = "activo", constant = "true") // activo por defecto
    @Mapping(target = "categoria", source = "categoriaId", qualifiedByName = "mapIdToCategoria")
    @Mapping(target = "proveedor", source = "proveedorId", qualifiedByName = "mapIdToProveedor")
    ProductoModel map(ProductoCreateRequestDTO dto);

    // --------------------------
    // UpdateRequestDTO -> Model
    // --------------------------
    @Mapping(target = "idProducto", ignore = true)
    @Mapping(target = "categoria", source = "categoriaId", qualifiedByName = "mapIdToCategoria")
    @Mapping(target = "proveedor", source = "proveedorId", qualifiedByName = "mapIdToProveedor")
    ProductoModel mapUpdate(ProductoUpdateRequestDTO dto);

    // --------------------------
    // Model -> ResponseDTO
    // --------------------------
    @Mapping(target = "categoria", source = "categoria")
    @Mapping(target = "proveedor", source = "proveedor")
    ProductoResponseDTO map(ProductoModel model);

    // --------------------------
    // Métodos auxiliares para mapear IDs
    // --------------------------
    @Named("mapIdToCategoria")
    default CategoriaProdModel mapIdToCategoria(Integer idCategoria) {
        if (idCategoria == null) return null;
        CategoriaProdModel categoria = new CategoriaProdModel();
        categoria.setIdCategoria(idCategoria);
        return categoria;
    }

    @Named("mapIdToProveedor")
    default ProveedorModel mapIdToProveedor(Integer idProveedor) {
        if (idProveedor == null) return null;
        ProveedorModel proveedor = new ProveedorModel();
        proveedor.setIdProveedor(idProveedor);
        return proveedor;
    }
}
