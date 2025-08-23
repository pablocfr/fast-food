package com.fastfood.infrastructure.persistence.combo.entity;

import com.fastfood.infrastructure.persistence.shared.Auditoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "combo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCombo;

    private String nombre;
    private Double precio;
    private Boolean activo = true;

    @OneToMany(mappedBy = "combo")
    private List<ComboProductoEntity> comboProductos;

}
