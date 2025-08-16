package com.fastfood.infrastructure.persistence.combo.entity;

import com.fastfood.infrastructure.persistence.producto.entity.ProductoEntity;
import com.fastfood.infrastructure.persistence.shared.Auditoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Combo_Producto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComboProducto;

    private Integer cantidad;
    private Boolean activo = true;

    @ManyToOne
    @JoinColumn(name = "id_combo")
    private ComboEntity combo;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoEntity producto;


}
