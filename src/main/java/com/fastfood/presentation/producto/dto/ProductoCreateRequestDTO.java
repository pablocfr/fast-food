package com.fastfood.presentation.producto.dto;

public record ProductoCreateRequestDTO(
        String nombre,
        Double precio,
        Boolean requiereCocina,
        Integer categoriaId,
        Integer proveedorId
) { }
