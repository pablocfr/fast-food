package com.fastfood.infrastructure.persistence.producto.entity;

import com.fastfood.infrastructure.persistence.shared.Auditoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "categoria_prod")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProdEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategoria;

    private String nombre;
    private Boolean activo = true;

    @OneToMany(mappedBy = "categoria")
    private List<ProductoEntity> productos;

}
