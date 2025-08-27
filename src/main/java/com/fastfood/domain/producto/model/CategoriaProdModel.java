package com.fastfood.domain.producto.model;

import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CategoriaProdModel {

    private Integer idCategoria;
    private String nombre;
    private Boolean activo;

}
