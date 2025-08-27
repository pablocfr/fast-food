package com.fastfood.presentation.producto.dto;

public record ProductoUpdateRequestDTO(
        String nombre,
        Double precio,
        Boolean requiereCocina,
        Boolean activo,
        Integer categoriaId,
        Integer proveedorId
) { }
