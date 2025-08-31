package com.fastfood.presentation.combo.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class ComboDTO {
    private Integer idCombo;
    private String nombre;
    private Double precio;
    private Boolean activo;
    private List<ComboProductoDTO> comboProductos;
}