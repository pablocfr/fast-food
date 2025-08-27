package com.fastfood.domain.pedido.model;

import com.fastfood.domain.combo.model.ComboModel;
import com.fastfood.domain.producto.model.ProductoModel;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class DetallePedidoModel {

    private Integer idDetallePedido;
    private Integer cantidad;
    private String estado;
    private PedidoModel pedido;
    private ProductoModel producto;
    private ComboModel comboProducto;


}
