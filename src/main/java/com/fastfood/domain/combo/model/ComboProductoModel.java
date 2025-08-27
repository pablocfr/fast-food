package com.fastfood.domain.combo.model;

import com.fastfood.domain.producto.model.ProductoModel;
import lombok.Data;

@Data
public class ComboProductoModel {

    private Integer idComboProducto;
    private Integer cantidad;
    private Boolean activo;

    private ProductoModel producto;

}
