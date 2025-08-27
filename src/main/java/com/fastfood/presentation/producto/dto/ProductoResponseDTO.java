package com.fastfood.presentation.producto.dto;

public record ProductoResponseDTO(
        Integer idProducto,
        String nombre,
        Double precio,
        Boolean requiereCocina,
        Boolean activo,
        CategoriaProdDTO categoria,
        ProveedorDTO proveedor
) {
}
