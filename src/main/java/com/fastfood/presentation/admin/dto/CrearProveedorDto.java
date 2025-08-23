package com.fastfood.presentation.admin.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CrearProveedorDto(
        @NotBlank(message = "El nombre del proveedor es obligatorio")
        @Size(max = 50, message = "El nombre no debe exceder 50 caracteres")
        String nombre,

        @NotBlank(message = "El contacto es obligatorio")
        @Size(max = 10, message = "El contacto no debe exceder 10 caracteres")
        String contacto
) {
}