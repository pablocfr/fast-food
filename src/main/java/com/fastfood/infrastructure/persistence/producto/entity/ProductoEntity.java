package com.fastfood.infrastructure.persistence.producto.entity;

import com.fastfood.infrastructure.persistence.combo.entity.ComboProductoEntity;
import com.fastfood.infrastructure.persistence.pedido.entity.DetallePedidoEntity;
import com.fastfood.infrastructure.persistence.shared.Auditoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProducto;

    private String nombre;
    private Double precio;
    private Boolean requiereCocina;
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaProdEntity categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private ProveedorEntity proveedor;

    @OneToMany(mappedBy = "producto")
    private List<ComboProductoEntity> comboProductos;

    @OneToMany(mappedBy = "producto")
    private List<DetallePedidoEntity> detalles;

}
