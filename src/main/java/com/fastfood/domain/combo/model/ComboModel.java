package com.fastfood.domain.combo.model;
import lombok.Data;

import java.util.List;

@Data
public class ComboModel {

    private Integer idCombo;
    private String nombre;
    private Double precio;
    private Boolean activo;
    private List<ComboProductoModel> comboProductos;

}
