package com.fastfood.infrastructure.persistence.proveedor.entity;

import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "proveedor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    private String nombre;
    private String contacto;
    private Boolean activo = true;

    @OneToMany(mappedBy = "proveedor")
    private List<ProductoEntity> productos;

}
