package com.fastfood.domain.producto.model;

import com.fastfood.domain.combo.model.ComboProductoModel;
import com.fastfood.domain.pedido.model.DetallePedidoModel;
import com.fastfood.infrastructure.persistence.combo.entity.ComboProductoEntity;
import com.fastfood.infrastructure.persistence.pedido.entity.DetallePedidoEntity;
import com.fastfood.infrastructure.persistence.producto.entity.CategoriaProdEntity;
import com.fastfood.infrastructure.persistence.producto.entity.ProveedorEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProductoModel {

    private Integer idProducto;
    private String nombre;
    private Double precio;
    private Boolean requiereCocina;
    private Boolean activo = true;
    private CategoriaProdModel categoria;
    private ProveedorModel proveedor;
    private List<ComboProductoModel> comboProductos;
    private List<DetallePedidoModel> detalles;

}
