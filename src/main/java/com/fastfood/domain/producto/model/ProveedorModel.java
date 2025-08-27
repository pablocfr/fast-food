package com.fastfood.domain.producto.model;

import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProveedorModel {

    private Integer idProveedor;
    private String nombre;
    private String contacto;
    private Boolean activo = true;
    private List<ProductoModel> productos;

}
